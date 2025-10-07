package com.globalin.biz.board.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.globalin.biz.board.BoardService;
import com.globalin.biz.board.BoardVO;
//import com.globalin.biz.common.LogAdvice;
//import com.globalin.biz.common.Log4jAdvice;

@Service("boardService")
public class BoardServiceImpl implements BoardService {

	@Autowired
	//private BoardDAO boardDAO;
	 private BoardDAOSpring boardDAO;
	//private BoardDAOSpring2 boardDAO;
	//private Log4jAdvice log;
	//private LogAdvice log;
	
	public BoardServiceImpl() {
	    //log = new LogAdvice();
		//log = new Log4jAdvice();
	}
	
	@Override
	public void insertBoard(BoardVO vo) {
		//log.printLog();
		//log.printLogging();
		/*
		if(vo.getSeq() == 0) {
			throw new IllegalArgumentException("0번 글은 등록할 수 없습니다.");
		}
		*/
		//boardDAO.insertBoard(vo);
		boardDAO.insertBoard(vo);
	}

	@Override
	public void updateBoard(BoardVO vo) {
		//log.printLog();
		//log.printLogging();
		boardDAO.updateBoard(vo);
	}

	@Override
	public void deleteBoard(BoardVO vo) {
		//log.printLog();
		//log.printLogging();
		boardDAO.deleteBoard(vo);
	}

	@Override
	public BoardVO getBoard(BoardVO vo) {
		//log.printLog();
		//log.printLogging();
		return boardDAO.getBoard(vo);
	}

	@Override
	public List<BoardVO> getBoardList(BoardVO vo) {
		//log.printLog();
		//log.printLogging();
		return boardDAO.getBoardList(vo);
	}

}
