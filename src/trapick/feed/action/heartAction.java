package trapick.feed.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import trapick.feed.service.FeedService;
import trapick.feed.service.ReplyService;

public class heartAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		FeedService service = FeedService.getInstance();

		int heartCount = service.heartActionService(request);
		JSONObject object = new JSONObject();
		object.put("status", 1);
		object.put("message", "oK");
		if (heartCount >= 0) {
			object.put("heartCount", heartCount);
		}
		System.out.println(object);
		response.getWriter().println(object);

		return null;
	}

}
