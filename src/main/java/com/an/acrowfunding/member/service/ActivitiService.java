package com.an.acrowfunding.member.service;

import java.util.Map;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("atcrowdfunding-activiti-service")
public interface ActivitiService {
	
	@RequestMapping("/act/completeTask")
	public void completeTask(@RequestBody Map<String, Object> variables);
}
