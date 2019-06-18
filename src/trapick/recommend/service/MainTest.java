package trapick.recommend.service;

import java.util.List;

import trapick.recommend.domain.Item;
import trapick.recommend.model.Crawling;

public class MainTest {

	public static void main(String[] args) {

		Crawling crawling = new Crawling();
		
		crawling.getInstance();
		
		List<Item> list = crawling.Getcrawling("프랑스", "파리");
		
		crawling.distanceSort("파리", list);
		
	}
}