package umc.spring.domain.mapping;

import lombok.*;
import umc.spring.domain.PreferenceFood;
import umc.spring.domain.Member;
import umc.spring.domain.common.BaseEntity;

import javax.persistence.*;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class MemberPreferenceFood extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "food_id")
    private PreferenceFood preferenceFood;


    public void setMember(Member newMember) {
        if (this.member != null) {
            member.getMemberPreferenceFoodList().remove(this);
        }
        this.member = newMember;
        member.getMemberPreferenceFoodList().add(this);
    }

    public void setFoodCategory(PreferenceFood preferenceFood){
        this.preferenceFood = preferenceFood;
    }
}
