package trapick.feed.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import trapick.feed.domain.Feed;
import trapick.feed.service.FeedService;

public class updateFeedFormAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		FeedService service =  FeedService.getInstance();
		
		Feed feed = service.getFeedUpdateService(Integer.parseInt(request.getParameter("feed_idx")));
		
		request.setAttribute("feed",feed);
		forward.setRedirect(false);
		forward.setPath("/updateForm.jsp");
		return forward;
	}

}
