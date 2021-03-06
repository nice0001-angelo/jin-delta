package net.jin.board.service;

import org.springframework.data.domain.Page;

import net.jin.board.domain.Board;
import net.jin.board.domain.Search;

public interface BoardService {
	
	void insertBoard(Board board);
	
	void updateBoard(Board board);
	
	void deleteBoard(Board board);
	
	Board getBoard(Board board);
	
	Page<Board> getBoardList(Search search);
}
