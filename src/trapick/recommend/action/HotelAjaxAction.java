package trapick.recommend.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import trapick.recommend.domain.Hotel;
import trapick.recommend.service.RecommendService;

public class HotelAjaxAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		RecommendService service = RecommendService.getInstance();
		ActionForward forward = new ActionForward();

		List<Hotel> list_Hotel = service.listHotelService(request, response);

		JSONArray jsonArray = JSONArray.fromObject(list_Hotel);

		response.setContentType("text/html;charset=UTF-8");
		response.getWriter().print(jsonArray);

		return null;
	}

}