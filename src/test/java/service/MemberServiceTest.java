package service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemoryMemberRepository;
import hello.hellospring.service.MemberService;
import org.junit.jupiter.api.*;

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
    public void afterEach(){
        memberRepository.clearStore();
    }

    @Test
    void 회원가입() {
        //given
        Member member = new Member();
        member.setName("spring");
        //when
        Long saveId = memberService.join(member);        

        //then
        Member findMember = memberService.findONe(saveId).get();
        org.assertj.core.api.Assertions.assertThat( member.getName() ).isEqualTo( findMember.getName() );
    }

    @Test
    public void 중복_회원_예외(){
        //given
        Member member1 = new Member();
        member1.setName("spring");
        Member member2 = new Member();
        member2.setName("spring");

        //when
        memberService.join(member1);
        assertThrows( IllegalStateException.class, ()->memberService.join(member2));

        /*
        try {
            memberService.join(member2);
            fail();
        }
        catch ( IllegalStateException e ){
            org.assertj.core.api.Assertions.assertThat( e.getMessage()).isEqualTo("이미 존재하는 회원입니다.!!!!");
        }
        */


        //then
    }


    @Test
    void findMembers() {
    }

    @Test
    void findONe() {
    }
}