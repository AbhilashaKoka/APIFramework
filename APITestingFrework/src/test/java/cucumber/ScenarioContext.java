package cucumber;

import java.util.HashMap;
import java.util.Map;
import enums.Context;
import enums.DocumentType;


public class ScenarioContext {
	 
	private  Map<String, Object> scenarioContext;

	    public ScenarioContext(){
	        scenarioContext = new HashMap<>();
	    }

	    public void setContext(Context key, Object value) {
	        scenarioContext.put(key.toString(), value);
	    }

	    public Object getContext(Context key){
	        return scenarioContext.get(key.toString());
	    }

	    public Boolean isContains(Context key){
	        return scenarioContext.containsKey(key.toString());
	    }
	    public void setContext(DocumentType key, Object value) {
	    	scenarioContext.put(key.toString(), value);
	    }
	    public Object getContext(DocumentType key){
	        return scenarioContext.get(key.toString());
	    }
	    public Boolean isContains(DocumentType key){
	        return scenarioContext.containsKey(key.toString());
	    }
	    
	    

	    
}