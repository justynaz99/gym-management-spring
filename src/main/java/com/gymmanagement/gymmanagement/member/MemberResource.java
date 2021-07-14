package com.gymmanagement.gymmanagement.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins="http://localhost:4200")
@RestController
public class MemberResource {

    @Autowired
    private MemberHardcodedService memberService;

    @GetMapping("/members")
    public List<Member> getAllUsers() {
        return memberService.findAll();
    }

    @DeleteMapping("/members")
    public ResponseEntity<Void> deleteMember(@PathVariable long id) {
        Member member = memberService.deleteById(id);
        if (member != null) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.notFound().build();
    }
}
