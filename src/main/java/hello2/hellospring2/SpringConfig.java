package hello2.hellospring2;


import hello2.hellospring2.repository.JdbcMemberRepository;
import hello2.hellospring2.repository.MemberRepository;
import hello2.hellospring2.repository.MemoryMember2Repository;
import hello2.hellospring2.repository.MemoryMemberRepository;
import hello2.hellospring2.service.Member2Service;
import hello2.hellospring2.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class SpringConfig {

    private DataSource dataSource;

    @Autowired
    public SpringConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Bean
    public Member2Service member2Service(){
        return new Member2Service(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository(){
//        return new MemoryMember2Repository();
        return new JdbcMemberRepository(dataSource);
    }
}
