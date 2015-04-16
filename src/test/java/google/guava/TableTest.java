package google.guava;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.google.common.collect.ClassToInstanceMap;
import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.MutableClassToInstanceMap;
import com.google.common.collect.Range;
import com.google.common.collect.RangeSet;
import com.google.common.collect.Table;
import com.google.common.collect.TreeRangeSet;
/**
 * guava Table 对应JDK 数据结构  Map<row, Map<column, value>>
 * @author no1
 *
 */
public class TableTest {
    public void TableTest(){
        Table<String, Integer, String> aTable = HashBasedTable.create();  
 
        for (char a = 'A'; a <= 'C'; ++a) {  
            for (Integer b = 1; b <= 3; ++b) {   
                aTable.put(Character.toString(a), b, String.format("%c%d", a, b));  
            }  
        }  
   
        System.out.println(aTable);
        System.out.println(aTable.column(2));  
        System.out.println(aTable.row("B"));   
        System.out.println(aTable.get("B", 2));  
        System.out.println(aTable.contains("D", 1));   
        System.out.println(aTable.containsColumn(3));   
        System.out.println(aTable.containsRow("C"));  
        System.out.println(aTable.columnMap()); 
        System.out.println(aTable.rowMap());   
        System.out.println(aTable.remove("B", 3)); 
        System.out.println(aTable);
    }
	
    public  void ClassToInstanceMapTest() {
        ClassToInstanceMap<String> classToInstanceMapString = MutableClassToInstanceMap.create();
        ClassToInstanceMap<Person> classToInstanceMap = MutableClassToInstanceMap.create();
        Person person= new Person("peida",20);
        System.out.println("person name :"+person.name+" age:"+person.age);
        classToInstanceMapString.put(String.class, "peida");
        System.out.println("string:"+classToInstanceMapString.getInstance(String.class));
        
        classToInstanceMap.putInstance(Person.class,person);
        Person person1=classToInstanceMap.getInstance(Person.class);
        System.out.println("person1 name :"+person1.name+" age:"+person1.age);
    }
	
	@Test
    public void RangeSetTest(){
        RangeSet<Integer> rangeSet = TreeRangeSet.create();
        rangeSet.add(Range.closed(1, 10));
        System.out.println("rangeSet:"+rangeSet);
        rangeSet.add(Range.closedOpen(11, 15)); 
        System.out.println("rangeSet:"+rangeSet);
        rangeSet.add(Range.open(15, 20));
        System.out.println("rangeSet:"+rangeSet);
        rangeSet.add(Range.openClosed(0, 0)); 
        System.out.println("rangeSet:"+rangeSet);
        rangeSet.remove(Range.open(5, 10)); 
        System.out.println("rangeSet:"+rangeSet);
        
        Map<String, Map<Long, List<String>>> map = Maps.newHashMap();
        ArrayList<String> list3 = Lists.newArrayList("a","b","c","d");
    }
}

class Person {
    public String name;
    public int age;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
} 
