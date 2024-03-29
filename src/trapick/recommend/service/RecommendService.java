package trapick.recommend.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

   public List<Item> ItemListService(HttpServletRequest request, HttpServletResponse response) throws Exception {
	   
	  Crawling crawling = Crawling.getInstance();
	  request.setCharacterEncoding("utf-8");
      String country_name = request.getParameter("country_name");
      String city_name = request.getParameter("city_name");

      List<Item> list = crawling.Getcrawling(country_name, city_name); // 크롤링한 원본 데이터 리스트
      
      System.out.println(request.getParameter("distance"));
      
      if (request.getParameter("price") != null) {
    	  if(request.getParameter("price").equals("price")) {
    		  list = crawling.priceSort(list);
   	   		}else if (request.getParameter("sales").equals("sales")) {
   		   list = crawling.salesSort(list);
   	   		}else if (request.getParameter("hits").equals("hits")) {
   		   list = crawling.hitsSort(list);
   	   }
       }
      
      if(request.getParameter("distance") != null) {
    	  if (request.getParameter("distance").equals("distance")) {
      		   System.out.println("dist");
      		   list = crawling.distanceSort(request.getParameter("current"), list);
      	   }
      }
      return list;
   }   
   
   public List<LandMark> landMarkListService(HttpServletRequest request)throws Exception{
		request.setCharacterEncoding("utf-8");
		String city_name = request.getParameter("city_name");
		List<LandMark> list = dao.landMarkList(city_name);
		System.out.println(list);
		return list;
	}
   
   public List<String> cityListService(HttpServletRequest request)throws Exception{
	   request.setCharacterEncoding("utf-8");
	   String country_name = request.getParameter("country_name");
	   System.out.println(country_name);
	   List<String> list = dao.cityList(country_name);
	   
	   return list;
   }
   
   public void saveScheduleService(HttpServletRequest request)throws Exception{
	   request.setCharacterEncoding("utf-8");
	   String html = request.getParameter("html");
	   String title = request.getParameter("title");
	   System.out.println("일정생성데이터:");
	   System.out.println(html);
	   System.out.println(title);
	   HashMap<String, String> map = new HashMap<String, String>();
	   map.put("html", html);
	   map.put("title", title);
	   
	   

	   dao.saveSchedule(map);
   }

   public List<Restaurant> listRestaurantService(HttpServletRequest request) {

	      String city_name = request.getParameter("city_name");

	      List<Restaurant> list_Res = crawling.crawlingNearRest(city_name);

	      return list_Res;

	}

   public List<Hotel> listHotelService(HttpServletRequest request, HttpServletResponse response) {

	   String city_name = request.getParameter("city_name");

	   List<Hotel> list_Hotel = crawling.crawlingNearHotel(city_name);

	   return list_Hotel;
	}
	   

   
}