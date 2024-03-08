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

    private GitHub gitHub;

    @Override
    public List<String> findFollowers(final String token, final String username) {
        validateToken(token);

        try {
            GHUser user = gitHub.getUser(username);
            return user.getFollowers().stream()
                    .map(GHUser::getLogin)
                    .toList();
        } catch (IOException exception) {
            throw new GithubUserNotFoundException();
        }
    }

    private void validateToken(final String token) {
        try {
            gitHub = new GitHubBuilder()
                    .withOAuthToken(token)
                    .build();
            gitHub.checkApiUrlValidity();
        } catch (IOException exception) {
            throw new GithubTokenException();
        }
    }
}
