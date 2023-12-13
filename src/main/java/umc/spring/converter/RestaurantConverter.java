package umc.spring.converter;

import umc.spring.domain.Member;
import umc.spring.domain.Restaurant;
import umc.spring.web.dto.restaurant.RestaurantRequestDTO;
import umc.spring.web.dto.restaurant.RestaurantResponseDTO;

import java.time.LocalDateTime;
import java.util.ArrayList;

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
}
