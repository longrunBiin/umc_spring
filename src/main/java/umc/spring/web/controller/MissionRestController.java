package umc.spring.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import umc.spring.apiPayLoad.ApiResponse;
import umc.spring.converter.mission.MemberMissionConverter;
import umc.spring.converter.mission.MissionConverter;
import umc.spring.domain.Mission;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.service.missionService.MissionCommandService;
import umc.spring.web.dto.mission.MissionRequestDTO;
import umc.spring.web.dto.mission.MissionResponseDTO;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/missions")
public class MissionRestController {

    private final MissionCommandService missionCommandService;

    @PostMapping("/addMissions/{storeId}")
    public ApiResponse<MissionResponseDTO.MissionResultDTO> addRestaurant(@RequestBody @Valid MissionRequestDTO.MissionDto request, @PathVariable long storeId){
        Mission mission = missionCommandService.addMission(storeId, request);
        return ApiResponse.onSuccess(MissionConverter.toJoinResultDTO(mission));
    }

//    @GetMapping("{missionId}/members/{memberId}")
//    public ApiResponse<MissionResponseDTO.JoinResultDTO> challengeMission(@PathVariable long missionId, @PathVariable long memberId){
//        MemberMission memberMission = missionCommandService.challengeMission(missionId, memberId);
//        return ApiResponse.onSuccess(MemberMissionConverter.toChallengeMissionReulstDto(memberMission));
//    }
}
