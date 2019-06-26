package trapick.mypage.domain;

import java.io.Serializable;

public class Schedule implements Serializable {
	int schd_idx;
	String title;
	int user_idx;
	String html;

	Schedule() {
	}

	public int getSchd_idx() {
		return schd_idx;
	}

	public void setSchd_idx(int schd_idx) {
		this.schd_idx = schd_idx;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getUser_idx() {
		return user_idx;
	}

	public void setUser_idx(int user_idx) {
		this.user_idx = user_idx;
	}

	public String getHtml() {
		return html;
	}

	public void setHtml(String html) {
		this.html = html;
	}

	public Schedule(int schd_idx, String title, int user_idx, String html) {
		super();
		this.schd_idx = schd_idx;
		this.title = title;
		this.user_idx = user_idx;
		this.html = html;
	}

	@Override
	public String toString() {
		return "Schedule [schd_idx=" + schd_idx + ", title=" + title + ", user_idx=" + user_idx + ", html=" + html
				+ "]";
	}

}
