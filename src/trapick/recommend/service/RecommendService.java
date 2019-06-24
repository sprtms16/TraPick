package trapick.recommend.service;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import trapick.recommend.domain.Item;
import trapick.recommend.model.Crawling;

public class RecommendService {
   private static RecommendService service = new RecommendService();
   private static Crawling crawling;

   public static RecommendService getInstance() {

      crawling = Crawling.getInstance();
      return service;
   }

   public List<Item> ItemListService(HttpServletRequest request, HttpServletResponse response) throws Exception {
	   
	  Crawling crawling = Crawling.getInstance();
	  request.setCharacterEncoding("utf-8");
      String country_name = request.getParameter("country_name");
      String city_name = request.getParameter("city_name");
      System.out.println("서비스실행");
      System.out.println(country_name);
      System.out.println(city_name);

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
}