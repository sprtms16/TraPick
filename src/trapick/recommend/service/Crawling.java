package trapick.recommend.service;

import java.io.IOException;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import trapick.recommend.domain.Item;

public class Crawling {

	public static void main(String[] args) {

		List<Item> list = null;

		int item_idx = 0;
		String name = null;
		double latitude = 33.22;
		double longitude = 33.22;
		String detail;
		String city_name = "홍콩";
		int time_defference = 1;
		String country_name = "홍콩";
		int price;
		String img;

		String input = "런던+입장권";

		try {
			String url = "https://search.naver.com/search.naver?sm=top_hty&fbm=1&ie=utf8&query=";
			url += input;
			Document doc = Jsoup.connect(url).get();

			Elements hotdeal = doc.select("._page_group ul");
			Elements deal = hotdeal.select("li");

			for (Element el : deal) {

				// idx
				item_idx += 1;
				// name
				name = el.select(".detail_area").select(".tit").select("a").attr("title");
				// detail > 여행사로 함
				detail = el.select(".detail_area").select(".mall_area").select("a").text();
				// price
				String temp = el.select(".detail_area").select(".price_num").text().replace(",", "");
				temp = temp.replace("원", "");
				price = Integer.parseInt(temp);
				// img
				img = el.select(".thumb_area").select("img").attr("src");

				System.out.println("상품 : " + "\t" + name);
				System.out.println("상세정보 : " + "\t" + detail);
				System.out.println("가격 : " + "\t" + price);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}