//类：矩形
//属性：长 宽
//方法：求面积
package com.oracle.test;

public class test001 {
	int a;
	int b;
	
	test001(int a,int b){
		this.a = a;
		this.b = b;
	}
	
	int Ji() {
		return a*b;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		test001 s = new test001(9,9);
		System.out.println(s.Ji());

	}

}
