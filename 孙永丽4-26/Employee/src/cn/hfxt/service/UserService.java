package cn.hfxt.service;

import java.util.List;

import cn.hfxt.entity.Layui;
import cn.hfxt.entity.User;

public interface UserService {
	Layui<User> SelectUser();//查询所有用户
	
	int LoginUser(String usercode,String userpasswd);//登录
	
	public int InsertUser(User user);//新增用户
	
	public int DeleteUser(int id);//删除用户

	public int UpdateUser(User user);//修改用户
	
	public List<User> SelectUserId(int id);//获取id
	
}
