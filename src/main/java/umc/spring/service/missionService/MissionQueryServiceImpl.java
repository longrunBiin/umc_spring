package umc.spring.service.missionService;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.domain.Member;
import umc.spring.domain.Mission;
import umc.spring.domain.Restaurant;
import umc.spring.repository.MemberRepository;
import umc.spring.repository.MissionRepository;
import umc.spring.repository.RestaurantRepository;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MissionQueryServiceImpl implements MissionQueryService{
    private final RestaurantRepository restaurantRepository;
    private final MissionRepository missionRepository;
    private final MemberRepository memberRepository;
    @Override
    public Page<Mission> getMissionList(Long restaurantId, Integer page) {
        Restaurant restaurant = restaurantRepository.findById(restaurantId).get();
        Page<Mission> missionPage = missionRepository.findAllByRestaurant(restaurant, PageRequest.of(page, 10));
        return missionPage;
    }

    @Override
    public Page<Mission> getMemberMissionList(Long memberId, Integer page) {
        Member member = memberRepository.findById(memberId).get();
        Page<Mission> missionPage = missionRepository.findAllByMember(member, PageRequest.of(page, 10));
        return missionPage;
    }
}
