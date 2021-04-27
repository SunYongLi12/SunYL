package cn.hfxt.dao;

import java.util.List;

import cn.hfxt.entity.BM;
import cn.hfxt.entity.Btn;
import cn.hfxt.entity.JS;
import cn.hfxt.entity.QX;
import cn.hfxt.entity.YG;
import cn.hfxt.entity.ZC;

public interface Dao {
	//��¼
	int Login(String name,String pwd);
	//��ѯ��ť
	List<QX> seleQX(int jsid);
	//��ѯԱ��
	List<YG> seleYG();
	//��ɫ��Ӧ�İ�ť
	List<QX> seleJsYG(int fid,int jsid);
	//��ѯ���н�ɫ
	List<JS> seleJS();
	//����
	List<BM> seleBM();
	//����
	List<ZC> seleZC();
	//����
	int addYG(YG yg);
	int addQX(QX qx);
	//ɾ��
	int deleteYG(int id);
	int deleteQX(int id);
	//�޸Ļ���
	YG echoYG(int id);
	QX echoQX(int id);
	//�޸�
	int updateYG(YG yg);
	//��ѯ����Ȩ��
	List<QX> seleQX();
	//�û���ɫ
	List<JS> seleALLYGJS();
	List<QX> seleJSALLQXTree(int id);
	//ָ���û���Ӧ�Ľ�ɫ
	//List<QX> seleYGQX(int id);
	List<Btn> allBtn();
	List<QX> seleF(int type);
}
