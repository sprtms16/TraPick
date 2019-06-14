package trapick.recommend.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import trapick.recommend.domain.Item;

public class Crawling {

	public static void main(String[] args) {
		
		List<Item> list = new ArrayList<>();
		Item item;
		
		int item_idx = 0;
		String name = null;
		double latitude = 33.2332;
		double longitude = 33.22;
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
	       
	        	 item = new Item(item_idx, name, latitude, longitude, detail, city_name, time_defference, country_name, price, img);
	        	 
	        	 System.out.println(item_idx);
	        	 System.out.println(latitude);
	        	 System.out.println(longitude);
	        	 System.out.println(detail);
	        	 System.out.println(city_name);
	        	 System.out.println(time_defference);
	        	 System.out.println(country_name);
	        	 System.out.println(price);
	        	 System.out.println(img);

	        	 System.out.println(item);
	        	 
	        	 list.add(item);
//	        	 
	         }
	         
	      } catch (IOException e) {
	         e.printStackTrace();
	      }
	}
}