package com.codeTeam_3.util;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
//import org.apache.commons.dbcp2.BasicDataSource;
//import java.sql.DriverManager;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public final class dbMysql {
    private static final HikariDataSource DS;

    static {
        HikariConfig cfg = new HikariConfig();

        cfg.setDriverClassName("com.mysql.cj.jdbc.Driver");

        cfg.setJdbcUrl("jdbc:mysql://localhost:3306/team3?useSSL=false&serverTimezone=UTC");

        cfg.setUsername("root");
        cfg.setPassword("");

        // --- Pool config ---
        int cores = Runtime.getRuntime().availableProcessors();
        cfg.setMaximumPoolSize(Math.max(10, cores * 2));
        cfg.setMinimumIdle(2);
        cfg.setConnectionTimeout(30_000);
        cfg.setIdleTimeout(600_000);
        cfg.setMaxLifetime(1_800_000);
        cfg.setPoolName("DemoHikariPool");

        cfg.setConnectionTestQuery("SELECT 1");
        cfg.addDataSourceProperty("cachePrepStmts", "true");
        cfg.addDataSourceProperty("prepStmtCacheSize", "250");
        cfg.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");

        DS = new HikariDataSource(cfg);
    }


    private dbMysql() {}

    public static DataSource getDataSource() {
        return DS;
    }

    public static Connection getConnection() throws SQLException {
        return DS.getConnection();
    }

    public static void close() {
        DS.close();
    }
}

