package cn.hfxt.service;

import cn.hfxt.entity.Flowers;
import cn.hfxt.entity.Layui;

public interface FlowerService {
	Layui<Flowers> seleFlowers();//��ѯ
	int addFlowers(Flowers flower);//����
	int deleFlowers(int id);//ɾ��
	int echoFlowers(int id);//����
	int updaFlowers(Flowers flower);//�޸�
}
