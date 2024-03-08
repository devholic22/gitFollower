package devholic.gitfollower.github.application.dto;

import jakarta.validation.constraints.NotBlank;

public record FollowerSearchRequest(
        @NotBlank(message = "깃허브 토큰이 필요합니다.")
        String token,

        @NotBlank(message = "깃허브 username이 필요합니다.")
        String username
) {
}
