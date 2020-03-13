
package net.jin.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import net.jin.board.domain.Board;
import net.jin.board.service.BoardService;

@Controller

@RequestMapping("/board")
public class BoardController {

	@Autowired
	private BoardService boardService;

	@RequestMapping("/getBoardList")
	public String getBoardList(Model model, Board board) {
		Page<Board> boardList = boardService.getBoardList(board);
		model.addAttribute("boardList", boardList);
		return "board/getBoardList";
	}

	@GetMapping("/getBoard")
	public String getBoard(Model model, Board board) {
		Board getboard = boardService.getBoard(board);
		model.addAttribute("board", getboard);
		return "board/getBoard";
	}
}
