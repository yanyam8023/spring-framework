package com.learn.sprinig.beans.definition;

import org.ioc.learn.domain.User;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionReaderUtils;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.annotation.PostConstruct;
import javax.naming.Context;

/**
 * @Auther: 流水拭剑
 * @Date: 2020/11/28 16:53
 * @Description: bean 不会重复注册
 */
@Import(BeanDefinitionRegisterDemo.Config.class)
public class BeanDefinitionRegisterDemo {


	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		// 注册配置类
		context.register(BeanDefinitionRegisterDemo.class);
		registerBeanDefinition(context, "user-1");
		registerBeanDefinition(context);
		// 启动容器
		context.refresh();
		System.out.println("config 配置类：" + context.getBeansOfType(Config.class));
		System.out.println("user 类：" + context.getBeansOfType(User.class));
		context.close();
	}

	// 通过BeanDefinition 注册api 实现
	private static void registerBeanDefinition(BeanDefinitionRegistry registry, String beanName){
		BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(User.class);
		beanDefinitionBuilder
				.addPropertyValue("id", 1)
				.addPropertyValue("name", "有妖气");
		if (StringUtils.hasText(beanName)) {
			registry.registerBeanDefinition(beanName, beanDefinitionBuilder.getBeanDefinition());
		}else {
			BeanDefinitionReaderUtils.registerWithGeneratedName(beanDefinitionBuilder.getBeanDefinition(), registry);
		}
	}

	// 通过非BeanDefinition 实现
	private static void registerBeanDefinition(BeanDefinitionRegistry registry){
		registerBeanDefinition(registry, null);
	}

	@Component
	static class Config{
		@Bean(name = {"user", "youyaoqi"})
		public User user(){
			User user = new User();
			user.setId(1L);
			user.setName("有妖气");
			return user;
		}
	}

}
