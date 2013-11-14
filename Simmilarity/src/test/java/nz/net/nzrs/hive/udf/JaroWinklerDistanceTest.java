package nz.net.nzrs.pig.udf;

// import junit.framework.Assert;
import org.apache.pig.data.Tuple;
import org.apache.pig.data.TupleFactory;
// import org.junit.Test;

import java.io.IOException;
import java.util.Arrays;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class JaroWinklerDistanceTest extends TestCase {
    private TupleFactory tupleFactory = TupleFactory.getInstance();
    final private String text1 = new String("home");
    final private String text2 = new String("homer");
    final private String text3 = new String("arthur");
    final private double epsilon = 0.0001;

    public void test1() throws IOException {
        Tuple input = tupleFactory.newTuple(Arrays.asList(text1, text2));
        final double res = new JaroWinklerDistance().exec(input);
        final double expected = 0.96;
        assertEquals(expected, res, epsilon);
    }

    public void test2() throws IOException {
        Tuple input = tupleFactory.newTuple(Arrays.asList(text2, text3));
        final double res = new JaroWinklerDistance().exec(input);
        final double expected = 0.0;
        assertEquals(expected, res, epsilon);
    }

    public void test3() throws IOException {
        Tuple input = tupleFactory.newTuple(Arrays.asList(text3, text3));
        final double res = new JaroWinklerDistance().exec(input);
        final double expected = 1.0;
        assertEquals(expected, res, epsilon);
    }
}
