package umc.spring.domain.mapping;

import lombok.*;
import umc.spring.domain.Restaurant;
import umc.spring.domain.Review;
import umc.spring.domain.Member;
import umc.spring.domain.common.BaseEntity;

import javax.persistence.*;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class MemberReview extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurant;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "review_id")
    private Review review;

    public void setReview(Review review) {
        if (this.review != null) {
            review.getMemberReviewList().remove(this);
        }
        this.review = review;
        review.getMemberReviewList().add(this);
    }
}
