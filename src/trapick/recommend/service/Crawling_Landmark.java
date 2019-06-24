package trapick.recommend.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import trapick.recommend.domain.LandMark;

public class Crawling_Landmark {
// 명소 크롤링 ==> DB 넣기

	private static Crawling_Landmark crawling = new Crawling_Landmark();

	public static Crawling_Landmark getInstance() {
		return crawling;
	}

	public List<LandMark> getLandmarkCrawling(String country_name, String city_name){
		
		List<LandMark> landscape_list = new ArrayList<LandMark>();
		LandMark landmark;
		
		int land_idx = 0;
		String name = "";
		String image = "";
		String latitude = "0";
		String longitude = "0";
		String detail;	// 명소 카테고리 (ex: 건축물, 박물관, 유적지, 성당 등)
		int time_defference = 0; // 받아야됨
		int city_idx = 0;
		
		String input = country_name + "+" + city_name + "+명소";
		String lat = null;
		String lng = null;
		
		try {
			String url = "https://search.naver.com/search.naver?sm=top_hty&fbm=1&ie=utf8&query=";
			url += input;
			Document doc = Jsoup.connect(url).get();
			Elements hotdeal = doc.select(".list_top ul");
			Elements deal = hotdeal.select("li");
			
			for(Element el : deal) {
				
				land_idx += 1;
				name = el.select(".list_title").select("strong").text();
				image = el.select(".list_thumb").select("img").attr("src");
				detail = el.select(".list_title").select(".list_cate").text();
				
				// latitude, longitude
				String url_rocation = "https://maps.googleapis.com/maps/api/geocode/xml?address=" + name
						+ "&key=AIzaSyC3G1qQMeFpartaXg_UguoBElqDEDYu3Rg";

				Document doc_rocation = Jsoup.connect(url_rocation).get();

				lat = doc_rocation.select("location").select("lat").text();
				lng = doc_rocation.select("location").select("lng").text();

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

				landmark = new LandMark(land_idx, name, latitude, longitude, detail, city_name, time_defference, country_name, image);
				landscape_list.add(landmark);
				
				
				System.out.println("idx\t" + land_idx);
				System.out.println("name\t" + name);
				System.out.println("img\t" + image);
				System.out.println("lat\t" + latitude);
				System.out.println("long\t" + longitude);
				System.out.println("detail\t" + detail);
	         }
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		return landscape_list;
		
	}
}
