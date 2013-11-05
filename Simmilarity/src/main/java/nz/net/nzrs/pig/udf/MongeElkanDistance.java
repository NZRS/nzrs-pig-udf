package nz.net.nzrs.pig.udf;

import java.io.IOException;
import org.apache.pig.EvalFunc;
import org.apache.pig.data.Tuple;
import uk.ac.shef.wit.simmetrics.similaritymetrics.*;

public final class MongeElkanDistance extends EvalFunc<Float> {
    private AbstractStringMetric metric;
    private final Float ERROR_CODE = new Float(-1);

    public MongeElkanDistance() {
        metric = new MongeElkan();
    }

    public Float exec(Tuple input) throws IOException {
        if (input == null || input.size() != 2)
            return ERROR_CODE;

        try {
            String a = (String)input.get(0);
            String b = (String)input.get(1);
            return new Float(metric.getSimilarity(a, b));
        } catch(Exception e) {
            throw new IOException("Exception on processing input", e);
        }
    }
}

