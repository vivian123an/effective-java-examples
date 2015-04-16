package org.effectivejava.examples;

import java.lang.reflect.Method;
import java.net.URL;
/**
 * A classLoader is sun.misc.Launcher$AppClassLoader@7692ed85 n
 * B classLoader is sun.misc.Launcher$AppClassLoader@7692ed85 n
 * A.b classLoader is sun.misc.Launcher$AppClassLoader@7692ed85 n
 * Exception in thread "main" java.net.MalformedURLException: no protocol: file
 * 
 * 这个类的作用是可以重新载入同名的类， 但是， 为了实现hotswap, 老的对象状态
需要通过其他方式拷贝到重载过的类生成的全新实例中来。(A类中的b实例)
而新实例所依赖的B类如果与老对象不是同一个类加载器加载的， 将会抛出类型转换异常(ClassCastException).
为了解决这种问题， HotSwapClassLoader自定义了load方法. 

即当前类是由自身classLoader加载的， 而内部依赖的类还是老对象的classLoader加载的.

 * @author no1
 *
 */

public class ClassLoaderTest {
	public static void main(String args[]) throws Exception {
		A a = new A();
		B b = new B();
		a.setB(b);

		System.out.printf("A classLoader is %s n", a.getClass().getClassLoader());
		System.out.printf("B classLoader is %s n", b.getClass().getClassLoader());
		System.out.printf("A.b classLoader is %s n", a.getB().getClass().getClassLoader());

		HotSwapClassLoader c1 = new HotSwapClassLoader(new URL[] { new URL("file:\\D:\\Users\no1\\git\\effective-java-examples\\target\\test-classes\\org\\effectivejava\\examples\\") }, a.getClass().getClassLoader());
		
		//D:\\Users\\no1\\git\\effective-java-examples\\src\\test\\java\\org\effectivejava\examples
		//E:\\\Users\\vivian\\workspace\\.metadata\\.plugins\\org.eclipse.debug.core\\.launches
		//D:\\Users\no1\\git\\effective-java-examples\\target\\test-classes\\org\\effectivejava\\examples
		
		Class clazz = c1.load("org.effectivejava.examples.A");
		Object aInstance = clazz.newInstance();

		Method method1 = clazz.getMethod("setB", B.class);
		method1.invoke(aInstance, b);

		Method method2 = clazz.getMethod("getB", null);
		Object bInstance = method2.invoke(aInstance, null);

		System.out.printf(" reloaded A.b classLoader is %s n", bInstance.getClass().getClassLoader());
	}
}
