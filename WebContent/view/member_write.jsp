<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<div align="center">
		<hr width="50%" color="skyblue">
		<h3>MEMBER1 테이블의 회원가입 폼</h3>
		<hr width="50%" color="skyblue">

		<form action="<%=request.getContextPath()%>/insert.do" method="post">
			<table border="1" cellspacing="0" width="300">
				<tr>
					<th>아이디</th>
					<td><input type="text" name="mem_id" required></td>
				</tr>
				<tr>
					<th>회원명</th>
					<td><input type="text" name="mem_name" required></td>
				</tr>
				<tr>
					<th>비밀번호</th>
					<td><input type="password" name="pwd" required></td>
				</tr>
				<tr>
					<th>연락처</th>
					<td><input type="text" name="mem_tel"></td>
				</tr>
				<tr>
					<th>주소</th>
					<td><input type="text" name="mem_addr"></td>
				</tr>
				<tr>
					<th>이메일</th>
					<td><input type="email" name="mem_email"></td>
				</tr>
				<tr>
					<th>나이</th>
					<td><input type="tel" name="mem_age"></td>
				</tr>
				
				<tr>
					<td colspan="2" align="center"><input type="submit"
						value="글쓰기">&ensp; <input type="reset" value="취소"></td>
				</tr>

			</table>

		</form>


	</div>

</body>
</html>