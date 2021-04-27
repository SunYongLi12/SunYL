package cn.hfxt.dao;

import java.util.List;

import cn.hfxt.entity.Flowers;

public interface FlowerDao {
	List<Flowers> seleFlowers();//查询
	int addFlowers(Flowers flower);//新增
	int deleFlowers(int id);//删除
	int echoFlowers(int id);//回显
	int updaFlowers(Flowers flower);//修改
}
