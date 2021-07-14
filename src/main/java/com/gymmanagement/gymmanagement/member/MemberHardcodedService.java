package com.gymmanagement.gymmanagement.member;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class MemberHardcodedService {

    private static List<Member> members = new ArrayList<>();
    private static int idCounter = 0;

    static {
        members.add(new Member(++idCounter, "Justyna Zadora", "student", new Date()));
        members.add(new Member(++idCounter, "Kamila Mucha", "student", new Date()));
        members.add(new Member(++idCounter, "Marta Janusz", "student", new Date()));
        members.add(new Member(++idCounter, "Lidia Pszczoła", "student", new Date()));
        members.add(new Member(++idCounter, "Anna Caputa", "student", new Date()));
    }

    public List<Member> findAll() {
        return members;
    }

    public Member deleteById(long id) {
        Member member = findById(id);

        if (member == null) return null;

        if(members.remove(member)) return member;

        return null;
    }

    public Member findById(long id) {
        for(Member member: members) {
            if (member.getId() == id) {
                return member;
            }
        }

        return null;
    }


}
