package trapick.schedule.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import trapick.schedule.domain.Country;
import trapick.schedule.service.ScheduleService;

public class SelectCountryAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ScheduleService service = ScheduleService.getInstance();
		ActionForward forward = new ActionForward();
		
		List<Country> list = service.listCountryService(request);
		
		request.setAttribute("list", list);
		
		forward.setRedirect(false);
		forward.setPath("/main_insert_form.jsp");
		return forward;
	}

}
