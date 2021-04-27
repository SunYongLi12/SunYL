package cn.hfxt.service.impl;

import java.sql.Connection;
import java.util.List;

import org.apache.log4j.Logger;

import cn.hfxt.dao.BaseDao;
import cn.hfxt.dao.impl.EmployeeDaoImpl;
import cn.hfxt.entity.Layui;
import cn.hfxt.entity.User;
import cn.hfxt.service.UserService;
import cn.hfxt.utils.DataBaseUtil;

public class UserServiceImpl implements UserService {

	public static Logger logger = Logger.getLogger(BaseDao.class.getName());
	Connection conn = null;
	
	@Override
	public Layui<User> SelectUser() {
		Layui<User> layui = new Layui<User>();
		List<User> user = null;
		try {
			
			// 调用数据访问层代码！
			user = new EmployeeDaoImpl(conn).SelectUser();
		} catch (Exception e) {
			logger.error(e.getMessage());
		} finally {
			// 释放资源！
			DataBaseUtil.closeAll(null, null, conn);
		}
		layui.setCode(0);
		layui.setCount(user.size());
		layui.setData(user);
		layui.setMassage("");
		return layui;
	}

	@Override
	public int LoginUser(String usercode, String userpasswd) {
		int user = 0;
		try {
			user = new EmployeeDaoImpl(conn).LoginUser(usercode, userpasswd);
		} catch (Exception e) {
			logger.error(e.getMessage());
		} finally {
			// 释放资源！
			DataBaseUtil.closeAll(null, null, conn);
		}
		return user;
	}

	@Override
	public int InsertUser(User user) {
		int num = 0;
		try {
			num = new EmployeeDaoImpl(conn).InsertUser(user);
		} catch (Exception e) {
			logger.error(e.getMessage());
		} finally {
			// 释放资源！
			DataBaseUtil.closeAll(null, null, conn);
		}
		return num;
	}

	@Override
	public int DeleteUser(int id) {
		int num = 0;
		try {
			num = new EmployeeDaoImpl(conn).DeleteUser(id);
		} catch (Exception e) {
			logger.error(e.getMessage());
		} finally {
			// 释放资源！
			DataBaseUtil.closeAll(null, null, conn);
		}
		return num;
	}

	@Override
	public int UpdateUser(User user) {
		int num = 0;
		try {
			num = new EmployeeDaoImpl(conn).UpdateUser(user);
		} catch (Exception e) {
			logger.error(e.getMessage());
		} finally {
			// 释放资源！
			DataBaseUtil.closeAll(null, null, conn);
		}
		return num;
	}

	@Override
	public List<User> SelectUserId(int id) {
		List<User> list = null;
		try {
			list = new EmployeeDaoImpl(conn).SelectUserId(id);
		} catch (Exception e) {
			logger.error(e.getMessage());
		} finally {
			// 释放资源！
			DataBaseUtil.closeAll(null, null, conn);
		}
		return list;
	}

}
