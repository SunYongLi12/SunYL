package cn.hfxt.dao;

import java.util.List;

import cn.hfxt.entity.Menu;
import cn.hfxt.entity.RoleType;

public interface MenuDao {
	List<Menu> resMenu1(int parentid, int type, int uid);//用户按钮
	
	List<Menu> allMenu();//查询所有权限
	
	List<Menu> menuByUserid(int userid);//查询对应id的权限
	
	List<Menu> seleMenu(int userid);
	
	int deleteAllot(int id);//删除
	
	Menu echo(int id);
	
	List<Menu> seleMunuid(int menuid);//查询菜单id
	
	int updateAllot(Menu menu);//修改权限
	
	//查询上级权限名
	String seleName(int pid);
	
	List<Menu> seleType(int type);
	
	int insertAllot(Menu menu);//新增权限
	
	List<RoleType> roleType();//查询用户类型数据
	
	
	
}
