package cn.hfxt.entity;

/**
 * 	用户表
 * @author Sun
 *
 */

public class User {
	
	private int id;
	public String userCode;//用户编码
	public String userName;//用户名
	public String dName;//部门
	public String passwd;//密码
	public String tName;//职称
	public int roleName;//权限类型名称
	public String phone;//手机号
	public String address;//住址
	public int userRole;//用户类型
	
	
	
	@Override
	public String toString() {
		return "User [id=" + id + ", userCode=" + userCode + ", userName=" + userName + ", dName=" + dName + ", passwd="
				+ passwd + ", tName=" + tName + ", roleName=" + roleName + ", phone=" + phone + ", address=" + address
				+ ", userRole=" + userRole + ", getId()=" + getId() + ", getUserRole()=" + getUserRole()
				+ ", getUserCode()=" + getUserCode() + ", getUserName()=" + getUserName() + ", getPasswd()="
				+ getPasswd() + ", getdName()=" + getdName() + ", gettName()=" + gettName() + ", getRoleName()="
				+ getRoleName() + ", getPhone()=" + getPhone() + ", getAddress()=" + getAddress() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserRole() {
		return userRole;
	}
	public void setUserRole(int userRole) {
		this.userRole = userRole;
	}
	public String getUserCode() {
		return userCode;
	}
	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public String getdName() {
		return dName;
	}
	public void setdName(String dName) {
		this.dName = dName;
	}
	public String gettName() {
		return tName;
	}
	public void settName(String tName) {
		this.tName = tName;
	}
	public int getRoleName() {
		return roleName;
	}
	public void setRoleName(int roleName) {
		this.roleName = roleName;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
}
