package trapick.feed.domain;

import java.io.Serializable;

public class ReplyDislike implements Serializable{
	int feed_idx;
	int reply_idx;
	int disliker;
	
	ReplyDislike(){}

	public ReplyDislike(int feed_idx, int reply_idx, int disliker) {
		super();
		this.feed_idx = feed_idx;
		this.reply_idx = reply_idx;
		this.disliker = disliker;
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

	public int getDisliker() {
		return disliker;
	}

	public void setDisliker(int disliker) {
		this.disliker = disliker;
	}

	@Override
	public String toString() {
		return "ReplyDislike [feed_idx=" + feed_idx + ", reply_idx=" + reply_idx + ", disliker=" + disliker + "]";
	}
	
	
}
