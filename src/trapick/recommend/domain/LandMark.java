package trapick.recommend.domain;

import java.io.Serializable;

public class LandMark implements Serializable{
   /**
    * 
    */
   private static final long serialVersionUID = 1L;
   
   int land_idx;
   String name;
   String latitude;
   String longitude;
   String detail;
   String city_name;
   int time_defference;
   String country_name;
   String image;

   public LandMark() {

   }

   public LandMark(int land_idx, String name, String latitude, String longitude, String detail, String city_name,
         int time_defference, String country_name, String image) {
      super();
      this.land_idx = land_idx;
      this.name = name;
      this.latitude = latitude;
      this.longitude = longitude;
      this.detail = detail;
      this.city_name = city_name;
      this.time_defference = time_defference;
      this.country_name = country_name;
      this.image = image;
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

   public String getImage() {
      return image;
   }

   public void setImage(String image) {
      this.image = image;
   }

   @Override
   public String toString() {
      return "LandMark [land_idx=" + land_idx + ", name=" + name + ", latitude=" + latitude + ", longitude="
            + longitude + ", detail=" + detail + ", city_name=" + city_name + ", time_defference=" + time_defference
            + ", country_name=" + country_name + ", image=" + image + "]";
   }

   

}