package com.web.insideframe.service;

import com.web.insideframe.common.DaoFactory;
import com.web.insideframe.dao.MemberDAO;
import com.web.insideframe.dto.MemberDTO;

public class ProfileService {
	DaoFactory df=new DaoFactory();
	MemberDAO mdao=df.memberDao();
	
	public MemberDTO getMemberDto(MemberDTO mdto){
		MemberDTO mdto2=mdto=mdao.select(mdto.getEmail());
		return mdto;
	}
}
