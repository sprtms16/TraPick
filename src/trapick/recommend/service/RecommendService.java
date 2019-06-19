package trapick.recommend.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import trapick.recommend.domain.Item;
import trapick.recommend.model.Crawling;

public class RecommendService {
	private static RecommendService service = new RecommendService();
	private static Crawling crawling;

	public static RecommendService getInstance() {
		// TODO Auto-generated method stub
		crawling = Crawling.getInstance();
		return service;
	}

	public List<Item> ItemListService(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String country_name = request.getParameter("country_name");
		String city_name = request.getParameter("city_name");
		
		List<Item> list = crawling.Getcrawling(country_name, city_name);
		if (request.getParameter("sort") != null) {
			switch (request.getParameter("sort")) {
			case "price":
				crawling.priceSort(list);
				break;
			case "sales":
				crawling.salesSort(list);
				break;
			case "hits":
				crawling.hitsSort(list);
				break;
			default:
				break;
			}
		}
		return list;
	}

}
