package com.project.moabuja.domain.record;

import com.project.moabuja.domain.Timestamped;
import com.project.moabuja.domain.member.Member;
import lombok.Getter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
public class Record extends Timestamped {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "record_id")
    private Long id;

    private int recordAmount;

    private String memo;

    private LocalDateTime recordDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @Enumerated(EnumType.STRING)
    private RecordType recordType;

    public Record(int recordAmount, String memo, LocalDateTime recordDate, Member member, RecordType recordType) {
        this.recordAmount = recordAmount;
        this.memo = memo;
        this.recordDate = recordDate;
        this.member = member;
        this.recordType = recordType;
    }

    protected Record(){

    }
}
