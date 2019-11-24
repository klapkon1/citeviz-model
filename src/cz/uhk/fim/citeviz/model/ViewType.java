package cz.uhk.fim.citeviz.model;

import cz.uhk.fim.citeviz.gui.components.Localizer;

public enum ViewType {

	PAPER_DETAIL,
	
	PAPER_TREE_VIEW,
	
	PAPER_CITATION_NETWORK,
	
	AUTHOR_DETAIL,
	
	AUTHOR_CITATION_NETWORK,
	
	AUTHOR_COLABORATORS;
	
	public String toString() {
		return Localizer.localizeEnum(getClass(), name());
	};
}