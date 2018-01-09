package com.github.test;

public class threadTest  extends Thread  {
	private String threadType;
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName()+"~~~线程启动~~~");
		try {
			sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if ("A".equals(threadType)) {
			System.out.println(Thread.currentThread().getName()+"A处理");
		}else {
			System.out.println(Thread.currentThread().getName()+"B处理");
		}
		
		
		System.out.println(Thread.currentThread().getName()+"~~~线程停止~~~");
	}
	public threadTest(String threadType) {
		this.threadType = threadType;
	}
}
