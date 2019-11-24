package cz.uhk.fim.citeviz.gui.components;

import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class Localizer {
	private static final ResourceBundle RESOURCE = ResourceBundle.getBundle("messages");
	
	public static String getString(String key){
		String message = "??? " + key + " ???";
        
        try {
            message = RESOURCE.getString(key);
        } catch (Exception e){};
        
        
        return message;
	}
	
	public static String getString(String key, String... params){
		String message = getString(key);
		
		for (int i = 0; i < params.length; i++) {
			if (message.contains("{" + i + "}")){
				message = message.replace("{" + i + "}", params[i]);
			}
		}
		return message;
	}
	
	public static String[] getStrings(String... keys){
		List<String> result = new ArrayList<>(keys.length);
		for (String key : keys) {
			result.add(getString(key));
		}
		
		return result.toArray(new String[0]);
	}
	
	public static String localizeEnum(Class<?> enumClass, String name){
		StringBuilder builder = new StringBuilder();
		builder.append("enum.");
		builder.append(enumClass.getSimpleName());
		builder.append(".");
		builder.append(name);
		return Localizer.getString(builder.toString());
	}
}
