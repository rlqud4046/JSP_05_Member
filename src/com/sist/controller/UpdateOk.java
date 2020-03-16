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
 * Servlet implementation class UpdateOk
 */
@WebServlet("/updateOk.do")
public class UpdateOk extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateOk() {
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

		String mem_id = request.getParameter("mem_id");
		String mem_name = request.getParameter("mem_name");
		String mem_pwd = request.getParameter("mem_pwd");
		String mem_tel = request.getParameter("mem_tel");
		String mem_addr = request.getParameter("mem_addr");
		String mem_email = request.getParameter("mem_email");
		int mem_age = Integer.parseInt(request.getParameter("mem_age"));

		MemberDTO dto = new MemberDTO();

		dto.setId(mem_id);
		dto.setName(mem_name);
		dto.setPwd(mem_pwd);
		dto.setTel(mem_tel);
		dto.setAddr(mem_addr);
		dto.setEmail(mem_email);
		dto.setAge(mem_age);

		MemberDAO dao = MemberDAO.getInstance();
		int res = dao.updateMember(dto);
		PrintWriter out = response.getWriter();

		if (res > 0) {
			out.println("<script>");
			out.println("alert('수정에 성공했습니다.')");
			out.println("location.href='cont.do?memID=" + dto.getId() +"'");
			out.println("</script>");
		}else {
			out.println("<script>");
			out.println("alert('수정에 실패했습니다..')");
			out.println("history.back()");
			out.println("</script>");
		}
		

	}

}
