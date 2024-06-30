package me.jiyeon.kim.blogbase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MemberService {

    @Autowired
    MemberRepository memberRepository;

    public void test() {
        memberRepository.save(new Member(1L, "A"));

        Optional<Member> member = memberRepository.findById(1L);
        System.out.println(member.get().getId() + member.get().getName());
        List<Member> allMembers = memberRepository.findAll();
        for (Member allMember : allMembers) {
            System.out.println("allMember = " + allMember.getId() + ", " + allMember.getName());
        }

        memberRepository.deleteById(1L);
        List<Member> deletedAfterAllMembers = memberRepository.findAll();
        for (Member deletedAfterMember : deletedAfterAllMembers) {
            System.out.println("deletedAfterMember = " + deletedAfterMember.getId() + ", " + deletedAfterMember.getName());
        }
    }
}
