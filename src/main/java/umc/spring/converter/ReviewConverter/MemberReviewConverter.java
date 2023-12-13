package umc.spring.converter.ReviewConverter;

import umc.spring.domain.PreferenceFood;
import umc.spring.domain.Review;
import umc.spring.domain.mapping.MemberPreferenceFood;
import umc.spring.domain.mapping.MemberReview;

import java.util.List;
import java.util.stream.Collectors;

public class MemberReviewConverter {
    public static List<MemberReview> toMemberReviewList(List<Review> ReviewList){

        return ReviewList.stream()
                .map(review ->
                        MemberReview.builder()
                                .review(review)
                                .build()
                ).collect(Collectors.toList());
    }
}
