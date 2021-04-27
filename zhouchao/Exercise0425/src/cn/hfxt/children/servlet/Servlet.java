package cn.hfxt.children.servlet;

import java.io.IOException;
import java.util.List;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.hfxt.entity.BM;
import cn.hfxt.entity.Btn;
import cn.hfxt.entity.FenMenu;
import cn.hfxt.entity.JS;
import cn.hfxt.entity.QX;
import cn.hfxt.entity.YG;
import cn.hfxt.entity.ZC;
import cn.hfxt.parent.servlet.AbstractServlet;
import cn.hfxt.service.Service;
import cn.hfxt.service.impl.ServiceImpl;
import cn.hfxt.util.Layui;
@WebServlet("/Servlet")
public class Servlet extends AbstractServlet{
	private Service service = new ServiceImpl();
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
	int YGid=0;
	//登录
	public int Login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		YGid = service.Login(request.getParameter("name"), request.getParameter("pwd"));
		return YGid;
//		request.setAttribute("login", login);
//		//seleQX(request, response,login);
//		"BackJsp/InitialPage";
	}
	
	//btn
	public List<Btn> seleAllBtn(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Btn> allBtn = service.allBtn();
		return allBtn;
	}
	
	public String seleQX(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<QX> list = service.seleQX(Integer.parseInt(request.getParameter("id")));
		System.out.println(list.size());
		request.setAttribute("list", list);//3
		return "BackJsp/InitialPage";
	}
//  查询员工
	public String YG(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int parseInt = Integer.parseInt(request.getParameter("fid"));
		List<QX> seleJsYG = service.seleJsYG(parseInt,YGid);
		request.setAttribute("seleButton", seleJsYG);
		return "/BackJsp/YG";
	}
	public Layui<YG> seleYG(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Layui<YG> seleYG = service.seleYG();
		return seleYG;
	}
	
//	查询所有角色
	public List<JS> seleJS(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<JS> seleJS = service.seleJS();
		return seleJS;
	}

//	查询所有部门
	public List<BM> seleBM(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<BM> seleBM = service.seleBM();
		return seleBM;
	}
	
//	查询所有职称
	public List<ZC> seleZC(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<ZC> seleZC = service.seleZC();
		return seleZC;
	}
	
//	新增YG
	public int addYG(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		YG yg = new YG(0, request.getParameter("name"), Integer.parseInt(request.getParameter("sex")), Integer.parseInt(request.getParameter("js")), Integer.parseInt(request.getParameter("bm")),Integer.parseInt(request.getParameter("zc")), null, null, null);
		return service.addYG(yg);
	}
	
//	删除YG
	public int deleteYG(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		return service.deleteYG(Integer.parseInt(request.getParameter("id")));
	}
//	删除QX
	public int deleteQX(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		return service.deleteQX(Integer.parseInt(request.getParameter("id")));
	}
//	回显YG
	public YG echoYG(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		return service.echoYG(Integer.parseInt(request.getParameter("id")));
	}
//	回显QX
	public QX echoQX(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		return service.echoQX(Integer.parseInt(request.getParameter("id")));
	}
//	修改YG
	public int updateYG(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		YG yg = new YG(Integer.parseInt(request.getParameter("id")), request.getParameter("name"), Integer.parseInt(request.getParameter("sex")), Integer.parseInt(request.getParameter("js")), Integer.parseInt(request.getParameter("bm")),Integer.parseInt(request.getParameter("zc")), null, null, null);
		return service.updateYG(yg);
	}
	
//	查询所有权限
	public String QX(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int parseInt = Integer.parseInt(request.getParameter("fid"));
		List<QX> seleJsYG = service.seleJsYG(parseInt,YGid);
		request.setAttribute("seleButton", seleJsYG);
		return "/BackJsp/QX";
	}
	public Layui<QX> seleALLQX(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Layui<QX> seleQX = service.seleQX();
		return seleQX;
	}
	public Layui<FenMenu> seleALLQXTree(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Layui<FenMenu> seleALLQXTree = service.seleALLQXTree();
		return seleALLQXTree;
	}
//	角色
	public String JS(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int parseInt = Integer.parseInt(request.getParameter("fid"));
		List<QX> seleJsYG = service.seleJsYG(parseInt,YGid);
		request.setAttribute("seleButton", seleJsYG);
		
		return "/BackJsp/JS";
	}
	public Layui<JS> seleALLJS(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Layui<JS> seleALLYGJS = service.seleALLYGJS();
		return seleALLYGJS;
	}
	
//	新增QX
	public int addQX(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		QX qx = new QX(0, request.getParameter("name"), request.getParameter("btn"), Integer.parseInt(request.getParameter("fid")), Integer.parseInt(request.getParameter("type")), request.getParameter("url"), request.getParameter("js"));
		return service.addQX(qx);
	}
	
	public List<QX> seleFF(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<QX> seleF = service.seleF(Integer.parseInt(request.getParameter("type"))-1);
		return seleF;
	}
	
	public List<QX> seleJSALLQXTree(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		return service.seleJSALLQXTree(Integer.parseInt(request.getParameter("userid")));
	}
	
	@Override
	public Class getServletClass() {
		// TODO Auto-generated method stub
		return Servlet.class;
	}
}
