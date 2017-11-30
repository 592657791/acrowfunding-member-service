package com.an.acrowfunding.member.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.an.acrowfunding.common.bean.Cert;
import com.an.acrowfunding.common.bean.Member;
import com.an.acrowfunding.common.bean.Ticket;

public interface MemberMapper {
	
	@Select("select * from t_member where loginacct = #{loginacct}")
	public Member getMemberByLoginAccout(String loginacct);

	@Select("select * from t_ticket where memberid = #{id} and status = '0'")
	public Ticket queryTicketByMemberId(Integer id);

	@Insert("insert into t_ticket(memberid,piid,status,pstep) values(#{memberid},#{piid},#{status},#{pstep})")
	public void insertTicket(Ticket ticket);

	@Update("update t_member set accttype = #{accttype} where id = #{id}")
	public int updateAcctType(Member loginMember);

	@Update("update t_ticket set pstep = #{pstep} where id = #{id}")
	public void updateTicketPstep(Ticket ticket);

	@Update("update t_member set realname = #{realname},cardnum=#{cardnum},tel=#{tel} where id = #{id}")
	public int updateBasicinfo(Member loginMember);

	@Select("select * from t_cert where id in (select certid from t_account_type_cert where accttype = #{accttype})")
	public List<Cert> queryCertsByAccttype(Member loginMember);
	
}
