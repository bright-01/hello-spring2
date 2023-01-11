package hello2.hellospring2.service;

import hello2.hellospring2.domain.Member;
import hello2.hellospring2.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public class Member2Service {

    private final MemberRepository memberRepository;

    public Member2Service(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }


    /**
     * 회원 가입
     * */
    public Long join(Member member) {

//           Optional<Member> result = memberRepository.findByName(member.getName()); // 이렇게 Optional 바로 꺼내서 사용하는 것을 권장 하지 않음.. 아래와 같이 사용
//           result.ifPresent( m -> {
//               throw new IllegalStateException("이미 존재하는 회원입니다.");
//           });

        // 그리고 아래와 같으면 메서드로 뽑는게 좋음
        validateDuplicateMember(member);


        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName()).ifPresent(m -> {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        });
    }

    /**
     * 전체 회원 조회
     * */
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
