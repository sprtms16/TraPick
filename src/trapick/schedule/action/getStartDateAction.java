package trapick.schedule.action;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import trapick.schedule.service.ScheduleService;

public class getStartDateAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String startDate = ScheduleService.getInstance().getStartDateService(request);
		request.setAttribute("startDate", startDate);
		return new ActionForward(false,"/main_insert_form.jsp");
	}

}
