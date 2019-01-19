package com.lovecws.mumu.hive.udf;

import junit.framework.TestCase;
import org.apache.hadoop.io.Text;

/**
 * @program: mumu-hive
 * @description: base64测试
 * @author: 甘亮
 * @create: 2019-01-14 11:53
 **/
public class Base64EncoderUDFTest extends TestCase {

    private Base64EncoderUDF base64EncoderUDF = new Base64EncoderUDF();

    public void testEncoder() {
        Text text = base64EncoderUDF.evaluate("lovecws");
        System.out.println(text.toString());
    }
}
