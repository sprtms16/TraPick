package trapick.feed.domain;

public class ReplyLike {
	int feed_idx;
	int reply_idx;
	int liker;
	
	
	public ReplyLike() {}


	public ReplyLike(int feed_idx, int reply_idx, int liker) {
		super();
		this.feed_idx = feed_idx;
		this.reply_idx = reply_idx;
		this.liker = liker;
	}


	public int getFeed_idx() {
		return feed_idx;
	}


	public void setFeed_idx(int feed_idx) {
		this.feed_idx = feed_idx;
	}


	public int getReply_idx() {
		return reply_idx;
	}


	public void setReply_idx(int reply_idx) {
		this.reply_idx = reply_idx;
	}


	public int getLiker() {
		return liker;
	}


	public void setLiker(int liker) {
		this.liker = liker;
	}


	@Override
	public String toString() {
		return "ReplyLike [feed_idx=" + feed_idx + ", reply_idx=" + reply_idx + ", liker=" + liker + "]";
	}

	
	
	
	
}
