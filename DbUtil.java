package com.bankcustomer.DbUtil;

import java.io.*;
import java.sql.*;
import java.util.*;

public class DbUtil {

    private static Connection connection = null;

    public static Connection getConnection() {
        if (connection != null) {
            return connection;
        } else {
            try {
                Properties prop = new Properties();
                InputStream input = DbUtil.class.getClassLoader().getResourceAsStream("db.properties");
                prop.load(input);
                String driver = prop.getProperty("driver");
                String url = prop.getProperty("url");
                String user = prop.getProperty("user");
                String pass = prop.getProperty("password");
                Class.forName(driver);
                connection = DriverManager.getConnection(url, user, pass);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }

            return connection;
        }
    }
}
