package devholic.gitfollower.github.exception.exceptions;

public class GithubTokenException extends RuntimeException {

    public GithubTokenException() {
        super("깃허브 토큰 인증이 실패하였습니다.");
    }
}
