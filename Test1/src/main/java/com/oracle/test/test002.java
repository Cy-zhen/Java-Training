//立方体
package com.oracle.test;

public class test002 {
	int a;//长
	int b;//宽
	int c;//高
	test002(int a,int b,int c){
		this.a = a;
		this.b = b;
		this.c = c;
	}
	int area() {
		return 2*(a*b+a*c+b*c);
	}
	int volume() {
		return (a*b*c);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		test002 s = new test002(3,4,5);
		System.out.println(s.area());
		System.out.println(s.volume());

		
		
	}

}
