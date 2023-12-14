package umc.spring.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import umc.spring.apiPayLoad.ApiResponse;
import umc.spring.converter.RestaurantConverter;
import umc.spring.domain.Restaurant;
import umc.spring.service.restaurantService.RestaurantCommandService;
import umc.spring.web.dto.restaurant.RestaurantRequestDTO;
import umc.spring.web.dto.restaurant.RestaurantResponseDTO;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/restaurants")
public class RestaurantRestController {

    private final RestaurantCommandService restaurantCommandService;

    @PostMapping("/regions/{restaurantId}")
    public ApiResponse<RestaurantResponseDTO.JoinResultDTO> addRestaurant(@RequestBody @Valid RestaurantRequestDTO.JoinDto request, @PathVariable long restaurantId){
        Restaurant restaurant = restaurantCommandService.addRestaurant(restaurantId, request);
        return ApiResponse.onSuccess(RestaurantConverter.toJoinResultDTO(restaurant));
    }
}
