package com.globalin.biz.board.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.globalin.biz.board.BoardService;
import com.globalin.biz.board.BoardVO;
//import com.globalin.biz.common.Log4jAdvice;
//import com.globalin.biz.common.LogAdvice;

@Service("boardService")
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardDAO boardDAO;
	//private BoardDAOSpring boardDAO;
	//private BoardDAOSpring2 boardDAO;
	//private Log4jAdvice log2;
	//public LogAdvice log;

	public BoardServiceImpl() {
		//log = new LogAdvice();
		//log2 = new Log4jAdvice();
	}

	@Override
	public void insertBoard(BoardVO vo) {
		//log.printLog();
		//log2.printLogging();
		/*
		if (vo.getSeq()==0) {
			throw new IllegalArgumentException("0번 글은 등록할 수 없습니다.");
		}
		*/
		boardDAO.insertBoardVO(vo);
	}

	@Override
	public void updateBoard(BoardVO vo) {
		//log.printLog();
		//log2.printLogging();
		boardDAO.updateBoardVO(vo);
	}

	@Override
	public void deleteBoard(BoardVO vo) {
		//log.printLog();
		//log2.printLogging();
		boardDAO.deleteBoardVO(vo);
	}

	@Override
	public BoardVO getBoard(BoardVO vo) {
		//log.printLog();
		//log2.printLogging();
		return boardDAO.getBoardVO(vo);
	}

	@Override
	public List getBoardList(BoardVO vo) {
		//log.printLog();
		//log2.printLogging();
		return boardDAO.getBoardList(vo);
	}

}
