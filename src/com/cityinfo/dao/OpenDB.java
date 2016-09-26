package com.cityinfo.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

import com.cityinfo.model.CreatePage;
import com.cityinfo.model.InfoSingle;
import com.cityinfo.tools.DoString;

public class OpenDB {
	private DB mydb;
	public OpenDB(){
		mydb=new DB();	
	}
	
	/**
	 * 返回结果中组成的TreeMap<"type_sign","type_intro">对
	 * @param sql
	 * @param params
	 * @return
	 */
	public TreeMap<Integer,String> OpGetListBox(String sql,Object[] params){
		System.out.println("正在执行OpenDB中OpGetListBox()方法");
		TreeMap<Integer,String> typeMap=new TreeMap<Integer,String>();
		mydb.doPstm(sql, params);
		try {
			ResultSet rs=mydb.getRs();
			if(rs!=null){
				while(rs.next()){					
					Integer sign=Integer.valueOf(rs.getInt("type_sign"));
					String intro=rs.getString("type_intro");
					typeMap.put(sign,intro);					
				}
				rs.close();
			}
		} catch (SQLException e) {			
			System.out.println("OpGetListBox()方法查询失败！");			
			e.printStackTrace();
		}finally{
			mydb.closed();			
		}
		return typeMap;	
	}
	
	/**
	 * 返回info集
	 * @param sql
	 * @param params
	 * @return
	 */
	public List<InfoSingle> OpListShow(String sql,Object[] params){
		System.out.println("正在执行OpenDB中OpListShow()方法");
		List<InfoSingle> onelist=new ArrayList<InfoSingle>();
		mydb.doPstm(sql, params);
		try{
			ResultSet rs=mydb.getRs();
			int count = 0;
			if(rs!=null){
				while(rs.next()){
					InfoSingle infoSingle=new InfoSingle();
					infoSingle.setId(rs.getInt("id"));
					infoSingle.setInfoType(rs.getInt("info_type"));
					infoSingle.setInfoTitle(rs.getString("info_title"));
					infoSingle.setInfoContent(rs.getString("info_content"));
					infoSingle.setInfoLinkman(rs.getString("info_linkman"));
					infoSingle.setInfoPhone(rs.getString("info_phone"));
					infoSingle.setInfoEmail(rs.getString("info_email"));
					infoSingle.setInfoDate(DoString.dateTimeChange(
							rs.getTimestamp("info_date")));
					infoSingle.setInfoState(rs.getString("info_state"));
					infoSingle.setInfoPayfor(rs.getString("info_payfor"));
					onelist.add(infoSingle);			
					count++;
				}
			}
			//System.out.println("查询结果的总总个数为：" + count);
			rs.close();
		}catch (Exception e){
			System.out.println("查看信息列表失败！");			
			e.printStackTrace();
		}finally{
			mydb.closed();			
		}
		return onelist;		
	}
	
	/**
	 * 返回单条info
	 * @param sql
	 * @param params
	 * @return
	 */
	public InfoSingle OpSingleShow(String sql,Object[] params){
		System.out.println("正在执行OpenDB中OpSingleShow()方法");
		InfoSingle infoSingle=null;
		mydb.doPstm(sql, params);       
		try{
		    ResultSet rs=mydb.getRs();
			if(rs!=null&&rs.next()){
				infoSingle=new InfoSingle();
				infoSingle.setId(rs.getInt("id"));
				infoSingle.setInfoType(rs.getInt("info_type"));
				infoSingle.setInfoTitle(rs.getString("info_title"));
				infoSingle.setInfoContent(rs.getString("info_content"));
				infoSingle.setInfoLinkman(rs.getString("info_linkman"));
				infoSingle.setInfoPhone(rs.getString("info_phone"));
				infoSingle.setInfoEmail(rs.getString("info_email"));
				infoSingle.setInfoDate(DoString.dateTimeChange(
						rs.getTimestamp("info_date")));
				infoSingle.setInfoState(rs.getString("info_state"));
				infoSingle.setInfoPayfor(rs.getString("info_payfor"));				
				rs.close();				
			}
		}catch(Exception e){
			System.out.println("查看详细内容失败！");
			e.printStackTrace();			
		}finally{
			mydb.closed();
		}
		return infoSingle;
	}
	
	/**
	 * 数据库修改
	 * @param sql
	 * @param params
	 * @return
	 */
	public int OpUpdate(String sql,Object[] params){
		System.out.println("正在执行OpenDB中OpUpdate()方法");
		int i=-1;
		mydb.doPstm(sql, params);
		try{
			i=mydb.getCount();			
		}catch(SQLException e){
			System.out.println("执行OpUpdate()方法失败！(更新数据库)");
			e.printStackTrace();
		}finally{
			mydb.closed();
		}
		return i;
	}
	
	/**
	 * 创建分页信息
	 * @param sqlall
	 * @param params
	 * @param perR 每页显示记录数
	 * @param strCurrentP 当前页码
	 * @param gowhich 分页导航栏信息
	 * @return 分页信息
	 */
	public CreatePage OpCreatePage(String sqlall,
			Object[] params,int perR,String strCurrentP,String gowhich){
		System.out.println("正在执行OpenDB中OpCreatePage()方法");
		CreatePage page=new CreatePage();
		page.setPerR(perR);
		if(sqlall!=null&&!sqlall.equals("")){
			DB mydb=new DB();
			mydb.doPstm(sqlall,params);			
			try {
				ResultSet rs=mydb.getRs();				
				if(rs!=null&&rs.next()){
					rs.last();					
					page.setAllR(rs.getRow());			//设置总记录数
					page.setAllP();
					page.setCurrentP(strCurrentP);
					page.setPageInfo();
					page.setPageLink(gowhich);
					rs.close();
				}
			} catch (SQLException e) {
				System.out.println("OpDB.java/OpCreatePage()方法："
						+ "创建CreatePage分页类失败！");
				e.printStackTrace();
			}finally{				
				mydb.closed();
			}
		}		
		return page;
	}
	
	/**
	 * 登录
	 * @param sql
	 * @param params
	 * @return
	 */
	public boolean LogOn(String sql,Object[] params){
		System.out.println("正在执行OpenDB中LogOn()方法");
		mydb.doPstm(sql, params);
		try {
			ResultSet rs=mydb.getRs();
			boolean mark=(rs==null||!rs.next()?false:true);
			rs.close();
			return mark;			
		} catch (SQLException e) {
			System.out.println("登录失败！");
			e.printStackTrace();
			return false;
		}
		finally{
			mydb.closed();
		}
	}
}
