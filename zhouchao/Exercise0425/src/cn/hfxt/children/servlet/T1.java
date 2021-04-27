package cn.hfxt.children.servlet;

import java.util.List;

import cn.hfxt.entity.Btn;
import cn.hfxt.service.impl.ServiceImpl;

public class T1 {
	public static void main(String[] args) {
		List<Btn> allBtn = new ServiceImpl().allBtn();
		System.out.println(allBtn.size());
		
	}
}
