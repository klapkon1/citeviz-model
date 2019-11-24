package cz.uhk.fim.citeviz.model;

import java.util.HashSet;
import java.util.Set;

import cz.uhk.fim.citeviz.graph.builder.ToolTipBuilder;
import cz.uhk.fim.citeviz.gui.components.Localizer;
/**
 * 
 * @author Ondøej Klapka
 *
 */
public class Author extends IdRecord {
	private static final long serialVersionUID = 1L;
	private final String name;
	private String nameShort;
	private final Set<IdRecord> papersId;
	private final Set<IdRecord> collaborators;
	
	private final Set<IdRecord> childs;
	private final Set<IdRecord> parents;
	
	private final int citationIndex;
	
	public Author(String id, String name, int citationIndex){
		super(id);
		this.name = name;
		this.citationIndex = citationIndex;
		this.papersId = new HashSet<IdRecord>();
		this.collaborators = new HashSet<IdRecord>();
		this.childs = new HashSet<IdRecord>();
		this.parents = new HashSet<IdRecord>();
	}
	
	public Author(String id, String name){
		super(id);
		this.name = name;
		this.citationIndex = -1;
		this.papersId = new HashSet<IdRecord>();
		this.collaborators = new HashSet<IdRecord>();
		this.childs = new HashSet<IdRecord>();
		this.parents = new HashSet<IdRecord>();
	}
	
	@Override
	public String getCaption(){
		if (nameShort == null){
			StringBuilder builder = new StringBuilder();
			for (int i = 0; (i < name.length() && builder.length() < 4); i++) {
				if (Character.isUpperCase(name.charAt(i))){
					if (builder.length() > 0){
						builder.append(". ");
					}
					builder.append(name.charAt(i));
				}		
			}
			nameShort = builder.toString();
		}
		return nameShort;
	}
	
	@Override
	public String getLongCaption() {
		return getName();
	}
	
	public boolean isCollaborator(IdRecord authorId){
		return collaborators.contains(authorId);
	}
	
	
	public boolean isChild(IdRecord authorId){
		return childs.contains(authorId);
	}
	
	public boolean isParent(IdRecord authorId){
		return parents.contains(authorId);
	}
	
	public String getName() {
		return name;
	}

	public Set<IdRecord> getPapersId() {
		return papersId;
	}
	
	public int getPapersCount(){
		return papersId.size();
	}
	
	public Set<IdRecord> getCollaborators() {
		return collaborators;
	}
	
	public int getCollaboratorsCount(){
		return collaborators.size();
	}
	
	public Set<IdRecord> getChilds() {
		return childs;
	}
	
	public int getChildsCount(){
		return childs.size();
	}
	
	public Set<IdRecord> getParents() {
		return parents;
	}
	
	public int getParentsCount(){
		return parents.size();
	}
	
	public int getCitationIndex() {
		return citationIndex;
	}
	
	@Override
	public String toString() {
		return "Author [id=" + super.getId() + ", name=" + name + ", nameShort="
				+ nameShort + ", citationIndex=" + citationIndex + ", papersId="
				+ papersId + ", collaborators=" + collaborators + ", childs="
				+ childs + ", parents=" + parents + "]";
	}
	
	@Override
	public String createHTMLTooltip(){
		ToolTipBuilder builder = new ToolTipBuilder();
		builder.beginHTML();
		builder.appendTitle(name, getId());
		builder.newLine();
		builder.append("Publikací: " + papersId.size());
		builder.newLine();
		builder.append("Spolupracovníkù: " + collaborators.size());
		builder.newLine();
		builder.appendRefInfo(Localizer.getString("global.references"), getParentsCount(), Localizer.getString("global.citations"), getChildsCount());
		builder.endHTML();
		return builder.toString();
	}
}
