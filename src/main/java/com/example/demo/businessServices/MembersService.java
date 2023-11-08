package com.example.demo.businessServices;

import com.example.demo.entities.Member;
import com.example.demo.entities.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class MembersService {

    private MemberRepository memberRepository;
    @Autowired
    public MembersService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }
    private List<Member> members = new ArrayList<>(Arrays.asList(
            new Member(1,"farouk","hdhili",33, new Date(2020, 02,11),"Oberhausen"),
            new Member(2,"Ramy","Gouia",33, new Date(2020, 02,11),"Oberhausen"),
            new Member(3,"Müller","Hans",42, new Date(2020, 02,11),"Köln"),
            new Member(4,"Viktor","maier",22, new Date(2020, 02,11),"Duisburg")
    ));

    public List<Member> getAllMembers() {
        return StreamSupport.stream(memberRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    public Member getMemberById(int id) {
        return memberRepository.findById(id).stream().findFirst().get();
    }

    public void createMember(Member member) {
        memberRepository.save(member);
    }

    public void deleteMember(int id) {
        memberRepository.deleteById(id);
    }
}
