package cz.uhk.fim.citeviz.model;

import java.util.HashSet;
import java.util.Set;

import cz.uhk.fim.citeviz.graph.builder.ToolTipBuilder;
import cz.uhk.fim.citeviz.gui.components.Localizer;

/**
 * @author Ondøej Klapka
 *
 */
public class Paper extends IdRecord {
	private static final long serialVersionUID = 1L;
	private final String title;
	private String titleShort;
	private final int citationIndex;
	private final Set<Author> authors;
	private final Set<IdRecord> parents;
	private final Set<IdRecord> childs;
	private final int year;
	
	public Paper(String id, String title, Set<Author> authors, int year, int citationIndex) {
		super(id);
		this.title = title;
		this.authors = authors;
		this.year = year;
		this.citationIndex = citationIndex;
		this.parents = new HashSet<IdRecord>();
		this.childs = new HashSet<IdRecord>();
	}

	public String getTitle() {
		return title;
	}
	
	@Override
	public String getCaption(){
		if (titleShort == null) {
			StringBuilder builder = new StringBuilder();
			for (int i = 0; (i < title.length() && builder.length() < 4); i++) {
				if (Character.isUpperCase(title.charAt(i))){
					builder.append(title.charAt(i));
				}
			}
			titleShort = builder.toString();
		}
		return titleShort;
	}
	
	@Override
	public String getLongCaption() {
		return getTitle();
	}
	
	public int getCitationIndex() {
		return citationIndex;
	}

	public Set<Author> getAuthors() {
		return authors;
	}
	
	public int getAuthorsCount(){
		return authors.size();
	}

	public String getAuthorsAsString() {
		StringBuilder builder = new StringBuilder();
		
		for (Author author : authors) {
			if (builder.length() > 0){
				builder.append(", ");
			}
			builder.append(author.getName());
		}
		
		return builder.toString();
	}

	public Set<IdRecord> getParents() {
		return parents;
	}
	
	public int getParentsCount(){
		return parents.size();
	}
	
	public boolean isParent(IdRecord paperId){
		return parents.contains(paperId);
	}

	public Set<IdRecord> getChilds() {
		return childs;
	}
	
	public int getChildsCount() {
		return childs.size();
	}
	
	public boolean isChild(IdRecord paperId){
		return childs.contains(paperId);
	}
	
	public int getYear() {
		return year;
	}

	@Override
	public String toString() {
		return "Paper [id=" + super.getId() + ", title=" + title + ", titleShort="
				+ titleShort + ", citationIndex=" + citationIndex + ", parents=" + parents
				+ ", childs=" + childs + ", year=" + year + "]";
	}
	
	@Override
	public String createHTMLTooltip(){
		ToolTipBuilder builder = new ToolTipBuilder();
		builder.beginHTML();
		builder.appendTitle(title, getId());
		builder.newLine();
		boolean firstAuthor = true;
		for (Author author : authors) {
			if (!firstAuthor){
				builder.append(", ");
			} else {
				firstAuthor = false;
			}
			
			builder.append(author.getName());
			
		}
		
		builder.appendRefInfo(Localizer.getString("global.references"), getParentsCount(), Localizer.getString("global.citations"), getChildsCount());
		
		builder.endHTML();
		return builder.toString();
	}
}