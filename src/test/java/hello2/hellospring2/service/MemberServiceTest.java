package hello2.hellospring2.service;

import hello2.hellospring2.domain.Member;
import hello2.hellospring2.repository.MemoryMemberRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {

    MemberService memberService;
    MemoryMemberRepository memberRepository;

    @BeforeEach
    public void beforeEach(){
        memberRepository = new MemoryMemberRepository();
        memberService = new MemberService(memberRepository);
    }

    @AfterEach
    public void afterEach() {
        memberRepository.clearStore();
    }

    @Test
    void join() {

        // given
        Member member = new Member();
        member.setName("hello");

        // when
        Long saveId = memberService.join(member);

        // then
        Member findMember = memberService.findOne(saveId).get();
        assertThat(member.getName()).isEqualTo(findMember.getName());
    }

    @Test
    public void 중복_회원_예외(){
        // given
        Member member = new Member();
        member.setName("hello");

        Member member2 = new Member();
        member.setName("hello");
        // when
        memberService.join(member);
        IllegalStateException illegalStateException = assertThrows(IllegalStateException.class, () -> memberService.join(member2));
        assertThat(illegalStateException.getMessage()).isEqualTo("이미 존재하는 회원 입니다.");

        /*try {
            memberService.join(member2);
            fail();
        } catch (IllegalStateException e) {
            assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
        }*/

        // then
    }


    @Test
    void findMembers() {
        // given

        // when

        // then
    }

    @Test
    void findOne() {

        // given

        // when

        // then
    }
}