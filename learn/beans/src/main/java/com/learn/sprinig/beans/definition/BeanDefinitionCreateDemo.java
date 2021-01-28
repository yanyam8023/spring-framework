package com.learn.sprinig.beans.definition;


import org.ioc.learn.domain.User;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.GenericBeanDefinition;

/**
 * @Auther: 流水拭剑
 * @Date: 2020/11/22 13:49
 * @Description:
 */
public class BeanDefinitionCreateDemo {

	public static void main(String[] args) {
		// beanDefinitionBuilder 构建bean
		BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(User.class);
		beanDefinitionBuilder.addPropertyValue("id", 1L);
		beanDefinitionBuilder.addPropertyValue("name", "有妖气");
		beanDefinitionBuilder.getBeanDefinition();

		// AbstractBeanDefinition 构建
		GenericBeanDefinition genericBeanDefinition = new GenericBeanDefinition();
		genericBeanDefinition.setBeanClass(User.class);
		MutablePropertyValues propertyValues = new MutablePropertyValues();
		propertyValues
				.add("id", 1L)
				.add("name", "有妖气");
		genericBeanDefinition.setPropertyValues(propertyValues);
	}
}
