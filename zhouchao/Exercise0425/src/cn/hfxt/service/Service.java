package cn.hfxt.service;

import java.util.List;

import cn.hfxt.entity.BM;
import cn.hfxt.entity.Btn;
import cn.hfxt.entity.FenMenu;
import cn.hfxt.entity.JS;
import cn.hfxt.entity.QX;
import cn.hfxt.entity.YG;
import cn.hfxt.entity.ZC;
import cn.hfxt.util.Layui;

public interface Service {
	int Login(String name, String pwd);//登录
	List<QX> seleQX(int jsid);//权限
	Layui<YG> seleYG();//查询员工
	List<QX> seleJsYG(int fid,int jsid);//角色按钮
	List<JS> seleJS();//所有角色
	List<BM> seleBM();//部门
	List<ZC> seleZC();//职称
	int addYG(YG yg);//新增
	int addQX(QX qx);
	int deleteYG(int id);//删除
	YG echoYG(int id);//回显
	QX echoQX(int id);
	int updateYG(YG yg);//修改
	Layui<QX> seleQX();//所有权限
	Layui<JS> seleALLYGJS();//角色
	Layui<FenMenu> seleALLQXTree();//所有权限
	List<Btn> allBtn();
	List<QX> seleF(int type);
	int deleteQX(int id);
	List<QX> seleJSALLQXTree(int id);
	//List<QX> seleQX(int jsid);//权限
}
