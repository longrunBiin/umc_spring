package umc.spring.service.restaurantService;

import org.springframework.data.domain.Page;
import umc.spring.domain.Mission;
import umc.spring.domain.Restaurant;
import umc.spring.domain.Review;

import java.util.Optional;

public interface RestaurantQueryService {
    Optional<Restaurant> findStore(Long id);

    Page<Review> getReviewList(Long restaurantId, Integer page);

    Page<Review> getMemberReviewList(Long memberId, Integer page);


}
