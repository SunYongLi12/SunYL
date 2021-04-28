package cn.hfxt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.hfxt.entity.Flowers;
import cn.hfxt.service.impl.FlowerServiceImpl;

public class FloServlet extends AbstractServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
	public int DelFlo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		return new FlowerServiceImpl().deleFlowers(id);
	}
	
	public int FloInsert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		Flowers flo = new Flowers();
		flo.setFlowerName(request.getParameter("flowername"));
		return new FlowerServiceImpl().addFlowers(flo);
	}
	
	@Override
	public Class getServletClass() {
		return FloServlet.class;
	}

	
}
