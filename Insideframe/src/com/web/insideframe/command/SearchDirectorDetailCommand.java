package com.web.insideframe.command;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web.insideframe.dto.CareerDTO;
import com.web.insideframe.dto.MemberDTO;
import com.web.insideframe.service.SearchActorConditionService;
import com.web.insideframe.service.SearchActorDetailService;
import com.web.insideframe.service.SearchAllActorService;
import com.web.insideframe.service.SearchDirectorDetailService;

public class SearchDirectorDetailCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		String email = request.getParameter("email");
		SearchDirectorDetailService sa = new SearchDirectorDetailService();
		MemberDTO mdto = sa.memberSelectDirector(email);
		ArrayList<CareerDTO> cList = sa.careerSelectDirector(email);
		
		request.setAttribute("mdto", mdto);
		request.setAttribute("cList", cList);
	}

}
