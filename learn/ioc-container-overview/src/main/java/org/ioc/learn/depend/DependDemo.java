package org.ioc.learn.depend;

import org.ioc.learn.annotation.Super;
import org.ioc.learn.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;

/**
 * 依赖查找
 * @Auther: 流水拭剑
 * @Date: 2020/11/15 10:57
 * @Description:
 */
public class DependDemo {

	public static void main(String[] args) {
		BeanFactory beanFactory = new ClassPathXmlApplicationContext("META-INF/dependency-lookup-context.xml");
//		lookUpInRealTime(beanFactory);
//		lookUpInLazy(beanFactory);
		lookUpByType(beanFactory);
//		lookUpCollectionByType(beanFactory);
		lookUpByAnnotationType(beanFactory);
	}

	private static void lookUpByAnnotationType(BeanFactory beanFactory) {
		if (beanFactory instanceof ListableBeanFactory) {
			ListableBeanFactory listableBeanFactory = (ListableBeanFactory) beanFactory;
			Map<String, Object> beansWithAnnotation = listableBeanFactory.getBeansWithAnnotation(Super.class);
			System.out.println("所有标注@Super注解：" + beansWithAnnotation);
		}
	}

	private static void lookUpCollectionByType(BeanFactory beanFactory) {
		if (beanFactory instanceof ListableBeanFactory) {
			ListableBeanFactory listableBeanFactory = (ListableBeanFactory) beanFactory;
			Map<String, User> map = listableBeanFactory.getBeansOfType(User.class);
			System.out.println("查找集合：" + map);
		}
	}

	/**
	 * 根据类型查找，会查找到所有符合该类型的bean，需要配置primary属性
	 * @param beanFactory
	 */
	private static void lookUpByType(BeanFactory beanFactory) {
		User user = beanFactory.getBean(User.class);
		System.out.println("根据类型查找：" +user);
	}

	private static void lookUpInRealTime(BeanFactory beanFactory){
		User user = (User) beanFactory.getBean("user");
		System.out.println("实施依赖查找："+user);
	}

	@SuppressWarnings("unchecked")
	private static void lookUpInLazy(BeanFactory beanFactory){
		ObjectFactory<User> objectFactory = (ObjectFactory<User>) beanFactory.getBean("objectFactory");
		User user = objectFactory.getObject();
		System.out.println("延时依赖查找：" + user);
	}

}
