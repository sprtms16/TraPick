package trapick.schedule.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import trapick.schedule.domain.Country;
import trapick.schedule.model.ScheduleDao;

public class ScheduleService {
	private static ScheduleService service = new ScheduleService();
	private static ScheduleDao dao;

	public static ScheduleService getInstance() {
		dao = ScheduleDao.getInstance();
		return service;
	}

	public List<Country> listCountryService(HttpServletRequest request) {
		return dao.listCountry();
	}

	public List<String> listCityService(HttpServletRequest request) {
		String country_name = request.getParameter("country_name");
		return dao.listCity(country_name);
	}

	public String getStartDateService(HttpServletRequest request) {
		// TODO Auto-generated method stub
		String idx = request.getParameter("idx");
		return dao.startDate(idx);
	}

}
