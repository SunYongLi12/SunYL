package cn.hfxt.dao;

import java.util.List;

import cn.hfxt.entity.Flowers;

public interface FlowerDao {
	List<Flowers> seleFlowers();//��ѯ
	int addFlowers(Flowers flower);//����
	int deleFlowers(int id);//ɾ��
	int echoFlowers(int id);//����
	int updaFlowers(Flowers flower);//�޸�
}
