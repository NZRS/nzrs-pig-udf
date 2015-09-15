package nz.net.nzrs.pig.udf;

import org.apache.pig.EvalFunc;
import org.apache.pig.data.Tuple;
import org.simmetrics.StringDistance;
import org.simmetrics.metrics.DamerauLevenshtein;

import java.io.IOException;

/**
 * Created by secastro on 16/09/15.
 */

public final class LevenshteinDamerauDistance extends EvalFunc<Float> {
    private StringDistance metric;
    private final Float ERROR_CODE = new Float(-1);

    public LevenshteinDamerauDistance() {
        metric = new DamerauLevenshtein();
    }

    public Float exec(Tuple input) throws IOException {
        if (input == null || input.size() != 2)
            return ERROR_CODE;

        try {
            String a = (String)input.get(0);
            String b = (String)input.get(1);
            return new Float(metric.distance(a, b));
        } catch(Exception e) {
            throw new IOException("Exception on processing input", e);
        }
    }
}

