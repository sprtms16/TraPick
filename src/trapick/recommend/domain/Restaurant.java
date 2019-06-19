package trapick.recommend.domain;

public class Restaurant {

	private String name;
	private String detail;
	private String img;
	private String latitude;
	private String longitude;
	
	public Restaurant() {
		
	}

	public Restaurant(String name, String detail, String img, String latitude, String longitude) {
		super();
		this.name = name;
		this.detail = detail;
		this.img = img;
		this.latitude = latitude;
		this.longitude = longitude;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	@Override
	public String toString() {
		return "Restaurant [name=" + name + ", detail=" + detail + ", img=" + img + ", latitude=" + latitude
				+ ", longitude=" + longitude + "]";
	}
	
}
