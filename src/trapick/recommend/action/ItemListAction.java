package trapick.recommend.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import trapick.recommend.service.RecommendService;

public class ItemListAction implements Action {

   @Override
   public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
      request.setAttribute("list", RecommendService.getInstance().ItemListService(request, response));
      request.setAttribute("list_Land", RecommendService.getInstance_dao().listLandMarkService(request));
      request.setAttribute("list_Rest", RecommendService.getInstance().listRestaurantService(request, response));
      request.setAttribute("list_Hotel", RecommendService.getInstance().listHotelService(request, response));
      
      return new ActionForward(false, "/item_sort.jsp");
   }

}