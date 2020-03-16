package com.sist.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MemberDAO {

	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	String sql = null;

	/*
	 * 싱글톤 객체 만들기 1. 싱글톤 객체를 만들때는 우선적으로 접근지정자는 private로 선언한다. 2. 정적(static) 멤버로 선언을
	 * 한다.
	 */

	private static MemberDAO instance = new MemberDAO();

	/*
	 * 3. 기본생성자는 외부에서 접근이 되지 않도록 해야한다. 외부에서 new를 사용하지 못하게 하는 접근 기법
	 */

	private MemberDAO() {
	}

	// 4. 생성자 대신에 싱글톤 객체를 retrun 해 주는 getInstance() 메서드를 만들어 준다.
	public static MemberDAO getInstance() {
		if (instance == null) {
			instance = new MemberDAO();
		}
		return instance;
	}

	public void openConn() {

		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		String user = "genie";
		String password = "1234";

		try {
			// 1. 드라이버 로딩
			Class.forName(driver);

			// 2. DB와 연동
			con = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	} // openConn() 메서드 end

	// member1 테이블에서 전체 리스트를 가져오는 메서드
	public List<MemberDTO> getMemberList() {

		List<MemberDTO> list = new ArrayList<MemberDTO>();

		try {
			openConn();
			sql = "select * from member1 order by reg_date desc";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				MemberDTO dto = new MemberDTO();
				dto.setId(rs.getString("id"));
				dto.setName(rs.getString("name"));
				dto.setPwd(rs.getString("pwd"));
				dto.setTel(rs.getString("tel"));
				dto.setAddr(rs.getString("addr"));
				dto.setEmail(rs.getString("email"));
				dto.setAge(rs.getInt("age"));
				dto.setReg_date(rs.getString("reg_date"));

				list.add(dto);
			}

			rs.close();
			pstmt.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;
	} // getMemberList() 메서드 end

	public int insertMember(MemberDTO dto) {
		int result = 0;

		try {
			openConn();
			sql = "insert into member1(id, name, pwd, reg_date) values(?,?,?,sysdate)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getName());
			pstmt.setString(3, dto.getPwd());
			result = pstmt.executeUpdate();

			pstmt.close();
			con.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return result;
	} // inserMember 메서드 end

	// member1 테이블에서 회원 아이디에 해당하는 회원의 상세내역을 조회하는ㅁ ㅔ서드
	public MemberDTO contMember(String id) {
		MemberDTO dto = new MemberDTO();

		try {
			openConn();
			sql = "select * from member1 where id=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();

			if (rs.next()) {

				dto.setId(rs.getString("id"));
				dto.setName(rs.getString("name"));
				dto.setPwd(rs.getString("pwd"));
				dto.setTel(rs.getString("tel"));
				dto.setAddr(rs.getString("addr"));
				dto.setEmail(rs.getString("email"));
				dto.setAge(rs.getInt("age"));
				dto.setReg_date(rs.getString("reg_date"));
			}

			rs.close();
			pstmt.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dto;
	} // contMemeber 메서드 end
}
