package trapick.recommend.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import trapick.recommend.domain.LandMark;
import trapick.recommend.service.RecommendService;

public class LandMarkListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		RecommendService service = RecommendService.getInstance();
		ActionForward forward = new ActionForward();
		
		List<LandMark> landMarkList = service.landMarkListService(request);
		
		JSONArray array = JSONArray.fromObject(landMarkList);
		response.setContentType("text/html;charset=UTF-8");
		response.getWriter().print(array);
		return null;
		
	}

}
