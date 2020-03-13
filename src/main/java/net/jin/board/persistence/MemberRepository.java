package net.jin.board.persistence;

import org.springframework.data.repository.CrudRepository;

import net.jin.board.domain.Member;

public interface MemberRepository extends CrudRepository<Member, String>{
}
