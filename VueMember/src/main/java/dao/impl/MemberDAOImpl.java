package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dao.MemberDAO;
import dto.MemberDTO;
import util.ConnectionManager;

public class MemberDAOImpl implements MemberDAO {

	@Override
	public void joinMember(String id, String name, String email) throws Exception {
		String sql = "insert into memberinfo (id, name, email, joindate) values (?, ?, ?, now())";
		Connection conn = ConnectionManager.getConnection();
		PreparedStatement pstmt =  conn.prepareStatement(sql);
		pstmt.setString(1, id);
		pstmt.setString(2, name);
		pstmt.setString(3, email);
		pstmt.executeUpdate();
		System.out.println("가입!");
	}

	@Override
	public List<MemberDTO> listMember() throws Exception {
		String sql = " select * from memberinfo ";
		Connection conn = ConnectionManager.getConnection();
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		
		List<MemberDTO> list = new ArrayList<MemberDTO>();
		
		while(rs.next()) {
		MemberDTO mDTO = new MemberDTO();
			mDTO.setId(rs.getString("id"));
			mDTO.setName(rs.getString("name"));
			mDTO.setEmail(rs.getString("email"));
			mDTO.setJoindate(rs.getTimestamp("joindate"));
			list.add(mDTO);
		}
		return list;
	}

	@Override
	public MemberDTO viewMember(String id) throws Exception {
		String sql = " select * from memberinfo m where m.id = ? ";
		Connection conn = ConnectionManager.getConnection();
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, id);
		ResultSet rs = pstmt.executeQuery();
		MemberDTO mDTO = new MemberDTO();
		mDTO.setId(rs.getString("id"));
		mDTO.setName(rs.getString("name"));
		mDTO.setEmail(rs.getString("email"));
		mDTO.setJoindate(rs.getTimestamp("jointime"));
		
		
		return mDTO;
	}


	}

