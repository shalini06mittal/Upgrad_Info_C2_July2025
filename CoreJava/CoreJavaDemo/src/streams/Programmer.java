package streams;

import java.util.List;

public class Programmer {
	
	private String name;
	private List<String> skills;
	private String city;
	
	public Programmer() {
		// TODO Auto-generated constructor stub
	}

	public Programmer(String name, List<String> skills, String city) {
		super();
		this.name = name;
		this.skills = skills;
		this.city = city;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<String> getSkills() {
		return skills;
	}

	public void setSkills(List<String> skills) {
		this.skills = skills;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "Programmer [name=" + name + ", skills=" + skills + ", city=" + city + "]";
	}
	
	
	

}
