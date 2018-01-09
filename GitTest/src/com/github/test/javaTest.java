package com.github.test;

public class javaTest {
	
	public static void main(String[] args) {
		/*threadTest threadTest1 = new threadTest("A");
		threadTest threadTest2 = new threadTest("B");
		threadTest1.start();
		threadTest2.start();*/
		new javaTest().test();
		System.out.println("hello world!");
	}
	private void test() {
		// TODO Auto-generated method stub
		Thread t1 = new Thread(threadTest2.geTest2());
		Thread t2 = new Thread(threadTest2.geTest2());
		
		t1.start();t2.start();
		System.out.println("测试！");
	}
	
	
	
}
