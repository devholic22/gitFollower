package devholic.gitfollower.github.domain;

import java.util.List;

public interface GithubManager {

    List<String> findFollowers(final String token, final String username);
}
