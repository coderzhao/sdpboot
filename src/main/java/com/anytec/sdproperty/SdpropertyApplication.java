package com.anytec.sdproperty;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;

@SpringBootApplication
@MapperScan(basePackages = { "com.anytec.sdproperty.dao" }, sqlSessionFactoryRef = "sqlSessionFactory")
//@EnableWebSocketMessageBroker
public class SdpropertyApplication {

	public static void main(String[] args) {
		SpringApplication.run(SdpropertyApplication.class, args);
	}
}
