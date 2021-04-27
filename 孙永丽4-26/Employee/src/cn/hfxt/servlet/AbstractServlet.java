package cn.hfxt.servlet;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.hfxt.utils.EmptyUtils;
import cn.hfxt.utils.PrintUtil;
import cn.hfxt.utils.ReturnResult;

public abstract class AbstractServlet extends HttpServlet {
	public abstract Class getServletClass();
	
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        doPost(req, resp);
    }
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		
		System.out.println("CCCCCCCCCCCCCCCCCCCCCCCCCCC");
		String actionIndicator = req.getParameter("action");
		System.out.println("action"+actionIndicator);
        Method method = null;
        Object result = null;
        try {
            if (EmptyUtils.isEmpty(actionIndicator)) {
                result = execute(req, resp);
            } else {
            	System.out.println("EEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEE");
                method = getServletClass().getDeclaredMethod(actionIndicator, HttpServletRequest.class, HttpServletResponse.class);
                System.out.println("这是method：："+method);
                System.out.println("this   :"+this);
                result = method.invoke(this, req, resp);
            }
            toView(req, resp, result);
           
	    } catch (Exception e) {
	    	System.out.println("PPPPPPPPPPPPPPPPPPP");
	    	e.printStackTrace();
            if (!EmptyUtils.isEmpty(result)) {
                if (result instanceof String) {
                    String viewName = "index.jsp";
                    req.getRequestDispatcher(viewName).forward(req, resp);
                } else {
                    ReturnResult returnResult = new ReturnResult();
                    returnResult.returnFail("系统错误");
                    PrintUtil.write(returnResult, resp);
                }
            } else {
                String viewName = "index.jsp";
                req.getRequestDispatcher(viewName).forward(req, resp);
            }
		}
	}
        
	protected void toView(HttpServletRequest req, HttpServletResponse resp, Object result) throws IOException, ServletException {
		System.out.println("HHHHHHHHHHHHHHHHHHHHHH");
		if (!EmptyUtils.isEmpty(result)) {
			System.out.println("SSSSSSSSSSSSSSSSSSSSSSS");
    	if (result instanceof String) {
    		System.out.println("DDDDDDDDDDDDDDDDDDDDDDDDD");
        	String viewName = result.toString() + ".jsp";
        	System.out.println(viewName);
            req.getRequestDispatcher(viewName).forward(req, resp);
        	} else {
        		System.out.println("RRRRRRRRRRRRRRRRRRRRRRRRRRRR");
            	PrintUtil.write(result, resp);
        	}
		}
	}

        public Object execute(HttpServletRequest req, HttpServletResponse resp) {
            return "/index";
        }
	
}
