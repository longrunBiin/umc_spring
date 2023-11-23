package umc.spring.domain;

import lombok.*;
import umc.spring.domain.common.BaseEntity;
import umc.spring.domain.mapping.UserPreferenceFood;
import umc.spring.domain.mapping.UserReview;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class PreferenceFood extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String category;

    @Column(nullable = false, length = 20)
    private String name;

    @OneToMany(mappedBy = "preferenceFood",cascade = CascadeType.ALL)
    private List<UserPreferenceFood> userPreferenceFoodList = new ArrayList<>();

}
