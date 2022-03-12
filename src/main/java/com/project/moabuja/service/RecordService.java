package com.project.moabuja.service;

import com.project.moabuja.domain.member.Member;
import com.project.moabuja.domain.record.Record;
import com.project.moabuja.dto.request.record.DayListRequestDto;
import com.project.moabuja.dto.request.record.RecordRequestDto;
import com.project.moabuja.dto.response.record.DayListResponseDto;
import com.project.moabuja.dto.response.record.RecordResponseDto;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

public interface RecordService {

    public RecordResponseDto save(RecordRequestDto recordRequestDto, Member currentMember);

    public DayListResponseDto getDayList(DayListRequestDto dayListRequestDto, Member currentMember);

    public void deleteRecord(Long id);
}
