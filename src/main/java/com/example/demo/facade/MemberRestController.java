package com.example.demo.facade;

import com.example.demo.businessServices.MembersService;
import com.example.demo.entities.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MemberRestController {
    @Autowired
    private MembersService membersService;

    @RequestMapping("/members")
    public List<Member> getAllMembers(){
        return membersService.getAllMembers();
    }

    @RequestMapping("/members/{id}")
    public Member getMemberById(@PathVariable int id){
        return membersService.getMemberById(id);
    }

    @RequestMapping(method= RequestMethod.POST, value="/members")
    public void createMember(@RequestBody Member member) {
         membersService.createMember(member);
    }

    @RequestMapping(method= RequestMethod.DELETE, value="/members/{id}")
    public void deleteMember(@PathVariable int id){
        membersService.deleteMember(id);
    }
}
