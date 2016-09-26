package com.cityinfo.action;

import com.cityinfo.actionSuper.AdminSuperAction;
import com.cityinfo.dao.OpenDB;

@SuppressWarnings("serial")
public class ProcessAction extends AdminSuperAction {
	/** 
	 * 功能：管理员操作-审核信息(更新数据库) 
	 * @return
	 */
	public String Check(){
		System.out.println("正在执行ProcessAction中的Check()方法");
		session.put("adminOP","Check");			//记录当前操作为“审核信息”			
		
		String checkID=request.getParameter("checkID");
		String sql="UPDATE tb_info SET info_state = 1 WHERE (id = ?)";
		Object[] params={checkID};
		
		OpenDB myOp=new OpenDB();
		int i=myOp.OpUpdate(sql, params);
		if(i>0){								//审核信息成功			
			return "checkSuccess";			
		}
		else{									//审核信息失败
			comebackState();
			addFieldError("AdminCheckUnSuccess",getText("city.admin.check.no.success"));			
			request.setAttribute("mainPage","/pages/error.jsp");
			return "UnSuccess";
		}
	}
	
	/** 
	 * 功能：管理员操作-删除信息(更新数据库) 
	 * @return
	 */
	public String Delete(){
		System.out.println("正在执行ProcessAction中的Delete()方法");
		session.put("adminOP","Delete");		//记录当前操作为“删除信息”			
		
		String deleteID=request.getParameter("deleteID");
		String sql="DELETE tb_info WHERE (id = ?)";
		Object[] params={deleteID};
		
		OpenDB myOp=new OpenDB();
		int i=myOp.OpUpdate(sql, params);
		if(i>0){								//删除信息成功			
			return "deleteSuccess";			
		}
		else{									//删除信息失败
			comebackState();
			addFieldError("AdminDeleteUnSuccess",getText("city.admin.delete.no.success"));			
			request.setAttribute("mainPage","/pages/error.jsp");
			return "UnSuccess";
		}
	}
	
	/** 
	 * 功能：恢复在“显示方式”中的选择状态 
	 */
	private void comebackState(){
		System.out.println("正在执行AdminAction中的comebackState()方法");
		/* 获取session中保存的选择状态。
		 * 将选择状态保存在session中，
		 * 是在管理员单击“显示”按钮请求列表显示时，
		 * 在ListShow()方法中实现的
		 */
		Integer getInfoType=(Integer)session.get("infoType");
		String getPayForType=(String)session.get("payforType");
		String getStateType=(String)session.get("stateType");
		
		/* 恢复选择的状态 */
		if(getPayForType!=null&&getStateType!=null&&getInfoType!=null){			
			showType.setInfoType(getInfoType.intValue());	
			showType.setTypePayfor(getPayForType);
			showType.setTypeState(getStateType);			
		}
	}
}
