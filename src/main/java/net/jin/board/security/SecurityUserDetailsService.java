package net.jin.board.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import net.jin.board.domain.Member;
import net.jin.board.persistence.MemberRepository;

@Service
public class SecurityUserDetailsService implements UserDetailsService{
	
	@Autowired
	private MemberRepository memberRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) 
			throws UsernameNotFoundException {
		Optional<Member> optional = memberRepository.findById(username);
		if(!optional.isPresent()) {
			throw new UsernameNotFoundException(username+"사용자없음");
		} else {
			Member member = optional.get();
			return new SecurityUser(member);
		}
	}
}
