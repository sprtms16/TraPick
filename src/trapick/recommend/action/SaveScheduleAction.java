package trapick.recommend.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import trapick.recommend.service.RecommendService;

public class SaveScheduleAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		RecommendService service = RecommendService.getInstance();
		ActionForward forward = new ActionForward();
		
		service.saveScheduleService(request);
		
		
		return null;		
	}

}
