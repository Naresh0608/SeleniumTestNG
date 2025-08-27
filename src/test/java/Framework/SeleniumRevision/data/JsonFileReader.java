package Framework.SeleniumRevision.data;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonFileReader {
	
	
	public List<HashMap<String, String>> GetJsonData(String Filepath) throws IOException {
		
		String JsonContent = FileUtils.readFileToString(new File (System.getProperty("user.dir")+"\\src\\test\\java\\Framework\\SeleniumRevision\\data\\PurchaseProducts.json")
				,StandardCharsets.UTF_8);
		
		//Convert Json File to list of Multiple Maps
		ObjectMapper mapper = new ObjectMapper();
		
		List<HashMap<String,String>> data = mapper.readValue(JsonContent, new TypeReference<List<HashMap<String,String>>>() {
		
		
		});
		
		return data;	
		
	}

}
