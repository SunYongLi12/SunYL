package cn.hfxt.entity;

/*
	²Ëµ¥
*/
public class Menu {
	private int id;
	private String mname;
	private int parentid;
	private int type;
	private int isdelete;
	private String mfunction;
	private String mbtn;
	private String url;
	
	public Menu() {
		
	}
	
	public Menu(int id, String mname, int parentid, int type, int isdelete, String mfunction, String mbtn, String url) {
		super();
		this.id = id;
		this.mname = mname;
		this.parentid = parentid;
		this.type = type;
		this.isdelete = isdelete;
		this.mfunction = mfunction;
		this.mbtn = mbtn;
		this.url = url;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}


	
	public Menu(String mname, int parentid, int type, String mbtn, int isdelete) {
		super();
		this.mname = mname;
		this.parentid = parentid;
		this.type = type;
		this.isdelete = isdelete;
		this.mbtn = mbtn;
	}
	
	
	public Menu(int id, String mname, int parentid, int type, int isdelete, String mfunction, String mbtn) {
		super();
		this.id = id;
		this.mname = mname;
		this.parentid = parentid;
		this.type = type;
		this.isdelete = isdelete;
		this.mfunction = mfunction;
		this.mbtn = mbtn;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	public int getParentid() {
		return parentid;
	}
	public void setParentid(int parentid) {
		this.parentid = parentid;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public int getIsdelete() {
		return isdelete;
	}
	public void setIsdelete(int isdelete) {
		this.isdelete = isdelete;
	}
	public String getMfunction() {
		return mfunction;
	}
	public void setMfunction(String mfunction) {
		this.mfunction = mfunction;
	}
	public String getMbtn() {
		return mbtn;
	}
	public void setMbtn(String mbtn) {
		this.mbtn = mbtn;
	}
	
	
}
