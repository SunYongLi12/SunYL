package cn.hfxt.service;

import java.util.List;

import cn.hfxt.entity.Layui;
import cn.hfxt.entity.User;

public interface UserService {
	Layui<User> SelectUser();//��ѯ�����û�
	
	int LoginUser(String usercode,String userpasswd);//��¼
	
	public int InsertUser(User user);//�����û�
	
	public int DeleteUser(int id);//ɾ���û�

	public int UpdateUser(User user);//�޸��û�
	
	public List<User> SelectUserId(int id);//��ȡid
	
}
