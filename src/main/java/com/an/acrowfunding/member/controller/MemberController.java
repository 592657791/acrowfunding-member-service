package com.an.acrowfunding.member.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.an.acrowfunding.common.bean.Cert;
import com.an.acrowfunding.common.bean.Member;
import com.an.acrowfunding.common.bean.Ticket;
import com.an.acrowfunding.member.service.ActivitiService;
import com.an.acrowfunding.member.service.MemberService;

@RestController
public class MemberController {

	@Autowired
	MemberService memberService;
	
	//通过会员的类型查询资质
	@RequestMapping("/member/queryCertsByAccttype")
	public List<Cert> queryCertsByAccttype(@RequestBody Member loginMember) {
		List<Cert> certs = memberService.queryCertsByAccttype(loginMember);
		return certs;
	}
	
	
	@RequestMapping("/member/updateBasicinfo")
	public int updateBasicinfo(@RequestBody Member loginMember) {
		//更新基本信息
		int count = memberService.updateBasicinfo(loginMember);
		return count;
	}
	
	@RequestMapping("/member/updateAcctType")
	public int updateAcctType(@RequestBody Member loginMember) {
		//更新会员账户类型
		int count = memberService.updateAcctType(loginMember);
		return count;
	}
	
	@RequestMapping("/member/insertTicket")
	public void insertTicket(@RequestBody Ticket ticket) {
		
		memberService.insertTicket(ticket);
		
	}
	
	@RequestMapping("/member/login/{loginacct}")
	public Member getMemberByLoginAccout(@PathVariable("loginacct")String loginacct) {
		Member member = memberService.getMemberByLoginAccout(loginacct);
		return member;
	}
	
	@RequestMapping("/member/queryTicketByMemberId/{id}")
	public Ticket queryTicketByMemberId(@PathVariable("id")Integer id) {
		
		return memberService.queryTicketByMemberId(id);
		
	}
	
	
}
