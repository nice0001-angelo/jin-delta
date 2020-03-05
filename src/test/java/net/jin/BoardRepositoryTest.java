
package net.jin;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import net.jin.board.domain.Board;
import net.jin.board.domain.Member;
import net.jin.board.persistence.BoardRepository;
import net.jin.board.persistence.MemberRepository;

@SpringBootTest
public class BoardRepositoryTest {

	@Autowired
	private MemberRepository memberRepository;

	@Autowired
	private BoardRepository boardRepository;

	/*@Test
	 * public void testInsert() { Member member1 = new Member();
	 * member1.setId("member"); member1.setPassword("1234");
	 * member1.setName("Angelo"); member1.setRole(Role.ROLE_MEMBER);
	 * member1.setEnabled(true); memberRepository.save(member1);
	 * 
	 * Member member2 = new Member(); member2.setId("admin");
	 * member2.setPassword("1234"); member2.setName("Jee");
	 * member2.setRole(Role.ROLE_ADMIN); member2.setEnabled(true);
	 * memberRepository.save(member2);
	 * 
	 * for (int i = 1; i <= 13; i++) { Board board = new Board();
	 * board.setMember(member1); board.setTitle(member1.getName() + "가 등록한 게시글" +
	 * i); board.setContent(member1.getName() + "가 등록한 게시글" + i);
	 * boardRepository.save(board); }
	 * 
	 * for (int i = 1; i <= 3; i++) { Board board = new Board();
	 * board.setMember(member2); board.setTitle(member2.getName() + "가 등록한 게시글" +
	 * i); board.setContent(member2.getName() + "가 등록한 게시글" + i);
	 * boardRepository.save(board); } }
	 */
	
	/*
	 * @Test public void testGetBoard() {
	 * 
	 * Board board = boardRepository.findById(1L).get();
	 * 
	 * System.out.println("[" + board.getSeq() + "번 게시글 상세정보 ]");
	 * System.out.println("제목\t : " + board.getTitle());
	 * System.out.println("작성자\t : " + board.getMember().getName());
	 * System.out.println("내용\t : " + board.getContent());
	 * System.out.println("작성일\t : " + board.getCreateDate());
	 * System.out.println("조회수\t : " + board.getCnt()); }
	 */
	
	@Test
	public void testGetBoardList() {
		Member member = memberRepository.findById("member").get();
		
		System.out.println("[ " + member.getName() + "가 등록한 게시글 ]");
		for (Board board : member.getBoardList()) {
			System.out.println("-----> " + board.toString());
		}
	}
}
