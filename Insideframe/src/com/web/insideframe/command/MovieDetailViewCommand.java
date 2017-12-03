package com.web.insideframe.command;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web.insideframe.service.MovieDetailViewService;
import com.web.insideframe.service.MovieReplyPagingService;

public class MovieDetailViewCommand implements Command {

   @Override
   public void execute(HttpServletRequest request, HttpServletResponse response) {
      // TODO Auto-generated method stub
      int movieNo=Integer.parseInt(request.getParameter("movieno"));
      int commentPage=Integer.parseInt(request.getParameter("commentPage"));
      
      MovieDetailViewService ms=new MovieDetailViewService();
      request.setAttribute("movie",ms.getMovieInfo(movieNo));
      request.setAttribute("peopleList",ms.getPeopleList(movieNo));
      
      
         boolean result=false;
         Cookie[] cookies=request.getCookies();
         if(cookies!=null){
            for(int i=0; i<cookies.length;i++){
               Cookie c=cookies[i];
               String cName=c.getName();
               if(cName.equals("movie"+movieNo)){
                  result=true;
                  break;
               }
            }
            if(result==false){
               Cookie c=new Cookie("movie"+movieNo,"yes");
               c.setMaxAge(60*60*24*365);
               response.addCookie(c);
               ms.updateCount(movieNo);
            }
         }

      
      MovieReplyPagingService mrps=new MovieReplyPagingService();
      
      request.setAttribute("paging",mrps.commentPaging(movieNo));
      request.setAttribute("commentList",mrps.getCommentList(movieNo, commentPage));
   }

}