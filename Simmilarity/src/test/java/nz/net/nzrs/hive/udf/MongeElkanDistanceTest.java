package nz.net.nzrs.pig.udf;

import org.apache.pig.data.Tuple;
import org.apache.pig.data.TupleFactory;

import java.io.IOException;
import java.util.Arrays;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class MongeElkanDistanceTest extends TestCase {
    private TupleFactory tupleFactory = TupleFactory.getInstance();
    final private String text1 = new String("home");
    final private String text2 = new String("casa");
    final private double epsilon = 0.0001;

    public void test1() throws IOException {
        Tuple input = tupleFactory.newTuple(Arrays.asList(text1, text2));
        final double res = new MongeElkanDistance().exec(input);
        final double expected = 0.15;
        assertEquals(expected, res, epsilon);
    }
}
