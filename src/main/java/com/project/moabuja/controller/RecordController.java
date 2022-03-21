package com.project.moabuja.controller;

import com.project.moabuja.domain.member.Member;
import com.project.moabuja.domain.record.Record;
import com.project.moabuja.dto.request.record.DayListRequestDto;
import com.project.moabuja.dto.request.record.RecordRequestDto;
import com.project.moabuja.dto.response.record.DayListResponseDto;
import com.project.moabuja.dto.response.record.RecordResponseDto;
import com.project.moabuja.security.userdetails.UserDetailsImpl;
import com.project.moabuja.service.RecordService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.rmi.registry.LocateRegistry;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@RestController
@RequiredArgsConstructor
public class RecordController {

    private final RecordService recordService;


    @PostMapping("/money/addRecord/post")
    public ResponseEntity addRecord(@RequestBody  RecordRequestDto recordRequestDto,
                                    @AuthenticationPrincipal UserDetailsImpl userDetails){

        Member currentUser = userDetails.getMember();
        RecordResponseDto recordResponseDto = recordService.save(recordRequestDto, currentUser);

        return ResponseEntity.ok().body(recordResponseDto);
    }

    @PostMapping("/money/dayList")
    public ResponseEntity getDay(@RequestBody DayListRequestDto dayListRequestDto,
                                 @AuthenticationPrincipal UserDetailsImpl userDetails){

        Member currentUser = userDetails.getMember();
        DayListResponseDto dayListResponseDto = recordService.getDayList(dayListRequestDto,currentUser);

        return ResponseEntity.ok().body(dayListResponseDto);
    }

    @DeleteMapping("/money/dayList/delete/{id}")
    public ResponseEntity DeleteDay(@PathVariable Long id, @AuthenticationPrincipal UserDetailsImpl userDetails){

        Member currentUser = userDetails.getMember();
        recordService.deleteRecord(id, currentUser);

        return ResponseEntity.ok().body("내역 삭제 완료");
    }

}
