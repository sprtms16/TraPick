package trapick.recommend.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import trapick.recommend.domain.Hotel;
import trapick.recommend.domain.Item;
import trapick.recommend.domain.LandMark;
import trapick.recommend.domain.Restaurant;
import trapick.recommend.model.Crawling;
import trapick.recommend.model.LandMarkDao;

public class RecommendService {

	private static RecommendService service = new RecommendService();
	private static Crawling crawling;
	private static LandMarkDao dao;

	public static RecommendService getInstance() {
		dao = LandMarkDao.getInstance();
		crawling = Crawling.getInstance();
		return service;
	}

	public static RecommendService getInstance_dao() {

		dao = LandMarkDao.getInstance();
		return service;

	}

	public List<Restaurant> listRestaurantService(HttpServletRequest request, HttpServletResponse response) {

		String city_name = request.getParameter("city_name");
		String base_point = "������";

		List<Restaurant> list_Rest = crawling.crawlingNearRest(city_name, base_point);

		return list_Rest;
	}

	public List<Item> ItemListService(HttpServletRequest request, HttpServletResponse response) {

		Crawling crawling = Crawling.getInstance();

		String country_name = request.getParameter("country_name");
		String city_name = request.getParameter("city_name");

		List<Item> list = crawling.Getcrawling(country_name, city_name); // ũ�Ѹ��� ���� ������ ����Ʈ

		System.out.println(request.getParameter("distance"));
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

	public List<Restaurant> listRestaurant(HttpServletRequest request) {

		String city_name = request.getParameter("city_name");
		String base_Point = request.getParameter("base_Point");

		List<Restaurant> list_Res = crawling.crawlingNearRest("�ĸ�", "������");

		System.out.println("����" + list_Res);

		return list_Res;

	}

	public List<Hotel> listHotelService(HttpServletRequest request, HttpServletResponse response) {

		String city_name = request.getParameter("city_name");

		List<Hotel> list_Hotel = crawling.crawlingNearHotel(city_name);

		return list_Hotel;
	}

	public List<LandMark> landMarkListService(HttpServletRequest request) throws Exception {
		request.setCharacterEncoding("utf-8");
		String city_name = request.getParameter("city_name");
		List<LandMark> list = dao.landMarkList(city_name);
		System.out.println(list);
		return list;
	}

	public List<String> cityListService(HttpServletRequest request) throws Exception {
		request.setCharacterEncoding("utf-8");
		String country_name = request.getParameter("country_name");
		System.out.println(country_name);
		List<String> list = dao.cityList(country_name);

		return list;
	}

	public void saveScheduleService(HttpServletRequest request) throws Exception {
		request.setCharacterEncoding("utf-8");
		String html = request.getParameter("html");
		System.out.println(html);

		dao.saveSchedule(html);
	}

}