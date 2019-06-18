package trapick.recommend.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import trapick.recommend.domain.Item;
import trapick.recommend.service.RecommendService;

public class ListSortAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		RecommendService service = RecommendService.getInstance();
		ActionForward forward = new ActionForward();
		
		List<Item> list = service.ItemListService(request, response);
		
		request.setAttribute("list",list);
				
		forward.setRedirect(false);
		forward.setPath("itemList");
		
		return forward;
	}

}
