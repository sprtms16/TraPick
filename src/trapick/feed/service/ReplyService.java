package trapick.feed.service;

import java.util.List;

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

	public List<Reply> listReplyService(int feed_idx) {
		List<Reply> list = replyDao.listReply(feed_idx);
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
		return replyDao.updateReplyLike(replyLike);
	}

	public int replyDislikeService(HttpServletRequest request) throws Exception {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		int reply_idx = Integer.parseInt(request.getParameter("reply_idx"));
		int feed_idx = Integer.parseInt(request.getParameter("feed_idx"));
		int disliker = (int)session.getAttribute("user_idx");
		ReplyDislike replyDislike = new ReplyDislike(feed_idx, reply_idx, disliker);
		return replyDao.updateReplyDislike(replyDislike);
		
	}

}
