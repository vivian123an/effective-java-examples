package org.effectivejava.examples;

import java.util.concurrent.TimeUnit;

import com.google.common.util.concurrent.SimpleTimeLimiter;
import com.google.common.util.concurrent.TimeLimiter;

/**
 * 与装饰模式的区别：
 * 装饰模式关注于在一个对象上动态的添加方法，然而代理模式关注于控制对对象的访问。换句话 说，用代理模式，代理类可以对它的客户隐藏一个对象的具体信息。
 * 因此，当使用代理模式的时候，我们通常在一个代理类中创建一个对象的实例。当我们使用装饰器模式的时候，我们通常的做法是将原始对象作为一个参数传给装饰者的构造器。
 * 
 * 使用代理模式，代理和真实对象之间的的关系通常在编译时就已经确定了，而装饰者能够在运行时递归地被构造，
 * @author vivian.chen
 * @since  2015.04.13
 *
 */


public class GuavaTest {
	public static void main(String[] args) {
        /*Image image = new ProxyImage("MyPhoto");
        image.displayImage();*/
        
        TimeLimiter limiter = new SimpleTimeLimiter();
        Image image = new ProxyImage("MyPhoto");
        Image proxy = limiter.newProxy(image, Image.class, 1000, TimeUnit.MILLISECONDS);
        try {
            proxy.displayImage();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

interface Image {
    public void displayImage();
}

class RealImage implements Image {
    private String filename;
    public RealImage(String filename) {
        this.filename = filename;
        loadImageFromDisk();
    }

    private void loadImageFromDisk() {
        System.out.println("Loading   " + filename);
    }

    public void displayImage() {
        System.out.println("Displaying " + filename);
    }
}

class ProxyImage implements Image {
    private String filename;
    private Image image;

    public ProxyImage(String filename) {
        this.filename = filename;
    }
    public void displayImage() {
        if(image == null)
            image = new RealImage(filename);
        image.displayImage();
    }
}