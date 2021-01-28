package org.ioc.learn.iocContainer;

import org.ioc.learn.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

import java.util.Map;

/**
 *
 * @Auther: 流水拭剑
 * @Date: 2020/11/21 17:13
 * @Description:
 */
public class iocContainerDemo {

	public static void main(String[] args) {
		// 创建beanFactory 容器
		DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
		// 读取配置
		XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
		// 加载xml中定义的bean个数
		int beans = reader.loadBeanDefinitions("META-INF/dependency-lookup-context.xml");
		System.out.println("定义了" + beans + "对象");
		lookUpCollectionByType(beanFactory);
	}


	private static void lookUpCollectionByType(BeanFactory beanFactory) {
		if (beanFactory instanceof ListableBeanFactory) {
			ListableBeanFactory listableBeanFactory = (ListableBeanFactory) beanFactory;
			Map<String, User> map = listableBeanFactory.getBeansOfType(User.class);
			System.out.println("查找集合：" + map);
		}
	}
}

