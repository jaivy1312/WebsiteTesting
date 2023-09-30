package resources;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Charsets;

public class UtilityToReadJson {
	
	
	public List<HashMap<String,String>> getJsonDataToMap(String path) throws IOException
	{	//will convert json to string
		String json=FileUtils.readFileToString(new File(path),StandardCharsets.UTF_8);
		//convert string to hashmap first add dependency jackson databind and then use objectmapper class
		
		ObjectMapper mapper= new ObjectMapper();
		
		List<HashMap<String,String>> data=mapper.readValue(json, new TypeReference<List<HashMap<String,String>>>(){});	
		return data;
	}

}
