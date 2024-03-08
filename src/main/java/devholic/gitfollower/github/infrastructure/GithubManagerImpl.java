package devholic.gitfollower.github.infrastructure;

import devholic.gitfollower.github.domain.GithubManager;
import devholic.gitfollower.github.exception.exceptions.GithubTokenException;
import devholic.gitfollower.github.exception.exceptions.GithubUserNotFoundException;
import org.kohsuke.github.GHUser;
import org.kohsuke.github.GitHub;
import org.kohsuke.github.GitHubBuilder;
import org.springframework.stereotype.Component;
import java.io.IOException;
import java.util.List;

@Component
public class GithubManagerImpl implements GithubManager {

    @Override
    public List<String> findFollowers(final String token, final String username) {
        GitHub gitHub = createGitHubFromToken(token);

        try {
            GHUser user = gitHub.getUser(username);
            return user.getFollowers().stream()
                    .map(GHUser::getLogin)
                    .toList();
        } catch (IOException exception) {
            throw new GithubUserNotFoundException();
        }
    }

    private GitHub createGitHubFromToken(final String token) {
        try {
            GitHub gitHub = new GitHubBuilder()
                    .withOAuthToken(token)
                    .build();
            gitHub.checkApiUrlValidity();

            return gitHub;
        } catch (IOException exception) {
            throw new GithubTokenException();
        }
    }
}
