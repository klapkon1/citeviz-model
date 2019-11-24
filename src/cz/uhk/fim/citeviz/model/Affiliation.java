package cz.uhk.fim.citeviz.model;

public class Affiliation extends IdRecord{
	private static final long serialVersionUID = 1L;
	
	private String name;
	
	private String country;
	
	private String city;
	
	private int papersCount;
	
	public Affiliation(String id) {
		super(id);
	}
	
}
