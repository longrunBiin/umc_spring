package umc.spring.converter.mission;

import umc.spring.domain.Mission;
import umc.spring.domain.enums.Gender;
import umc.spring.domain.enums.MissionStatus;
import umc.spring.web.dto.mission.MissionRequestDTO;
import umc.spring.web.dto.mission.MissionResponseDTO;

import java.time.LocalDateTime;

public class MissionConverter {
    public static MissionResponseDTO.MissionResultDTO toJoinResultDTO(Mission mission) {
        return MissionResponseDTO.MissionResultDTO.builder()
                .missionId(mission.getMissionId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static Mission toMission(MissionRequestDTO.MissionDto request) {

        MissionStatus status = null;

        switch (request.getMissionStatus()){
            case 1:
                status = MissionStatus.NOTCOMPLETE;
                break;
            case 2:
                status = MissionStatus.PROCEEDING;
                break;
            case 3:
                status = MissionStatus.COMPLETE;
                break;
        }
        return Mission.builder()
                .missionStatus(status)
                .content(request.getContent())
                .name(request.getName())
                .build();
    }
}
