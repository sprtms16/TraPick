package trapick.schedule.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import trapick.schedule.service.ScheduleService;

public class CityListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		ScheduleService service = ScheduleService.getInstance();
		
		List<String> list = service.listCityService(request);
		JSONArray array = JSONArray.fromObject(list);
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().print(array);
		return null;
	}

}
