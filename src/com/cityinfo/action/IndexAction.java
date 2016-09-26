package com.cityinfo.action;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.TreeMap;

import com.cityinfo.actionSuper.MySuperAction;
import com.cityinfo.dao.OpenDB;
import com.cityinfo.model.InfoSingle;

@SuppressWarnings("serial")
public class IndexAction extends MySuperAction {
	public static TreeMap<Integer,String> typeMap;					
	public static TreeMap<String,String> searchMap;				

	static{
		System.out.println("正在执行indexAction中的静态代码块");
		OpenDB myOp=new OpenDB();
		//获取所有信息类别
		String sql="select * from tb_type order by type_sign";
		//查询出所有的info种类分类编号放入typeMap中
		typeMap=myOp.OpGetListBox(sql,null);
		if(typeMap==null)
			typeMap=new TreeMap<Integer,String>();
		//初始化搜索功能的下拉列表
		searchMap=new TreeMap<String,String>();
		searchMap.put("ID值","id");
		searchMap.put("信息标题","info_title");
		searchMap.put("信息内容","info_content");
		searchMap.put("联系人","info_linkman");
		searchMap.put("联系电话","info_phone");
		searchMap.put("E-mail地址","info_email");
	}
	
	public String execute() throws Exception {
		System.out.println("正在执行indexAction中的excute()方法");
		/* 查询所有收费信息，按发布时间降序排列 */
		OpenDB myOp=new OpenDB();
		String sql1="select * from tb_info where (info_state='1') and (info_payfor = '1') order by info_date desc";
		List<InfoSingle> payforlist=myOp.OpListShow(sql1,null);
		request.setAttribute("payforlist",payforlist);		
		/* 查询免费信息，按发布时间降序排列 */
		List<List<InfoSingle>> allsublist=new ArrayList<List<InfoSingle>>();
		if(typeMap!=null&&typeMap.size()!=0){
			Iterator<Integer> itype=typeMap.keySet().iterator();			
			String sql2="SELECT * FROM tb_info WHERE (info_type = ?) AND (info_state='1') AND (info_payfor = '0') ORDER BY info_date DESC LIMIT 5";			
			while(itype.hasNext()){
				Integer sign=(Integer)itype.next();
				Object[] params={sign};//将查询出来的所有info种类赋予参数中进行查询
				//查询所有种类已通过审核但是未付款的info
				List<InfoSingle> onesublist=myOp.OpListShow(sql2, params);
				allsublist.add(onesublist);				
			}			
		}
		request.setAttribute("allsublist",allsublist);
		session.put("typeMap",typeMap);
		session.put("searchMap",searchMap);		
		return SUCCESS;
	}
}
