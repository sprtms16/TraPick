package trapick.feed.domain;

import java.io.Serializable;

public class Heart implements Serializable {
	int feed_idx;
	int user_idx;

	public Heart() {
	}

	public int getFeed_idx() {
		return feed_idx;
	}

	public void setFeed_idx(int feed_idx) {
		this.feed_idx = feed_idx;
	}

	public int getUser_idx() {
		return user_idx;
	}

	public void setUser_idx(int user_idx) {
		this.user_idx = user_idx;
	}

	public Heart(int feed_idx, int user_idx) {
		super();
		this.feed_idx = feed_idx;
		this.user_idx = user_idx;
	}

	@Override
	public String toString() {
		return "Heart [feed_idx=" + feed_idx + ", user_idx=" + user_idx + "]";
	}

}
