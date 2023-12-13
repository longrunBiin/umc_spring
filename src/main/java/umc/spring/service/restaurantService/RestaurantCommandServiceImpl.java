package umc.spring.service.restaurantService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.apiPayLoad.code.status.ErrorStatus;
import umc.spring.apiPayLoad.exception.handler.RegionHandler;
import umc.spring.converter.RestaurantConverter;
import umc.spring.domain.Region;
import umc.spring.domain.Restaurant;
import umc.spring.repository.RegionRepository;
import umc.spring.repository.RestaurantRepository;
import umc.spring.web.dto.restaurant.RestaurantRequestDTO;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class RestaurantCommandServiceImpl implements RestaurantCommandService {

    private final RestaurantRepository restaurantRepository;
    private final RegionRepository regionRepository;

    @Override
    @Transactional
    public Restaurant addRestaurant(RestaurantRequestDTO.JoinDto request) {
        Restaurant restaurant = RestaurantConverter.toRestaurant(request);
        String regionName = request.getAddress();

        Region region = regionRepository.findByRegionName(regionName).orElseThrow(() -> new RegionHandler(ErrorStatus.REGION_NOT_FOUND));

        restaurant.setRegion(region);
        return restaurantRepository.save(restaurant);
    }
}