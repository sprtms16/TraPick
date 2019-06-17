package trapick.feed.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import trapick.feed.service.ReplyService;

public class replyLikeAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		ReplyService replyService = ReplyService.getInstance();
		
		replyService.replyLikeService(request);
		
		JSONArray jsonArray = new JSONArray();
		jsonArray.add(new JSONObject().put("status", 1));
		jsonArray.add(new JSONObject().put("message", "oK"));
		
		
		
		
		

		return null;
	}

}
