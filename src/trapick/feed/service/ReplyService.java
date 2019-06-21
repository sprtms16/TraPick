package trapick.feed.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import trapick.feed.domain.Reply;
import trapick.feed.domain.ReplyDislike;
import trapick.feed.domain.ReplyLike;
import trapick.feed.model.ReplyDao;

public class ReplyService {
	private static ReplyService replyService = new ReplyService();
	private static ReplyDao replyDao;

	public static ReplyService getInstance() {
		replyDao = ReplyDao.getInstance();
		return replyService;
	}

	public int insertReplyService(HttpServletRequest request) throws Exception {

		request.setCharacterEncoding("utf-8");
		Reply reply = new Reply();
		reply.setFeed_idx(Integer.parseInt(request.getParameter("feed_idx")));
		reply.setUser_idx((int) request.getSession().getAttribute("user_idx"));
		reply.setContents(request.getParameter("contents"));
		return replyDao.insertReply(reply);

	}

	public List<Reply> listReplyService(HttpServletRequest request, int feed_idx) {
		Map<String, Object> param = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		param.put("feed_idx", feed_idx);
		param.put("user_idx", session.getAttribute("user_idx"));
		List<Reply> list = replyDao.listReply(param);
		return list;
	}

	public int replyLikeService(HttpServletRequest request) throws Exception {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		int reply_idx = Integer.parseInt(request.getParameter("reply_idx"));
		int feed_idx = Integer.parseInt(request.getParameter("feed_idx"));
		int liker = (int) session.getAttribute("user_idx");
		ReplyLike replyLike = new ReplyLike(feed_idx, reply_idx, liker);
		request.setCharacterEncoding("utf-8");

		if (replyDao.selectReplyLikeCheck(replyLike) > 0) {
			if (replyDao.deleteReplyLike(replyLike) > 0)
				return replyDao.selectReplyLikeCount(reply_idx);
			else
				return -1;
		} else {
			if (replyDao.insertReplyLike(replyLike) > 0)
				return replyDao.selectReplyLikeCount(reply_idx);
			else
				return -1;
		}
	}

	public int replyDislikeService(HttpServletRequest request) throws Exception {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		int reply_idx = Integer.parseInt(request.getParameter("reply_idx"));
		int feed_idx = Integer.parseInt(request.getParameter("feed_idx"));
		int disliker = (int) session.getAttribute("user_idx");
		ReplyDislike replyLike = new ReplyDislike(feed_idx, reply_idx, disliker);
		request.setCharacterEncoding("utf-8");

		if (replyDao.selectReplyDislikeCheck(replyLike) > 0) {
			if (replyDao.deleteReplyDislike(replyLike) > 0)
				return replyDao.selectReplyDislikeCount(reply_idx);
			else
				return -1;
		} else {
			if (replyDao.insertReplyDislike(replyLike) > 0)
				return replyDao.selectReplyDislikeCount(reply_idx);
			else
				return -1;
		}

	}

}
