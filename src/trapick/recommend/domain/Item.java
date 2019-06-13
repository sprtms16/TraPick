package trapick.recommend.domain;

public class Item {
	int land_idx;
	String name;
	double latitude;
	double longitude;
	String detail;
	String city_name;
	int time_defference;
	String country_name;
	int price;

	public Item() {
		
	}

	public Item(int land_idx, String name, double latitude, double longitude, String detail, String city_name,
			int time_defference, String country_name, int price) {
		super();
		this.land_idx = land_idx;
		this.name = name;
		this.latitude = latitude;
		this.longitude = longitude;
		this.detail = detail;
		this.city_name = city_name;
		this.time_defference = time_defference;
		this.country_name = country_name;
		this.price = price;
	}

	public int getLand_idx() {
		return land_idx;
	}

	public void setLand_idx(int land_idx) {
		this.land_idx = land_idx;
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

	@Override
	public String toString() {
		return "Item [land_idx=" + land_idx + ", name=" + name + ", latitude=" + latitude + ", longitude=" + longitude
				+ ", detail=" + detail + ", city_name=" + city_name + ", time_defference=" + time_defference
				+ ", country_name=" + country_name + ", price=" + price + "]";
	}

}
