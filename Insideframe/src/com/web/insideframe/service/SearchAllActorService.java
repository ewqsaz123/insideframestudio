package com.web.insideframe.service;

import java.util.ArrayList;
import java.util.List;

import com.web.insideframe.common.DaoFactory;
import com.web.insideframe.dao.MemberDAO;
import com.web.insideframe.dto.MemberDTO;

public class SearchAllActorService {
	DaoFactory df = new DaoFactory();
	MemberDAO mdao = df.memberDao();
	
	public ArrayList<MemberDTO> memberSelectAllActor(){
		return mdao.selectAllActor();	
	}
}
