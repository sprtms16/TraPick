package trapick.schedule.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import trapick.schedule.service.ScheduleService;

public class SelectCityAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		ScheduleService service = ScheduleService.getInstance();
		ActionForward forward = new ActionForward();
		
		List<String> list = service.listCityService(request);
		
		request.setAttribute("list", list);
		
		forward.setRedirect(false);
		forward.setPath("/main_insert_form.jsp");
		return forward;
	}

}
