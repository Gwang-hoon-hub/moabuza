package com.project.moabuja.repository;

import com.project.moabuja.domain.friend.Friend;
import com.project.moabuja.domain.member.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FriendRepository extends JpaRepository<Friend,Long> {


    List<Friend> findFriendsByMember(Member member);

    Friend findByMemberAAndFriend(Member member, Member friend);

}
