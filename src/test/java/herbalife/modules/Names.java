package herbalife.modules;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
public class Names {
    private English english;
    private Local local;
    
	public English getEnglish() {
		return english;
	}
	
	public void setEnglish(English english) {
		this.english = english;
	}
	
	public Local getLocal() {
		return local;
	}
	
	public void setLocal(Local local) {
		this.local = local;
	}

}
