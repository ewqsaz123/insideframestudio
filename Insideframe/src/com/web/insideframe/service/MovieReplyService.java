package com.web.insideframe.service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.web.insideframe.common.DaoFactory;
import com.web.insideframe.dao.MovieReplyDAO;
import com.web.insideframe.dto.MovieReplyDTO;

public class MovieReplyService {
	DaoFactory df=new DaoFactory();
	MovieReplyDAO mrdao=df.movieReplyDao();
	
	public MovieReplyDTO getReply(int movieNo,String email,String commentContent){
		
		 Pattern p=Pattern.compile("<!-- Not Allowed Tag Filtered -->");
	      Matcher m=p.matcher(commentContent);
	      String XssResult="";
	      if(m.find()){
	         XssResult="비정상적인 댓글입니다.";
	      }else{
	         XssResult=commentContent;
	      }
	      
	      MovieReplyDTO mrdto=new MovieReplyDTO();
	      
	      mrdto.setComment_movieNo(movieNo);
	      mrdto.setCommentId(email);
	      mrdto.setCommentContent(XssResult);
	      
	      return mrdto;
		
	}
	public void insertReply(MovieReplyDTO mrdto){
		mrdao.insert(mrdto);
	}
	/*public boolean isXssAttack(String commentContent){
		boolean result=false;
		Pattern p=Pattern.compile("<!-- Not Allowed Tag Filtered -->");
		Matcher m=p.matcher(commentContent);
		if(m.matches()){
			result=true;
		}
		return result;
	}*/
}
