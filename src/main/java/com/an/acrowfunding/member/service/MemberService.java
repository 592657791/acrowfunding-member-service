package com.an.acrowfunding.member.service;

import java.util.List;

import com.an.acrowfunding.common.bean.Cert;
import com.an.acrowfunding.common.bean.Member;
import com.an.acrowfunding.common.bean.Ticket;

public interface MemberService {

	Member getMemberByLoginAccout(String loginacct);

	
	Ticket queryTicketByMemberId(Integer id);


	void insertTicket(Ticket ticket);


	int updateAcctType(Member loginMember);


	void updateTicketPstep(Ticket ticket);


	int updateBasicinfo(Member loginMember);


	List<Cert> queryCertsByAccttype(Member loginMember);

}
