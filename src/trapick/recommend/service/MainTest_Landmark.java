package trapick.recommend.service;

import java.util.List;

import trapick.recommend.domain.LandMark;

public class MainTest_Landmark {

	public static void main(String[] args) {

		Crawling_Landmark crawling = Crawling_Landmark.getInstance();

		String country_name = "È«Äá";
		String city_name = "È«Äá";
		List<LandMark> landscape_list = crawling.getLandmarkCrawling(country_name, city_name);
		System.out.println(landscape_list);
		for (LandMark mark : landscape_list) {
			System.out.println("insert into LANDMARK values(landmark_seq.nextval, '" + mark.getName() + "','"
					+ mark.getImage() + "' ,'"+mark.getLatitude()+"','"+mark.getLongitude()+"', '"+mark.getDetail()+"',(select city_idx from city where NAME = '"+mark.getCity_name()+"'));");
		}

	}

}
