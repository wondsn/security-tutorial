package hello.wondsn.securityturotial;

import hello.wondsn.securityturotial.model.Member;
import hello.wondsn.securityturotial.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@SpringBootApplication
public class SecurityturotialApplication {

	public static void main(String[] args) {
		SpringApplication.run(SecurityturotialApplication.class, args);
	}

}

@RequiredArgsConstructor
@Component
class SecurityRunner implements ApplicationRunner {

	private final MemberRepository memberRepository;
	private final PasswordEncoder passwordEncoder;
	@Override
	@Transactional
	public void run(ApplicationArguments args) throws Exception {
		String username = "gyeongkim";
		if (memberRepository.findByUsername(username).isEmpty()) {
			String password = passwordEncoder.encode("abc1234");
			Member member = new Member(username, password, "ROLE_USER");
			memberRepository.save(member);
		}
	}
}
