package com.kh.member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.member.model.service.MemberService;
import com.kh.member.model.vo.Member;

/**
 * Servlet implementation class MemberInsertController
 */
@WebServlet("/insert.me")
public class MemberInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberInsertController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1) 인코딩
		request.setCharacterEncoding("UTF-8");
		
		// 2) 요청 시 전달값 추출해서 변수 및 객체저장
		String userId = request.getParameter("userId");          //파라미터 키값 : input태그의 name값
		String userPwd = request.getParameter("userPwd");
		String userName = request.getParameter("userName");
		String phone = request.getParameter("phone");       // 010xxxxx | ""
		String email = request.getParameter("email");          // | ""
		String address = request.getParameter("address");          // | ""
		String[] interestArr = request.getParameterValues("interest");     //[ ] | null
		
		// String[]  --> String으로 바꿔줘야 함
		// [ xx, yy]  --> "xx, yy"
		String interest = "";
		if(interest != null) {
			interest = String.join(", ", interestArr);
		}
		//1. 기본생성자로 생성 후 setter메서드 이용해서 담기
		//2. 매개변수 생성자 이용해서 생성과 동시에 담아주기
		Member m = new Member(userId, userPwd, userName, phone, email, address, interest);
		
		//3. sql요청 => service => dao => sql문 실행
		int result = new MemberService().insertMember(m);
		
		if (result > 0) {
			HttpSession session = request.getSession();
			session.setAttribute("alertMsg", "성공적으로 회원가입이 되었습니다");
			
			// jsp로 url재요청 => index페이지
			response.sendRedirect(request.getContextPath());
			
		} else { //회원가입실패
			// 여러문구가 보여지는 에러페이지
			request.setAttribute("errorMsg", "회원가입에 실패하였습니다.");
			RequestDispatcher view = request.getRequestDispatcher("/views/common/errorPage.jsp");
			view.forward(request, response);
		}
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
