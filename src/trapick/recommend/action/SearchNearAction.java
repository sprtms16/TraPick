package trapick.recommend.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import trapick.recommend.domain.Restaurant;
import trapick.recommend.service.RecommendService;

public class SearchNearAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		RecommendService service = RecommendService.getInstance();
		ActionForward forward = new ActionForward();
		
		List<Restaurant> RestaurantList = service.listRestaurant(request);	
		
		JSONArray jsonArray = JSONArray.fromObject(RestaurantList);
		
		response.setContentType("text/html;charset=UTF-8");
		response.getWriter().println(jsonArray);
		
		return null;
	}

}
