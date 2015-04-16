package google.guava;

import org.junit.Test;

import com.google.common.base.Splitter;

public class SplitterTest {
	
	/**
	 * 需要注意的：Splitter对象是immutable的，所以在你为Splitter对象添加配置方的时候，你必须用一个新的Splitter对象去接收，如下:
	 */
	@Test
	public void test() {
		// Do NOT do this
		Splitter splitter = Splitter.on('/');
		splitter = splitter.trimResults(); // 你必须用一个新的Splitter对象去接收
		System.out.println(splitter.split("wrong / wrong / wrong"));
	}
}
