package cn.hfxt.entity;

import java.util.List;
/**
 * 
 * @author 86136
 *
 * @param 泛型类  layui<T>
 */
public class Layui<T> {
	private int code;//状态码
	private String massage;//提示信息
	private int count;//次数
	private List<T> data;//数据存放
	
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getMassage() {
		return massage;
	}
	public void setMassage(String massage) {
		this.massage = massage;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public List<T> getData() {
		return data;
	}
	public void setData(List<T> data) {
		this.data = data;
	}
}
