package t6_ex;

public class NetpayVO {
	private String jikkub;             
	private int bonbong;
	private int idx;
	private String sabun;
	private String buseo;
	private String name;
	private int age;
	private String ipsail;
	private String gender;
	private String address;
	
	public String getJikkub() {
		return jikkub;
	}
	public void setJikkub(String jikkub) {
		this.jikkub = jikkub;
	}
	public int getBonbong() {
		return bonbong;
	}
	public void setBonbong(int bonbong) {
		this.bonbong = bonbong;
	}
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getSabun() {
		return sabun;
	}
	public void setSabun(String sabun) {
		this.sabun = sabun;
	}  
	public String getBuseo() {
		return buseo;
	}
	public void setBuseo(String buseo) {
		this.buseo = buseo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getIpsail() {
		return ipsail;
	}
	public void setIpsail(String ipsail) {
		this.ipsail = ipsail;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "NetpayVO [jikkub=" + jikkub + ", bonbong =" + bonbong + ", idx=" + idx + ", sabun=" + sabun + ", buseo="
				+ buseo + ", name=" + name + ", age=" + age + ", ipsail=" + ipsail + ", gender=" + gender + ", address="
				+ address + "]";
	}
}
