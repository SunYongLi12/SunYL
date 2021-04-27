package cn.hfxt.service;

import java.util.List;

import cn.hfxt.entity.Layui;
import cn.hfxt.entity.Menu;/*
							import cn.hfxt.entity.MenudtreeData;*/
import cn.hfxt.entity.RoleType;


public interface MenuService {
	/*
	 * List<Menu> MenuList(int id);//菜单
	 */	
	List<Menu> resMenu1(int parentid,int type, int uid);//按钮
	
	Layui<Menu> allMenu();//查询所有权限

	Layui<Menu> allMenus();//查询所有权限

	List<Menu> menuByUserid(int userid);//查询对应id的权限
	
	List<Menu> seleMunuid(int menuid);//查询菜单id

	List<Menu> menu();

	List<Menu> seleMenu(int userid);

	int deleteAllot(int id);

	Menu echo(int id);

	int updateAllot(Menu menu);

	public String seleName(int pid);

	public List<Menu> seleType(int type);

	public int insertAllot(Menu menu);
	
	Layui<RoleType> roleType();//查询用户类型数据

}
