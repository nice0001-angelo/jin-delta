package net.jin.board.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import net.jin.board.domain.Member;

public interface MemberRepository extends JpaRepository<Member, String>{
}
