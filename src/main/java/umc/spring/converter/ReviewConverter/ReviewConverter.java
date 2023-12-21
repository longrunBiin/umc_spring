package umc.spring.converter.ReviewConverter;

import org.springframework.data.domain.Page;
import umc.spring.converter.RestaurantConverter;
import umc.spring.domain.Member;
import umc.spring.domain.Review;
import umc.spring.domain.enums.Gender;
import umc.spring.web.dto.member.MemberRequestDTO;
import umc.spring.web.dto.member.MemberResponseDTO;
import umc.spring.web.dto.restaurant.RestaurantResponseDTO;
import umc.spring.web.dto.review.ReviewRequestDTO;
import umc.spring.web.dto.review.ReviewResponseDTO;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ReviewConverter {

    public static ReviewResponseDTO.ReviewResultDTO toWriteReviewResultDTO(Review review){
        return ReviewResponseDTO.ReviewResultDTO.builder()
                .reviewId(review.getReviewId())
                .memberId(review.getMember().getId())
                .build();
    }

    public static Review toReview(ReviewRequestDTO.reviewDto request){


        return Review.builder()
                .content(request.getContents())
                .score(request.getScore())
                .memberReviewList(new ArrayList<>())
                .build();
    }
    public static RestaurantResponseDTO.ReviewPreViewDTO reviewPreViewDTO(Review review){
        return RestaurantResponseDTO.ReviewPreViewDTO.builder()
                .ownerNickname(review.getMember().getName())
                .score(review.getScore())
                .createdAt(review.getCreatedAt().toLocalDate())
                .body(review.getContent())
                .build();
    }
    public static RestaurantResponseDTO.ReviewPreViewListDTO reviewPreViewListDTO(Page<Review> reviewList){

        List<RestaurantResponseDTO.ReviewPreViewDTO> reviewPreViewDTOList = reviewList.stream()
                .map(RestaurantConverter::reviewPreViewDTO).collect(Collectors.toList());

        return RestaurantResponseDTO.ReviewPreViewListDTO.builder()
                .isLast(reviewList.isLast())
                .isFirst(reviewList.isFirst())
                .totalPage(reviewList.getTotalPages())
                .totalElements(reviewList.getTotalElements())
                .listSize(reviewPreViewDTOList.size())
                .reviewList(reviewPreViewDTOList)
                .build();
    }

}

