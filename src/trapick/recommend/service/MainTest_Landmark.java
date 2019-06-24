package trapick.recommend.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import trapick.recommend.domain.Restaurant;

public class MainTest_Landmark {

	public static void main(String[] args) {

			List<Restaurant> list = new ArrayList<>();
			List<Restaurant> list_restaurant = new ArrayList<>();
			List<Restaurant> list_rest = new ArrayList<>();
			Restaurant restaurant;

			String name = null;
			String detail;
			String img;
			String latitude;
			String longitude;
			String city_name = "파리";
			String base_Point = "개선문";

			String input = city_name + "맛집";
			String lat;
			String lng;
			double dist = 0;

			try {
				String url = "https://search.naver.com/search.naver?sm=tab_hty.top&where=nexearch&query=";
				url += input;

				Document doc = Jsoup.connect(url).get();

				Elements doc_el = doc.select(".list_top ul");
				Elements doc_rest = doc_el.select("li");

				for (Element el : doc_rest) {

					// name
					name = el.select(".list_title").select("strong").text();
					// detail
					detail = el.select(".list_title").select(".list_cate").text();
					// img
					img = el.select(".list_thumb").select("img").attr("src");

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

					restaurant = new Restaurant(name, detail, img, latitude, longitude,dist);

					list.add(restaurant);
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
			
			try {
				String url = "https://maps.googleapis.com/maps/api/geocode/xml?address=" + base_Point
						+ "&key=AIzaSyC3G1qQMeFpartaXg_UguoBElqDEDYu3Rg";
				
				Document doc;
				
				doc = Jsoup.connect(url).get();
				
				String latitude_1 = doc.select("location").select("lat").text();
				String longitude_1 = doc.select("location").select("lng").text();
				
				double lat_1 = Double.valueOf(latitude_1);
				double lon_1 = Double.valueOf(longitude_1);
				
				for (int i = 0; i < list.size(); i++) {

					double lat_2 = Double.valueOf(list.get(i).getLatitude());
					double lon_2 = Double.valueOf(list.get(i).getLongitude());

					double theta = lon_1 - lon_2;

					dist = Math.sin(deg2rad(lat_1)) * Math.sin(deg2rad(lat_2))
							+ Math.cos(deg2rad(lat_1)) * Math.cos(deg2rad(lat_2)) * Math.cos(deg2rad(theta));

					dist = Math.acos(dist);

					dist = rad2deg(dist);

					dist = dist * 60 * 1.1515;

					dist = dist * 1.609344; // kilometer

					dist = Math.round((dist) * 10) / 10.0;

					if (dist == 0) {
						dist = 0.4;
					}
										
					String name_list = list.get(i).getName();
					String detail_list = list.get(i).getDetail();
					String img_list = list.get(i).getImg();
					String latitude_list = list.get(i).getLatitude();
					String longitude_list = list.get(i).getLongitude();
									
					Restaurant restaurant2 = new Restaurant(name_list, detail_list, img_list, latitude_list, longitude_list, dist);
					
					list_rest.add(restaurant2);
			
				}
						
				int min = 0;
				
				for(int i=0; i<list_rest.size();i++) {
					for(int j=i; j<list_rest.size();j++) {
						if(list_rest.get(i).getDist() > list_rest.get(j).getDist()) {
							min = j;
						}else {
							min = i;
						}
					}
					
					String name_rest = list_rest.get(min).getName();
					String detail_rest = list_rest.get(min).getDetail();
					String img_rest = list_rest.get(min).getImg();
					String latitude_rest = list_rest.get(min).getLatitude();
					String longitude_rest = list_rest.get(min).getLongitude();
					double dist_rest = list_rest.get(min).getDist();
					
					Restaurant restaurant2 = new Restaurant(name_rest, detail_rest, img_rest, latitude_rest, longitude_rest, dist_rest);
					
					list_restaurant.add(restaurant2);
				}

	
	
				
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println("기존");
			System.out.println(list_rest);
			System.out.println("변경");
			System.out.println(list_restaurant);
	}
	
	private static double deg2rad(double deg) {
		return (deg * Math.PI / 180.0);
	}

	private static double rad2deg(double rad) {
		return (rad * 180 / Math.PI);
	}

}
