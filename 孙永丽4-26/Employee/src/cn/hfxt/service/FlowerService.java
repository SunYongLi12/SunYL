package cn.hfxt.service;

import java.util.List;

import cn.hfxt.entity.Flowers;
import cn.hfxt.entity.Layui;
import cn.hfxt.entity.Menu;

public interface FlowerService {
	Layui<Flowers> seleFlowers();//��ѯ
	
	List<Menu> seleFBtn(int parentid);//��ť
	
	int addFlowers(Flowers flower);//����
	
	int deleFlowers(int id);//ɾ��
<<<<<<< HEAD
	
	int echoFlowers(int id);//����
	
=======
	Flowers echoFlowers(int id);//����
>>>>>>> 7b927714ff12b788263f5fb2517cd67fa386705e
	int updaFlowers(Flowers flower);//�޸�
	
}
