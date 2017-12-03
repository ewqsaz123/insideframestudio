package com.web.insideframe.command;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web.insideframe.dto.MemberDTO;
import com.web.insideframe.service.SearchActorConditionService;
import com.web.insideframe.service.SearchAllActorService;

public class SearchActorCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		ArrayList<MemberDTO> mList = new ArrayList<>();
		
		try{
			if(request.getParameter("search") == null){
				SearchAllActorService ss = new SearchAllActorService();
				mList = ss.memberSelectAllActor();
			}else{
						MemberDTO mdto = new MemberDTO();
						String sex = request.getParameter("sex");
						int agemin = Integer.parseInt(request.getParameter("agemin"));
						int agemax = (request.getParameter("agemax").equals("0"))?100:Integer.parseInt(request.getParameter("agemax"));
						int heightmin = Integer.parseInt(request.getParameter("heightmin"));
						int heightmax = (request.getParameter("heightmax").equals("0"))?1000:Integer.parseInt(request.getParameter("heightmax"));
						int weightmin = Integer.parseInt(request.getParameter("weightmin"));
						int weightmax = (request.getParameter("weightmax").equals("0"))?1000:Integer.parseInt(request.getParameter("weightmax"));
						String name = request.getParameter("name");
						
						SearchActorConditionService sc = new SearchActorConditionService();
						mList = sc.memberSelectCondition(sex, agemin, agemax, heightmin, heightmax, weightmin, weightmax, name);
			}
		}catch(Exception e){
		}
		request.setAttribute("mList", mList);
		
	}

}
