package cn.hfxt.dao;

import java.util.List;

import cn.hfxt.entity.Flowers;
import cn.hfxt.entity.Menu;

public interface FlowerDao {
	List<Flowers> seleFlowers();//��ѯ
	List<Menu> seleFBtn(int parentid);//��ť
	int addFlowers(Flowers flower);//����
	int deleFlowers(int id);//ɾ��
	int echoFlowers(int id);//����
	int updaFlowers(Flowers flower);//�޸�
}
