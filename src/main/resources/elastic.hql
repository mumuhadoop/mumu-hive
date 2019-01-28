-- 添加elasticsearch-hadoop
add jar hdfs://192.168.0.25:9000/hive/jar/elasticsearch-hadoop/elasticsearch-hadoop-5.6.3.jar;

-- 创建es的外部存储表
CREATE EXTERNAL TABLE dns_domainparse (
id string,
dns_id string,
domain string,
ip string,
version bigint,key string,
manager_name string,
visit_count bigint
)
STORED BY 'org.elasticsearch.hadoop.hive.EsStorageHandler'
TBLPROPERTIES(
'es.nodes' = '192.168.0.71:9200',
'es.index.auto.create' = 'true',
'es.resource' = 'dns_domainparse',
'es.read.metadata' = 'true',
'es.mapping.names' = 'id:id, dns_id:dns_id, domain:domain, ip:ip,ip_version:ip_version,key:key,manager_name:manager_name,visit_count:visit_count');