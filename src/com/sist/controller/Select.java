package com.sist.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.model.MemberDAO;
import com.sist.model.MemberDTO;

/**
 * Servlet implementation class Select
 */
@WebServlet("/select.do")
public class Select extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Select() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// DB상의 member1 테이블의 전체 리스트를 가져오는 메서드
		MemberDAO dao = MemberDAO.getInstance();
		// 전체 리스트를 가져오는 메서드 호출
		List<MemberDTO> member = dao.getMemberList();

		// 뷰페이지로 해당 데이터를 이동
		// 1. setAttribute() 메서드로 저장
		request.setAttribute("List", member);
		// 2. 뷰페이지로 실제 이동 시키기		
		RequestDispatcher rd = request.getRequestDispatcher("view/member_list.jsp");
		rd.forward(request, response);

	}

}
