package cn.hfxt.util;

import java.io.Serializable;

public class ReturnResult implements Serializable {

	@Override
	public String toString() {
		return "ReturnResult [status=" + status + ", data=" + data
				+ ", message=" + message + "]";
	}

	private int status;//状�?�码
	private Object data;//数据
	private String message = "操作成功";//提示

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
//  不同情况下：
	/**
	 * 返回成功状�??
	 * 
	 * @param obj
	 */
	public ReturnResult returnSuccess(Object obj) {
		this.status = Constants.ReturnResult.SUCCESS;
		this.data = obj;
		if (obj != null) {
			this.message = obj.toString();
		}
		return this;
	}

	/**
	 * 返回默认成功状�??
	 */
	public ReturnResult returnSuccess() {
		this.status = Constants.ReturnResult.SUCCESS;
		return this;
	}

	/**
	 * 返回失败状�??
	 * 
	 * @param message
	 */
	public ReturnResult returnFail(String message) {
		this.status = Constants.ReturnResult.FAIL;
		this.message = message;
		return this;
	}

	public ReturnResult(String message, int status, Object data) {
		this.message = message;
		this.status = status;
		this.data = data;
	}

	public ReturnResult(Object data) {
		this.status = Constants.ReturnResult.SUCCESS;
		this.data = data;
	}

	public ReturnResult() {

	}
}
