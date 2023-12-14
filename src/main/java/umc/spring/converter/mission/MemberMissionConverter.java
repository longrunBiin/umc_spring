package umc.spring.converter.mission;

import umc.spring.domain.Mission;
import umc.spring.domain.Restaurant;
import umc.spring.domain.Review;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.domain.mapping.MemberReview;
import umc.spring.web.dto.mission.MissionResponseDTO;

import java.util.List;
import java.util.stream.Collectors;

public class MemberMissionConverter {
    public static MissionResponseDTO.JoinResultDTO toChallengeMissionReulstDto(MemberMission memberMission) {

        Mission mission = memberMission.getMission();
        Restaurant restaurant = mission.getRestaurant();

        return MissionResponseDTO.JoinResultDTO.builder()
                .missionId(mission.getMissionId())
                .missionStatus(memberMission.getMissionStatus())
                .point(mission.getPoint())
                .content(mission.getContent())
                .name(mission.getName())
                .build();

    }
}
