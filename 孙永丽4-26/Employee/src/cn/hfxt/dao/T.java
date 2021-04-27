package cn.hfxt.dao;

import cn.hfxt.dao.impl.MenuDaoImpl;
import cn.hfxt.entity.Menu;
import cn.hfxt.service.impl.MenuServiceImpl;
import cn.hfxt.utils.DataBaseUtil;

public class T {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MenuDao mDao = new MenuDaoImpl(DataBaseUtil.getConnection());
		Menu menu = new Menu();
		menu.setParentid(5);
		menu.setMname("aaa");
		menu.setParentid(1);
		menu.setType(3);
		menu.setMbtn("ss");
		menu.setIsdelete(0);
		int updateAllot = new MenuServiceImpl().updateAllot(menu);
		System.out.println(updateAllot);
	}

}
