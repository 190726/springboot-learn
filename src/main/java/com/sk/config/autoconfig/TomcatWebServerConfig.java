package com.sk.config.autoconfig;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;

import com.sk.config.ConditionalMyOnClass;
import com.sk.config.MyAutoConfiguration;

@MyAutoConfiguration
@ConditionalMyOnClass("org.apache.catalina.startup.Tomcat")
public class TomcatWebServerConfig {
	
	@Value("${contextPath}")
	String  contextPath;
	
	@Bean("tomcatWebServerConfig")
	@ConditionalOnMissingBean
	public ServletWebServerFactory dispatcherServlet(ServerProperties properties){
		
		TomcatServletWebServerFactory factory = new TomcatServletWebServerFactory();
		factory.setContextPath(properties.getContextPath());
		factory.setPort(properties.getPort());
		return factory;
	}
}