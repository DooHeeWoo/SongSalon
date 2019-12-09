

public class VO_RESERVATION {
	
	private String rsv_num; // 예약번호
	private String rsv_date; // 예약날짜
	private String rsv_gen; // 성별
	private int rsv_cost; // 예상 결제 금액
	private String rsv_cst_id; // 고객 ID
	private String rsv_sv_name; // 시술 이름
	private String rsv_sch_code; // 스케줄 코드
	
	public VO_RESERVATION(String rsv_num, String rsv_date, String rsv_gen, int rsv_cost, String rsv_cst_id,
			String rsv_sv_name, String rsv_sch_code) {
		this.rsv_num = rsv_num;
		this.rsv_date = rsv_date;
		this.rsv_gen = rsv_gen;
		this.rsv_cost = rsv_cost;
		this.rsv_cst_id = rsv_cst_id;
		this.rsv_sv_name = rsv_sv_name;
		this.rsv_sch_code = rsv_sch_code;
	}

	public VO_RESERVATION(String rsv_date, String rsv_gen, int totMoney, String rsv_cst_id, String rsv_sv_name,
			String rsv_sch_code) {
		this.rsv_date = rsv_date;
		this.rsv_gen = rsv_gen;
		this.rsv_cost = totMoney;
		this.rsv_cst_id = rsv_cst_id;
		this.rsv_sv_name = rsv_sv_name;
		this.rsv_sch_code = rsv_sch_code;
	}

	public String getRsv_num() {
		return rsv_num;
	}

	public String getRsv_date() {
		return rsv_date;
	}

	public String getRsv_gen() {
		return rsv_gen;
	}

	public int getRsv_cost() {
		return rsv_cost;
	}

	public String getRsv_cst_id() {
		return rsv_cst_id;
	}

	public String getRsv_sv_name() {
		return rsv_sv_name;
	}

	public String getRsv_sch_code() {
		return rsv_sch_code;
	}
}
