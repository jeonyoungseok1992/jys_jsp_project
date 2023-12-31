package com.kh.member.model.service;

import java.sql.Connection;

import static com.kh.common.JDBCTemplate.*;
import com.kh.member.model.dao.MemberDao;
import com.kh.member.model.vo.Member;

public class MemberService {
	
	public Member loginMember(String userId, String userPwd) {
		Connection conn = getConnection();
		Member me = new MemberDao().loginMember(conn, userId, userPwd);
		close(conn);
		return me;
	}
	
	
	public int insertMember(Member m) {
		Connection conn = getConnection();
		int result = new MemberDao().insertMember(conn, m);
		
		if(result >0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}
	
	public Member updateMember(Member m) {
		Connection conn = getConnection();
		int result = new MemberDao().updateMember(conn, m);
		
		Member updateMem = null;
		
		if(result >0) {
			commit(conn);
			//갱신 된 회원 객체 다시 조회해오기
			updateMem =  new MemberDao().selectMember(conn, m.getUserId());
		} else {
			rollback(conn);
		}
		
		close(conn);
		
		return updateMem;
		
	}
	
	public Member updatePwdMember(String userId,String userPwd,String updatePwd) {
		Connection conn = getConnection();
		int result = new MemberDao().updatePwdMember(conn, userId, userPwd, updatePwd);
		System.out.println(result);
		Member updateMem = null;
		
		if(result >0) {
			commit(conn);
			//갱신 된 회원 객체 다시 조회해오기
			updateMem =  new MemberDao().selectMember(conn, userId);
		} else {
			rollback(conn);
		}
		
		close(conn);
		
		return updateMem;
	}
	
	public int deleteMember(String userId, String userPwd) {
		Connection conn = getConnection();
		int result = new MemberDao().deleteMember(conn, userId, userPwd);
		
		if (result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		close(conn);
		return result;
	}

}
