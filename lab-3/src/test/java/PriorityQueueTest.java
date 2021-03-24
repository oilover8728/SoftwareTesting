import com.sun.jdi.connect.Connector;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.runners.Parameterized;


import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.stream.Stream;

public class PriorityQueueTest {
    static Stream<Arguments> stringIntAndListProvider(){
        return Stream.of(
          Arguments.of(new int[]{5,4,2,3},new int[]{2,3,4,5}),
          Arguments.of(new int[]{5,4,3,2,1},new int[]{1,2,3,4,5}),
          Arguments.of(new int[]{6,8,9,4,1},new int[]{1,4,6,8,9}),
          Arguments.of(new int[]{6,5,4,3,2,1},new int[]{1,2,3,4,5,6}),
          Arguments.of(new int[]{2,3,1},new int[]{1,2,3})
        );
    }
    @ParameterizedTest(name="#{index} - Test with Argument={0},{1}")
    @MethodSource("stringIntAndListProvider")
    public  void PriorityQueue_RunTest(int[] random_array,int[] correct_array){
        PriorityQueue<Integer> test = new PriorityQueue<Integer>();
        int index=0;
        Integer s;
        int[] result=new int[random_array.length];

        for(int i=0;i<random_array.length;i++){
            test.add(random_array[i]);
        }
        for(int i=0;i<random_array.length;i++){
            result[i]=test.poll();
        }

        assertArrayEquals(correct_array,result);
    }
    @Test
    public void whenExceptionThrown_thenAssertionSucceeds(){
        Exception exception = assertThrows(NumberFormatException.class, () ->{
            Integer.parseInt("1a");
        });

        String expectedMessage = "For input string";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }
    @Test
    public void whenExceptionThrown1_thenAssertionSucceeds(){
        assertThrows(NullPointerException.class, () ->{
            PriorityQueue a=new PriorityQueue();
            a.offer(null);
        });
    }
    @Test
    public void whenExceptionThrown2_thenAssertionSucceeds(){
        assertThrows(ClassNotFoundException.class, () ->{
            PriorityQueue a=new PriorityQueue();
            Class.forName("oracle.jdbc.driver.OracleDriver");
        });
    }
    @Test
    public void whenExceptionThrown3_thenAssertionSucceeds(){
        assertThrows(IllegalArgumentException.class, () ->{
            PriorityQueue a=new PriorityQueue(0);
        });
    }
    @Test
    public void whenExceptionThrown4_thenAssertionSucceeds(){
        assertThrows(ClassCastException.class, () ->{
            PriorityQueue a=new PriorityQueue();
            a.offer(1);
            a.offer(a);
        });
    }

}

