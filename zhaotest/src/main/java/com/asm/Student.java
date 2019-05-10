package com.asm;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

class Student {
	private int age;
	private String name=null;

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public static void main(String args[]){
		String str=ToStringBuilder.reflectionToString(new Student(), ToStringStyle.SHORT_PREFIX_STYLE);
		System.out.println(str);
	}

}
