package cn.hfxt.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import cn.hfxt.dao.BaseDao;
import cn.hfxt.dao.MenuDao;
import cn.hfxt.entity.Esmenu;
import cn.hfxt.entity.Menu;
import cn.hfxt.entity.RoleType;
import cn.hfxt.utils.DataBaseUtil;

public class MenuDaoImpl extends BaseDao implements MenuDao {

	public MenuDaoImpl(Connection conn) {
		super(conn);
		// TODO Auto-generated constructor stub
	}

	public static Logger logger = Logger.getLogger(BaseDao.class.getName());

	@Override
	public List<Menu> resMenu1(int parentid,int type, int uid) {
		String sql = "SELECT * FROM `ls_menu` WHERE parentid=? and TYPE=? AND id IN(SELECT menuid FROM `rs_menu` WHERE userid=? )"; 

		Object[] parms = {parentid, type , uid};
		ResultSet set = null;
		Menu menu = null;
		List<Menu> list=new ArrayList<Menu>();
		try {
			set = super.excuteQuery(sql, parms);
			if (set != null) {
				while (set.next()) {
					menu = new Menu();
					menu.setId(set.getInt("id"));
					menu.setMname(set.getString("mname"));
					menu.setType(set.getInt("type"));
					menu.setParentid(set.getInt("parentid"));
					menu.setMbtn(set.getString("mbtn"));
					list.add(menu);

					 System.out.println("    "+list.size()); 
				}
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
		} finally {
			DataBaseUtil.closeAll(set, null, null);
		}
		return list;
	}

	@Override
	public List<Menu> allMenu() {
		List<Menu> list = new ArrayList<Menu>();
		String sql = "SELECT * FROM `ls_menu` ";
		ResultSet set = null;
		Menu menu = null;
		try {
			set = super.excuteQuery(sql, null);
			if (set != null) {
				while (set.next()) {
					menu = new Menu();
					menu.setId(set.getInt("id"));
					menu.setMname(set.getString("mname"));
					System.out.println("set.getString(mname)"+set.getString("mname"));
					menu.setParentid(set.getInt("parentid"));
					menu.setType(set.getInt("type"));
					menu.setMbtn(set.getString("mbtn"));
					menu.setIsdelete(set.getInt("isdelete"));
					menu.setMfunction(set.getString("mfunction"));
					list.add(menu);
				}
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
		} finally {
			DataBaseUtil.closeAll(set, null, null);
		}

		return list;
	}

	@Override
	public List<Menu> menuByUserid(int userid) {
		String sql = "SELECT * FROM `ls_menu` WHERE id IN(SELECT menuid FROM `rs_menu` WHERE userid=? )";

		ResultSet set = null;
		Object[] parms = {userid};
		List<Menu> list = new ArrayList<Menu>();
		Menu menu = null;
		try {
			set = super.excuteQuery(sql, parms);
			if (set != null) {
				while (set.next()) {
					menu = new Menu();
					menu.setId(set.getInt("id"));
					menu.setMname(set.getString("mname"));
					System.out.println("set.getString(mname)"+set.getString("mname"));
					menu.setParentid(set.getInt("parentid"));
					menu.setType(set.getInt("type"));
					menu.setMbtn(set.getString("mbtn"));
					menu.setIsdelete(set.getInt("isdelete"));
					menu.setMfunction(set.getString("mfunction"));
					menu.setUrl(set.getString("url"));
					list.add(menu);
				}
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
		} finally {
			DataBaseUtil.closeAll(set, null, null);
		}
		return list;
	}

	@Override
	public List<Menu> seleMenu(int userid) {

		String sql = "SELECT * FROM ls_menu WHERE `type`= 3 AND id IN (SELECT menuid FROM `rs_menu` WHERE userid = ?)";
		ResultSet set = null;

		Esmenu esmenu = null;
		Object[] parms = {userid};
		List<Menu> list = new ArrayList<Menu>();
		Menu menu = null;
		try {
			set = super.excuteQuery(sql, parms);
			if (set != null) {
				while (set.next()) {
					menu = new Menu();
					menu.setId(set.getInt("id"));
					menu.setMname(set.getString("mname"));
					menu.setParentid(set.getInt("parentid"));
					menu.setType(set.getInt("type"));
					menu.setMbtn(set.getString("mbtn"));
					menu.setIsdelete(set.getInt("isdelete"));
					menu.setMfunction(set.getString("mfunction"));
					list.add(menu);
				}
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
		} finally {
			DataBaseUtil.closeAll(set, null, null);
		}
		return list;
	}

	@Override
	public int deleteAllot(int id) {
		ResultSet set = null;
		String sql = "DELETE FROM `ls_menu` WHERE id = ? "; 
		Object[] parms = { id };
		return super.excuteUpdate(sql, parms);
	}

	@Override
	public Menu echo(int id) {
		String sql = "select * from `ls_menu` where id = ?";
		List<Menu> list = new ArrayList<Menu>();
		ResultSet set = null;

		Object[] parms = {id};
		Menu menu = null;
		try {
			set = super.excuteQuery(sql, parms);
			if (set != null) {
				while (set.next()) {
					menu = new Menu();
					menu.setId(set.getInt("id"));
					menu.setMname(set.getString("mname"));
					menu.setParentid(set.getInt("parentid"));
					menu.setType(set.getInt("type"));
					menu.setMbtn(set.getString("mbtn"));
					menu.setIsdelete(set.getInt("isdelete"));
					menu.setMfunction(set.getString("mfunction"));
				}
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
		} finally {
			DataBaseUtil.closeAll(set, null, null);
		}
		return menu;
	}

	@Override
	public int updateAllot(Menu menu) {
		String sql = "UPDATE `ls_menu` SET mname=?,parentid=?,`type`=?,mbtn=?,isdelete=? WHERE id=?";
		Object[] parms = {menu.getMname(),menu.getParentid(),menu.getType(),menu.getMbtn(),menu.getIsdelete(),menu.getId()};
		for (Object object : parms) {
			System.out.println(object);
		}
		return super.excuteUpdate(sql, parms);
	}

	@Override
	public String seleName(int pid) {
		String sql = "select mname from `ls_menu` where id = ?";
		String name = "";
		ResultSet set = null;
		Object[] parms = {pid};
		try {
			set = super.excuteQuery(sql, parms);
			if (set != null) {
				while (set.next()) {
					name = set.getString("mname");
				}
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
		} finally {
			DataBaseUtil.closeAll(set, null, null);
		}
		return name;
	}

	/*
	 * 
	 * @see cn.hfxt.dao.MenuDao#seleType(int)
	 */
	@Override
	public List<Menu> seleType(int type) {
		String sql = "SELECT * FROM ls_menu WHERE `type`=?";
		List<Menu> list = new ArrayList<Menu>();
		ResultSet set = null;
		Object[] parms = {type};
		try {
			set = super.excuteQuery(sql, parms);
			if (set != null) {
				while (set.next()) {
					Menu me = new Menu();
					me.setId(set.getInt("id"));
					me.setMname(set.getString("mname"));
					list.add(me);
				}
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
		} finally {
			DataBaseUtil.closeAll(set, null, null);
		}
		return list;
	}

	@Override
	public int insertAllot(Menu menu) {
		String sql = "INSERT INTO `ls_menu` (mname, parentid, `type`, mbtn ,isdelete) VALUES(?, ?, ?, ?, ?)";
		Object[] parms = {menu.getMname(),menu.getParentid(),menu.getType(),menu.getMbtn(),menu.getIsdelete()};
		return super.excuteUpdate(sql, parms);
	}

	@Override
	public List<Menu> seleMunuid(int menuid) {
		String sql = "select * from `ls_menu` where id = ?";
		List<Menu> list = new ArrayList<Menu>();
		ResultSet set = null;

		Object[] parms = { menuid };
		Menu menu = null;
		try {
			set = super.excuteQuery(sql, parms);
			if (set != null) {
				while (set.next()) {
					menu = new Menu();
					menu.setId(set.getInt("id"));
					menu.setMname(set.getString("mname"));
					menu.setParentid(set.getInt("parentid"));
					menu.setType(set.getInt("type"));
					menu.setMbtn(set.getString("mbtn"));
					menu.setIsdelete(set.getInt("isdelete"));
					menu.setMfunction(set.getString("mfunction"));
					list.add(menu);
				}
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
		} finally {
			DataBaseUtil.closeAll(set, null, null);
		}
		return list;
	}

	@Override
	public List<RoleType> roleType() {
		String sql = "SELECT smbms_user.id,`smbms_role`.`roleName`,username FROM `smbms_role`,`smbms_user` WHERE `smbms_role`.`id`=smbms_user.`userRole` ORDER BY `smbms_role`.`roleName` ";
		List<RoleType> list = new ArrayList<RoleType>();
		ResultSet set = null;
		RoleType type = null;
		try {
			set = super.excuteQuery(sql, null);
			if (set != null) {
				while (set.next()) {
					type = new RoleType();
					type.setId(set.getInt("id"));
					type.setRoleName(set.getString("roleName"));
					type.setUserName(set.getString("userName"));
					list.add(type);
				}
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
		} finally {
			DataBaseUtil.closeAll(set, null, null);
		}
		return list;
	}

}
