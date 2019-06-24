package trapick.recommend.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import trapick.recommend.service.RecommendService;

public class ItemListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		request.setAttribute("list", RecommendService.getInstance().ItemListService(request, response));
		return new ActionForward(false, "/item_sort.jsp");
	}

}
