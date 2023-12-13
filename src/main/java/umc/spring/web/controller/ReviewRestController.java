package umc.spring.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umc.spring.apiPayLoad.ApiResponse;
import umc.spring.converter.ReviewConverter.ReviewConverter;
import umc.spring.converter.memberConverter.MemberConverter;
import umc.spring.domain.Review;
import umc.spring.service.reviewService.ReviewCommandService;
import umc.spring.web.dto.review.ReviewRequestDTO;
import umc.spring.web.dto.review.ReviewResponseDTO;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/reviews")
public class ReviewRestController {

    private final ReviewCommandService reviewCommandService;

    @PostMapping("/")
    public ApiResponse<ReviewResponseDTO.JoinResultDTO> addReview(@RequestBody @Valid ReviewRequestDTO.JoinDto request){
        Review review = reviewCommandService.writeReview(request);
        return ApiResponse.onSuccess(ReviewConverter.toWriteReviewResultDTO(review));

    }
}
