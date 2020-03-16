<%@page import="com.sist.model.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	MemberDTO cont = (MemberDTO) request.getAttribute("Cont");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<div align="center">
		<table border="1" cellspacing="0" width="400">
			<%
				if (cont != null) { // 검색된 레코드가 있는 경우
			%>
			<tr>
				<th colspan="2" align="center">
					<h3><%=cont.getName()%>님 상세 정보
					</h3>
				</th>
			</tr>
			<tr>
				<th>아이디</th>
				<td><%=cont.getId()%></td>
			</tr>
			<tr>
				<th>회원명</th>
				<td><%=cont.getName()%></td>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td>
					<%
						if (cont.getPwd().length() != 0) {
								for (int i = 0; i < cont.getPwd().length(); i++) {
					%>*<%
						}
							}
					%>
				</td>
			</tr>

			<tr>
				<th>연락처</th>
				<%
					if (cont.getTel() == null) {
				%>
				<td></td>
				<%
					} else {
				%>

				<td><%=cont.getTel()%></td>
				<%
					}
				%>
			</tr>
			<tr>
				<th>주소</th>
				<%
					if (cont.getAddr() == null) {
				%>
				<td></td>
				<%
					} else {
				%>

				<td><%=cont.getTel()%></td>
				<%
					}
				%>
			</tr>
			<tr>
				<th>이메일</th>
				<%
					if (cont.getEmail() == null) {
				%>
				<td></td>
				<%
					} else {
				%>

				<td><%=cont.getTel()%></td>
				<%
					}
				%>
			</tr>
			<tr>
				<th>나이</th>
				<%
					if (cont.getAge() == 0) {
				%>
				<td></td>
				<%
					} else {
				%>

				<td><%=cont.getTel()%></td>
				<%
					}
				%>
			</tr>
			<tr>
				<th>가입일</th>
				<td><%=cont.getReg_date()%></td>
			</tr>

			<tr>
				<td colspan="2" align="right"><a
					href="update.do?no=<%=cont.getId()%>">[수정]</a> <%-- <a href="delete.do?no=<%=cont.getBoard_no()%>">[삭제]</a>	--%>
					<a href="board_delete.jsp?no=<%=cont.getId()%>">[삭제]</a> <%-- jsp로 바로 보내보자! --%>
					<a href="select.do">[전체 목록]</a></td>
			</tr>

			<%
				} else {
			%>
			<tr>
				<td colspan="2" align="center">
					<h3>검색된 레코드가 없습니다</h3>
				</td>
			</tr>
			<%
				}
			%>
		</table>


	</div>

</body>
</html>