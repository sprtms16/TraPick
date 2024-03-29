package trapick.feed.domain;

import java.io.Serializable;
import java.util.List;

public class Feed implements Serializable {
	int feed_idx;
	int user_idx;
	int schd_idx;
	String regdate;
	String title;
	String contents;
	List<String> url;
	int heart;
	List<Reply> replys;
	int rating;
	int islike;
	String html;

	public Feed() {
		// TODO Auto-generated constructor stub
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

	public int getSchd_idx() {
		return schd_idx;
	}

	public void setSchd_idx(int schd_idx) {
		this.schd_idx = schd_idx;
	}

	public String getRegdate() {
		return regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public List<String> getUrl() {
		return url;
	}

	public void setUrl(List<String> url) {
		this.url = url;
	}

	public int getHeart() {
		return heart;
	}

	public void setHeart(int heart) {
		this.heart = heart;
	}

	public List<Reply> getReplys() {
		return replys;
	}

	public void setReplys(List<Reply> replys) {
		this.replys = replys;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public int getIslike() {
		return islike;
	}

	public void setIslike(int islike) {
		this.islike = islike;
	}

	public String getHtml() {
		return html;
	}

	public void setHtml(String html) {
		this.html = html;
	}

	public Feed(int feed_idx, int user_idx, int schd_idx, String regdate, String title, String contents,
			List<String> url, int heart, List<Reply> replys, int rating, int islike, String html) {
		super();
		this.feed_idx = feed_idx;
		this.user_idx = user_idx;
		this.schd_idx = schd_idx;
		this.regdate = regdate;
		this.title = title;
		this.contents = contents;
		this.url = url;
		this.heart = heart;
		this.replys = replys;
		this.rating = rating;
		this.islike = islike;
		this.html = html;
	}

	@Override
	public String toString() {
		return "Feed [feed_idx=" + feed_idx + ", user_idx=" + user_idx + ", schd_idx=" + schd_idx + ", regdate="
				+ regdate + ", title=" + title + ", contents=" + contents + ", url=" + url + ", heart=" + heart
				+ ", replys=" + replys + ", rating=" + rating + ", islike=" + islike + ", html=" + html + "]";
	}

	

}
