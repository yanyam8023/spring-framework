package com.learn.spring.dependency.lookup;


import org.springframework.beans.factory.ObjectProvider;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

/**
 * @Auther: 流水拭剑
 * @Date: 2020/11/29 11:01
 * @Description:
 */
public class ObjectProviderDemo {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		// 注册配置类
		context.register(ObjectProviderDemo.class);
		// 启动容器
		context.refresh();
		lookupByObjectProvider(context);
		context.close();
	}


	@Bean
	private String helloWorld(){
		return "Hello,World";
	}

	private static void lookupByObjectProvider(AnnotationConfigApplicationContext context){
		ObjectProvider<String> beanProvider = context.getBeanProvider(String.class);
		System.out.println(beanProvider.getObject());
	}
}
