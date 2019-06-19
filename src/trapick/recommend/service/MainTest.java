package trapick.recommend.service;

import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import trapick.recommend.domain.Hotel;

public class MainTest {

	public static void main(String[] args) {

//		Crawling crawling = new Crawling();
//		
//		crawling.getInstance();
//		
//		List<Item> list = crawling.Getcrawling("프랑스", "파리");
//		
//		crawling.distanceSort("파리", list);

//		List<Restaurant> list = new ArrayList<>();
//		Restaurant restaurant;
//		
//		String name = null;
//		String detail;
//		String img;
//		String latitude;
//		String longitude;
//		String city_name = "런던";
//		
//		String input = city_name + "맛집";
//		String lat;
//		String lng;
//		
//		try {
//			String url = "https://search.naver.com/search.naver?sm=tab_hty.top&where=nexearch&query=";
//			url += input;
//			
//			Document doc = Jsoup.connect(url).get();
//			
//			Elements doc_el = doc.select(".list_top ul");
//			Elements doc_hotel = doc_el.select("li");
//			
//			for(Element el : doc_hotel) {
//				
//				//name
//				name = el.select(".list_title").select("strong").text();
//				//detail
//				detail = el.select(".list_title").select(".list_cate").text();
//				//img
//				img = el.select(".list_thumb").select("img").attr("src");
//				
//				String url_location = "https://maps.googleapis.com/maps/api/geocode/xml?address=" + city_name + name + "&key=AIzaSyC3G1qQMeFpartaXg_UguoBElqDEDYu3Rg";
//				
//				Document doc_loc = Jsoup.connect(url_location).get();
//				
//				lat = doc_loc.select("location").select("lat").text();
//				lng = doc_loc.select("location").select("lng").text();
//
//				if (lat.length() < 10) {
//					String url_temp = "https://maps.googleapis.com/maps/api/geocode/xml?address=" + city_name
//							+ "&key=AIzaSyC3G1qQMeFpartaXg_UguoBElqDEDYu3Rg";
//
//					Document doc_temp = Jsoup.connect(url_temp).get();
//
//					lat = doc_temp.select("location").select("lat").text();
//				}
//
//				if (lng.length() < 10) {
//					String url_temp = "https://maps.googleapis.com/maps/api/geocode/xml?address=" + city_name
//							+ "&key=AIzaSyC3G1qQMeFpartaXg_UguoBElqDEDYu3Rg";
//
//					Document doc_temp = Jsoup.connect(url_temp).get();
//
//					lng = doc_temp.select("location").select("lng").text();
//				}
//
//				if (lat.length() > 15) {
//					lat = lat.substring(lat.lastIndexOf(" ") + 1);
//				}
//
//				if (lng.length() > 15) {
//					lng = lng.substring(lng.lastIndexOf(" ") + 1);
//				}
//
//				latitude = lat;
//				longitude = lng;
//				
//				restaurant = new Restaurant(name, detail, img, latitude, longitude);
//				
//				list.add(restaurant);
//				
//				System.out.println(restaurant);
//			}
//			
//			
//			
//			
//			
//			
//			
//			
//			
//			
//			
//			
//			
//			
//			
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		}

		List<Hotel> list = new ArrayList<>();
		Hotel hotel;

		String name;
		String detail;
		String img;
		String location;
		String review;
		String stars;
		String latitude;
		String longitude;
		String price;
		String city_name = "런던";

		String input_hotel = city_name + "호텔";
		String input_guest = city_name + "게스트하우스";
		String lat;
		String lng;

