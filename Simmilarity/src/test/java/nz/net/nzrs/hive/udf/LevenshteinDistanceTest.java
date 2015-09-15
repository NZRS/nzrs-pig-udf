package nz.net.nzrs.hive.udf;

import junit.framework.TestCase;
import nz.net.nzrs.pig.udf.LevenshteinDistance;
import org.apache.pig.data.Tuple;
import org.apache.pig.data.TupleFactory;

import java.io.IOException;
import java.util.Arrays;

/**
 * Created by secastro on 16/09/15.
 */
public class LevenshteinDistanceTest extends TestCase {
    private TupleFactory tupleFactory = TupleFactory.getInstance();
    final private String text1 = new String("home");
    final private String text2 = new String("homer");
    final private String text3 = new String("arthur");
    final private double epsilon = 0.0001;

    public void test1() throws IOException {
        Tuple input = tupleFactory.newTuple(Arrays.asList(text1, text2));
        final double res = new LevenshteinDistance().exec(input);
        final double expected = 1.00;
        assertEquals(expected, res, epsilon);
    }

    public void test2() throws IOException {
        Tuple input = tupleFactory.newTuple(Arrays.asList(text2, text3));
        final double res = new LevenshteinDistance().exec(input);
        final double expected = 5.0;
        assertEquals(expected, res, epsilon);
    }

    public void test3() throws IOException {
        Tuple input = tupleFactory.newTuple(Arrays.asList(text3, text3));
        final double res = new LevenshteinDistance().exec(input);
        final double expected = 0.0;
        assertEquals(expected, res, epsilon);
    }
}

