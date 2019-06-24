package trapick.recommend.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import trapick.recommend.domain.Item;
import trapick.recommend.domain.LandMark;
import trapick.recommend.model.Crawling;
import trapick.recommend.model.LandMarkDao;

public class RecommendService {
	private static RecommendService service = new RecommendService();
	private static Crawling crawling;
	private static LandMarkDao dao;

	public static RecommendService getInstance() {

		crawling = Crawling.getInstance();
		return service;
	}

	public static RecommendService getInstance_dao() {

		dao = LandMarkDao.getInstance();
		return service;

	}

	public List<Item> ItemListService(HttpServletRequest request, HttpServletResponse response) {

		Crawling crawling = Crawling.getInstance();

		String country_name = request.getParameter("country_name");
		String city_name = request.getParameter("city_name");

		List<Item> list = crawling.Getcrawling(country_name, city_name); // 크롤링한 원본 데이터 리스트

		if (request.getParameter("price") != null) {
			if (request.getParameter("price").equals("price")) {
				list = crawling.priceSort(list);
			} else if (request.getParameter("sales").equals("sales")) {
				list = crawling.salesSort(list);
			} else if (request.getParameter("hits").equals("hits")) {
				list = crawling.hitsSort(list);
			}
		}

		if (request.getParameter("distance") != null) {
			if (request.getParameter("distance").equals("distance")) {
				System.out.println("dist");
				list = crawling.distanceSort(request.getParameter("current"), list);
			}
		}
		return list;
	}

	public List<LandMark> listLandMarkService(HttpServletRequest request) {

		String city_name = request.getParameter("city_name");

		List<LandMark> list_Land = dao.listLandMark(city_name);

		return list_Land;

	}
}