package com.cityinfo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DB {
	private Connection conn;
	private PreparedStatement pstm;
	private String user = "root";
	private String pass = "1214";
	private String driver = "com.mysql.jdbc.Driver";
	private String url = "jdbc:mysql://localhost/db_cityinfo";
	
	public DB() {
		try{
			Class.forName(driver);
		}catch(ClassNotFoundException e){
			System.out.println("加载数据库驱动失败！");
			e.printStackTrace();
		}
	}

	/**
	 * 创建数据库连接
	 * @return
	 */
	public Connection getCon() {
		try {
			conn=DriverManager.getConnection(url,user,pass);
		} catch (SQLException e) {
			System.out.println("创建数据库连接失败！");
			conn=null;
			e.printStackTrace();
		}
		return conn;
	}
	
	/**
	 * 对数据库进行增改删查
	 * params存储了sql语句中？占位符的赋值数据
	 * @param sql
	 * @param params
	 */
	public void doPstm(String sql, Object[] params) {
		if(sql!=null&&!sql.equals("")) {
			if(params == null)
				params = new Object[0];	
			getCon();
			if(conn!=null){
				try{		
					System.out.println("doPstm()执行的sql语句为：" + sql);
					pstm = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, 
							ResultSet.CONCUR_READ_ONLY);
					for(int i=0; i<params.length; i++){//读取sql语句中的？参数
						System.out.println("正在设置sql语句中第" + (i+1) + "个参数" + params[i]);
						pstm.setObject(i+1, params[i]);
					}
					pstm.execute();//执行
				}catch(SQLException e){
					System.out.println("doPstm()方法出错！");
					e.printStackTrace();
				}				
			}			
		}
	}
	
	/**
	 * 返回结果集对象的方法
	 * @return
	 * @throws SQLException
	 */
	public ResultSet getRs() throws SQLException{
		return pstm.getResultSet();		
	}
	
	/**
	 * 返回更新影响的记录的数量
	 * @return
	 * @throws SQLException
	 */
	public int getCount() throws SQLException{
		return pstm.getUpdateCount();		
	}
	
	public void closed(){
		try{
			if(pstm!=null)
				pstm.close();			
		}catch(SQLException e){
			System.out.println("关闭pstm对象失败！");
			e.printStackTrace();
		}
		try{
			if(conn!=null){
				conn.close();
			}
		}catch(SQLException e){
			System.out.println("关闭conn对象失败！");
			e.printStackTrace();
		}
	}
}
