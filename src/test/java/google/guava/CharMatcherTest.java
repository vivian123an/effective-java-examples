package google.guava;

import java.util.regex.Pattern;

import org.junit.Test;

import com.google.common.base.CaseFormat;
import com.google.common.base.CharMatcher;
import com.google.common.base.Charsets;
import com.google.common.base.Splitter;

/**
 * 修剪[trim]、折叠[collapse]、移除[remove]、保留[retain]
 * @author no1
 *
 */
public class CharMatcherTest {

	
	public void test1(){
		String originStr = "ROCKY  rocky  RoCkY ~!@#$%^&*()      23(*&gS   你好 234啊   GES ";
		
		
		System.out.println(originStr.getBytes(Charsets.UTF_8));
		//原字符串  
		System.out.println(originStr);  
		//去掉控制字符(\t,\n,\b...)  
		System.out.println(CharMatcher.JAVA_ISO_CONTROL.removeFrom(originStr));  
		//获取所有的数字  
		System.out.println(CharMatcher.DIGIT.retainFrom(originStr));  
		//把多个空格替换为一个包括\t,并去掉首位的空格  
		System.out.println(CharMatcher.WHITESPACE.trimAndCollapseFrom(originStr, ' '));  
		//把所有的数字用"*"代替  
		System.out.println(CharMatcher.JAVA_DIGIT.replaceFrom(originStr, "*"));  
		//获取所有的数字和小写字母  
		System.out.println(CharMatcher.JAVA_DIGIT.or(CharMatcher.JAVA_LOWER_CASE).retainFrom(originStr));  
		//获取所有的大写字母  
		System.out.println(CharMatcher.JAVA_UPPER_CASE.retainFrom(originStr));  
		//获取所有单字节长度的符号  
		System.out.println(CharMatcher.SINGLE_WIDTH.retainFrom(originStr));  
		
		System.out.println(CaseFormat.UPPER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL, "CONSTANT_NAME"));
		/* 
		原字符串: 
		  ROCKY  rocky  RoCkY ~!@#$%^&*()      23(*&gS   你好 234啊   GES   
		去掉控制字符(\t,\n,\b...): 
		  ROCKY  rocky  RoCkY ~!@#$%^&*()      23(*&gS   你好234啊   GES   
		获取所有的数字: 
		23234 
		把多个空格替换为一个包括\t,并去掉首位的空格: 
		ROCKY rocky RoCkY ~!@#$%^&*() 23(*&gS 你好 234啊 GES 
		把所有的数字用"*"代替: 
		  ROCKY  rocky  RoCkY ~!@#$%^&*()      **(*&gS   你好 ***啊   GES   
		获取所有的数字和小写字母: 
		rockyok23g234 
		获取所有的大写字母: 
		ROCKYRCYSGES 
		获取所有单字节长度的符号: 
		  ROCKY  rocky  RoCkY ~!@#$%^&*()      23(*&gS      234   GES   
		*/  
		
	}
	@Test
	public void test2(){
		String str = "foRo-bar-- G  qux";  
		//使用char作为参数  
		System.out.println(Splitter.on('-').split(str));  
		//使用CharMatcher作为参数  
		System.out.println(Splitter.on(CharMatcher.JAVA_UPPER_CASE).split(str));  
		//使用正则表达式Pattern作为参数  
		System.out.println(Splitter.on(Pattern.compile("[o-]")).split(str));  
		//使用正则表达式字符串作为参数  
		System.out.println(Splitter.onPattern("[o-]").split(str));  
		/* 
		输出结果: 
		[foRo, bar, ,  G  qux] 
		[fo, o-bar-- ,   qux] 
		[f, R, , bar, ,  G  qux] 
		[f, R, , bar, ,  G  qux] 
		 */  
	}
}
