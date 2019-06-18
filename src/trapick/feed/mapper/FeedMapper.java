package trapick.feed.mapper;

import java.util.List;

import trapick.feed.domain.Feed;
import trapick.feed.domain.Heart;
import trapick.feed.domain.Reply;

public interface FeedMapper {

	int insertFeed(Feed feed);

	List<Feed> feedList(int user_idx);

	Feed getFeed(int feed_idx);

	int updateFeedHeart(Heart heart);

	int deleteFeed(int feed_idx);

	int selectFeedHeartCount(int feed_idx);
	
	int selectFeedHeartCheck(int user_idx);

	

}
