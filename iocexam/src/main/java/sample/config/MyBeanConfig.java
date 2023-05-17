package sample.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

import sample.MyBean;

public class MyBeanConfig {
	@Bean
	@Scope("prototype")
	public MyBean myBean() {
		return new MyBean();
	}
	
	@Bean
	public MyBean myBean2() {
		return new MyBean();
	}
}
