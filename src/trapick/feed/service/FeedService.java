package trapick.feed.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.executor.ReuseExecutor;

import trapick.feed.domain.Feed;
import trapick.feed.domain.Heart;
import trapick.feed.domain.Reply;
import trapick.feed.model.FeedDao;

public class FeedService {

	private static FeedService service = new FeedService();
	private static FeedDao dao;

	public static FeedService getInstance() {
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
		HttpSession session = request.getSession();
		int user_idx = (int) session.getAttribute("user_idx");

		Map<String, Object> map = new HashMap<String, Object>();
		List<String> keywordList = new ArrayList<String>();
		map.put("user_idx", user_idx);
		if (request.getParameter("keyword") != null) { // hashtag
			String keyword = "#" + request.getParameter("keyword");
			keywordList.add(keyword);
			map.put("keyword", keywordList);
		}
		if (request.getParameter("word") != null) { // 검색창에 입력한 text값
			String word = request.getParameter("word");
			for (String words : word.split(" "))
				keywordList.add(words);
			map.put("keyword", keywordList);
		}

		List<Feed> list = dao.feedList(map);
		return list;
	}

	public Feed updateFormService(int feed_idx) {
		Feed feed = dao.feedUpdate(feed_idx);
		return feed;
	}

	public int heartActionService(HttpServletRequest request) throws Exception {
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		int feed_idx = Integer.parseInt(request.getParameter("feed_idx"));
		int user_idx = (int) session.getAttribute("user_idx");
		Heart heart = new Heart(feed_idx, user_idx);
		if (dao.selectFeedHeartCheck(heart) > 0) {
			if (dao.deleteFeedHeart(heart) > 0)
				return dao.selectFeedHeartCount(feed_idx);
			else
				return -1;
		} else {
			if (dao.insertFeedHeart(heart) > 0)
				return dao.selectFeedHeartCount(feed_idx);
			else
				return -1;
		}

	}

	public int deleteFeedService(HttpServletRequest request) {
		return dao.deleteFeed(Integer.parseInt(request.getParameter("feed_idx")));

	}

	public List<Feed> popularFeedService(HttpServletRequest request, HttpServletResponse response) {

		return null;
	}

	public Feed getFeedUpdateService(int feed_idx) {
		Feed feed = dao.updateFeed(feed_idx);
		return feed;
	}

	public int updateFeedActionService(HttpServletRequest request) throws Exception {
		request.setCharacterEncoding("utf-8");
		Feed feed = new Feed();
		feed.setFeed_idx(Integer.parseInt(request.getParameter("feed_idx")));
		feed.setTitle(request.getParameter("title"));
		feed.setContents(request.getParameter("contents"));

		return dao.updateFeedAction(feed);

	}

}
