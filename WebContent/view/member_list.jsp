<%@page import="com.sist.model.MemberDTO"%>

<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	List<MemberDTO> member = (List<MemberDTO>) request.getAttribute("List");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<div align="center">
		<hr width="50%" color="tomato">
		<h3>Member1 테이블 전체 게시물 목록</h3>
		<hr width="50%" color="tomato">
		<br> <br>
		<table border="1" cellspacing="0" width="400">
			<tr>
				<th>회원ID</th>
				<th>회원명</th>
				<th>가입일</th>
			</tr>
			<%
				if (member.size() != 0) { // 검색한 레코드가 있으면
					// 검색된 레코드 수만큼 반복해서 웹에 출력
					for (int i = 0; i < member.size(); i++) {
						MemberDTO dto = member.get(i);
			%>
			<tr>
				<td><%=dto.getId()%></td>
				<td><a href="cont.do?memID=<%=dto.getId()%>"> <!-- no라는 변수를 cont에 넘겨준다. -->
						<!-- ?변수명=값  >>> get방식 --> <%=dto.getName()%></a></td>
				<td><%=dto.getReg_date().substring(0,10)%></td>

			</tr>

			<%
				}
				} else {
			%>
			<tr>
				<td colspan="3" align="center">
					<h3>검색된 레코드가 없습니다</h3>
				</td>
			</tr>
			<%
				}
			%>

		</table>


		<br>
		<hr width="50%" color="tomato">
		<br> <input type="button" value="가입"
			onclick="location.href ='view/member_write.jsp'"> <br>
		<form action="<%=request.getContextPath()%>/search.do" method="post">
			<select name="find_field">
				<%-- 검색을 누르면 넘어가는 타입 --%>
				<option value="mem_id">아이디</option>
				<option value="mem_name">이름</option>
			</select> <input type="text" name="find_name" size="15">
			<%-- 검색을 누르면 넘어가는 내용 --%>
			<input type="submit" value="검색">
		</form>




	</div>











</body>
</html>