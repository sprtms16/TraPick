package trapick.recommend.model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import trapick.recommend.domain.Item;

public class Crawling {

	private static Crawling crawling = new Crawling();

	public static Crawling getInstance() {
		return crawling;
	}

	public List<Item> Getcrawling(String country_name, String city_name) {

		List<Item> list = new ArrayList<>();
		Item item;

		int item_idx = 0;
		String name = null;
		String latitude = "0";
		String longitude = "0";
		String detail;
		int time_defference = 0; // 받아야됨
		int price;
		String img;
		int sales = 0; // 판매량
		int hits = 0; // 인기

		String input = city_name + "+입장권";
		String lat = null;
		String lng = null;

		try {
			String url_naver = "https://search.naver.com/search.naver?sm=top_hty&fbm=1&ie=utf8&query=";
			String url_daum = "https://search.daum.net/search?w=tot&DA=YZR&t__nil_searchbox=btn&sug=&sugo=&q=";
			url_naver += input;
			url_daum += input;
			Document doc_naver = Jsoup.connect(url_naver).get();
			Document doc_daum = Jsoup.connect(url_daum).get();

			Elements hotdeal_naver = doc_naver.select("._page_group ul");
			Elements deal_naver = hotdeal_naver.select("li");

			Elements hotdeal_daum = doc_daum.select(".cont_shop ul");
			Elements deal_daum = hotdeal_daum.select("li");

			// naver
			for (Element el : deal_naver) {

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
				// sales
				String sales_temp = el.select(".detail").select(".txt_review").select("em").text();

				if (sales_temp.length() < 1) {
					sales = 0;
				} else {
					sales = Integer.parseInt(sales_temp);

				}

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

				item = new Item(item_idx, name, latitude, longitude, detail, city_name, time_defference, country_name,
						price, img, sales, hits);
				list.add(item);

			}
			// daum
			for (Element da : deal_daum) {

				// idx
				item_idx += 1;
				// name
				name = da.select(".wrap_cont").select(".wrap_tit").select("strong").text();
				// detail > 여행사로 함
				detail = da.select(".wrap_cont").select(".dl_comm").select(".cont").text().replaceAll("[0-9]", "");
				// price
				String temp = da.select(".wrap_cont").select(".txt_price").text().replace(",", "");
				temp = temp.replace("원", "");
				price = Integer.parseInt(temp);
				// img
				img = da.select(".wrap_thumb").select("img").attr("src");
				// sales
				String sales_temp = da.select(".wrap_cont").select(".dl_comm").select(".cont").text()
						.replaceAll("[^0-9]", "");
				if (sales_temp.length() < 1) {
					sales = 0;
				} else {
					sales = Integer.parseInt(sales_temp);
				}

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

				item = new Item(item_idx, name, latitude, longitude, detail, city_name, time_defference, country_name,
						price, img, sales, hits);

				list.add(item);
				
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return list;

	}

//   가격순 정렬
	public List<Item> priceSort(List<Item> list) {
		Collections.sort(list, new Comparator<Item>() {
			@Override
			public int compare(Item o1, Item o2) {
				if (o1.getPrice() < o2.getPrice()) {
					return -1;
				} else if (o1.getPrice() > o2.getPrice()) {
					return 1;
				}
				return 0;
			}
		});
//      for (Item item : list) {
//         System.out.println(item);
//      }
		return list;
	}

//   판매량순 정렬
	public List<Item> salesSort(List<Item> list) {
		Collections.sort(list, new Comparator<Item>() {
			@Override
			public int compare(Item o1, Item o2) {
				if (o1.getSales() > o2.getSales()) {
					return -1;
				} else if (o1.getSales() < o2.getSales()) {
					return 1;
				}
				return 0;
			}
		});
//      for (Item item : list) {
//         System.out.println(item);
//      }
		return list;
	}

//    인기순 정렬
	public List<Item> hitsSort(List<Item> list) {
		Collections.sort(list, new Comparator<Item>() {
			@Override
			public int compare(Item o1, Item o2) {
				if (o1.getHits() > o2.getHits()) {
					return -1;
				} else if (o1.getHits() < o2.getHits()) {
					return 1;
				}
				return 0;
			}
		});
//      for (Item item : list) {
//         System.out.println(item);
//      }
		return list;
	}

	// 거리 순 정렬
	public List<Item> distanceSort(String city_name, List<Item> list) {

		List<Item> sortList = new ArrayList<>();
		List<Integer> indexList = new ArrayList<>();
		List<Double> distList = new ArrayList<>();

		try {

			String url = "https://maps.googleapis.com/maps/api/geocode/xml?address=" + city_name
					+ "&key=AIzaSyC3G1qQMeFpartaXg_UguoBElqDEDYu3Rg";
			Document doc;

			double arr_value[] = new double[15];
			int arr_key[] = new int[15];

			doc = Jsoup.connect(url).get();

			String latitude = doc.select("location").select("lat").text();
			String longitude = doc.select("location").select("lng").text();

			double lat1 = Double.valueOf(latitude);
			double lon1 = Double.valueOf(longitude);

			for (int i = 0; i < list.size(); i++) {

				double dist = 0;

				double lat2 = Double.valueOf(list.get(i).getLatitude());
				double lon2 = Double.valueOf(list.get(i).getLongitude());

				double theta = lon1 - lon2;

				dist = Math.sin(deg2rad(lat1)) * Math.sin(deg2rad(lat2))
						+ Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2)) * Math.cos(deg2rad(theta));

				dist = Math.acos(dist);

				dist = rad2deg(dist);

				dist = dist * 60 * 1.1515;

				dist = dist * 1.609344; // kilometer

				dist = Math.round((dist) * 10) / 10.0;

				if (dist == 0) {
					dist = 0.4;
				}
				arr_key[i] = i + 1;
				arr_value[i] = dist;
			}

			for (int i = 0; i < arr_key.length - 1; i++) {
				int temp_key = 0;
				double temp_value = 0;
				for (int j = i; j < arr_value.length; j++) {
					if (arr_value[i] > arr_value[j]) {

						temp_value = arr_value[j];
						arr_value[j] = arr_value[i];
						arr_value[i] = temp_value;

						temp_key = arr_key[j];
						arr_key[j] = arr_key[i];
						arr_key[i] = temp_key;
					}
				}
			}

			for (int i = 0; i < arr_key.length; i++) {
				for (int j = 0; j < list.size(); j++) {
					if (arr_key[i] == list.get(j).getItem_idx()) {
						sortList.add(list.get(j));
						indexList.add(arr_key[i]);
						distList.add(arr_value[i]);
					}
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		return sortList;
	}

	private static double deg2rad(double deg) {
		return (deg * Math.PI / 180.0);
	}

	private static double rad2deg(double rad) {
		return (rad * 180 / Math.PI);
	}
}
