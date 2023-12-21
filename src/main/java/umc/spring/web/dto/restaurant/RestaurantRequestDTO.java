package umc.spring.web.dto.restaurant;

import lombok.Getter;
import umc.spring.domain.Region;
import umc.spring.validation.annotation.ExistCategories;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

public class RestaurantRequestDTO {
    @Getter
    public static class RestaurantDto{
        @NotBlank
        String name;
        @NotNull
        String address;
        @NotNull
        String title;
        @NotNull
        Float score;
        @NotNull
        String content;
    }
}
