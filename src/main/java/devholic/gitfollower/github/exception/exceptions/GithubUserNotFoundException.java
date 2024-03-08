package devholic.gitfollower.github.exception.exceptions;

public class GithubUserNotFoundException extends RuntimeException {

    public GithubUserNotFoundException() {
        super("깃허브에 등록되지 않은 이름입니다.");
    }
}
