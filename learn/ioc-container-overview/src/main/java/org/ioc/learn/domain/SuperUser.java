package org.ioc.learn.domain;

import org.ioc.learn.annotation.Super;

/**
 * @Auther: 流水拭剑
 * @Date: 2020/11/15 12:00
 * @Description:
 */
@Super
public class SuperUser extends User{
	private String address;

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "SuperUser{" +
				"address='" + address + '\'' +
				"} " + super.toString();
	}
}
