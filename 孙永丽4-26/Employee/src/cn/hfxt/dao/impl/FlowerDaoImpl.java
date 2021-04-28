package cn.hfxt.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import cn.hfxt.dao.BaseDao;
import cn.hfxt.dao.FlowerDao;
import cn.hfxt.entity.Flowers;
import cn.hfxt.entity.Menu;
import cn.hfxt.utils.DataBaseUtil;

public class FlowerDaoImpl extends BaseDao implements FlowerDao{

	public FlowerDaoImpl(Connection conn) {
		super(conn);
		// TODO Auto-generated constructor stub
	}

	public static Logger logger = Logger.getLogger(BaseDao.class.getName());
	ResultSet set = null;
	
	@Override
	public List<Flowers> seleFlowers() {
		String sql = "SELECT id,flowerName FROM `flowers`";
		List<Flowers> list = new ArrayList<Flowers>();
		try {
			set = super.excuteQuery(sql, null);
			if(set != null) {
				while (set.next()) {
					Flowers flo = new Flowers();
					flo.setId(set.getInt("id"));
					flo.setFlowerName(set.getString("flowerName"));
					list.add(flo);
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
	public int addFlowers(Flowers flower) {
		String sql="INSERT INTO flowers(flowername) VALUES(? )";
		Object[] parms={flower.getFlowerName()};
		int num=this.excuteUpdate(sql,parms);
		return num;
	}

	@Override
	public int deleFlowers(int id) {
		String sql = "DELETE FROM `flowers` WHERE id=?";
		Object[] parms = { id };
		int num = super.excuteUpdate(sql, parms);
		return num;
	}

	@Override
	public Flowers echoFlowers(int id) {
		String sql = "SELECT * FROM `flowers` WHERE id = ?";
		Flowers flower = null;
		Object[] parms = {id};
		try {
			set = super.excuteQuery(sql, parms);
			if(set != null) {
				while (set.next()) {
					flower = new Flowers();
					flower.setId(set.getInt("id"));
					flower.setFlowerName(set.getString("flowerName"));
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return flower;
	}

	@Override
	public int updaFlowers(Flowers flower) {
		String sql = "UPDATE `flowers` SET flowername=? WHERE id=?";
		Object[] parms = {flower.getFlowerName(),flower.getId()};
		return super.excuteUpdate(sql, parms);
	}

	@Override
	public List<Menu> seleFBtn(int parentid) {
		List<Menu> list = new ArrayList<Menu>();
		String sql = "SELECT * FROM `ls_menu` WHERE parentid = ? AND `type` = 3";
		Object[] parms = {parentid};
		try {
			set = super.excuteQuery(sql, parms);
			if(set != null) {
				while (set.next()) {
					Menu menu = new Menu();
					menu.setId(set.getInt("id"));
					menu.setMbtn(set.getString("mbtn"));
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

}
