package ct.dp.RestClient;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import org.springframework.http.HttpEntity;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;
import ct.dp.entity.PizzaOrderEntity;

public class RestClient {
	private static String Update_Info = "http://localhost:9191/update/";

	private static final String Get_Info = "http://localhost:9191/pizzalist";

	static RestTemplate restTemplate = new RestTemplate();

	public static void main(String[] args) {
		updatePizza(); 
		getPizza();
		
	}

	public static void getPizza() {

		org.springframework.http.HttpHeaders headers = new org.springframework.http.HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity("parameters", headers);
		String result = restTemplate.getForObject(Get_Info, String.class); // restTemplate.exchange(Get_Info,
																			// HttpMethod.GET, entity, String.class);
		System.out.print(result);
	}
	private static void updatePizza() {
	
  	  Map<String, Integer> param=new HashMap();
  	  param.put("orderId", 5001);
  	  PizzaOrderEntity updatePizza=new PizzaOrderEntity(5001 ,1001, "Aadhar", "1234567890", 250.00,2);
  	restTemplate.put(Update_Info+"5001", updatePizza, param);
    }
}
	




