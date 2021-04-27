package cn.hfxt.parent.servlet;

import cn.hfxt.util.EmptyUtils;
import cn.hfxt.util.PrintUtil;
import cn.hfxt.util.ReturnResult;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public abstract class AbstractServlet extends HttpServlet {


	public abstract Class getServletClass();

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//鑾峰緱action鏂规硶锟�??
		String actionIndicator = req.getParameter("action");
		Method method = null;
		Object result = null;
		try {
//			EmptyUtils:鍒ゆ柇闈炵┖
			if (EmptyUtils.isEmpty(actionIndicator)) {
				result = execute(req, resp);
			} else {
				/*
				 * getServletClass():鑾峰緱姣忎竴涓猄ervlet锟�??
				 * getDeclaredMethod():鑾峰彇绫昏嚜韬畾涔夌殑鏂规硶
				 * getMethod():鑾峰彇锟�??鏈夊叡鏈夌殑鏂规硶
				 */
				method = getServletClass().getDeclaredMethod(actionIndicator, HttpServletRequest.class, HttpServletResponse.class);
				System.out.println("method"+method);
				result = method.invoke(this, req, resp);//鍙嶅皠鏈哄埗璋冪敤鏂规硶锛屽緱鍒拌鏂规硶鐨勮繑鍥烇拷??
			}
			toView(req, resp, result);
		} catch (NoSuchMethodException e) {//鐢ㄥ弽灏勬満鍒惰皟鐢ㄦ柟娉曪紝鎶ユ壘涓嶅埌鏂规硶寮傚父浼氳浆鍙戝埌404椤甸潰
			String viewName = "404.jsp";
			req.getRequestDispatcher(viewName).forward(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
			if (!EmptyUtils.isEmpty(result)) {
				if (result instanceof String) {
					String viewName = "500.jsp";
					req.getRequestDispatcher(viewName).forward(req, resp);
				} else {
					ReturnResult returnResult = new ReturnResult(); 
					returnResult.returnFail("绯荤粺閿欒");
					PrintUtil.write(returnResult, resp);
				}
			} else {
				String viewName = "500.jsp";
				req.getRequestDispatcher(viewName).forward(req, resp);
			}

		}
	}

	protected void toView(HttpServletRequest req, HttpServletResponse resp, Object result) throws IOException, ServletException {
		if (!EmptyUtils.isEmpty(result)) {
			//instanceof:绫诲瀷鍒ゆ柇
			if (result instanceof String) {
				String viewName = result.toString() + ".jsp";
				System.out.println("----------------viewName");
				req.getRequestDispatcher(viewName).forward(req, resp);
			} else {
				System.out.println("----------------PrintUtil.write");
				PrintUtil.write(result, resp);
			}
		}
	}

//	
	public Object execute(HttpServletRequest req, HttpServletResponse resp) {
		return "pre/Index";
	}
}
