package nz.net.nzrs.pig.udf;

import org.apache.pig.EvalFunc;
import org.apache.pig.data.Tuple;
import org.simmetrics.StringMetric;
import org.simmetrics.metrics.JaroWinkler;
import java.io.IOException;

public final class JaroWinklerDistance extends EvalFunc<Float> {
    private StringMetric metric;
    private final Float ERROR_CODE = new Float(-1);

    public JaroWinklerDistance() {
        metric = new JaroWinkler();
    }

    public Float exec(Tuple input) throws IOException {
        if (input == null || input.size() != 2)
            return ERROR_CODE;

        try {
            String a = (String)input.get(0);
            String b = (String)input.get(1);
            return new Float(metric.compare(a, b));
        } catch(Exception e) {
            throw new IOException("Exception on processing input", e);
        }
    }
}

