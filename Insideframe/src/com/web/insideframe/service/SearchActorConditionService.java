package com.web.insideframe.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

import com.web.insideframe.common.DaoFactory;
import com.web.insideframe.dao.MemberDAO;
import com.web.insideframe.dto.MemberDTO;

public class SearchActorConditionService {
	DaoFactory df = new DaoFactory();
	MemberDAO mdao = df.memberDao();
	
	public ArrayList<MemberDTO> memberSelectCondition(String sex, int agemin, int agemax, int heightmin, int heightmax, int weightmin, int weightmax, String name){
		Iterator<MemberDTO> it = mdao.selectAllActor().iterator();
		ArrayList<MemberDTO> mlist = new ArrayList<>();
		
		while(it.hasNext()){
			MemberDTO mdto = it.next();
			SimpleDateFormat sd = new SimpleDateFormat("yyyy");
			Date d = new Date();
			int age = (Integer.parseInt(sd.format(d))-Integer.parseInt(mdto.getBirth().substring(0, 4)))+1;
			int height = mdto.getHeight();
			int weight = mdto.getWeight();
			
			
			if(sex.equals("¸ðµÎ")){
				if(name.equals("")){
					if(agemin <= age && agemax>=age && heightmin<=height && heightmax>= height && weightmin<=weight && weightmax >= weight){
						mlist.add(mdto);
					}
				}else{
					if(agemin <= age && agemax>=age && heightmin<=height && heightmax>= height && weightmin<=weight && weightmax >= weight && mdto.getName().equals(name)){
						mlist.add(mdto);
					}
				}
			}else{
				if(name.equals("")){
					if(mdto.getSex().equals(sex) && agemin <= age && agemax>=age && heightmin<=height && heightmax>= height && weightmin<=weight && weightmax >= weight){
						mlist.add(mdto);
					}
				}else{
					if(mdto.getSex().equals(sex) && agemin <= age && agemax>=age && heightmin<=height && heightmax>= height && weightmin<=weight && weightmax >= weight && mdto.getName().equals(name)){
						mlist.add(mdto);
					}
				}
			}
			
		}
		
		return mlist;
	}
	
	
}
