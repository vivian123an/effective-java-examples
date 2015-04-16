package org.effectivejava.examples;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.lang.reflect.UndeclaredThrowableException;

public final class $Proxy0 extends Proxy implements Operate {
	private static Method m4;
	private static Method m1;
	private static Method m5;
	private static Method m0;
	private static Method m3;
	private static Method m2;

	public $Proxy0(InvocationHandler paramInvocationHandler) {
		super(paramInvocationHandler);
	}

	public final void operateMethod1() {
		try {
			h.invoke(this, m4, null);
			return;
		} catch (Error | RuntimeException localError) {
			throw localError;
		} catch (Throwable localThrowable) {
			throw new UndeclaredThrowableException(localThrowable);
		}
	}

	public final void operateMethod2() {
		try {
			h.invoke(this, m5, null);
			return;
		} catch (Error | RuntimeException localError) {
			throw localError;
		} catch (Throwable localThrowable) {
			throw new UndeclaredThrowableException(localThrowable);
		}
	}
	
	public final void operateMethod3() {
		try {
			h.invoke(this, m3, null);
			return;
		} catch (Error | RuntimeException localError) {
			throw localError;
		} catch (Throwable localThrowable) {
			throw new UndeclaredThrowableException(localThrowable);
		}
	}
	
	public final boolean equals(Object paramObject) {
		try {
			return ((Boolean) h.invoke(this, m1, new Object[] { paramObject })).booleanValue();
		} catch (Error | RuntimeException localError) {
			throw localError;
		} catch (Throwable localThrowable) {
			throw new UndeclaredThrowableException(localThrowable);
		}
	}

	public final int hashCode() {
		try {
			return ((Integer) h.invoke(this, m0, null)).intValue();
		} catch (Error | RuntimeException localError) {
			throw localError;
		} catch (Throwable localThrowable) {
			throw new UndeclaredThrowableException(localThrowable);
		}
	}

	public final String toString() {
		try {
			return (String) h.invoke(this, m2, null);
		} catch (Error | RuntimeException localError) {
			throw localError;
		} catch (Throwable localThrowable) {
			throw new UndeclaredThrowableException(localThrowable);
		}
	}

	static {
		try {
			m4 = Class.forName("org.effectivejava.examples.Operate").getMethod("operateMethod1", new Class[0]);
			m1 = Class.forName("java.lang.Object").getMethod("equals",new Class[] { Class.forName("java.lang.Object") });
			m5 = Class.forName("org.effectivejava.examples.Operate").getMethod("operateMethod2", new Class[0]);
			m0 = Class.forName("java.lang.Object").getMethod("hashCode",new Class[0]);
			m3 = Class.forName("org.effectivejava.examples.Operate").getMethod("operateMethod3", new Class[0]);
			m2 = Class.forName("java.lang.Object").getMethod("toString",new Class[0]);
		} catch (NoSuchMethodException localNoSuchMethodException) {
			throw new NoSuchMethodError(localNoSuchMethodException.getMessage());
		} catch (ClassNotFoundException localClassNotFoundException) {
			throw new NoClassDefFoundError(localClassNotFoundException.getMessage());
		}
	}

	/*
	 * static{ try { m4 =
	 * Class.forName("com.codekk.java.test.dynamicproxy.Operate"
	 * ).getMethod("operateMethod1", new Class[0]); m1 =
	 * Class.forName("java.lang.Object").getMethod("equals", new Class[] {
	 * Class.forName("java.lang.Object") }); m5 =
	 * Class.forName("com.codekk.java.test.dynamicproxy.Operate"
	 * ).getMethod("operateMethod2", new Class[0]); m0 =
	 * Class.forName("java.lang.Object").getMethod("hashCode", new Class[0]); m3
	 * = Class.forName("com.codekk.java.test.dynamicproxy.Operate").getMethod(
	 * "operateMethod3", new Class[0]); m2 =
	 * Class.forName("java.lang.Object").getMethod("toString", new Class[0]);
	 * return; } catch (NoSuchMethodException localNoSuchMethodException) {
	 * throw new NoSuchMethodError(localNoSuchMethodException.getMessage()); }
	 * catch (ClassNotFoundException localClassNotFoundException) { throw new
	 * NoClassDefFoundError(localClassNotFoundException.getMessage()); } }
	 */
}
