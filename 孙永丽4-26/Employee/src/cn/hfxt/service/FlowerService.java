package cn.hfxt.service;

import cn.hfxt.entity.Flowers;
import cn.hfxt.entity.Layui;

public interface FlowerService {
	Layui<Flowers> seleFlowers();//查询
	int addFlowers(Flowers flower);//新增
	int deleFlowers(int id);//删除
	int echoFlowers(int id);//回显
	int updaFlowers(Flowers flower);//修改
}
