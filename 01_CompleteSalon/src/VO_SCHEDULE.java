

public class VO_SCHEDULE {
	
	private String sch_code; // 스케줄코드
	private String sch_id; // 디자이너ID
	private String sch_time; // 시간대
	private String sch_date; // 날짜

	public VO_SCHEDULE(String sch_code, String sch_id, String sch_time, String sch_date) {
		this.sch_code = sch_code;
		this.sch_id = sch_id;
		this.sch_time = sch_time;
		this.sch_date = sch_date;
	}

	public VO_SCHEDULE(String sch_id, Object sch_time, String sch_date) {
		this.sch_id = sch_id;
		this.sch_time = (String) sch_time;
		this.sch_date = sch_date;
		
	}

	public String getSch_code() {
		return sch_code;
	}

	public String getSch_id() {
		return sch_id;
	}

	public String getSch_time() {
		return sch_time;
	}

	public String getSch_date() {
		return sch_date;
	}

}
