package devholic.gitfollower.github.application;

import devholic.gitfollower.github.application.dto.FollowerSearchRequest;
import devholic.gitfollower.github.domain.GithubManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class GithubService {

    private final GithubManager githubManager;

    public List<String> getFollowers(final FollowerSearchRequest request) {
        return githubManager.findFollowers(request.token(), request.username());
    }
}
