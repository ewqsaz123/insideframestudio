package com.web.insideframe.command;

import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web.insideframe.dto.ReplyDTO;
import com.web.insideframe.service.BoardDetailViewService;
import com.web.insideframe.service.CommentPagingService;
import com.web.insideframe.service.PagingService;
import com.web.insideframe.service.ReplyService;

public class BoardDetailViewCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		int idx=Integer.parseInt(request.getParameter("idx"));
		int commentPage=Integer.parseInt(request.getParameter("commentPage"));
		
		BoardDetailViewService bs=new BoardDetailViewService();
		request.setAttribute("board",bs.selectDetail(idx));
	      if(request.getSession().getAttribute("member")!=null){
	         boolean result=false;
	         Cookie[] cookies=request.getCookies();
	         if(cookies!=null){
	            for(int i=0; i<cookies.length;i++){
	               Cookie c=cookies[i];
	               String cName=c.getName();
	               if(cName.equals("board"+idx)){
	                  result=true;
	                  break;
	               }
	            }
	            if(result==false){
	               Cookie c=new Cookie("board"+idx,"yes");
	               c.setMaxAge(60*60*24*365);
	               response.addCookie(c);
	               bs.updateCount(idx);
	            }
	         }
	      }
		
		CommentPagingService cps=new CommentPagingService();
		
		request.setAttribute("paging",cps.commentPaging(idx));
		request.setAttribute("commentList",cps.getCommentList(idx, commentPage));
	}

}
