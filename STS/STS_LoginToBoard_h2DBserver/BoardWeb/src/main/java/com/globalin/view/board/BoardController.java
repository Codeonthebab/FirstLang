package com.globalin.view.board;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.globalin.biz.board.BoardService;
import com.globalin.biz.board.BoardVO;
import com.globalin.biz.board.impl.BoardDAO;

@Controller
@SessionAttributes("board")
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	// 검색 조건 목록 설정
	@ModelAttribute("conditionMap")
	public Map<String, String> searchConditionMap() {
		Map<String, String> conditionMap = new HashMap<String, String>();
		conditionMap.put("제목", "TITLE");
		conditionMap.put("내용", "CONTENT");
		return conditionMap;
	}
	
	// 글등록
	@RequestMapping(value = "/insertBoard.do")
	public String insertBoard(BoardVO vo) {
		boardService.insertBoard(vo);
		return "getBoardList.do";
	}
	
	
	// 글 수정
	/*
	@RequestMapping("/updateBoard.do")
	public String updateBoard(@ModelAttribute("board")  BoardVO vo, BoardDAO boardDAO) {
		System.out.println("번호 : "+ vo.getSeq());
		System.out.println("제목 : "+vo.getTitle());
    	System.out.println("작성자 : "+ vo.getWriter());
    	System.out.println("내용 : "+vo.getContent());
    	System.out.println("등록일 : "+vo.getRegDate());
    	System.out.println("조회수 : "+vo.getCnt());
		 boardDAO.updateBoard(vo);
		 return "getBoardList.do";
	}
	*/
	@RequestMapping("/updateBoard.do")
	public String updateBoard(@ModelAttribute("board")  BoardVO vo) {
		 boardService.updateBoard(vo);
		 return "getBoardList.do";
	}
	
	
	// 글 삭제
	@RequestMapping("/deleteBoard.do")
	public String deleteBoard(BoardVO vo) {
	 boardService.deleteBoard(vo);
	return "getBoardList.do";
		
	}
	
	// 글 상세 조회
	/*
	@RequestMapping("/getBoard.do")
	public ModelAndView getBoard(BoardVO vo, BoardDAO boardDAO, ModelAndView mav) {
		        mav.addObject("board", boardDAO.getBoard(vo));// 모델 정보 저장
				mav.setViewName("getBoard.jsp");// 뷰 정보 저장
				return mav;
	}
	*/
	@RequestMapping("/getBoard.do")
	public String getBoard(BoardVO vo, Model model) {
		        model.addAttribute("board", boardService.getBoard(vo));// 모델 정보 저장
				return "getBoard.jsp";// 뷰 정보 저장
	}
	// 글 목록 조회
	/*
	@RequestMapping("/getBoardList.do")
	public ModelAndView getBoardList(
			BoardVO vo, BoardDAO boardDAO, ModelAndView mav) {
		    mav.addObject("boardList", boardDAO.getBoardList(vo));// 모델 정보 저장
			mav.setViewName("getBoardList.jsp");// 뷰 정보 저장
			return mav;
	}
	*/
	/*
	@RequestMapping("/getBoardList.do")
	public String getBoardList(
			BoardVO vo, BoardDAO boardDAO, Model model) {
		    model.addAttribute("boardList", boardDAO.getBoardList(vo));// 모델 정보 저장
			return "getBoardList.jsp";// 뷰 정보 저장
	}*/
	
	/*
	@RequestMapping("/getBoardList.do")
	public String getBoardList(
		@RequestParam(value = "searchCondition",defaultValue = "TITLE", required = false) String condition,
		@RequestParam(value = "searchKeyword",defaultValue = "", required = false) String keyword,
				 
		     @RequestParam 속성
		      1. value : 화면으로 전달될 파라미터의 이름
		      2. defaultValue : 화면으로 부터 전달될 파라미터 정보가 없을때, 설정할 기본값을 의미함
		      3. required : 파라미터의 생략 여부를 의미함
		 
			BoardVO vo, BoardDAO boardDAO, Model model) {
		    System.out.println("검색 조건 : "+condition);
		    System.out.println("검색 단어 : "+keyword);
		    
		    model.addAttribute("boardList", boardDAO.getBoardList(vo));// 모델 정보 저장
			return "getBoardList.jsp";// 뷰 정보 저장
	}
	*/
	@RequestMapping("/getBoardList.do")
	public String getBoardList(BoardVO vo, Model model) {
		    model.addAttribute("boardList", boardService.getBoardList(vo));// 모델 정보 저장
			return "getBoardList.jsp";// 뷰 정보 저장
	}
}
