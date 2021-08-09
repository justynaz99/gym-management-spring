package com.gymmanagement.gymmanagement.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@CrossOrigin(origins="http://localhost:4200")
@RestController
public class MemberResource {

    @Autowired
    private MemberHardcodedService memberService;

    @GetMapping("/members")
    public List<Member> getAllMembers() {
        return memberService.findAll();
    }

    @GetMapping("/members/{id}")
    public Member getMember(@PathVariable long id) {
        return memberService.findById(id);
    }

    @DeleteMapping("/members/{id}")
    public ResponseEntity<Void> deleteMember(@PathVariable long id) {
        Member member = memberService.deleteById(id);
        if (member != null) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    //Edit/update member
    //PUT/ members/{id}
    @PutMapping ("/members/{id}")
    public ResponseEntity<Member> updateMember(@PathVariable long id, @RequestBody Member member) {

        Member updatedMember = memberService.save(member);
        return new ResponseEntity<Member>(member, HttpStatus.OK);
    }

    //Create new member
    //POST /members/{id}
    @PostMapping("/members")
    public ResponseEntity<Void> createMember(@PathVariable long id, @RequestBody Member member) {
        Member createdMember = memberService.save(member);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(createdMember.getId()).toUri();

        return ResponseEntity.created(uri).build();
    }

}
