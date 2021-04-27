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
	int Login(String name, String pwd);//��¼
	List<QX> seleQX(int jsid);//Ȩ��
	Layui<YG> seleYG();//��ѯԱ��
	List<QX> seleJsYG(int fid,int jsid);//��ɫ��ť
	List<JS> seleJS();//���н�ɫ
	List<BM> seleBM();//����
	List<ZC> seleZC();//ְ��
	int addYG(YG yg);//����
	int addQX(QX qx);
	int deleteYG(int id);//ɾ��
	YG echoYG(int id);//����
	QX echoQX(int id);
	int updateYG(YG yg);//�޸�
	Layui<QX> seleQX();//����Ȩ��
	Layui<JS> seleALLYGJS();//��ɫ
	Layui<FenMenu> seleALLQXTree();//����Ȩ��
	List<Btn> allBtn();
	List<QX> seleF(int type);
	int deleteQX(int id);
	List<QX> seleJSALLQXTree(int id);
	//List<QX> seleQX(int jsid);//Ȩ��
}
