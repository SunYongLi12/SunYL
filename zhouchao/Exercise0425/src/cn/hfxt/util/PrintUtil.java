package cn.hfxt.util;
import com.alibaba.fastjson.JSONObject;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServletResponse;

public class PrintUtil {

	private static void print(String sj,HttpServletResponse response){
		PrintWriter out=null;
		try {
			if(null != response){
				out=response.getWriter();
				out.print(sj);//向页面输出数据?
				out.flush();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			out.close();
		}
	}
	public static void write(Object obj,HttpServletResponse response){
		response.setContentType("text/html; charset=utf-8");
//		System.out.println("PrintUtil:"+obj.toString());
		String json = JSONObject.toJSONString(obj);//将获得的Object类型数据转换成JSON字符串?
		System.out.println("jsop:::::"+json);
		print(json,response);
	}
}
