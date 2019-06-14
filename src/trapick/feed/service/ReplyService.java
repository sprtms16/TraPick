package trapick.feed.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import trapick.feed.domain.Reply;
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

}
