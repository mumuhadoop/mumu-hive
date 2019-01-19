package com.lovecws.mumu.hive.udf;

import junit.framework.TestCase;
import org.apache.hadoop.io.Text;

/**
 * @program: mumu-hive
 * @description: base64测试
 * @author: 甘亮
 * @create: 2019-01-14 11:53
 **/
public class Base64DecoderUDFTest extends TestCase {

    private Base64DecoderUDF base64DecoderUDF = new Base64DecoderUDF();

    public void testDecoder() {
        //Text text = base64DecoderUDF.evaluate("bG92ZWN3cw==");
        //Text text = base64DecoderUDF.evaluate("aHR0cDovLzIxMC4yMi42MC4xOC9jMS8yMDE5LzAxLzExXzAvNDU2QTVEMEY2RjRDRjc0NjgzQUYyRDVFM0JCQTBFMjdfMjAxOTAxMTFfMl8xXzgxMF9tcDQvNDAyMkZDMkQ5OUQwNTJBOTAwMTQzOEJCMDEzM0QxMzJfMjkwMDAwXzMwMDAwMF81MDFfdjAyX21wNC5tNHM/cG09OEN1S3BCUGVLbGdmZkQ0cHRhOVpJYnBhMzYyOGhSN0ljV3NuZTNzYkM5QmNUcDVCSkNJaEl6blZSUGtndnp1S0dIQn5XMnJ3U1kwcDJreEQzTjRvdE5Md1RtdUhBdG1XaUUyZjFSc1d6Q3dJflJLdzNKVHRzT0lHOXZwX005ckUyflJrYW8zV3BaenAwQXFzTzA1N2gwUnJnUlFHdXhXajBLcjVkSV9FMGtBRTE4MWN5Y2ZGVmJuNGdxbGpFMVBSb0E4M0JVcFF5fnJMUzJhOG9XSlUyVHhpeFJ3R25zUn51Mmx2ZWZGdn43OGJER1BEN185dEhxUGRxNzQt");
        Text text = base64DecoderUDF.evaluate("123");
        System.out.println(text.toString());
    }
}


