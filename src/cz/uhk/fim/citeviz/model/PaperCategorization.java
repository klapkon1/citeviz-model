package cz.uhk.fim.citeviz.model;

import cz.uhk.fim.citeviz.gui.components.Localizer;

public enum PaperCategorization {
	NONE,
	YEAR,
	CHILDS,
	PARENTS,
	CITATION_INDEX,
	PROVIDER_CATEGORY_0,
	PROVIDER_CATEGORY_1,
	PROVIDER_CATEGORY_2,
	PROVIDER_CATEGORY_3,
	PROVIDER_CATEGORY_4,
	PROVIDER_CATEGORY_5,
	PROVIDER_CATEGORY_6,
	PROVIDER_CATEGORY_7;
	
	public String toString() {
		return Localizer.localizeEnum(getClass(), name());	
	}
}
