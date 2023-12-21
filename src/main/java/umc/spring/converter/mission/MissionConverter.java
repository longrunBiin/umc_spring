package umc.spring.converter.mission;

import org.springframework.data.domain.Page;
import umc.spring.converter.RestaurantConverter;
import umc.spring.domain.Mission;
import umc.spring.domain.Review;
import umc.spring.domain.enums.Gender;
import umc.spring.domain.enums.MissionStatus;
import umc.spring.web.dto.mission.MissionRequestDTO;
import umc.spring.web.dto.mission.MissionResponseDTO;
import umc.spring.web.dto.restaurant.RestaurantResponseDTO;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class MissionConverter {
    public static MissionResponseDTO.MissionResultDTO toJoinResultDTO(Mission mission) {
        return MissionResponseDTO.MissionResultDTO.builder()
                .missionId(mission.getMissionId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static Mission toMission(MissionRequestDTO.MissionDto request) {

        MissionStatus status = null;

        switch (request.getMissionStatus()){
            case 1:
                status = MissionStatus.NOTCOMPLETE;
                break;
            case 2:
                status = MissionStatus.PROCEEDING;
                break;
            case 3:
                status = MissionStatus.COMPLETE;
                break;
        }
        return Mission.builder()
                .missionStatus(status)
                .content(request.getContent())
                .name(request.getName())
                .build();
    }


    public static MissionResponseDTO.MissionPreViewDTO reviewPreViewDTO(Mission mission){
        return MissionResponseDTO.MissionPreViewDTO.builder()
                .point(mission.getPoint())
                .createdAt(mission.getCreatedAt().toLocalDate())
                .content(mission.getContent())
                .build();
    }
    public static RestaurantResponseDTO.ReviewPreViewListDTO reviewPreViewListDTO(Page<Review> reviewList){

        List<RestaurantResponseDTO.ReviewPreViewDTO> reviewPreViewDTOList = reviewList.stream()
                .map(RestaurantConverter::reviewPreViewDTO).collect(Collectors.toList());

        return RestaurantResponseDTO.ReviewPreViewListDTO.builder()
                .isLast(reviewList.isLast())
                .isFirst(reviewList.isFirst())
                .totalPage(reviewList.getTotalPages())
                .totalElements(reviewList.getTotalElements())
                .listSize(reviewPreViewDTOList.size())
                .reviewList(reviewPreViewDTOList)
                .build();
    }
}
