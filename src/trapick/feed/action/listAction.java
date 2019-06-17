package trapick.feed.action;

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
		ActionForward forward = new ActionForward();
		List<Feed> feedList = service.FeedListService(request, response);
		for (Feed feed : feedList)
			feed.setReplys(replyService.listReplyService(feed.getFeed_idx()));
		System.out.println(feedList);
		request.setAttribute("feedList", feedList);

		forward.setRedirect(false);
		forward.setPath("/feedList.jsp");

		return forward;
	}

}
