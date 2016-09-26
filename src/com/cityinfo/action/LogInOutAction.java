package com.cityinfo.action;

import com.cityinfo.actionSuper.MySuperAction;
import com.cityinfo.dao.OpenDB;
import com.cityinfo.model.UserSingle;

@SuppressWarnings("serial")
public class LogInOutAction extends MySuperAction {
	protected UserSingle user;
	
	public UserSingle getUser() {
		return user;
	}
	public void setUser(UserSingle user) {
		this.user = user;
	}

	/**
	 * 判断当前用户是否登录 
	 * @return
	 */
	public String isLogin(){
		System.out.println("正在执行LoginInOutAction中的isLogin()方法");
		Object ob=session.get("loginUser");
		if(ob==null||!(ob instanceof UserSingle))
			return INPUT;
		else
			return LOGIN;
	}
	
	/**
	 * 查询数据表，验证是否存在该用户 
	 * @return
	 */
	public String Login(){
		System.out.println("正在执行LoginInOutAction中的Login()方法");
		String sql="select * from tb_user where user_name=? and user_pass=?";
		Object[] params={user.getUserName(),user.getUserPass()};
		OpenDB myOp=new OpenDB();
		if(myOp.LogOn(sql, params)){				//登录成功
			session.put("loginUser",user);
			return LOGIN;
		}
		else{										//用户名或密码错误
			addFieldError("loginE",getText("city.login.wrong.input"));
			return INPUT;
		}
	}
	
	/**
	 * 退出登录
	 * @return
	 */
	public String Logout(){		
		System.out.println("正在执行LoginInOutAction中的Logout()方法");
		session.clear();	
		return "logout";
	}
	
	/**
	 * 验证是否输入用户名和密码
	 */
	public void validateLogin() {
		System.out.println("正在执行LoginInOutAction中的validateLogin()方法");
		String name=user.getUserName();
		String password=user.getUserPass();
		if(name==null||name.equals(""))
			addFieldError("nameError",getText("city.login.no.name"));
		if(password==null||password.equals(""))
			addFieldError("passwordError",getText("city.login.no.password"));
	}
}