		try {
			String url = "https://search.naver.com/search.naver?sm=tab_hty.top&where=nexearch&query=";

			String url_hotel = url + input_hotel;
			String url_guest = url + input_guest;

			Document doc_hotel = Jsoup.connect(url_hotel).get();

			Elements doc_el = doc_hotel.select(".section_hotel_list ul");
			Elements doc_hotelList = doc_el.select("li");

			Document doc_guest = Jsoup.connect(url_guest).get();

			Elements doc_el_ = doc_guest.select(".section_hotel_list ul");
			Elements doc_guestList = doc_el_.select("li");

//			for (Element el : doc_hotelList) {
//
//				// name
//				name = el.select(".info").select("strong").attr("title");
//				// detail
//				detail = el.select(".info").select(".review").select(".short_review").text();
//				// img
//				img = el.select(".img").select("img").attr("src");
//				// location
//				location = el.select(".info").select(".area").text();
//				// review
//				review = el.select(".info").select(".star_wrap").select(".num").text();
//				// stars
//				stars = el.select(".info").select(".rating_wrap").select(".grade").text();
//				// price
//				price = el.select(".sub_area").select(".price").text();
//
//				// location
//				String url_location = "https://maps.googleapis.com/maps/api/geocode/xml?address=" + city_name + name
//						+ "&key=AIzaSyC3G1qQMeFpartaXg_UguoBElqDEDYu3Rg";
//
//				Document doc_loc = Jsoup.connect(url_location).get();
//
//				lat = doc_loc.select("location").select("lat").text();
//				lng = doc_loc.select("location").select("lng").text();
//
//				if (lat.length() < 10) {
//					String url_temp = "https://maps.googleapis.com/maps/api/geocode/xml?address=" + city_name
//							+ "&key=AIzaSyC3G1qQMeFpartaXg_UguoBElqDEDYu3Rg";
//
//					Document doc_temp = Jsoup.connect(url_temp).get();
//
//					lat = doc_temp.select("location").select("lat").text();
//				}
//
//				if (lng.length() < 10) {
//					String url_temp = "https://maps.googleapis.com/maps/api/geocode/xml?address=" + city_name
//							+ "&key=AIzaSyC3G1qQMeFpartaXg_UguoBElqDEDYu3Rg";
//
//					Document doc_temp = Jsoup.connect(url_temp).get();
//
//					lng = doc_temp.select("location").select("lng").text();
//				}
//
//				if (lat.length() > 15) {
//					lat = lat.substring(lat.lastIndexOf(" ") + 1);
//				}
//
//				if (lng.length() > 15) {
//					lng = lng.substring(lng.lastIndexOf(" ") + 1);
//				}
//
//				latitude = lat;
//				longitude = lng;
//
//				hotel = new Hotel(name, detail, img, location, review, latitude, longitude, stars, price);
//
//				if (name.length() > 2) {
//					list.add(hotel);
//				}
//				
//				System.out.println(hotel);
//
//			}

			for (Element el : doc_guestList) {

				// name
				name = el.select(".info").select("strong").attr("title");
				System.out.println(name);
				// detail
				detail = el.select(".info").select(".review").select(".short_review").text();
				// img
				img = el.select(".img").select("img").attr("src");
				// location
				location = el.select(".info").select(".area").text();
				// review
				review = el.select(".info").select(".star_wrap").select(".num").text();
				// stars
				stars = el.select(".info").select(".rating_wrap").select(".grade").text();
				// price
				price = el.select(".sub_area").select(".price").text();

				// location
				String url_location = "https://maps.googleapis.com/maps/api/geocode/xml?address=" + city_name + name
						+ "&key=AIzaSyC3G1qQMeFpartaXg_UguoBElqDEDYu3Rg";

				Document doc_loc = Jsoup.connect(url_location).get();

				lat = doc_loc.select("location").select("lat").text();
				lng = doc_loc.select("location").select("lng").text();

				if (lat.length() < 10) {
					String url_temp = "https://maps.googleapis.com/maps/api/geocode/xml?address=" + city_name
							+ "&key=AIzaSyC3G1qQMeFpartaXg_UguoBElqDEDYu3Rg";

					Document doc_temp = Jsoup.connect(url_temp).get();

					lat = doc_temp.select("location").select("lat").text();
				}

				if (lng.length() < 10) {
					String url_temp = "https://maps.googleapis.com/maps/api/geocode/xml?address=" + city_name
							+ "&key=AIzaSyC3G1qQMeFpartaXg_UguoBElqDEDYu3Rg";

					Document doc_temp = Jsoup.connect(url_temp).get();

					lng = doc_temp.select("location").select("lng").text();
				}

				if (lat.length() > 15) {
					lat = lat.substring(lat.lastIndexOf(" ") + 1);
				}

				if (lng.length() > 15) {
					lng = lng.substring(lng.lastIndexOf(" ") + 1);
				}

				latitude = lat;
				longitude = lng;

				hotel = new Hotel(name, detail, img, location, review, latitude, longitude, stars, price);

				if (name.length() > 2) {
					list.add(hotel);
				}
				
				System.out.println(hotel);

			}
			
			System.out.println(list);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
