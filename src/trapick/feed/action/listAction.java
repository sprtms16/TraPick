package trapick.feed.action;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import trapick.feed.domain.Feed;
import trapick.feed.domain.Reply;
import trapick.feed.service.FeedService;
import trapick.feed.service.ReplyService;

public class listAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		FeedService service = FeedService.getInstance();
		ReplyService replyService = ReplyService.getInstance();
		
		List<Feed> feedList = service.FeedListService(request, response);
		for (Feed feed : feedList)
			feed.setReplys(replyService.listReplyService(request,feed.getFeed_idx()));
		System.out.println(feedList);

		if (request.getParameter("odb") != null) {
			int ud = request.getParameter("sc").equals("up") ? 1 : -1;
			switch (request.getParameter("odb")) {
			case "pop":

				Collections.sort(feedList, (o1, o2) -> (o1.getHeart() - o2.getHeart()) * ud );
				break;
			case "rep":
				Collections.sort(feedList, new Comparator<Feed>() {

					@Override
					public int compare(Feed o1, Feed o2) {
					
						return (o1.getReplys().size() - o2.getReplys().size()) * ud;
					}
				});
				break;
				
			default:
	
				
				break;
			}
		}
		
		
		
		request.setAttribute("feedList", feedList);
		
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("/feedList.jsp");

		return forward;
	}

}
