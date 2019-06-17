package trapick.feed.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import trapick.feed.service.ReplyService;

public class insertActionReply implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ReplyService replyService = ReplyService.getInstance();

		ActionForward forward = new ActionForward();
		if (!request.getParameter("contents").trim().equals(""))
			replyService.insertReplyService(request);

		forward.setRedirect(true);
		forward.setPath("list");

		return forward;
	}

}
