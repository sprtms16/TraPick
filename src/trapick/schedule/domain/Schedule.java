package trapick.schedule.domain;

import java.util.List;

public class Schedule {
	int schd_idx;
	String title;
	String schd_start;
	String schd_end;
	int user_idx;
	List<SelectedLandMark> selectedLandmarkds;
	List<SelectedItem> selectedItems;

	public Schedule() {
		// TODO Auto-generated constructor stub
	}

	public Schedule(int schd_idx, String title, String schd_start, String schd_end, int user_idx,
			List<SelectedLandMark> selectedLandmarkds, List<SelectedItem> selectedItems) {
		super();
		this.schd_idx = schd_idx;
		this.title = title;
		this.schd_start = schd_start;
		this.schd_end = schd_end;
		this.user_idx = user_idx;
		this.selectedLandmarkds = selectedLandmarkds;
		this.selectedItems = selectedItems;
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

	public String getSchd_start() {
		return schd_start;
	}

	public void setSchd_start(String schd_start) {
		this.schd_start = schd_start;
	}

	public String getSchd_end() {
		return schd_end;
	}

	public void setSchd_end(String schd_end) {
		this.schd_end = schd_end;
	}

	public int getUser_idx() {
		return user_idx;
	}

	public void setUser_idx(int user_idx) {
		this.user_idx = user_idx;
	}

	public List<SelectedLandMark> getSelectedLandmarkds() {
		return selectedLandmarkds;
	}

	public void setSelectedLandmarkds(List<SelectedLandMark> selectedLandmarkds) {
		this.selectedLandmarkds = selectedLandmarkds;
	}

	public List<SelectedItem> getSelectedItems() {
		return selectedItems;
	}

	public void setSelectedItems(List<SelectedItem> selectedItems) {
		this.selectedItems = selectedItems;
	}

	@Override
	public String toString() {
		return "Schedule [schd_idx=" + schd_idx + ", title=" + title + ", schd_start=" + schd_start + ", schd_end="
				+ schd_end + ", user_idx=" + user_idx + ", selectedLandmarkds=" + selectedLandmarkds
				+ ", selectedItems=" + selectedItems + "]";
	}

}
