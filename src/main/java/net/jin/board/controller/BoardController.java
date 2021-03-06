
package net.jin.board.controller;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import net.jin.board.domain.Board;
import net.jin.board.domain.Search;
import net.jin.board.security.SecurityUser;
import net.jin.board.service.BoardService;

@Controller
@RequestMapping("/board")
public class BoardController {


	
	private static final Logger log = org.slf4j.LoggerFactory.getLogger(BoardController.class);
	
	@Autowired
	private BoardService boardService;

	@RequestMapping("/getBoardList")
	public String getBoardList(Model model, Search search) {
		log.info("getSearchCondition:"+search.getSearchCondition());
		log.info("getSearchKeyword:"+search.getSearchKeyword());
		if(search.getSearchCondition() == null) search.setSearchCondition("TITLE");
		if(search.getSearchKeyword() == null) search.setSearchKeyword("");
		Page<Board> boardList = boardService.getBoardList(search);
		model.addAttribute("boardList", boardList);
		return "board/getBoardList";
	}

	@GetMapping("/getBoard")
	public String getBoard(Model model, Board board) {
		Board getboard = boardService.getBoard(board);
		model.addAttribute("board", getboard);
		return "board/getBoard";
	}
	
	@GetMapping("/insertBoardView")
	public String insertBoardView() {
		return "/board/insertBoard";
	}
	
	
	@PostMapping("/insertBoard")
	public String insertBoard(Board board, @AuthenticationPrincipal SecurityUser principal) {
		board.setMember(principal.getMember());
		boardService.insertBoard(board);
		return "redirect:getBoardList";
	}
	
	@PostMapping("/updateBoard")
	public String updateBoard(Board board) {
		boardService.updateBoard(board);
		return "forward:getBoardList";
	}
	
	@GetMapping("/deleteBoard")
	public String deleteBoard(Board board) {
		boardService.deleteBoard(board);
		return "forward:getBoardList";
	}
}
