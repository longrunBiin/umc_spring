package umc.spring.service.missionService;

import umc.spring.domain.Member;
import umc.spring.domain.Mission;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.web.dto.member.MemberRequestDTO;
import umc.spring.web.dto.mission.MissionRequestDTO;

public interface MissionCommandService {
    Mission addMission(long storeId, MissionRequestDTO.JoinDto request);

    MemberMission challengeMission(long missionId, long memberId);
}
