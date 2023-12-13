package umc.spring.converter.ReviewConverter;

import umc.spring.domain.Member;
import umc.spring.domain.Review;
import umc.spring.domain.enums.Gender;
import umc.spring.web.dto.member.MemberRequestDTO;
import umc.spring.web.dto.member.MemberResponseDTO;
import umc.spring.web.dto.review.ReviewRequestDTO;
import umc.spring.web.dto.review.ReviewResponseDTO;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class ReviewConverter {

    public static ReviewResponseDTO.JoinResultDTO toWriteReviewResultDTO(Review review){
        return ReviewResponseDTO.JoinResultDTO.builder()
                .reviewId(review.getReviewId())
                .memberId(review.getMemberId())
                .build();
    }

    public static Review toReview(ReviewRequestDTO.JoinDto request){


        return Review.builder()
                .content(request.getContents())
                .Score(request.getScore())
                .memberReviewList(new ArrayList<>())
                .build();
    }

}
