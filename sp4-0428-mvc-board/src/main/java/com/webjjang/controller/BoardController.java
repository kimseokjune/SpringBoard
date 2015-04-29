package com.webjjang.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;



import com.webjjang.board.service.BoardListService;

@Controller
public class BoardController {

	private BoardListService boardListService;

	public void setBoardListService(BoardListService boardListService) {
		this.boardListService = boardListService;
	}

	@RequestMapping("/board/list.do")
	public String list(HttpServletRequest request, Model model) {
		model.addAttribute("data", boardListService.process(request));
		return "board/list";
	}

}
