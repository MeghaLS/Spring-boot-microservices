package com.intuit;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//beans.xml
@Configuration
public class MyConfiguration {

	@Bean
	public List<String> operations(){
		return Arrays.asList("add", "subtract", "square", "product");
	}
	/*
	 * <beans>
			<util:list id="operations">
				<value>add</value>
				<value>subtract</value>
			</util>
		</beans>
	 * */
	
	
}
