package trapick.schedule.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import trapick.schedule.domain.Country;
import trapick.schedule.service.ScheduleService;

public class CountryIsoListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		ScheduleService service = ScheduleService.getInstance();
		JSONObject object = new JSONObject();
		object.put("iso", (String) service.selectISO(request));
		System.out.println(object);
		JSONArray array = new JSONArray();
		array.add(object);
		response.setContentType("text/html;charset=UTF-8");
		response.getWriter().print(object);
		System.out.println(object);
		return null;
	}

}
