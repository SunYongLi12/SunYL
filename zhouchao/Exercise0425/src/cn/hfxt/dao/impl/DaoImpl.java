package cn.hfxt.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.hfxt.dao.BaseDao;
import cn.hfxt.dao.Dao;
import cn.hfxt.entity.BM;
import cn.hfxt.entity.Btn;
import cn.hfxt.entity.JS;
import cn.hfxt.entity.QX;
import cn.hfxt.entity.YG;
import cn.hfxt.entity.ZC;
import sun.security.jca.GetInstance;

public class DaoImpl extends BaseDao implements Dao{

//	查询员工
	@Override
	public List<YG> seleYG() {
		List<YG> list = new ArrayList<YG>();
		String sql = "SELECT yg.id,yg.name,yg.`sex`,js.`role`,bm.`branch`,zc.`rank` FROM `yg`,`js`,`bm`,`zc` WHERE yg.jsid=js.`id` AND yg.`bmid`=bm.`id` AND yg.`zcid`=zc.`id`";
		conn = getconnection();
		try {
			pre = conn.prepareStatement(sql);
			rs = pre.executeQuery();
			while(rs.next()) {
				YG yg=new YG();
				yg.setId(rs.getInt(1));
				yg.setName(rs.getString(2));
				yg.setSex(rs.getInt(3));
				yg.setJs(rs.getString(4));
				yg.setBm(rs.getString(5));
				yg.setZc(rs.getString(6));
				list.add(yg);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		return list;
	}
//  角色权限
	@Override
	public List<QX> seleQX(int jsid) {
		List<QX> list = new ArrayList<QX>();
		String sql = "SELECT * FROM `qx` WHERE id IN (SELECT qxid FROM `qxjs` WHERE jsid = ?)";
		conn = getconnection();
		try {
			pre = conn.prepareStatement(sql);
			pre.setInt(1, jsid);
			rs = pre.executeQuery();
			while(rs.next()) {
				QX qx=new QX();
				qx.setId(rs.getInt(1));
				qx.setQname(rs.getString(2));
				qx.setBtn(rs.getString(3));
				qx.setFid(rs.getInt(4));
				qx.setType(rs.getInt(5));
				qx.setUrl(rs.getString(6));
				qx.setJs(rs.getString(7));
				list.add(qx);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		return list;
	}
//	角色按钮
	@Override
	public List<QX> seleJsYG(int fid,int jsid) {
		List<QX> list = new ArrayList<QX>();
		String sql = "SELECT * FROM `qx` WHERE fid =? and `type`=3 AND id IN (SELECT qxid FROM `qxjs` WHERE jsid = ?)";
		conn = getconnection();
		try {
			pre = conn.prepareStatement(sql);
			pre.setInt(1, fid);
			pre.setInt(2, jsid);
			rs = pre.executeQuery();
			while(rs.next()) {
				QX qx=new QX();
				qx.setId(rs.getInt(1));
				qx.setQname(rs.getString(2));
				qx.setBtn(rs.getString(3));
				qx.setFid(rs.getInt(4));
				qx.setType(rs.getInt(5));
				qx.setUrl(rs.getString(6));
				qx.setJs(rs.getString(7));
				list.add(qx);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		return list;
	}
//  所有角色
	@Override
	public List<JS> seleJS() {
		List<JS> list = new ArrayList<JS>();
		String sql = "SELECT id,role FROM `js`";
		conn = getconnection();
		try {
			pre = conn.prepareStatement(sql);
			rs = pre.executeQuery();
			while(rs.next()) {
				JS js = new JS();
				js.setId(rs.getInt(1));
				js.setRole(rs.getString(2));
				list.add(js);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		return list;
	}
	
//	部门
	@Override
	public List<BM> seleBM() {
		List<BM> list = new ArrayList<BM>();
		String sql = "SELECT id,branch FROM `bm`";
		conn = getconnection();
		try {
			pre = conn.prepareStatement(sql);
			rs = pre.executeQuery();
			while(rs.next()) {
				BM bm = new BM();
				bm.setId(rs.getInt(1));
				bm.setBranch(rs.getString(2));
				list.add(bm);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		return list;
	}
	
//	职称
	@Override
	public List<ZC> seleZC() {
		List<ZC> list = new ArrayList<ZC>();
		String sql = "SELECT id,rank FROM `zc`";
		conn = getconnection();
		try {
			pre = conn.prepareStatement(sql);
			rs = pre.executeQuery();
			while(rs.next()) {
				ZC zc = new ZC();
				zc.setId(rs.getInt(1));
				zc.setRank(rs.getString(2));
				list.add(zc);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		return list;
	}
	@Override
	public int addYG(YG yg) {
		String sql = "INSERT INTO `yg`(`name`,sex,jsid,bmid,zcid) VALUES(?,?,?,?,?)";
		return operaction(sql, yg.getName(),yg.getSex(),yg.getJsid(),yg.getBmid(),yg.getZcid());
	}
	
	@Override
	public int deleteYG(int id) {
		String sql = "delete from `yg` where id = ?";
		return operaction(sql, id);
	}
	//UPDATE `yg` SET `name` = ?,sex = ?,jsid =?,bmid =?,zcid =? WHERE id =?
	@Override
	public YG echoYG(int id) {
		List<YG> list = new ArrayList<YG>();
		YG yg = null;
		String sql = "SELECT * FROM `yg` WHERE yg.id =?";
		conn = getconnection();
		try {
			pre = conn.prepareStatement(sql);
			pre.setInt(1, id);
			rs = pre.executeQuery();
			while(rs.next()) {
				yg=new YG();
				yg.setId(rs.getInt(1));
				yg.setName(rs.getString(2));
				yg.setSex(rs.getInt(3));
				yg.setJsid(rs.getInt(4));
				yg.setBmid(rs.getInt(5));
				yg.setZcid(rs.getInt(6));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		return yg;
	}
	
	@Override
	public int updateYG(YG yg) {
		String sql = "UPDATE `yg` SET `name` = ?,sex = ?,jsid =?,bmid =?,zcid =? WHERE id =?";
		return operaction(sql, yg.getName(),yg.getSex(),yg.getJsid(),yg.getBmid(),yg.getZcid(),yg.getId());
	}
	@Override
	public List<QX> seleQX() {
		List<QX> list = new ArrayList<QX>();
		String sql = "SELECT * FROM `qx`";
		conn = getconnection();
		try {
			pre = conn.prepareStatement(sql);
			rs = pre.executeQuery();
			while(rs.next()) {
				QX qx=new QX();
				qx.setId(rs.getInt(1));
				qx.setQname(rs.getString(2));
				qx.setBtn(rs.getString(3));
				qx.setFid(rs.getInt(4));
				qx.setType(rs.getInt(5));
				qx.setUrl(rs.getString(6));
				qx.setJs(rs.getString(7));
				list.add(qx);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		return list;	
	}
	//登录
	@Override
	public int Login(String name, String pwd) {
		String sql = "SELECT id FROM `yg` WHERE `name`=? AND pwd=?";
		int num = 0;
		conn = getconnection();
		try {
			pre = conn.prepareStatement(sql);
			pre.setString(1, name);
			pre.setString(2, pwd);
			rs = pre.executeQuery();
			while(rs.next()) {
				num = rs.getInt("id");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return num;
	}
	
	@Override
	public List<JS> seleALLYGJS() {
		List<JS> list = new ArrayList<JS>();
		String sql = "SELECT js.id,role,yg.`name`,yg.`sex` FROM `js`,`yg` WHERE js.`id`=yg.`jsid` ORDER BY js.role";
		conn = getconnection();
		try {
			pre = conn.prepareStatement(sql);
			rs = pre.executeQuery();
			while(rs.next()) {
				JS js = new JS();
				js.setId(rs.getInt(1));
				js.setRole(rs.getString(2));
				js.setName(rs.getString(3));
				js.setSex(rs.getInt(4));
				list.add(js);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		return list;
	}
	@Override
	public int addQX(QX qx) {
		String sql = "Insert into `qx`(qname,btn,fid,`type`,url,js) values(?,?,?,?,?,?)";
		return operaction(sql, qx.getQname(),qx.getBtn(),qx.getFid(),qx.getType(),qx.getUrl(),qx.getJs());
	}
	
	@Override
	public List<Btn> allBtn() {
		List<Btn> list = new ArrayList<Btn>();
		conn=getconnection();
		String sql="select * from `btn`";
		try {
			pre=conn.prepareStatement(sql);
			rs=pre.executeQuery();
			while(rs.next()) {
				Btn btn = new Btn();
				System.out.println(rs.getInt("id"));
				btn.setId(rs.getInt("id"));
				btn.setButton(rs.getString("button"));
				list.add(btn);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	@Override
	public List<QX> seleF(int type) {
		List<QX> list=new ArrayList<QX>();
		conn=getconnection();
		String sql = "SELECT id,qname FROM `qx` WHERE `type`=?";
		try {
			pre=conn.prepareStatement(sql);
			pre.setInt(1, type);
			rs=pre.executeQuery();
			while(rs.next()) {
				QX qx = new QX();
				qx.setId(rs.getInt("id"));
				qx.setQname(rs.getString("qname"));
				list.add(qx);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return list;
	}
	@Override
	public int deleteQX(int id) {
		String sql = "delete from qx where id = ?";
		return operaction(sql, id);
	}
	@Override
	public QX echoQX(int id) {
		QX qx = null;
		String sql = "SELECT * FROM `qx` WHERE qx.id =?";
		conn = getconnection();
		try {
			pre = conn.prepareStatement(sql);
			pre.setInt(1, id);
			rs = pre.executeQuery();
			while(rs.next()) {
				qx=new QX();
				qx.setId(rs.getInt(1));
				qx.setQname(rs.getString(2));
				qx.setBtn(rs.getString(3));
				qx.setFid(rs.getInt(4));
				qx.setType(rs.getInt(5));
				qx.setUrl(rs.getString(6));
				qx.setJs(rs.getString(7));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		return qx;
	}
	@Override
	public List<QX> seleJSALLQXTree(int id) {
		String sql ="SELECT * FROM `qx` WHERE id IN (SELECT qxid FROM `qxjs` WHERE jsid = ?)";
		List<QX> list = new ArrayList<QX>();
		conn = getconnection();
		try {
			pre = conn.prepareStatement(sql);
			pre.setInt(1, id);
			rs = pre.executeQuery();
			while(rs.next()) {
				QX qx=new QX();
				qx.setId(rs.getInt(1));
				qx.setQname(rs.getString(2));
				qx.setBtn(rs.getString(3));
				qx.setFid(rs.getInt(4));
				qx.setType(rs.getInt(5));
				qx.setUrl(rs.getString(6));
				qx.setJs(rs.getString(7));
				list.add(qx);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		return list;
	}
	
	

}
