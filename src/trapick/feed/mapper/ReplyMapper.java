package trapick.feed.mapper;

import java.util.List;

import trapick.feed.domain.Reply;
import trapick.feed.domain.ReplyDislike;
import trapick.feed.domain.ReplyLike;

public interface ReplyMapper {
	int insertReply(Reply reply);

	List<Reply> listReply(int feed_idx);

	int updateReplyLike(ReplyLike replyLike);

	int updateReplyDislike(ReplyDislike replyDislike);

	

	
}
