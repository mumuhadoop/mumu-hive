package com.lovecws.mumu.hive.jdbc;


import org.apache.tomcat.jdbc.pool.DataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class HiveJdbcConfig {

    private static final Logger logger = LoggerFactory.getLogger(HiveJdbcConfig.class);

    private static DataSource dataSource;

    private synchronized DataSource dataSource() {
        if (dataSource == null) {
            dataSource = new DataSource();
            dataSource.setUrl("jdbc:hive2://192.168.0.81:10000/default");
            dataSource.setDriverClassName("org.apache.hive.jdbc.HiveDriver");
            dataSource.setUsername("");
            dataSource.setPassword("");
            //dataSource.setInitSQL("add jar hdfs://192.168.0.25:9000/hive/jar/elasticsearch-hadoop/elasticsearch-hadoop-5.6.3.jar");
            logger.debug("Hive DataSource Inject Successfully...");
        }
        return dataSource;
    }

    public Connection getConnection() {
        try {
            return dataSource().getConnection();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        HiveJdbcConfig hiveJdbcConfig = new HiveJdbcConfig();
        Connection connection = hiveJdbcConfig.getConnection();
        try {
            Statement statement = connection.createStatement();
            //boolean execute = statement.execute("add jar hdfs://192.168.0.25:9000/hive/jar/elasticsearch-hadoop/elasticsearch-hadoop-5.6.3.jar");
            //System.out.println(execute);
            ResultSet resultSet = statement.executeQuery("select name,encodebase64(name) from t1 limit 10");
            int columnCount = resultSet.getMetaData().getColumnCount();
            while (resultSet.next()) {
                for (int i = 1; i <= columnCount; i++) {
                    System.out.print(resultSet.getObject(i) + "  ");
                }
                System.out.println();
            }
            resultSet.close();
            statement.cancel();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}