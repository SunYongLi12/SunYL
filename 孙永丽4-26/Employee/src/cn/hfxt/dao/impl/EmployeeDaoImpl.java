package cn.hfxt.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import cn.hfxt.dao.BaseDao;
import cn.hfxt.dao.EmployeeDao;
import cn.hfxt.entity.User;
import cn.hfxt.utils.DataBaseUtil;

public class EmployeeDaoImpl extends BaseDao implements EmployeeDao {

	public EmployeeDaoImpl(Connection conn) {
		super(conn);
		// TODO Auto-generated constructor stub
	}
	public static Logger logger = Logger.getLogger(BaseDao.class.getName());
	ResultSet set = null;
	
	
	//查询所有用户
	@Override
	public List<User> SelectUser() {
		List<User> list = new ArrayList<User>();
		
		String sql = "SELECT `smbms_user`.id,usercode,userName,userpassword,Dname,Tname,userrole,phone,address FROM `title`,`department`,`smbms_user`,`smbms_role` \r\n" + 
				"WHERE `smbms_user`.`userRole`=smbms_role.`id` AND `smbms_user`.`Did`=department.`id` AND `smbms_user`.`Tid`=title.`id` ";
		
		try {
			// 调用方法！
			set = super.excuteQuery(sql, null);
			if (set != null) {
				while (set.next()) {
					User user=new User();
					user.setId(set.getInt("id"));
					user.setUserCode(set.getString("usercode"));
					user.setUserName(set.getString("userName"));
					user.setdName(set.getString("dName"));
					user.settName(set.getString("tName"));
					user.setRoleName(set.getInt("userrole"));
					user.setPhone(set.getString("phone"));
					user.setAddress(set.getString("address"));
					list.add(user);
				}
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
		} finally {
			// 释放资源！
			DataBaseUtil.closeAll(set, null, null);
		}
		return list;
	}

	@Override
	public int LoginUser(String usercode,String userpasswd) {
		int num = 0;
		ResultSet set = null;
		String sql = "SELECT id,usercode,userpassword FROM `smbms_user` WHERE usercode=? AND userpassword=? " ;
		System.out.println("sql++"+sql);
		try {
			Object[] parms = {usercode, userpasswd};
			System.out.println("222"+usercode+"    "+ userpasswd);
			set = super.excuteQuery(sql, parms);
			System.out.println("set+"+set);
			if (set != null) {
				if (set.next()) {
					num= set.getInt("id");
					return num;
				}
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
		} finally {
			// 释放资源！
			DataBaseUtil.closeAll(set, null, null);
		}
		System.out.println(num+" ...");
		return num;
	}

	@Override
	public int InsertUser(User user) {
		String sql="INSERT INTO smbms_user(`userCode`,`userName`,userPassword,`Phone`,`address`,`userRole`) VALUES(?,?,?,?,?,?)";
		System.out.println(user.toString());
		Object[] parms={user.getUserCode(),user.getUserName(),user.getPasswd(),user.getPhone(),user.getAddress(),user.getUserRole()};
		int num=this.excuteUpdate(sql,parms);
		return num;
	}

	@Override
	public int DeleteUser(int id) {
		String sql="DELETE FROM smbms_user WHERE id=?";
		Object[] parms = { id };
		int num=this.excuteUpdate(sql, parms);
		return num;
	}

	@Override
	public int UpdateUser(User user) {
		String sql="update smbms_user set usercode=?,`userName`=?,userPassword=?,`Phone`=?,`address`=?,`userRole`=? where id=?";
		Object[] parms= {user.getUserCode(),user.getUserName(),user.getPasswd(),user.getPhone(),user.getAddress(),user.getUserRole(),user.getId()};
		int num=this.excuteUpdate(sql,parms);
		return num;
	}

	@Override
	public List<User> SelectUserId(int id) {
		List<User> list=new ArrayList<User>();
		String sql="SELECT id, `userCode`,`userName`,userpassword,`phone`,userrole,address FROM `smbms_user`\r\n" + 
					"WHERE  smbms_user.`id`=?";
		try {
			Object[] parms = { id };
			set=super.excuteQuery(sql , parms);
			while (set.next()) {
				User user=new User();
				user.setId(set.getInt("id"));
				user.setUserCode(set.getString("usercode"));
				user.setUserName(set.getString("userName"));
				user.setPasswd(set.getString("userpassword"));
				user.setUserRole(set.getInt("userrole"));
				user.setPhone(set.getString("phone"));
				user.setAddress(set.getString("address"));
				list.add(user);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

}
