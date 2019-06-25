package trapick.recommend.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import trapick.recommend.domain.Restaurant;
import trapick.recommend.service.RecommendService;

public class RestAjaxAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		RecommendService service = RecommendService.getInstance();
		ActionForward forward = new ActionForward();
		
		List<Restaurant> list_Rest = service.listRestaurantService(request);
		
		JSONArray jsonArray = JSONArray.fromObject(list_Rest);
		
		response.setContentType("text/html;charset=UTF-8");
		response.getWriter().print(jsonArray);
		
		return null;
	}

}
