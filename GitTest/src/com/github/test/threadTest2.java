package com.github.test;

public class threadTest2 implements Runnable {
	
	private  static threadTest2 test2 = null;
	private int tickets = 100;  
    
	
    
    private synchronized void sale(){  
        if(tickets > 0){  
            System.out.println(this.hashCode()+Thread.currentThread().getName() + "卖出 第 "+ (tickets--)+"张票");  
              
            try{  
                Thread.sleep(100);  
            }catch(InterruptedException e){  
                e.printStackTrace();  
            }  
        }  
    }  
    public void run(){  
        while(tickets > 0){  
            sale();  
        }  
    }  
    //私有化构造方法，不可以new实例
    private threadTest2() {
 
	}
    public static threadTest2 geTest2(){
    	if (test2==null) {
			synchronized (threadTest2.class) {
				if (test2==null) {
					test2 = new threadTest2();
				}
			}
		}
    	return test2;
    }
}
