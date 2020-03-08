package net.jin.board.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

import net.jin.board.domain.Board;
import net.jin.board.persistence.BoardRepository;

public class BoardServiceImpl implements BoardService {
	
	@Autowired
	private BoardRepository boardRepository;
	
	public void insertBoard(Board board) {
		boardRepository.save(board);
	}
	
	public void updateBoard(Board board) {
		
	}

	@Override
	public void deleteBoard(Board board) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Board getBoard(Board board) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Board> getBoardList(Board board) {
		// TODO Auto-generated method stub
		return null;
	}
}
