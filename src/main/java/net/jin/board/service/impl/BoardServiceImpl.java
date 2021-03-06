package net.jin.board.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.querydsl.core.BooleanBuilder;

import net.jin.board.domain.Board;
import net.jin.board.domain.QBoard;
import net.jin.board.domain.Search;
import net.jin.board.persistence.BoardRepository;
import net.jin.board.service.BoardService;

@Service
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
	public Page<Board> getBoardList(Search search) {
		BooleanBuilder booleanBuilder = new BooleanBuilder();

		QBoard qboard = QBoard.board;

		
		if (search.getSearchCondition().equals("TITLE")) {
			
			booleanBuilder.and(qboard.title.like("%" + search.getSearchKeyword() + "%"));
		} else if (search.getSearchCondition().equals("CONTENT")) {
			booleanBuilder.and(qboard.content.like("%" + search.getSearchKeyword() + "%"));
		}

		Pageable pageable = PageRequest.of(0, 10, Sort.Direction.DESC, "seq");
		return boardRepository.findAll(booleanBuilder, pageable);
	}

}
