package trapick.schedule.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import trapick.schedule.service.ScheduleService;

public class CityEnameListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		ScheduleService service = ScheduleService.getInstance();
		String ename = service.selectCityEnameService(request);
		
		response.setContentType("text/html;charset=UTF-8");
		response.getWriter().print(ename);
		/* System.out.println("action : " + ename); */
		return null;
	}

}
