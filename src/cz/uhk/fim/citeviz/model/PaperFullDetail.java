package cz.uhk.fim.citeviz.model;

import java.util.Map;
import java.util.Set;

public class PaperFullDetail extends Paper{
	
	private static final long serialVersionUID = 1L;
	
	public static final String ABSTRACT_KEY = "abstract";
	
	public static final String CONTRIBUTOR_KEY = "contributor";
	
	public static final String DOI_KEY = "doi";
	
	public static final String URL_KEY = "url";
	
	public static final String SOURCE_TYPE_KEY = "srctype";
	
	public static final String SUBJECT_KEY = "subject";

	public static final String AFFILIATION_KEY = "affiliation";
	
	public static final String KEYWORDS_KEY = "keyword";
	
	public static final String COUNTRY_KEY = "country";
	
	private Map<String, Set<String>> otherData;
	
	
	public PaperFullDetail(String id, String title, Set<Author> authors, int year, int citationIndex, Map<String, Set<String>> otherData) {
		super(id, title, authors, year, citationIndex);
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
	
	public String getAbstract() {
		return getOtherDataSingleValue(ABSTRACT_KEY);
	}
}
