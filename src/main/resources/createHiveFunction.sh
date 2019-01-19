#将本地的jar包添加到hive中
add jar hdfs://hncluster/hive/udf/mumu-hive-1.0-SNAPSHOT.jar

#创建临时函数
create temporary function encodebase64 as 'com.lovecws.mumu.hive.udf.Base64EncoderUDF';
create temporary function decodebase64 as 'com.lovecws.mumu.hive.udf.Base64DecoderUDF';

#创建永久函数
CREATE FUNCTION encodebase64 AS 'com.lovecws.mumu.hive.udf.Base64EncoderUDF' USING JAR 'hdfs://hncluster/hive/udf/mumu-hive-1.0-SNAPSHOT.jar';
CREATE FUNCTION decodebase64 AS 'com.lovecws.mumu.hive.udf.Base64DecoderUDF' USING JAR 'hdfs://hncluster/hive/udf/mumu-hive-1.0-SNAPSHOT.jar';

#测试函数
select 'lovecws',encodebase64('lovecws');
select 'bG92ZWN3cw==',decodebase64('bG92ZWN3cw==');

