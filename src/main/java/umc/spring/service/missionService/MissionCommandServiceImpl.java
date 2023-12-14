package umc.spring.service.missionService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.apiPayLoad.code.status.ErrorStatus;
import umc.spring.apiPayLoad.exception.handler.FoodCategoryHandler;
import umc.spring.apiPayLoad.exception.handler.RestaurantHandler;
import umc.spring.converter.MissionConverter;
import umc.spring.converter.RestaurantConverter;
import umc.spring.converter.memberConverter.MemberConverter;
import umc.spring.converter.memberConverter.MemberPreferConverter;
import umc.spring.domain.Member;
import umc.spring.domain.Mission;
import umc.spring.domain.PreferenceFood;
import umc.spring.domain.Restaurant;
import umc.spring.domain.mapping.MemberPreferenceFood;
import umc.spring.repository.FoodCategoryRepository;
import umc.spring.repository.MemberRepository;
import umc.spring.repository.MissionRepository;
import umc.spring.repository.RestaurantRepository;
import umc.spring.service.memberService.MemberCommandService;
import umc.spring.web.dto.member.MemberRequestDTO;
import umc.spring.web.dto.mission.MissionRequestDTO;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MissionCommandServiceImpl implements MissionCommandService {

    private final MissionRepository missionRepository;

    private final RestaurantRepository restaurantRepository;

    @Override
    public Mission addMission(long storeId, MissionRequestDTO.JoinDto request) {
        Mission mission = MissionConverter.toMission(request);

        Restaurant restaurant = restaurantRepository.findById(storeId).orElseThrow(() -> new RestaurantHandler(ErrorStatus.RESTAURANT_NOT_FOUND));

        mission.setRestaurant(restaurant);

        return missionRepository.save(mission);
    }
}