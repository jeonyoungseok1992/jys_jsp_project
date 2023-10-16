package com.kh.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ScoreController
 */
@WebServlet("/ScoreCT")
public class ScoreController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ScoreController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		String StudentName = request.getParameter("name");
		String StudentId = request.getParameter("student_id");
		int koreanScore = Integer.parseInt(request.getParameter("korean"));
		int mathScore = Integer.parseInt(request.getParameter("math"));
		int englishScore = Integer.parseInt(request.getParameter("english"));
		int scienceScore = Integer.parseInt(request.getParameter("science"));
	
//		response.setContentType("text/html; charset=EUC-KR");
//		PrintWriter writer = response.getWriter();
//		
//		writer.println("이름 : " + StudentName);
//		writer.println("힉번 : " + StudentId);
//		writer.println("국어 : " + koreanScore);
//		writer.println("수학 : " + mathScore);
//		writer.println("영어 : " + englishScore);
//		writer.println("과학 : " + scienceScore);
//		
//		writer.close();
		
		
		
		
		//new ScoreService().testScore(StudentName, StudentId, koreanScore, mathScore, englishScore, scienceScore );
		
		request.setAttribute("Sname", StudentName);
		request.setAttribute("Sid", StudentId);
		request.setAttribute("kscore", koreanScore);
		request.setAttribute("mscore", mathScore);
		request.setAttribute("escore", englishScore);
		request.setAttribute("sscore", scienceScore);
		
		RequestDispatcher view = request.getRequestDispatcher("/view/responsePage.jsp");
		view.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
