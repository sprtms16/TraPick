package trapick.feed.mapper;

import java.util.List;

import trapick.feed.domain.Feed;
import trapick.feed.domain.Heart;

public interface FeedMapper {

	int insertFeed(Feed feed);

	List<Feed> feedList();

	Feed getFeed(int feed_idx);

	int updateFeedHeart(Heart heart);

	int deleteFeed(int feed_idx);

	Feed updateFeed(int feed_idx);

	int updateFeedAction(Feed feed);

}
