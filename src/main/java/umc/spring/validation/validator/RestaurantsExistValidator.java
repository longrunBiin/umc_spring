package umc.spring.validation.validator;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import umc.spring.apiPayLoad.code.status.ErrorStatus;
import umc.spring.repository.FoodCategoryRepository;
import umc.spring.repository.RestaurantRepository;
import umc.spring.validation.annotation.ExistCategories;
import umc.spring.validation.annotation.ExistRestaurant;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

@Component
@RequiredArgsConstructor
public class RestaurantsExistValidator implements ConstraintValidator<ExistRestaurant, List<Long>> {


    private final RestaurantRepository restaurantRepository;

    @Override
    public void initialize(ExistRestaurant constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(List<Long> values, ConstraintValidatorContext context) {
        boolean isValid = values.stream()
                .allMatch(value -> restaurantRepository.existsById(value));

        if (!isValid) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(ErrorStatus.RESTAURANT_NOT_FOUND.toString()).addConstraintViolation();
        }

        return isValid;

    }
}