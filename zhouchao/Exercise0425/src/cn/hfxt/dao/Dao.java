package cn.hfxt.dao;

import java.util.List;

import cn.hfxt.entity.BM;
import cn.hfxt.entity.Btn;
import cn.hfxt.entity.JS;
import cn.hfxt.entity.QX;
import cn.hfxt.entity.YG;
import cn.hfxt.entity.ZC;

public interface Dao {
	//登录
	int Login(String name,String pwd);
	//查询按钮
	List<QX> seleQX(int jsid);
	//查询员工
	List<YG> seleYG();
	//角色对应的按钮
	List<QX> seleJsYG(int fid,int jsid);
	//查询所有角色
	List<JS> seleJS();
	//部门
	List<BM> seleBM();
	//部门
	List<ZC> seleZC();
	//新增
	int addYG(YG yg);
	int addQX(QX qx);
	//删除
	int deleteYG(int id);
	int deleteQX(int id);
	//修改回显
	YG echoYG(int id);
	QX echoQX(int id);
	//修改
	int updateYG(YG yg);
	//查询所有权限
	List<QX> seleQX();
	//用户角色
	List<JS> seleALLYGJS();
	List<QX> seleJSALLQXTree(int id);
	//指定用户对应的角色
	//List<QX> seleYGQX(int id);
	List<Btn> allBtn();
	List<QX> seleF(int type);
}
