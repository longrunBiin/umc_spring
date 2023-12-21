package umc.spring.converter;

import umc.spring.domain.Member;
import umc.spring.domain.Restaurant;
import umc.spring.domain.Review;
import umc.spring.web.dto.restaurant.RestaurantRequestDTO;
import umc.spring.web.dto.restaurant.RestaurantResponseDTO;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class RestaurantConverter {
    public static RestaurantResponseDTO.JoinResultDTO toJoinResultDTO(Restaurant restaurant){
        return RestaurantResponseDTO.JoinResultDTO.builder()
                .restaurantId(restaurant.getRestaurantId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static Restaurant toRestaurant(RestaurantRequestDTO.JoinDto request){

        return Restaurant.builder()
                .name(request.getName())
                .address(request.getAddress())
                .build();
    }
    public static Review toReview(RestaurantRequestDTO.JoinDto request){
        return Review.builder()
                .title(request.getTitle())
                .score(request.getScore())
                .content(request.getContent())
                .build();
    }

    public static RestaurantResponseDTO.JoinResultDTO toCreateReviewResultDTO(Review review){
        return RestaurantResponseDTO.JoinResultDTO.builder()
                .reviewId(review.getReviewId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static RestaurantResponseDTO.ReviewPreViewDTO reviewPreViewDTO(Review review){
        return null;
    }
    public static RestaurantResponseDTO.ReviewPreViewListDTO reviewPreViewListDTO(List<Review> reviewList){
        return null;
    }
}
