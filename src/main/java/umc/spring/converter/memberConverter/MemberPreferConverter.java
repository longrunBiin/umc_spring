package umc.spring.converter.memberConverter;

import umc.spring.domain.PreferenceFood;
import umc.spring.domain.mapping.MemberPreferenceFood;

import java.util.List;
import java.util.stream.Collectors;

public class MemberPreferConverter {
    public static List<MemberPreferenceFood> toMemberPreferList(List<PreferenceFood> preferenceFoodsList){

        return preferenceFoodsList.stream()
                .map(foodCategory ->
                        MemberPreferenceFood.builder()
                                .preferenceFood(foodCategory)
                                .build()
                ).collect(Collectors.toList());
    }
}
