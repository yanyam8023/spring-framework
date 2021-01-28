package org.ioc.learn.iocContainer;

import org.ioc.learn.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.Map;

/**
 *
 * @Auther: 流水拭剑
 * @Date: 2020/11/21 17:13
 * @Description:
 */
public class AnnoatationiocContainerDemo {

	public static void main(String[] args) {
		// 创建beanFactory 容器
		AnnotationConfigApplicationContext beanFactory = new AnnotationConfigApplicationContext();
		// 将当前类作为配置类
		beanFactory.register(AnnoatationiocContainerDemo.class);
		// 启动应用上下文
		beanFactory.refresh();
		lookUpCollectionByType(beanFactory);
	}

	@Bean
	public User user(){
		User user = new User();
		user.setId(1L);
		user.setName("有妖气");
		return user;
	}


	private static void lookUpCollectionByType(BeanFactory beanFactory) {
		if (beanFactory instanceof ListableBeanFactory) {
			ListableBeanFactory listableBeanFactory = (ListableBeanFactory) beanFactory;
			Map<String, User> map = listableBeanFactory.getBeansOfType(User.class);
			System.out.println("查找集合：" + map);
		}
	}
}

