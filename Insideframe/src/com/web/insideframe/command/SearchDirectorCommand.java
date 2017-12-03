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
			//���� ��ü �˻�
			if(request.getParameter("search") == null){
				SearchAllDirectorService sd = new SearchAllDirectorService();
				mList = sd.memberSelectAllDirector();	//member���̺��� ���� ����Ʈ ��������
			}
			//���� ���� �˻�
			else{ 
				SearchDirectorConditionService sdc = new SearchDirectorConditionService();
				if(searchtype.equals("�̸�")){
					mList = sdc.memberNameConditionDirector(searchvalue);
				}else if(searchtype.equals("��ǰ��")){
					mList = sdc.memberTitleConditionDirector(searchvalue);
				}
			}
		}catch(Exception e){}
		
		request.setAttribute("mList", mList);
		request.setAttribute("searchtype", searchtype);
	}

}
