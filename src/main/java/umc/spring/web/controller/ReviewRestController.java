package umc.spring.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import umc.spring.apiPayLoad.ApiResponse;
import umc.spring.converter.ReviewConverter.ReviewConverter;
import umc.spring.converter.memberConverter.MemberConverter;
import umc.spring.domain.Review;
import umc.spring.service.restaurantService.RestaurantQueryService;
import umc.spring.service.reviewService.ReviewCommandService;
import umc.spring.validation.annotation.ExistRestaurant;
import umc.spring.web.dto.restaurant.RestaurantResponseDTO;
import umc.spring.web.dto.review.ReviewRequestDTO;
import umc.spring.web.dto.review.ReviewResponseDTO;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/reviews")
public class ReviewRestController {

    private final ReviewCommandService reviewCommandService;
    private final RestaurantQueryService restaurantQueryService;

    @PostMapping("/")
    public ApiResponse<ReviewResponseDTO.JoinResultDTO> addReview(@RequestBody @Valid ReviewRequestDTO.JoinDto request){
        Review review = reviewCommandService.writeReview(request);
        return ApiResponse.onSuccess(ReviewConverter.toWriteReviewResultDTO(review));

    }

    @GetMapping("/{restaurantId}")
    @Operation(summary = "특정 가게의 리뷰 목록 조회 API", description = "특정 가게의 리뷰들의 목록을 조회하는 API이며, 페이징을 포함합니다. query String 으로 page 번호를 주세요")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200", description = "OK, 성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH003", description = "access 토큰을 주세요!", content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH004", description = "acess 토큰 만료", content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH006", description = "acess 토큰 모양이 이상함", content = @Content(schema = @Schema(implementation = ApiResponse.class))),
    })
    @Parameters({
            @Parameter(name = "restaurantId", description = "가게의 아이디, path variable 입니다!")
    })
    public ApiResponse<RestaurantResponseDTO.ReviewPreViewListDTO> getReviewList(@ExistRestaurant @PathVariable(name = "restaurantId") Long restaurantId, @RequestParam(name = "page") Integer page){
        Page<Review> review = restaurantQueryService.getReviewList(restaurantId,page);
        return null;
    }
}
