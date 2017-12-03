package com.web.insideframe.command;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web.insideframe.dto.CareerDTO;
import com.web.insideframe.dto.MemberDTO;
import com.web.insideframe.service.SearchActorConditionService;
import com.web.insideframe.service.SearchAllActorService;
import com.web.insideframe.service.SearchAllDirectorService;
import com.web.insideframe.service.SearchDirectorConditionService;

public class SearchDirectorCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String searchtype = request.getParameter("searchtype");
		String searchvalue = request.getParameter("searchvalue");
		
		ArrayList<MemberDTO> mList = new ArrayList<>();
		try{
			//감독 전체 검색
			if(request.getParameter("search") == null){
				SearchAllDirectorService sd = new SearchAllDirectorService();
				mList = sd.memberSelectAllDirector();	//member테이블에서 감독 리스트 가져오기
			}
			//감독 조건 검색
			else{ 
				SearchDirectorConditionService sdc = new SearchDirectorConditionService();
				if(searchtype.equals("이름")){
					mList = sdc.memberNameConditionDirector(searchvalue);
				}else if(searchtype.equals("작품명")){
					mList = sdc.memberTitleConditionDirector(searchvalue);
				}
			}
		}catch(Exception e){}
		
		request.setAttribute("mList", mList);
		request.setAttribute("searchtype", searchtype);
	}

}
