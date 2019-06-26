package trapick.recommend.domain;

public class Hotel {

   private String name;
   private String detail;
   private String img;
   private String location;
   private String review;
   private String latitude;
   private String longitude;
   private String stars;
   private String price;
   private double dist;
   
   public Hotel() {}

   public Hotel(String name, String detail, String img, String location, String review, String latitude,
         String longitude, String stars, String price, double dist) {
      super();
      this.name = name;
      this.detail = detail;
      this.img = img;
      this.location = location;
      this.review = review;
      this.latitude = latitude;
      this.longitude = longitude;
      this.stars = stars;
      this.price = price;
      this.dist = dist;
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

   public String getLocation() {
      return location;
   }

   public void setLocation(String location) {
      this.location = location;
   }

   public String getReview() {
      return review;
   }

   public void setReview(String review) {
      this.review = review;
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

   public String getStars() {
      return stars;
   }

   public void setStars(String stars) {
      this.stars = stars;
   }

   public String getPrice() {
      return price;
   }

   public void setPrice(String price) {
      this.price = price;
   }

   public double getDist() {
      return dist;
   }

   public void setDist(double dist) {
      this.dist = dist;
   }

   @Override
   public String toString() {
      return "Hotel [name=" + name + ", detail=" + detail + ", img=" + img + ", location=" + location + ", review="
            + review + ", latitude=" + latitude + ", longitude=" + longitude + ", stars=" + stars + ", price="
            + price + ", dist=" + dist + "]";
   }      
}