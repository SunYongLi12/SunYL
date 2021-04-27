package cn.hfxt.entity;

public class QX {
	private int id;
	private String qname;
	private String btn;
	private int fid;
	private int type;
	private String url;
	private String js;
	
	public QX() {}
	
	public QX(int id, String qname, String btn, int fid, int type, String url, String js) {
		super();
		this.id = id;
		this.qname = qname;
		this.btn = btn;
		this.fid = fid;
		this.type = type;
		this.url = url;
		this.js = js;
	}
	public String getJs() {
		return js;
	}
	public void setJs(String js) {
		this.js = js;
	}
	public int getFid() {
		return fid;
	}
	public void setFid(int fid) {
		this.fid = fid;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getQname() {
		return qname;
	}
	public void setQname(String qname) {
		this.qname = qname;
	}
	public String getBtn() {
		return btn;
	}
	public void setBtn(String btn) {
		this.btn = btn;
	}
	
	
}
