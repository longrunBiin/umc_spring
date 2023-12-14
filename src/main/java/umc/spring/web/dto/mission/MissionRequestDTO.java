package umc.spring.web.dto.mission;

import lombok.Getter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

public class MissionRequestDTO {
    @Getter
    public static class JoinDto {
        @NotBlank
        String name;
        @NotNull
        Integer missionStatus;
        @NotNull
        String content;
        @NotNull
        Integer point;

        List<Long> userMissionList;
    }
}
