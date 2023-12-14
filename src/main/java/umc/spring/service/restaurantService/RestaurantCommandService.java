package umc.spring.service.restaurantService;

import umc.spring.domain.Member;
import umc.spring.domain.Restaurant;
import umc.spring.domain.Review;
import umc.spring.web.dto.member.MemberRequestDTO;
import umc.spring.web.dto.restaurant.RestaurantRequestDTO;
import umc.spring.web.dto.review.ReviewRequestDTO;

public interface RestaurantCommandService {
    Restaurant addRestaurant(long restaurantId, RestaurantRequestDTO.JoinDto request);
}
