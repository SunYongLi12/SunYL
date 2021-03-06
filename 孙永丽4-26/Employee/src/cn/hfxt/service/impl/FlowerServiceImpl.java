package cn.hfxt.service.impl;

import java.util.List;

import cn.hfxt.dao.FlowerDao;
import cn.hfxt.dao.impl.FlowerDaoImpl;
import cn.hfxt.entity.Flowers;
import cn.hfxt.entity.Layui;
import cn.hfxt.entity.Menu;
import cn.hfxt.service.FlowerService;
import cn.hfxt.utils.DataBaseUtil;

public class FlowerServiceImpl implements FlowerService{

	private FlowerDao flodao = new FlowerDaoImpl(DataBaseUtil.getConnection());
	
	@Override
	public Layui<Flowers> seleFlowers() {
		Layui<Flowers> layui = new Layui<Flowers>();
		List<Flowers> seleFlowers = flodao.seleFlowers();
		
		layui.setCode(0);
		layui.setCount(seleFlowers.size());
		layui.setData(seleFlowers);
		layui.setMassage("");
		
		return layui;
	}

	@Override
	public int addFlowers(Flowers flower) {
		return flodao.addFlowers(flower);
	}

	@Override
	public int deleFlowers(int id) {
		return flodao.deleFlowers(id);
	}

	@Override
	public Flowers echoFlowers(int id) {
		// TODO Auto-generated method stub
		return flodao.echoFlowers(id);
	}

	@Override
	public int updaFlowers(Flowers flower) {
		// TODO Auto-generated method stub
		return flodao.updaFlowers(flower);
	}

	@Override
	public List<Menu> seleFBtn(int parentid) {
		return flodao.seleFBtn(parentid);
	}

}
