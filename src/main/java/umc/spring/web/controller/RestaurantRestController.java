package umc.spring.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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

    @PostMapping("/")
    public ApiResponse<RestaurantResponseDTO.RestaurantResultDTO> addStore(@RequestBody @Valid RestaurantRequestDTO.RestaurantDto request){
        Restaurant restaurant = restaurantCommandService.addRestaurant(request);
        return ApiResponse.onSuccess(RestaurantConverter.toRestaurantResultDTO(restaurant));
    }
}
