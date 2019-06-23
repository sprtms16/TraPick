package trapick.recommend.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import trapick.recommend.domain.Item;
import trapick.recommend.service.RecommendService;

public class ItemListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setAttribute("list", RecommendService.getInstance().ItemListService(request, response));
		request.setAttribute("cityList", RecommendService.getInstance().cityListService(request));
		request.setAttribute("landMarkList", RecommendService.getInstance().landMarkListService(request));
		return new ActionForward(false, "/item_sort.jsp");
	}

}
