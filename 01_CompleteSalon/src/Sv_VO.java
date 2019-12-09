
public class Sv_VO {
	
	private String sv_name;
	private int sv_price;
	private int sv_time;
	
	public Sv_VO(String sv_name, int sv_price, int sv_time) {
		this.sv_name = sv_name;
		this.sv_price = sv_price;
		this.sv_time = sv_time;
	}
	
	public String getSv_name() {
		return sv_name;
	}
	public int getSv_price() {
		return sv_price;
	}
	public int getSv_time() {
		return sv_time;
	}
	
	

}
