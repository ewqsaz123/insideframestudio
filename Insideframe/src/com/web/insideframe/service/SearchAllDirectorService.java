package com.web.insideframe.service;

import java.util.ArrayList;
import java.util.List;

import com.web.insideframe.common.DaoFactory;
import com.web.insideframe.dao.CareerDAO;
import com.web.insideframe.dao.MemberDAO;
import com.web.insideframe.dto.CareerDTO;
import com.web.insideframe.dto.MemberDTO;

public class SearchAllDirectorService {
	DaoFactory df = new DaoFactory();
	MemberDAO mdao = df.memberDao();
	CareerDAO cdao = df.careerDao();
	
	public ArrayList<MemberDTO> memberSelectAllDirector(){
		return mdao.selectAllDirector();	
	}
	
	public ArrayList<CareerDTO> careerSelectAllDirector(){
		return cdao.selectAllCareer();
	}
}
