package devholic.gitfollower.github.ui;

import devholic.gitfollower.github.application.GithubService;
import devholic.gitfollower.github.application.dto.FollowerSearchRequest;
import devholic.gitfollower.github.ui.dto.FollowerSearchResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/api/follower")
@RestController
public class GithubController {

    private final GithubService githubService;

    @GetMapping
    public ResponseEntity<List<FollowerSearchResponse>> findFollowers(@RequestBody final FollowerSearchRequest request) {
        List<FollowerSearchResponse> followers = githubService.getFollowers(request).stream()
                .map(FollowerSearchResponse::new)
                .toList();

        return ResponseEntity.ok()
                .body(followers);
    }
}
