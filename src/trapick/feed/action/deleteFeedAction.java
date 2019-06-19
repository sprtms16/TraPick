package trapick.feed.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import trapick.feed.service.FeedService;

public class deleteFeedAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		FeedService service = FeedService.getInstance();
		ActionForward forward = new ActionForward();
		service.deleteFeedService(request);
		
		forward.setRedirect(true);
		forward.setPath("list");
		return forward;
	}

}
