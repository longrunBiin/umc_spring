package umc.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.spring.domain.PreferenceFood;

public interface FoodCategoryRepository extends JpaRepository<PreferenceFood, Long> {
}
