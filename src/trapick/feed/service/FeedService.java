package trapick.feed.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import trapick.feed.domain.Feed;
import trapick.feed.model.FeedDao;

public class FeedService {
	
	private static FeedService service = new FeedService();
	private static FeedDao dao;
	
	public static FeedService getInstance(){
		dao = FeedDao.getInstance();
		return service;
	}

	public int insertFeedService(HttpServletRequest request) throws Exception {
		request.setCharacterEncoding("utf-8");
		
	Feed feed = new Feed();
	feed.setTitle(request.getParameter("title"));
	feed.setContents(request.getParameter("contents"));


		return dao.insertFeed(feed);
		
	}

	public List<Feed> FeedListService(HttpServletRequest request, HttpServletResponse response) {
		List<Feed> list = dao.feedList();
		return list;
	}

	public Feed updateFormService(int feed_idx) {
		Feed feed = dao.feedUpdate(feed_idx);
		return feed;
	}
	
	


}
