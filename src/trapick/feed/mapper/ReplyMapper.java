package trapick.feed.mapper;

import java.util.List;
import java.util.Map;

import trapick.feed.domain.Reply;
import trapick.feed.domain.ReplyDislike;
import trapick.feed.domain.ReplyLike;

public interface ReplyMapper {
	int insertReply(Reply reply);

	List<Reply> listReply(Map<String, Object> param);

	int updateReplyLike(ReplyLike replyLike);

	int updateReplyDislike(ReplyDislike replyDislike);

	int selectReplyLikeCheck(ReplyLike replyLike);

	int deleteReplyLike(ReplyLike replyLike);

	int selectReplyLikeCount(int reply_idx);

	int insertReplyLike(ReplyLike replyLike);

	int selectReplyDislikeCheck(ReplyDislike replyDislike);

	int deleteReplyDislike(ReplyDislike replyDislike);

	int selectReplyDislikeCount(int reply_idx);

	int insertReplyDislike(ReplyDislike replyDislike);

}
