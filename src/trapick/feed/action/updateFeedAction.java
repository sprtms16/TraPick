package trapick.feed.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import trapick.feed.service.FeedService;

public class updateFeedAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		FeedService service = FeedService.getInstance();
		service.updateFeedActionService(request);
		
		forward.setRedirect(true);
		forward.setPath("list");
		return forward;
	}

}
