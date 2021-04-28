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
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleFlowers(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int echoFlowers(int id) {
		String sql = "SELECT * FROM `flowers` WHERE id = ?";
		
		return 0;
	}

	@Override
	public int updaFlowers(Flowers flower) {
		// TODO Auto-generated method stub
		return 0;
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
