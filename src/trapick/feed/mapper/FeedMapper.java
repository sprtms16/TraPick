package trapick.feed.mapper;

import java.util.List;

import trapick.feed.domain.Feed;
import trapick.feed.domain.Reply;

public interface FeedMapper {

	int insertFeed(Feed feed);

	List<Feed> feedList();

	Feed getFeed(int feed_idx);

	

}
