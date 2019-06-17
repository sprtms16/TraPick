package trapick.schedule.domain;

import java.io.Serializable;

public class Country implements Serializable{
	private int Country_idx;
	private String name;
	
	public Country(){}

	public int getCountry_idx() {
		return Country_idx;
	}

	public void setCountry_idx(int country_idx) {
		Country_idx = country_idx;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Country [Country_idx=" + Country_idx + ", name=" + name + "]";
	}

	public Country(int country_idx, String name) {
		super();
		Country_idx = country_idx;
		this.name = name;
	}
	
	
}
