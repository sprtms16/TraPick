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
		
		service.heartActionService(request);
		
		JSONArray jsonArray = new JSONArray();
		jsonArray.add(new JSONObject().put("status", 1));
		jsonArray.add(new JSONObject().put("message", "oK"));
		
		
		return null;
	}

}
