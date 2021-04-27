package cn.hfxt.service.impl;

import java.util.ArrayList;
import java.util.List;

import cn.hfxt.dao.Dao;
import cn.hfxt.dao.impl.DaoImpl;
import cn.hfxt.entity.BM;
import cn.hfxt.entity.Btn;
import cn.hfxt.entity.FenMenu;
import cn.hfxt.entity.JS;
import cn.hfxt.entity.QX;
import cn.hfxt.entity.YG;
import cn.hfxt.entity.ZC;
import cn.hfxt.service.Service;
import cn.hfxt.util.Layui;

public class ServiceImpl implements Service{
private Dao dd = new DaoImpl();
	
	/*
	 * (查询员工)
	 * @see cn.hfxt.service.Service#seleYG()
	 */
	@Override
	public Layui<YG> seleYG() {
		Layui<YG> layui = new Layui<YG>();
		List<YG> seleYG = dd.seleYG();
		
		layui.setCode(0);
		layui.setCount(seleYG.size());
		layui.setMessage("");
		layui.setData(seleYG);
		
		return layui;
	}

	/*
	 * (权限)
	 * @see cn.hfxt.service.Service#seleQX(int)
	 */
	@Override
	public List<QX> seleQX(int jsid) {
		return dd.seleQX(jsid);
	}

	@Override
	public List<QX> seleJsYG(int fid,int jsid) {
		return dd.seleJsYG(fid,jsid);
	}

	@Override
	public List<JS> seleJS() {
		return dd.seleJS();
	}

	@Override
	public List<BM> seleBM() {
		return dd.seleBM();
	}

	@Override
	public List<ZC> seleZC() {
		return dd.seleZC();
	}

	@Override
	public int addYG(YG yg) {
		return dd.addYG(yg);
	}

	@Override
	public int deleteYG(int id) {
		return dd.deleteYG(id);
	}

	@Override
	public YG echoYG(int id) {
		return dd.echoYG(id);
	}

	@Override
	public int updateYG(YG yg) {
		return dd.updateYG(yg);
	}

	@Override
	public Layui<QX> seleQX() {
		Layui<QX> layui = new Layui<QX>();
		List<QX> seleQX = dd.seleQX();
		
		layui.setCode(0);
		layui.setCount(seleQX.size());
		layui.setMessage("");
		layui.setData(seleQX);
		
		return layui;
	}

	@Override
	public int Login(String name, String pwd) {
		return dd.Login(name, pwd);
	}

	@Override
	public Layui<JS> seleALLYGJS() {
		List<JS> seleALLYGJS = dd.seleALLYGJS();
		Layui<JS> layui = new Layui<JS>();
		layui.setCode(0);
		layui.setCount(seleALLYGJS.size());
		layui.setData(seleALLYGJS);
		layui.setMessage("");
		return layui;
	}

	
	@Override
	public Layui<FenMenu> seleALLQXTree() {
		Layui<FenMenu> layui = new Layui<FenMenu>();
		List<QX> seleQX = dd.seleQX();
		List<FenMenu> fenList = new ArrayList<FenMenu>();
		layui.setCode(0);
		layui.setCount(seleQX.size());
		layui.setMessage("");
		for (QX qx : seleQX) {
			FenMenu fen = new FenMenu();
			fen.setId(qx.getId());
			fen.setParentId(qx.getFid());
			fen.setTitle(qx.getQname());
			fen.setCheckArr("0");
			fenList.add(fen);
		}
		layui.setData(fenList);
		
		return layui;
	}


	@Override
	public int addQX(QX qx) {
		return dd.addQX(qx);
	}

	
	@Override
	public List<Btn> allBtn() {
		return dd.allBtn();
	}

	
	@Override
	public List<QX> seleF(int type) {
		return dd.seleF(type);
	}

	
	@Override
	public int deleteQX(int id) {
		return dd.deleteQX(id);
	}

	@Override
	public QX echoQX(int id) {
		return dd.echoQX(id);
	}

	@Override
	public List<QX> seleJSALLQXTree(int id) {
		// TODO Auto-generated method stub
		return dd.seleJSALLQXTree(id);
	}

}
