package cn.hfxt.entity;

public class YG {
	private int id;
	private String name;
	private int sex;
	private int jsid;//角色id
	private int bmid;//部门id
	private int zcid;//职称id
	private String js;//角色
	private String bm;//部
	private String zc;//职称
	private String pwd;
	
	public YG() {}
	public YG(int id, String name, int sex, int jsid, int bmid, int zcid, String js, String bm, String zc) {
		super();
		this.id = id;
		this.name = name;
		this.sex = sex;
		this.jsid = jsid;
		this.bmid = bmid;
		this.zcid = zcid;
		this.js = js;
		this.bm = bm;
		this.zc = zc;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public int getBmid() {
		return bmid;
	}
	public void setBmid(int bmid) {
		this.bmid = bmid;
	}
	public int getZcid() {
		return zcid;
	}
	public void setZcid(int zcid) {
		this.zcid = zcid;
	}
	public String getJs() {
		return js;
	}
	public void setJs(String js) {
		this.js = js;
	}
	public String getBm() {
		return bm;
	}
	public void setBm(String bm) {
		this.bm = bm;
	}
	public String getZc() {
		return zc;
	}
	public void setZc(String zc) {
		this.zc = zc;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	public int getJsid() {
		return jsid;
	}
	public void setJsid(int jsid) {
		this.jsid = jsid;
	}
	
	
}
