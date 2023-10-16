package com.kh.service;

import java.sql.Connection;

import com.kh.common.JDBCTemplate;
import com.kh.member.model.dao.MemberDao;
import com.kh.vo.Member;

public class ScoreService {
	
	public Member testScore(String StudentName,String StudentId
			,int koreanScore,int mathScore,int englishScore,int scienceScore) {
		Connection conn = JDBCTemplate.getConnection();
		Member me = new ScoreDao().loginMember(conn, StudentName, StudentId, koreanScore, mathScore, englishScore, scienceScore);
		JDBCTemplate.close(conn);
	
	
		return me
}
