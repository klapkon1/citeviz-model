package cz.uhk.fim.citeviz.graph.builder;

public class ToolTipBuilder {
	
	private StringBuilder builder = new StringBuilder();
	
	public void append(String s){
		builder.append(s);
	}
	
	public void appendTitle(String title, String id){
		beginBold();
		builder.append(title);
		
		if (id != null){
			builder.append(" (");
			builder.append(id);
			builder.append(")");
		}
		endBold();
	}
	
	public void beginBold(){
		builder.append("<b>");
	}
	
	public void endBold(){
		builder.append("</b>");
	}
	
	public void beginHTML(){
		builder.append("<html><body style=\"width: 200px; margin: 3px; padding: 0px; height: 100px;\">");
	}
	
	public void beginHTMLAutosized(){
		builder.append("<html><body style=\"margin: 3px; padding: 0px;\">");
	}
	
	
	public void endHTML(){
		builder.append("</body></html>");
	}
	
	public String toString(){
		return builder.toString();
	}

	public void newLine() {
		builder.append("<br>");
	}
	
	public void appendRefInfo(String parentLabel, int parents, String childLabel, int childs){
		builder.append("<center><span style=\"color:red; font-weight:bold;\">");
		builder.append(parentLabel);
		builder.append(parents);
		builder.append("</span>");
		builder.append("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
		builder.append("<span style=\"color:blue; font-weight:bold;\">");
		builder.append(childLabel);
		builder.append(childs);
		builder.append("</span></center>");
	}
}
