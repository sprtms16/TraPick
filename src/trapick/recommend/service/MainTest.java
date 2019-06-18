package trapick.recommend.service;

import java.util.List;

import trapick.recommend.domain.Item;
import trapick.recommend.model.Crawling;

public class MainTest {

	public static void main(String[] args) {

		Crawling crawling = new Crawling();
		
		crawling.getInstance();
		
		List<Item> list = crawling.Getcrawling("������", "�ĸ�");
		
		crawling.distanceSort("�ĸ�", list);
		
	}
}