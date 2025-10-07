package com.globalin.biz.board.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.globalin.biz.board.BoardService;
import com.globalin.biz.board.BoardVO;

@Service("boardService")
public class BoardServiceImlp implements BoardService {

	@Autowired
	private BoardDAO boardDAO;
	
	@Override
	public void insertBoard(BoardVO vo) {
		boardDAO.insertBoardVO(vo);
	}

	@Override
	public void updateBoard(BoardVO vo) {
		boardDAO.updateBoardVO(vo);
	}

	@Override
	public void deleteBoard(BoardVO vo) {
		boardDAO.deleteBoardVO(vo);
	}

	@Override
	public BoardVO getBoard(BoardVO vo) {
		return boardDAO.getBoardVO(vo);
	}

	@Override
	public List getBoardList(BoardVO vo) {
		return boardDAO.getBoardList(vo);
	}

}
