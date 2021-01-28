package org.ioc.learn.domain;

/**
 * @Auther: 流水拭剑
 * @Date: 2020/11/15 10:53
 * @Description:
 */
public class User {
	private Long id;
	private String name;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "User{" +
				"id=" + id +
				", name='" + name + '\'' +
				'}';
	}
}
