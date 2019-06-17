package trapick.feed.domain;

import java.io.Serializable;

public class Reply implements Serializable{
	int reply_idx;
	int feed_idx;
	int user_idx;
	String contents;
	String regdate;
	int like;
	int dislike;

	public Reply() {
		// TODO Auto-generated constructor stub
	}

	public Reply(int reply_idx, int feed_idx, int user_idx, String contents, String regdate, int like, int dislike) {
		super();
		this.reply_idx = reply_idx;
		this.feed_idx = feed_idx;
		this.user_idx = user_idx;
		this.contents = contents;
		this.regdate = regdate;
		this.like = like;
		this.dislike = dislike;
	}

	public int getReply_idx() {
		return reply_idx;
	}

	public void setReply_idx(int reply_idx) {
		this.reply_idx = reply_idx;
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

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public String getRegdate() {
		return regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}

	public int getLike() {
		return like;
	}

	public void setLike(int like) {
		this.like = like;
	}

	public int getDislike() {
		return dislike;
	}

	public void setDislike(int dislike) {
		this.dislike = dislike;
	}

	@Override
	public String toString() {
		return "Reply [reply_idx=" + reply_idx + ", feed_idx=" + feed_idx + ", user_idx=" + user_idx + ", contents="
				+ contents + ", regdate=" + regdate + ", like=" + like + ", dislike=" + dislike + "]";
	}

}
