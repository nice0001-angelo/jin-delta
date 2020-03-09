package net.jin.board.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

import net.jin.board.domain.Board;
import net.jin.board.persistence.BoardRepository;

public class BoardServiceImpl implements BoardService {

	@Autowired
	BoardRepository boardRepository;
	
	@Override
	public void insertBoard(Board board) {
		boardRepository.save(board);
			}

	@Override
	public void updateBoard(Board board) {
		Board findedBoard = boardRepository.findById(board.getSeq()).get();
		
		findedBoard.setTitle(board.getTitle());
		findedBoard.setContent(board.getContent());
		boardRepository.save(findedBoard);		
	}

	@Override
	public void deleteBoard(Board board) {
		boardRepository.deleteById(board.getSeq());
	}

	@Override
	public Board getBoard(Board board) {
		Board findedBoard = boardRepository.findById(board.getSeq()).get();
		return findedBoard;
	}

	@Override
	public Page<Board> getBoardList(Board board) {
		// TODO Auto-generated method stub
		return null;
	}

		
}
