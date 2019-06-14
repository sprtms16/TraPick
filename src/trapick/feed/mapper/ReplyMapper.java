package trapick.feed.mapper;

import java.util.List;

import trapick.feed.domain.Reply;

public interface ReplyMapper {
	int insertReply(Reply reply);

	List<Reply> listReply(int feed_idx);
}
