package cn.hfxt.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.hfxt.entity.Flowers;
import cn.hfxt.entity.Layui;
import cn.hfxt.service.impl.FlowerServiceImpl;

public class FlowerServlet extends AbstractServlet {

	/**
		 * The doGet method of the servlet. <br>
		 *
		 * This method is called when a form has its tag value method equals to get.
		 * 
		 * @param request the request send by the client to the server
		 * @param response the response send by the server to the client
		 * @throws ServletException if an error occurred
		 * @throws IOException if an error occurred
		 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
	//ªÿœ‘
	public Flowers echoFlower(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Flowers flower = new FlowerServiceImpl().echoFlowers(Integer.parseInt(request.getParameter("id")));
		return flower;
	}
	
<<<<<<< HEAD
	
=======
	//–ﬁ∏ƒ
	public int updateFlower(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Flowers flower = new Flowers();
		flower.setId(Integer.parseInt(request.getParameter("id")));
		flower.setFlowerName(request.getParameter("flower"));
		return new FlowerServiceImpl().updaFlowers(flower);
	}
>>>>>>> 7b927714ff12b788263f5fb2517cd67fa386705e
	@Override
	public Class getServletClass() {
		return FlowerServlet.class;
	}

}
