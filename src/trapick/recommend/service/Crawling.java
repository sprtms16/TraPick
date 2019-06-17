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
		String city_name = "ȫ��";
		int time_defference = 1;
		String country_name = "ȫ��";
		int price;
		String img;

		String input = "����+�����";

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
				// detail > ������ ��
				detail = el.select(".detail_area").select(".mall_area").select("a").text();
				// price
				String temp = el.select(".detail_area").select(".price_num").text().replace(",", "");
				temp = temp.replace("��", "");
				price = Integer.parseInt(temp);
				// img
				img = el.select(".thumb_area").select("img").attr("src");

				System.out.println("��ǰ : " + "\t" + name);
				System.out.println("������ : " + "\t" + detail);
				System.out.println("���� : " + "\t" + price);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}