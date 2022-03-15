package com.project.moabuja.dto.response.goal;

import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@NoArgsConstructor
public class CreateGroupMemberDto {
    private String groupMemberNickname;
    private boolean groupMemberCanInvite;

    public CreateGroupMemberDto(String groupMemberNickname, boolean groupMemberCanInvite) {
        this.groupMemberNickname = groupMemberNickname;
        this.groupMemberCanInvite = groupMemberCanInvite;
    }
}
