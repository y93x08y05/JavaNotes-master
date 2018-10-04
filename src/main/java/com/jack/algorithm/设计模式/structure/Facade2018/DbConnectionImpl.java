package com.jack.algorithm.设计模式.structure.Facade2018;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnectionImpl implements DbConnection{
    String DB_DRIVER = "com.microsoft.jdbc.sqlserver.SQLServerDriver";
    String DB_User = "sa";
    String DB_PASSWD = "sa";
    String DATASRC_URL = "jdbc:microsoft:sqlserver://192.168.0.1:DatabaseName=test";
    private Connection conn;
    private Object objId;
    private boolean isClosed = false;
    public DbConnectionImpl(Object obj){
        this.objId = obj;
    }
    @Override
    public void beginTransaction(Object obj) throws SQLException {
        try {
            if (this.objId == obj && this.conn != null && !this.isClosed){
                this.conn.setAutoCommit(false);
            }
        }catch (SQLException e){
            throw new SQLException("beginTransaction获取连接失败"+obj.getClass().getName()+e);
        }
    }

    @Override
    public Connection getConnection(Object obj) throws SQLException, ClassNotFoundException {
        try {
            if (this.objId == obj && this.conn != null && !this.isClosed){
                return conn;
            } else {
                Class.forName(DB_DRIVER);
                conn = DriverManager.getConnection(DATASRC_URL,DB_User,DB_PASSWD);
            }
        }catch (SQLException e){
            throw new SQLException("获取连接失败"+obj.getClass().getName()+e);
        }
        return conn;
    }

    @Override
    public void close(Object obj) throws SQLException {
        try {
            if (this.objId == obj && this.conn != null && !this.isClosed){
                this.conn.close();
            }
        }catch (SQLException e){
            throw new SQLException("关闭连接失败"+obj.getClass().getName()+e);
        }
    }

    @Override
    public void commit(Object obj) throws SQLException {
        try {
            if (this.objId == obj && this.conn != null && !this.isClosed){
                this.conn.commit();
            }
        }catch (SQLException e){
            throw new SQLException("commit连接失败"+obj.getClass().getName()+e);
        }
    }

    @Override
    public void rollback(Object obj) throws SQLException {
        try {
            if (this.objId == obj && this.conn != null && !this.isClosed){
                this.conn.rollback();
            }
        }catch (SQLException e){
            throw new SQLException("rollback连接失败"+obj.getClass().getName()+e);
        }
    }
    public boolean isClosed(){
        return isClosed;
    }
}