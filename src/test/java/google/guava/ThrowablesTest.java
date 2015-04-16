package google.guava;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import org.junit.Test;

import com.google.common.base.Throwables;

public class ThrowablesTest {
	@Test
    public void testThrowables(){
        try {
            throw new Exception();
        } catch (Throwable t) {
            String ss = Throwables.getStackTraceAsString(t);
            System.out.println("ss:"+ss);
            Throwables.propagate(t);
        }
    }
    
    //@Test
    public void call() throws IOException {
        try {
            throw new IOException();
        } catch (Throwable t) {
            Throwables.propagateIfInstanceOf(t, IOException.class);
            throw Throwables.propagate(t);
        }
    }    
    
    //将检查异常转换成未检查异常
    @Test
    public void testCheckException(){
        try {  
            URL url = new URL("http://ociweb.com");  
            final InputStream in = url.openStream();  
            in.close();  
        } catch (Throwable t) {  
            throw Throwables.propagate(t);  
        }  
    }
    
    @Test
    public void testThrowables2(){
        try {
            throw new Exception();
        } catch (Throwable t) {
            String ss = Throwables.getStackTraceAsString(t);
            System.out.println("ss:"+ss);
            Throwables.propagate(t);
        }
    }
    
    @Test
    public void call2() throws IOException {
        try {
            throw new IOException();
        } catch (Throwable t) {
            Throwables.propagateIfInstanceOf(t, IOException.class);
            throw Throwables.propagate(t);
        }
    }
    
    public Void testPropagateIfPossible() throws Exception {
          try {
              throw new Exception();
          } catch (Throwable t) {
            Throwables.propagateIfPossible(t, Exception.class);
            Throwables.propagate(t);
          }

          return null;
    }
}
