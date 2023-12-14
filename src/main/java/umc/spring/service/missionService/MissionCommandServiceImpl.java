package umc.spring.service.missionService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.apiPayLoad.code.status.ErrorStatus;
import umc.spring.apiPayLoad.exception.handler.MemberMissionHandler;
import umc.spring.apiPayLoad.exception.handler.RestaurantHandler;
import umc.spring.converter.mission.MissionConverter;
import umc.spring.domain.Mission;
import umc.spring.domain.Restaurant;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.repository.*;
import umc.spring.web.dto.mission.MissionRequestDTO;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MissionCommandServiceImpl implements MissionCommandService {

    private final MissionRepository missionRepository;

    private final RestaurantRepository restaurantRepository;

    private final MemberMissionRepository memberMissionRepository;

    @Override
    public Mission addMission(long storeId, MissionRequestDTO.JoinDto request) {
        Mission mission = MissionConverter.toMission(request);

        Restaurant restaurant = restaurantRepository.findById(storeId).orElseThrow(() -> new RestaurantHandler(ErrorStatus.RESTAURANT_NOT_FOUND));

        mission.setRestaurant(restaurant);

        return missionRepository.save(mission);
    }

    @Override
    public MemberMission challengeMission(long missionId, long memberId) {
        MemberMission mission = memberMissionRepository.findByMissionIdAndMemberId(missionId, memberId).orElseThrow(() -> new MemberMissionHandler(ErrorStatus.MEMBER_MISSION_NOT_FOUND));

        mission.setMissionStatus();
        return memberMissionRepository.save(mission);
    }
}