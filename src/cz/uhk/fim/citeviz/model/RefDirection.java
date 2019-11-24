package cz.uhk.fim.citeviz.model;

import cz.uhk.fim.citeviz.gui.components.Localizer;

public enum RefDirection {
	CITATION,
	REFERENCE;
	
	
	public String toString() {
		return Localizer.localizeEnum(getClass(), name());
	};
	
}