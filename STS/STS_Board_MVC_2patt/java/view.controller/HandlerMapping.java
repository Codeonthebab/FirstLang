package com.globalin.view.controller;

import java.util.HashMap;
import java.util.Map;

import com.globalin.biz.board.BoardVO;
import com.globalin.view.board.DeleteBoardController;
import com.globalin.view.board.GetBoardController;
import com.globalin.view.board.GetBoardListController;
import com.globalin.view.board.InsertBoardController;
import com.globalin.view.board.LogoutController;
import com.globalin.view.board.UpdateBoardController;
import com.globalin.view.user.LoginController;

public class HandlerMapping {
	
	private Map<String, Controller> mappings;
	BoardVO vo = new BoardVO();
	
	public HandlerMapping() {
		mappings=new HashMap<String, Controller>();
		mappings.put("/login.do", new LoginController());
		mappings.put("/logout.do", new LogoutController());
		mappings.put("/getBoardList.do", new GetBoardListController());
		mappings.put("/getBoard.do", new GetBoardController());
		mappings.put("/deleteBoard.do", new DeleteBoardController());
		mappings.put("/updateBoard.do", new UpdateBoardController());
		mappings.put("/insertBoard.do", new InsertBoardController());
		
		
	}
	
	public Controller getController (String path) {
		return mappings.get(path);
	}
	
	
}