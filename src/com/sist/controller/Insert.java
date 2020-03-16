package com.sist.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.model.MemberDAO;
import com.sist.model.MemberDTO;

/**
 * Servlet implementation class Insert
 */
@WebServlet("/insert.do")
public class Insert extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Insert() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");

		// 가입폼 페이지에서 넘어온 데이터들을 DB에 저장을 시키는 메서드

		// 가입폼 페이지에서 넘어온 데이터 처리
		String mem_id = request.getParameter("mem_id").trim();
		String mem_name = request.getParameter("mem_name").trim();
		String mem_pwd = request.getParameter("pwd").trim();
		String mem_tel = request.getParameter("mem_tel").trim();
		String mem_addr = request.getParameter("mem_addr").trim();
		String mem_email = request.getParameter("mem_email").trim();
		String age = request.getParameter("mem_age").trim();
		int mem_age = 0;
		if(age != null) {
			mem_age = Integer.parseInt(age);
		}

		MemberDTO dto = new MemberDTO();
		dto.setId(mem_id);
		dto.setName(mem_name);
		dto.setPwd(mem_pwd);
		dto.setTel(mem_tel);
		dto.setAddr(mem_addr);
		dto.setEmail(mem_email);
		dto.setAge(mem_age);

		MemberDAO dao = MemberDAO.getInstance();
		int res = dao.insertMember(dto);

		PrintWriter out = response.getWriter();

		if (res > 0) {
			out.println("<script>");
			out.println("alert('가입완료')");
			out.println("location.href='select.do'");
			out.println("</script>");
		} else {
			out.println("<script>");
			out.println("alert('가입 실패')");
			out.println("history.go(-1)"); // 이전 페이지로 이동
			out.println("</script>");
		}

	}

}
