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

	public List<String> listCountryIsoService(HttpServletRequest request) {
		String country_iso = request.getParameter("country_iso");
		return dao.listCountryIso();
	}

	public String selectISO(HttpServletRequest request) {
		// TODO Auto-generated method stub
		String country_name = request.getParameter("country_name");
		return dao.selectCountryISO(country_name);
	}

	public String selectCityEnameService(HttpServletRequest request) {
		// TODO Auto-generated method stub
		String city_ename = request.getParameter("city_name");
		/* System.out.println("service" + city_ename); */
		return dao.selectCityEname(city_ename);
	}

}
