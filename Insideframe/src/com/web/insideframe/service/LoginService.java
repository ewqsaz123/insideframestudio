package com.web.insideframe.service;

import com.web.insideframe.common.DaoFactory;
import com.web.insideframe.dao.MemberDAO;
import com.web.insideframe.dto.MemberDTO;

public class LoginService {
	DaoFactory df=new DaoFactory();
	MemberDAO mdao=df.memberDao();
	
	public boolean loginCheck(String email,String pw){
		boolean result=false;
		
		MemberDTO mdto=mdao.select(email);
		if(mdto.getEmail().equals(email)){
			if(mdto.getPw().equals(pw)){
				result=true;
			}
		}
		return result;
	}
	public MemberDTO loginMember(String email,String pw){
		MemberDTO mdto= null;
		if(loginCheck(email,pw)){
			mdto=mdao.select(email);
		}
		
		return mdto;
	}
}
