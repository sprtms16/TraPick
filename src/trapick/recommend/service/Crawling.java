package trapick.recommend.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.lang.model.element.Element;
import javax.swing.text.Document;


import trapick.recommend.domain.Item;

public class Crawling {

	public static void main(String[] args) {
		
		List<Item> list = new ArrayList<>();
		Item item;
		
		int item_idx = 0;
		String name = null;
		String latitude = "0";
		String longitude = "0";
		String detail;
		String city_name = "È«Äá";
		int time_defference = 1;
		String country_name = "È«Äá";
		int price;
		String img;
		
		String input = "È«Äá+ÀÔÀå±Ç";  

		 try {
			 String url = "https://search.naver.com/search.naver?sm=top_hty&fbm=1&ie=utf8&query=";
		     url += input;
	         Document doc = Jsoup.connect(url).get();
	      
	         Elements hotdeal = doc.select("._page_group ul");
	         Elements deal = hotdeal.select("li");
	         
	         for(Element el : deal) {
	        	 
	        	 //idx
	        	 item_idx += 1;
	        	 //name
	        	 name = el.select(".detail_area").select(".tit").select("a").attr("title");
	        	 //detail > ¿©Çà»ç·Î ÇÔ
	        	 detail = el.select(".detail_area").select(".mall_area").select("a").text();
	        	 //price
	        	 String temp = el.select(".detail_area").select(".price_num").text().replace(",","");
	        	 temp = temp.replace("¿ø","");
	        	 price = Integer.parseInt(temp);
	        	 //img
	        	 img = el.select(".thumb_area").select("img").attr("src");
	        	 //latitude, longitude
	        	 String url_rocation = "https://maps.googleapis.com/maps/api/geocode/xml?address="+name+"&key=AIzaSyC3G1qQMeFpartaXg_UguoBElqDEDYu3Rg";
	        	 
	        	 Document doc2 = Jsoup.connect(url_rocation).get();
	        	 
	        	 String lat = null;
	        	 String lng = null;
	        	 
	        	 lat = doc2.select("location").select("lat").text();
	        	 
	        	 if(lat.length() < 5) {
	        		 String url_rocation_temp = "https://maps.googleapis.com/maps/api/geocode/xml?address="+city_name+"&key=AIzaSyC3G1qQMeFpartaXg_UguoBElqDEDYu3Rg";
		        	 
		        	 Document doc2_temp = Jsoup.connect(url_rocation_temp).get();
		        	 
		        	 lat = doc2_temp.select("location").select("lat").text();
	        	 }
	        	
	        	 lng = doc2.select("location").select("lng").text();
	        	 
	        	 if(lng.length() < 5) {
	        		 String url_rocation_temp = "https://maps.googleapis.com/maps/api/geocode/xml?address="+city_name+"&key=AIzaSyC3G1qQMeFpartaXg_UguoBElqDEDYu3Rg";
		        	 
		        	 Document doc2_temp = Jsoup.connect(url_rocation_temp).get();
		        	 
		        	 lat = doc2_temp.select("location").select("lng").text();
	        	 }
	        	 
	        	 if(lat.length() > 20) {
	        		 latitude = lat.substring(lat.lastIndexOf(" ")+1);
	        	 }else {
	        		 latitude = lat;
	        	 }
	        	 if(longitude.length()>20) {
	        		 longitude = lng.substring(lng.lastIndexOf(" ")+1);
	        	 }else {
	        		 longitude = lng;
	        	 }
	        	 
	        	 latitude = lat;
	        	 longitude = lng;
	        	 
	        	 item = new Item(item_idx, name, latitude, longitude, detail, city_name, time_defference, country_name, price, img);
	        	 
	        	 
	        	 System.out.println(latitude);
	        	 System.out.println(longitude);
	        	 System.out.println(item);
	        	 
	        	 list.add(item);	        	 
	         }	         
	      } catch (IOException e) {
	         e.printStackTrace();
	      }
	}
}