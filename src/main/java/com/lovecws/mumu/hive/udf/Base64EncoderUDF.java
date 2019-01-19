package com.lovecws.mumu.hive.udf;

import org.apache.hadoop.hive.ql.exec.UDF;
import org.apache.hadoop.io.Text;

import java.util.Base64;

/**
 * @program: mumu-hive
 * @description: base64解码
 * @author: 甘亮
 * @create: 2019-01-14 11:28
 **/
public class Base64EncoderUDF extends UDF {

    private Base64.Encoder encoder = Base64.getEncoder();
    private Text result = new Text();

    public Text evaluate(String baseStr) {
        if (baseStr == null || "".equals(baseStr)) {
            return null;
        }
        result.set(encoder.encode(baseStr.getBytes()));
        return result;
    }
}
