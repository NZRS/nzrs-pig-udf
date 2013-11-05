package nz.net.nzrs.pig.udf;

import junit.framework.Assert;
import org.apache.pig.data.Tuple;
import org.apache.pig.data.TupleFactory;
import org.junit.Test;

import java.io.IOException;
import java.util.Arrays;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class JaroWinklerDistanceTest extends TestCase {
    private TupleFactory tupleFactory = TupleFactory.getInstance();
    final private Text text1 = new Text("home");
    final private Text text2 = new Text("homer");
    final private Text text3 = new Text("arthur");
    final private double epsilon = 0.0001;

    public void test1() throws IOException {
        Tuple input = tupleFactory.newTuple(Arrays.asList(text1, text2));
        final double res = new JaroWinklerDistance().exec(input);
        final double expected = 0.96;
        assertEquals(expected, res, epsilon);
    }

    public void test2() {
        Tuple input = tupleFactory.newTuple(Arrays.asList(text2, text3));
        final double res = new JaroWinklerDistance().exec(input);
        final double expected = 0.0;
        assertEquals(expected, res, epsilon);
    }

    public void test3() {
        Tuple input = tupleFactory.newTuple(Arrays.asList(text3, text3));
        final double res = new JaroWinklerDistance().exec(input);
        final double expected = 1.0;
        assertEquals(expected, res, epsilon);
    }
}
