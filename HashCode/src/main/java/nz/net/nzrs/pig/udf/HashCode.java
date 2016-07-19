package nz.net.nzrs.pig.udf;

import java.io.IOException;
import org.apache.pig.EvalFunc;
import org.apache.pig.data.Tuple;

public class HashCode extends EvalFunc<Integer>
{
    public Integer exec(Tuple input) throws IOException {
        if (input == null || input.size() == 0 || input.size() > 1)
            return null;

        try {
            String str = (String)input.get(0);
            return new Integer(Math.abs(str.hashCode()));
        } catch(Exception e){
            throw new IOException("Caught exception processing input row ", e);
        }
    }
}
