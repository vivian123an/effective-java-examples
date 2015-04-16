package google.guava;

import java.util.ArrayList;
import java.util.Map;

import com.google.common.base.Function;
import com.google.common.base.Joiner;
import com.google.common.base.Predicate;
import com.google.common.base.Splitter;
import com.google.common.base.Strings;
import com.google.common.collect.Collections2;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

public class JoinerTest {

	private static final Splitter COMMA_SPLITTER = Splitter.on(',').trimResults().omitEmptyStrings();
	
	public void test(){
		String str = "test1, , test2, test3";
		Iterable<String> strArr = Splitter.on(',').trimResults().omitEmptyStrings().split(str);
		  
		//Output:->
		//["test1", "test2", "test3"]

		str = "key1: 1; key2: 2  ; key3: 3";
		Map<String, String> m = Splitter.on(';')
		  .trimResults()
		  .withKeyValueSeparator(":")
		  .split(str);
		  
		//Output:->
		//{key1= 1, key2= 2, key3= 3}
		
		COMMA_SPLITTER.split("foo, ,bar, quux,");
		//Output:->
		//["foo", "bar", "quux"]

		ArrayList<String> strArr1 = Lists.newArrayList("test1","test2","test3",null,"test4",null,null);
		  
		Joiner.on(';')
		  .skipNulls()
		  .join(strArr1);
		//Output:->
		//"test1;test2;test3;test4"
		
		Joiner.on(';').useForNull("_").join(strArr1);
		//Output:->
		//"test1;test2;test3;_;test4;_;_"
	
		Map<String, String> map = Maps.newHashMap();
		map.put("key1", "value1");
		map.put("key2", "value2");
		map.put("key3", null);
		map.put("key4", "value3");
		   
		Joiner.on(';')
		 .useForNull("NULL")
		 .withKeyValueSeparator("=")
		 .join(map);
		  
		//Output:->
		//"key4=value3;key3=NULL;key2=value2;key1=value1"
		
		strArr = Lists.newArrayList( " test1","test2 "," test3 ",null,"test4",null,null,"", "  ");
		Predicate<String> EMPTY_OR_NULL_FILTER = new Predicate<String>() {
			 @Override
			 public boolean apply(String str){
			  str = Strings.nullToEmpty(str).trim();
			  return !Strings.isNullOrEmpty(str);
			 }
		};
		  
		Function<String, String> TRIM_RESULT = new Function<String, String>(){
			 @Override
			 public String apply(String str){
			  return Strings.nullToEmpty(str).trim();
			 }
		};
		    
		//String joinStr = Joiner.on(';').skipNulls().join(Collections2.transform(Collections2.filter(strArr, EMPTY_OR_NULL_FILTER), TRIM_RESULT));
		  
		//Output:->"test1;test2;test3;test4"
		    
	}
	
	public static void main(String[] args) {
		 
        String tmpValue = "a_b_c_1_2_3";
        String[] valArr = tmpValue.split("_");
         
        // 求字符串数组的子串，并最后拼接起来
        String tmpVal = "";
        for (int i = 1; i < valArr.length; i++) {
            tmpVal = tmpVal.equalsIgnoreCase("") ? valArr[i] : tmpVal + "_" + valArr[i];
        }
        System.out.println(tmpVal);
        System.out.println("———————");
         
        // 上面这么一段与下面这句等价
        System.out.println(Joiner.on("_").join(Lists.newArrayList(valArr).subList(1, valArr.length)));
        
        /*// 结果：
        b_c_1_2_3
        ———————
        b_c_1_2_3*/
 
    }
 

}
