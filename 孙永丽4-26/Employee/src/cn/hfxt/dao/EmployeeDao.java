package cn.hfxt.dao;

import java.util.List;

import cn.hfxt.entity.User;

public interface EmployeeDao {
	List<User> SelectUser();//��ѯ�����û�
	
	int LoginUser(String usercode,String userpasswd);//��¼
	
	public int InsertUser(User user);//�����û�
	
	public int DeleteUser(int id);//ɾ���û�

	public int UpdateUser(User user);//�޸��û�
	
	public List<User> SelectUserId(int id);//id
	
}
