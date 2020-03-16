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
		<hr width="50%" color="red">
		<h3>MEMBER1 메인 페이지</h3>
		<hr width="50%" color="red">
		<br> <br> <br>
		<%--현재 프로젝트명을 반환하는 메서드 --%>
		<a href="<%=request.getContextPath()%>/select.do">[레코드 검색]</a>
		<!-- 두가지 방식 다 사용 가능하나 원칙적으로 위의 방식을 쓴다. -->

	</div>

	<div id="disqus_thread"></div>
	<script>
		/**
		 *  RECOMMENDED CONFIGURATION VARIABLES: EDIT AND UNCOMMENT THE SECTION BELOW TO INSERT DYNAMIC VALUES FROM YOUR PLATFORM OR CMS.
		 *  LEARN WHY DEFINING THESE VARIABLES IS IMPORTANT: https://disqus.com/admin/universalcode/#configuration-variables*/
		/*
		 var disqus_config = function () {
		 this.page.url = PAGE_URL;  // Replace PAGE_URL with your page's canonical URL variable
		 this.page.identifier = PAGE_IDENTIFIER; // Replace PAGE_IDENTIFIER with your page's unique identifier variable
		 };
		 */
		(function() { // DON'T EDIT BELOW THIS LINE
			var d = document, s = d.createElement('script');
			s.src = 'https://kblee.disqus.com/embed.js';
			s.setAttribute('data-timestamp', +new Date());
			(d.head || d.body).appendChild(s);
		})();
	</script>
	<noscript>
		Please enable JavaScript to view the <a
			href="https://disqus.com/?ref_noscript">comments powered by
			Disqus.</a>
	</noscript>



</body>


</html>