package com.an.acrowfunding.member;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableFeignClients
@EnableTransactionManagement
@EnableDiscoveryClient
@MapperScan("com.an.acrowfunding.member.dao")
@SpringBootApplication
public class AcrowfundingSpringbootMemberServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AcrowfundingSpringbootMemberServiceApplication.class, args);
	}
}
