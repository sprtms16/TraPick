package trapick.schedule.domain;

public class SelectedItem {
	int land_idx;
	int schd_idx;
	String name;
	double latitude;
	double longitude;
	String detail;
	String city_name;
	int time_defference;
	String country_name;
	int price;
	String start_time;
	String endItme;
	int rating;
	String memo;

	public SelectedItem() {
		// TODO Auto-generated constructor stub
	}

	public SelectedItem(int land_idx, int schd_idx, String name, double latitude, double longitude, String detail,
			String city_name, int time_defference, String country_name, int price, String start_time, String endItme,
			int rating, String memo) {
		super();
		this.land_idx = land_idx;
		this.schd_idx = schd_idx;
		this.name = name;
		this.latitude = latitude;
		this.longitude = longitude;
		this.detail = detail;
		this.city_name = city_name;
		this.time_defference = time_defference;
		this.country_name = country_name;
		this.price = price;
		this.start_time = start_time;
		this.endItme = endItme;
		this.rating = rating;
		this.memo = memo;
	}

	public int getLand_idx() {
		return land_idx;
	}

	public void setLand_idx(int land_idx) {
		this.land_idx = land_idx;
	}

	public int getSchd_idx() {
		return schd_idx;
	}

	public void setSchd_idx(int schd_idx) {
		this.schd_idx = schd_idx;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public String getCity_name() {
		return city_name;
	}

	public void setCity_name(String city_name) {
		this.city_name = city_name;
	}

	public int getTime_defference() {
		return time_defference;
	}

	public void setTime_defference(int time_defference) {
		this.time_defference = time_defference;
	}

	public String getCountry_name() {
		return country_name;
	}

	public void setCountry_name(String country_name) {
		this.country_name = country_name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getStart_time() {
		return start_time;
	}

	public void setStart_time(String start_time) {
		this.start_time = start_time;
	}

	public String getEndItme() {
		return endItme;
	}

	public void setEndItme(String endItme) {
		this.endItme = endItme;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	@Override
	public String toString() {
		return "SelectedLandItem [land_idx=" + land_idx + ", schd_idx=" + schd_idx + ", name=" + name + ", latitude="
				+ latitude + ", longitude=" + longitude + ", detail=" + detail + ", city_name=" + city_name
				+ ", time_defference=" + time_defference + ", country_name=" + country_name + ", price=" + price
				+ ", start_time=" + start_time + ", endItme=" + endItme + ", rating=" + rating + ", memo=" + memo + "]";
	}

}
