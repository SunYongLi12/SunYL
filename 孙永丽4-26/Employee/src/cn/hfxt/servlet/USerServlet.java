package cn.hfxt.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.hfxt.entity.Flowers;
import cn.hfxt.entity.Layui;
import cn.hfxt.entity.Menu;
import cn.hfxt.entity.RoleType;
import cn.hfxt.entity.User;
import cn.hfxt.service.FlowerService;
import cn.hfxt.service.impl.FlowerServiceImpl;
import cn.hfxt.service.impl.MenuServiceImpl;
import cn.hfxt.service.impl.UserServiceImpl;
public class USerServlet extends AbstractServlet{

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doPost(request, response);
	}
	private FlowerService flower = new FlowerServiceImpl();
	int num = 0;
	
	public int LoginUser(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String usercode = request.getParameter("usercode");
		String userpasswd = request.getParameter("userpasswd");
		System.out.println("-----------"+usercode+"------"+userpasswd);
		num = new UserServiceImpl().LoginUser(usercode, userpasswd);
		System.out.println("num::"+num);
		
		return num;
	}
	
	public String resMenu(HttpServletRequest request, HttpServletResponse response) throws Exception{
		System.out.println("menuByUserid::"+Integer.parseInt(request.getParameter("id")));
		List<Menu> menuByUserid = new MenuServiceImpl().menuByUserid(Integer.parseInt(request.getParameter("id")));
		
		request.setAttribute("list", menuByUserid);
		
		return "InitialPage";
	}
	
	public String Control(HttpServletRequest request, HttpServletResponse response) throws Exception{
		System.out.println("zheshi "+num);
		System.out.println(request.getParameter("id"));
		List<Menu> menuByUserid = new MenuServiceImpl().resMenu1(Integer.parseInt(request.getParameter("id")), 3, num);
		request.setAttribute("list", menuByUserid);
		System.out.println(menuByUserid.size());
		return "RightCentent";
	}
	public Layui<User> AllUser(HttpServletRequest request, HttpServletResponse response) throws Exception{
		Layui<User> selectUser = new UserServiceImpl().SelectUser();
		return selectUser;
	}
	
	public String Jurisdiction(HttpServletRequest request, HttpServletResponse response) throws Exception{
		System.out.println("aaaaaaa "+num);
		System.out.println(request.getParameter("id"));
		List<Menu> menuByUserid = new MenuServiceImpl().resMenu1(Integer.parseInt(request.getParameter("id")), 3, num);
		request.setAttribute("list", menuByUserid);
		System.out.println(menuByUserid.size());
		return "RightJurisdiction";
	}
	
	public Layui<Menu> AllMenu(HttpServletRequest request, HttpServletResponse response) throws Exception{
		Layui<Menu> allMenu = new MenuServiceImpl().allMenu();
		return allMenu;
	}
	
	public int addUser(HttpServletRequest request, HttpServletResponse response) throws Exception{
		User user = new User();
		user.setUserCode(request.getParameter("usercode"));
		user.setUserName(request.getParameter("username"));
		user.setPasswd(request.getParameter("passwd"));
		user.setPhone(request.getParameter("phone"));
		user.setAddress(request.getParameter("address"));
		user.setUserRole(Integer.parseInt(request.getParameter("roleName")));
		System.out.println("SD"+user.toString());
		int insertUser = new UserServiceImpl().InsertUser(user);
		System.out.println("insertUser::"+insertUser);
		return insertUser;
	}

	public int delUser(HttpServletRequest request, HttpServletResponse response) throws Exception{
		int id = Integer.parseInt(request.getParameter("id"));
		int deleteUser = new UserServiceImpl().DeleteUser(id);
		System.out.println("deleteUser::"+deleteUser);
		return deleteUser;
	}
	
	public List<User> selectByUserid(HttpServletRequest request, HttpServletResponse response) throws Exception{
		int id = Integer.parseInt(request.getParameter("id"));
		List<User> selectUserId = new UserServiceImpl().SelectUserId(id);
		System.out.println("selectUserId::"+selectUserId);
		return selectUserId;
	}
	
	public int UpdateUser(HttpServletRequest request, HttpServletResponse response) throws Exception{
		User user = new User();
		user.setId(Integer.parseInt(request.getParameter("id")));
		user.setUserName(request.getParameter("username"));
		user.setUserCode(request.getParameter("usercode"));
		user.setPasswd(request.getParameter("passwd"));
		user.setPhone(request.getParameter("phone"));
		user.setAddress(request.getParameter("address"));
		user.setUserRole(Integer.parseInt(request.getParameter("userrole")));
		int updateUser = new UserServiceImpl().UpdateUser(user);
		return updateUser;
	}
	
	
	public String RoleType(HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		return "RightRoleType";
	}
	public Layui<RoleType> AllRoleType(HttpServletRequest request, HttpServletResponse response) throws Exception{
		Layui<RoleType> roletype = new MenuServiceImpl().roleType();
		return roletype;
	}
	
	public String Flower(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Menu> seleFBtn = flower.seleFBtn(Integer.parseInt(request.getParameter("id")));
		System.out.println("flower::"+seleFBtn.size());
		request.setAttribute("list", seleFBtn);
		return "RightFlower";
	}
	public Layui<Flowers> AllFlowers(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Layui<Flowers> layui = flower.seleFlowers();
		return layui;
	}
	
	@Override
	public Class getServletClass() {
		return USerServlet.class;
	}

}
