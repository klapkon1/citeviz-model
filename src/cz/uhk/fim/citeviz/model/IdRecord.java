package cz.uhk.fim.citeviz.model;

import java.io.Serializable;

import cz.uhk.fim.citeviz.graph.builder.ToolTipBuilder;

public class IdRecord implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private final String id;
	
	public IdRecord(String id) {
		super();
		this.id = id;
	}

	public String getId() {
		return id;
	}
	
	public int getNumericId(){
		return id.hashCode();
	}
	
	public String getCaption(){
		return id;
	}
	
	public String getLongCaption(){
		return id;
	}
	
	public String createHTMLTooltip(){
		ToolTipBuilder builder = new ToolTipBuilder();
		builder.beginHTML();
		builder.appendTitle(id, null);
		
		builder.endHTML();
		return builder.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		IdRecord other = (IdRecord) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return id;
	}
}
