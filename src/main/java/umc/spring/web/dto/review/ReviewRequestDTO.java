package umc.spring.web.dto.review;

import lombok.Getter;
import umc.spring.validation.annotation.ExistCategories;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

public class ReviewRequestDTO {
    @Getter
    public static class JoinDto{
        @NotNull
        Integer score;
        @Size(min = 5, max = 50)
        String contents;

        @ExistCategories
        List<Long> reviewList;
    }
}
