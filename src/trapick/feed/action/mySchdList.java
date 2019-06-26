package trapick.feed.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import trapick.feed.domain.Feed;
import trapick.feed.service.FeedService;

public class mySchdList implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		FeedService service = FeedService.getInstance();
		List<Feed> list = service.selectMySchdListService(request);
		JSONArray array = JSONArray.fromObject(list);
		response.setContentType("text/html;charset=UTF-8");
		response.getWriter().print(array);
		return null;
	}

}
