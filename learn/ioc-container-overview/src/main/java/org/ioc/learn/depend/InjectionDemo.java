package org.ioc.learn.depend;

import org.ioc.learn.repository.UserRespository;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.env.Environment;


/**
 * 依赖查找
 * @Auther: 流水拭剑
 * @Date: 2020/11/15 10:57
 * @Description:
 */
public class InjectionDemo {

	public static void main(String[] args) {
		BeanFactory beanFactory = new ClassPathXmlApplicationContext("META-INF/dependency-injection-context.xml");
		UserRespository userRespository = (UserRespository) beanFactory.getBean("userRespository");
		ObjectFactory<ApplicationContext> objectFactory = userRespository.getObjectFactory();
		System.out.println(userRespository.getUsers());
		System.out.println(userRespository.getBeanFactory());
//		System.out.println(userRespository.getBeanFactory()  == beanFactory);
		System.out.println(objectFactory.getObject());
		// 容器内建Bean
		Environment environment = beanFactory.getBean(Environment.class);
		System.out.println(environment);
	}


}
