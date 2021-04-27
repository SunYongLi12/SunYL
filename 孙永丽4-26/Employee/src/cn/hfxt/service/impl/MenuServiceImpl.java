package cn.hfxt.service.impl;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import cn.hfxt.dao.BaseDao;
import cn.hfxt.dao.MenuDao;
import cn.hfxt.dao.impl.MenuDaoImpl;
import cn.hfxt.entity.Esmenu;
import cn.hfxt.entity.Layui;
import cn.hfxt.entity.Menu;
import cn.hfxt.entity.MenudtreeData;
import cn.hfxt.entity.RoleType;
import cn.hfxt.service.MenuService;
import cn.hfxt.utils.DataBaseUtil;

public class MenuServiceImpl implements MenuService {
	/**
	 * 使用Logger记录日志！
	 */
	public static Logger logger = Logger.getLogger(BaseDao.class.getName());
	private MenuDao mDao = new MenuDaoImpl(DataBaseUtil.getConnection());

	@Override
	public List<Menu> resMenu1(int parentid,int type, int uid) {
		// 获得连接对象！
		Connection conn = null;
		List<Menu> menu = null;
		try {
			conn = DataBaseUtil.getConnection();
			// 调用数据访问层代码！
			menu = new MenuDaoImpl(conn).resMenu1(parentid, type ,uid);
		} catch (Exception e) {
			logger.error(e.getMessage());
		} finally {
			// 释放资源！
			DataBaseUtil.closeAll(null, null, conn);
		}
		return menu;
	}

	@Override
	public List<Menu> menuByUserid(int userid) {
		Connection conn = null;
		List<Menu> result = null;
		try {
			conn = DataBaseUtil.getConnection();
			// 调用数据访问层代码！
			result = new MenuDaoImpl(conn).menuByUserid(userid);
		} catch (Exception e) {
			logger.error(e.getMessage());
		} finally {
			// 释放资源！
			DataBaseUtil.closeAll(null, null, conn);
		}
		return result;
	}

	@Override
	public Layui<Menu> allMenu() {
		Layui<Menu> layui = new Layui<Menu>();
		List<Menu> allMenu = new MenuDaoImpl(DataBaseUtil.getConnection()).allMenu();
		layui.setCode(0); 
		layui.setCount(allMenu.size());
		layui.setMassage("");
		layui.setData(allMenu);
		return layui;
	}

	@Override
	public Layui<Menu> allMenus() {
		// TODO Auto-generated method stub
		Layui<Menu> layui=new Layui<Menu>();
		List<Menu> allMenu = new MenuDaoImpl(DataBaseUtil.getConnection()).allMenu();
		System.out.println("EasybuyOrderEasybuyOrderEasybuyOrderEasybuyOrder");
		layui.setCount(allMenu.size()); 
		layui.setCode(0);
		layui.setData(allMenu);
		layui.setMassage("");
		return layui;
	}

	@Override
	public List<Menu> menu() {
		List<Menu> allMenu = new MenuDaoImpl(DataBaseUtil.getConnection()).allMenu();
		return allMenu;
	}

	@Override
	public List<Menu> seleMenu(int userid) {
		return mDao.seleMenu(userid);
	}

	@Override
	public int deleteAllot(int id) {
		return mDao.deleteAllot(id);
	}

	@Override
	public Menu echo(int id) {
		return mDao.echo(id);
	}

	@Override
	public int updateAllot(Menu menu) {
		return mDao.updateAllot(menu);
	}

	@Override
	public String seleName(int pid) {
		return mDao.seleName(pid);
	}

	@Override
	public List<Menu> seleType(int type) {
		return mDao.seleType(type);
	}

	@Override
	public int insertAllot(Menu menu) {
		return mDao.insertAllot(menu);
	}

	@Override
	public List<Menu> seleMunuid(int menuid) {
		// TODO Auto-generated method stub
		return mDao.seleMunuid(menuid);
	}

	@Override
	public Layui<RoleType> roleType() {
		// TODO Auto-generated method stub
		Layui<RoleType> layui=new Layui<RoleType>();
		List<RoleType> roletype = new MenuDaoImpl(DataBaseUtil.getConnection()).roleType();
		layui.setCount(roletype.size()); 
		layui.setCode(0);
		layui.setData(roletype);
		layui.setMassage("");
		return layui;
	}

}
