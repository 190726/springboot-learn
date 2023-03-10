package com.sk.helloboot;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class HelloServiceTest {
	
	@Test
	void simpleHelloService() {
		HelloService helloService = new SimpleHelloService();
		String ret = helloService.sayHello("Test");
		
		Assertions.assertThat(ret).isEqualTo("Hello Test");
	}
}