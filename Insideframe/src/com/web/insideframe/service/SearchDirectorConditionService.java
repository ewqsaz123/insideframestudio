package com.web.insideframe.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.web.insideframe.common.DaoFactory;
import com.web.insideframe.dao.CareerDAO;
import com.web.insideframe.dao.MemberDAO;
import com.web.insideframe.dto.CareerDTO;
import com.web.insideframe.dto.MemberDTO;

public class SearchDirectorConditionService {
	DaoFactory df = new DaoFactory();
	MemberDAO mdao = df.memberDao();
	
	public ArrayList<MemberDTO> memberNameConditionDirector(String searchvalue){
		return mdao.selectConditionDirectorAsName(searchvalue);
	}
	
	public ArrayList<MemberDTO> memberTitleConditionDirector(String searchvalue){
		return mdao.selectConditionDirectorAsTitle(searchvalue);
	}

}
