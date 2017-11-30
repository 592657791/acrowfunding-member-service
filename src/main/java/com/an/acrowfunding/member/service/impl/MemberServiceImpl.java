package com.an.acrowfunding.member.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.an.acrowfunding.common.bean.Cert;
import com.an.acrowfunding.common.bean.Member;
import com.an.acrowfunding.common.bean.Ticket;
import com.an.acrowfunding.member.dao.MemberMapper;
import com.an.acrowfunding.member.service.ActivitiService;
import com.an.acrowfunding.member.service.MemberService;

@Transactional
@Service
public class MemberServiceImpl implements MemberService{

	@Autowired
	private MemberMapper memberMapper;
	
	@Autowired
	ActivitiService activitiService;
	
	
	@Override
	public Member getMemberByLoginAccout(String loginacct) {
		// TODO Auto-generated method stub
		return memberMapper.getMemberByLoginAccout(loginacct);
	}

	@Override
	public Ticket queryTicketByMemberId(Integer id) {
		return memberMapper.queryTicketByMemberId(id);
	}

	@Override
	public void insertTicket(Ticket ticket) {
		memberMapper.insertTicket(ticket);
	}

	@Override
	public int updateAcctType(Member loginMember) {
		int count = memberMapper.updateAcctType(loginMember);
		//更新流程单的Pstep值
		Ticket ticket = memberMapper.queryTicketByMemberId(loginMember.getId());
		ticket.setPstep("basicinfo");
		memberMapper.updateTicketPstep(ticket);
		
		Map<String, Object> variables = new HashMap<>();
		variables.put("piid", ticket.getPiid());
		variables.put("loginacct", loginMember.getLoginacct());
		
		System.out.println("updateAcctType  Map:"+variables.get("loginacct"));
		
		activitiService.completeTask(variables);
		return count;
	}

	@Override
	public void updateTicketPstep(Ticket ticket) {
		memberMapper.updateTicketPstep(ticket);
	}

	@Override
	public int updateBasicinfo(Member loginMember) {
		int count = memberMapper.updateBasicinfo(loginMember);
		//更新流程单的Pstep值
		Ticket ticket = memberMapper.queryTicketByMemberId(loginMember.getId());
		ticket.setPstep("uploadfile");
		memberMapper.updateTicketPstep(ticket);
		
		Map<String, Object> variables = new HashMap<>();
		variables.put("piid", ticket.getPiid());
		variables.put("loginacct", loginMember.getLoginacct());
		variables.put("flag", true);
		//System.out.println("updateAcctType  Map:"+variables.get("loginacct"));
		
		activitiService.completeTask(variables);
		return count;
	}

	@Override
	public List<Cert> queryCertsByAccttype(Member loginMember) {
		List<Cert> certs = memberMapper.queryCertsByAccttype(loginMember);
		return certs;
	}

}
