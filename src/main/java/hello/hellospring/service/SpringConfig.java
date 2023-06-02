package hello.hellospring.service;

import hello.hellospring.aop.TimeTraceAop;
import hello.hellospring.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

@Configuration
public class SpringConfig {

    private final MemberRepository memberRepository;

    private final DataSource dataSource;
    private final EntityManager em;

    @Autowired
    public SpringConfig(DataSource dataSource, EntityManager em, MemberRepository memberRepository) {
        this.dataSource = dataSource;
        this.em = em;
        this.memberRepository = memberRepository;
    }

    /*

    public SpringConfig(DataSource dataSource){
        this.dataSource = dataSource;
    }
     */

    @Bean
    public MemberService memberService(){
        return new MemberService( memberRepository );
    }
    /*
    @Bean
    public TimeTraceAop timeTraceAop(){
        return new TimeTraceAop();
    }
     */

/*
    @Bean
    public MemberRepository memberRepository(){
        // return new MemoryMemberRepository();
        //return  new JdbcMemberRepository(dataSource);
        //return new JdbcTemplateMemberRepository(dataSource);
        return new JpaMemberRepository(em);
    }
*/

}
