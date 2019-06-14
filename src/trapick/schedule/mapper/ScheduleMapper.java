package trapick.schedule.mapper;

import java.util.List;

import trapick.schedule.domain.Country;

public interface ScheduleMapper {
	List<Country> listCountry();
	List<String> listCity();
}
