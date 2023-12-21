package umc.spring.service.reviewService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.apiPayLoad.code.status.ErrorStatus;
import umc.spring.apiPayLoad.exception.handler.ReviewHandler;
import umc.spring.converter.ReviewConverter.MemberReviewConverter;
import umc.spring.converter.ReviewConverter.ReviewConverter;
import umc.spring.converter.memberConverter.MemberPreferConverter;
import umc.spring.domain.Review;
import umc.spring.domain.mapping.MemberReview;
import umc.spring.repository.ReviewRepository;
import umc.spring.web.dto.review.ReviewRequestDTO;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ReviewCommandServiceImpl implements ReviewCommandService {

    private final ReviewRepository reviewRepository;

    @Override
    @Transactional
    public Review writeReview(ReviewRequestDTO.reviewDto request) {
        Review newReview = ReviewConverter.toReview(request);

        List<Review> reviewList = request.getReviewList().stream()
                .map(review -> {
                    return reviewRepository.findById(review).orElseThrow(() -> new ReviewHandler(ErrorStatus.RESTAURANT_NOT_FOUND));
                }).collect(Collectors.toList());



        List<MemberReview> memberReviewList = MemberReviewConverter.toMemberReviewList(reviewList);

        memberReviewList.forEach(memberReview -> {memberReview.setReview(newReview);});

        return reviewRepository.save(newReview);
    }
}