package umc.spring.service.reviewService;

import umc.spring.domain.Member;
import umc.spring.domain.Review;
import umc.spring.web.dto.member.MemberRequestDTO;
import umc.spring.web.dto.review.ReviewRequestDTO;

public interface ReviewCommandService {
    Review writeReview(ReviewRequestDTO.reviewDto request);
}
