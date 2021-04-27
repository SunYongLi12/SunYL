package cn.hfxt.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.hfxt.entity.Layui;
import cn.hfxt.entity.Menu;
import cn.hfxt.entity.RoleType;
import cn.hfxt.service.impl.MenuServiceImpl;

public class MenuServlet extends AbstractServlet  {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doPost(request, response);
	}
	
	public int MenuInsert(HttpServletRequest request, HttpServletResponse response) throws Exception{
		Menu menu = new Menu();
		menu.setMname(request.getParameter("mname"));
		menu.setParentid(Integer.parseInt(request.getParameter("parentid")));
		menu.setType(Integer.parseInt(request.getParameter("type2")));
		menu.setMbtn(request.getParameter("mbtn"));
		menu.setIsdelete(Integer.parseInt(request.getParameter("isdelete")));
		int insertAllot = new MenuServiceImpl().insertAllot(menu);
		return insertAllot;
	}
	
	public int delmenu(HttpServletRequest request, HttpServletResponse response) throws Exception{
		int id = Integer.parseInt(request.getParameter("id"));
		int deleteAllot = new MenuServiceImpl().deleteAllot(id);
		return deleteAllot;
	}
	
	public List<Menu> selectByMenuid(HttpServletRequest request, HttpServletResponse response) throws Exception{
		int menuid = Integer.parseInt(request.getParameter("menuid"));
		List<Menu> seleMunuid = new MenuServiceImpl().seleMunuid(menuid);
		return seleMunuid;
	}
	
	public List<Menu> seleType(HttpServletRequest request, HttpServletResponse response) throws Exception{
		int type = Integer.parseInt(request.getParameter("type"))-1;
		List<Menu> seleType = new MenuServiceImpl().seleType(type);
		
		return seleType;
	}
	
	public int MenuUpdate(HttpServletRequest request, HttpServletResponse response) throws Exception{
		Menu menu = new Menu(Integer.parseInt(request.getParameter("id")), request.getParameter("mname"), Integer.parseInt(request.getParameter("parentid")), Integer.parseInt(request.getParameter("type2")), Integer.parseInt(request.getParameter("isdelete")), null, request.getParameter("mbtn"));
		int updateAllot = new MenuServiceImpl().updateAllot(menu);
		return updateAllot;
	}

	
	@Override
	public Class getServletClass() {
		return MenuServlet.class;
	}

}
