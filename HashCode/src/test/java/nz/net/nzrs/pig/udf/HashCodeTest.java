package nz.net.nzrs.pig.udf;

import org.apache.pig.data.Tuple;
import org.apache.pig.data.TupleFactory;

import java.io.IOException;
import java.util.Arrays;

import junit.framework.TestCase;

public class HashCodeTest extends TestCase {
    private TupleFactory tupleFactory = TupleFactory.getInstance();
    final private String text1 = new String("home");
    final private String text2 = new String("homer");
    final private String text3 = new String("arthur");
    final private String text4 = new String("a-base");
    final private String text5 = new String("");

    public void test1() throws IOException {
        Tuple input = tupleFactory.newTuple(Arrays.asList(text1));
        final Integer res = new HashCode().exec(input);
        final Integer expected = 3208415;
        assertEquals(expected, res);
    }

    public void test2() throws IOException {
        Tuple input = tupleFactory.newTuple(Arrays.asList(text2, text3));
        final Integer res = new HashCode().exec(input);
        final Integer expected = null;
        assertEquals(expected, res);
    }

    public void test3() throws IOException {
        Tuple input = tupleFactory.newTuple(Arrays.asList(text4));
        final Integer res = new HashCode().exec(input);
        final Integer expected = 1473364803;
        assertEquals(expected, res);
    }

    public void test4() throws IOException {
        Tuple input = tupleFactory.newTuple(Arrays.asList(text5));
        final Integer res = new HashCode().exec(input);
        final Integer expected = 0;
        assertEquals(expected, res);
    }
}
