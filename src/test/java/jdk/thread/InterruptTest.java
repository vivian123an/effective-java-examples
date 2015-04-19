package jdk.thread;

public class InterruptTest {  
    public static void main(String[] args) throws InterruptedException {  
        MyThread t = new MyThread("MyThread");  
        t.start();  
        Thread.sleep(10);// 睡眠100毫秒  
        t.interrupt();// 中断t线程  
    }  
}  
class MyThread extends Thread {  
    int i = 0;  
    public MyThread(String name) {  
        super(name);  
    }  
    public void run() {  
        while(!isInterrupted()) {// 死循环，等待被中断  
            System.out.println(getName() + getId() + "执行了" + ++i + "次");  
        }  
    }  
}  
