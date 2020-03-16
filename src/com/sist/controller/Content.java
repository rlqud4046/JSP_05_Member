package com.sist.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.model.MemberDAO;
import com.sist.model.MemberDTO;

/**
 * Servlet implementation class Content
 */
@WebServlet("/cont.do")
public class Content extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Content() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 게시물의 상새내역을 조회하는 메서드
		String mem_id = request.getParameter("memID");

		MemberDAO dao = MemberDAO.getInstance();
		MemberDTO cont = dao.contMember(mem_id);

		request.setAttribute("Cont", cont);
		RequestDispatcher rd = request.getRequestDispatcher("view/member_cont.jsp");
		rd.forward(request, response);

	}

}
