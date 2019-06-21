package trapick.recommend.domain;

public class Item {
   
   int item_idx;
   String name;
   String latitude;
   String longitude;
   String detail;
   String city_name;
   int time_defference;
   String country_name;
   int price;
   String img;
   int sales;
   int hits;
   double dist;
   
   public Item() {
      
   }

public Item(int item_idx, String name, String latitude, String longitude, String detail, String city_name,
		int time_defference, String country_name, int price, String img, int sales, int hits, double dist) {
	super();
	this.item_idx = item_idx;
	this.name = name;
	this.latitude = latitude;
	this.longitude = longitude;
	this.detail = detail;
	this.city_name = city_name;
	this.time_defference = time_defference;
	this.country_name = country_name;
	this.price = price;
	this.img = img;
	this.sales = sales;
	this.hits = hits;
	this.dist = dist;
}

public int getItem_idx() {
	return item_idx;
}

public void setItem_idx(int item_idx) {
	this.item_idx = item_idx;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
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

public String getImg() {
	return img;
}

public void setImg(String img) {
	this.img = img;
}

public int getSales() {
	return sales;
}

public void setSales(int sales) {
	this.sales = sales;
}

public int getHits() {
	return hits;
}

public void setHits(int hits) {
	this.hits = hits;
}

public double getDist() {
	return dist;
}

public void setDist(double dist) {
	this.dist = dist;
}

@Override
public String toString() {
	return "Item [item_idx=" + item_idx + ", name=" + name + ", latitude=" + latitude + ", longitude=" + longitude
			+ ", detail=" + detail + ", city_name=" + city_name + ", time_defference=" + time_defference
			+ ", country_name=" + country_name + ", price=" + price + ", img=" + img + ", sales=" + sales + ", hits="
			+ hits + ", dist=" + dist + "]";
}
 
   
}