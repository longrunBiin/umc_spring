package umc.spring.service.missionService;

import org.springframework.data.domain.Page;
import umc.spring.domain.Mission;

public interface MissionQueryService {
    Page<Mission> getMissionList(Long restaurantId, Integer page);

    Page<Mission> getMemberMissionList(Long memberId, Integer page);
}
