package cz.uhk.fim.citeviz.model;

import java.util.Map;
import java.util.Set;

public class AuthorFullDetail extends Author {
private static final long serialVersionUID = 1L;
	
	public static final String SUBJECT_KEY = "subject";

	public static final String AFFILIATION_KEY = "affiliation";
	
	public static final String COUNTRY_KEY = "country";
	
	private Map<String, Set<String>> otherData;
	
	
	public AuthorFullDetail(String id, String name, int citationIndex, Map<String, Set<String>> otherData) {
		super(id, name, citationIndex);
		this.otherData = otherData;
	}
	
	public String getOtherDataSingleValue(String key) {
		Set<String> set = otherData.get(key);
		if (set != null && !set.isEmpty()){
			return set.iterator().next();
		}
		
		return null;
	}
	
	public Set<String> getOtherDataMultiValue(String key) {
		return otherData.get(key);
	}
	
	public Map<String, Set<String>> getOtherData() {
		return otherData;
	}
}
