package ct.dp.RestClient;

import java.util.Arrays;
import org.springframework.http.HttpEntity;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;
import ct.dp.entity.PizzaOrderEntity;

public class RestClient {
	private static String Update_Info = "http://localhost:8080/update/";

	private static final String Get_Info = "http://localhost:8080/pizzalist";

	static RestTemplate restTemplate = new RestTemplate();

	public static void main(String[] args) {

		getPizza(); 
		useExchangeMethod();
	}

	public static void getPizza() {

		org.springframework.http.HttpHeaders headers = new org.springframework.http.HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity("parameters", headers);
		String result = restTemplate.getForObject(Get_Info, String.class); // restTemplate.exchange(Get_Info,
																			// HttpMethod.GET, entity, String.class);
		System.out.print(result);
	}

	private static void useExchangeMethod() {

		org.springframework.http.HttpHeaders headers = new org.springframework.http.HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		HttpEntity<PizzaOrderEntity> requestEntity = new HttpEntity(headers);
		PizzaOrderEntity pizzaOrderEntity = new PizzaOrderEntity();
		/* pizzaOrderEntity.setOrderId(5002); */
		pizzaOrderEntity.setPizzaId(1001);
		pizzaOrderEntity.setCustomerName("Ross");
		pizzaOrderEntity.setContactNumber("1234567809");
		pizzaOrderEntity.setBill(250.00);
		pizzaOrderEntity.setNumberOfPiecesOrdered(5);

		callUpdate(requestEntity);

	}

	private static void callUpdate(HttpEntity<PizzaOrderEntity> requestEntity) {
		restTemplate.put(Update_Info + "5002", requestEntity);
	}
}

/*
 * ; org.springframework.http.HttpHeaders headers = new
 * org.springframework.http.HttpHeaders();
 * headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
 * 
 * HttpEntity<String> entity = new HttpEntity("parameters", headers);
 * ResponseEntity<String> result = restTemplate.exchange(Update_Info,
 * HttpMethod.PUT, entity, String.class); System.out.print(result);
 */

/*
 * MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter = new
 * MappingJackson2HttpMessageConverter();
 * mappingJackson2HttpMessageConverter.setSupportedMediaTypes(Arrays.asList(
 * MediaType.APPLICATION_JSON, MediaType.APPLICATION_OCTET_STREAM));
 * restTemplate.getMessageConverters().add(mappingJackson2HttpMessageConverter);
 * 
 * PizzaOrderEntity pizzaOrderEntity = new PizzaOrderEntity();
 * pizzaOrderEntity.setOrderId(5001);
 * pizzaOrderEntity.setCustomerName("Aadhar");
 * pizzaOrderEntity.setContactNumber("1234567809");
 * restTemplate.put(Update_Info, pizzaOrderEntity);
 */

/*
 * Map<String, Integer> param = new HashMap(); param.put("orderId", 5001);
 * PizzaOrderEntity pizzaOrderEntity = new PizzaOrderEntity(1001, "aadhar",
 * "1234567890", 250.00, 3); restTemplate.put(Update_Info, pizzaOrderEntity,
 * param);
 */
/*
 * @RequestMapping(path="template/update/{orderId}", method =
 * RequestMethod.PATCH) public String templatePizza(@RequestBody
 * updatePizzaEntity updatePizza, @PathVariable String orderId) { HttpHeaders
 * headers = new HttpHeaders();
 * headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
 * HttpEntity<updatePizzaEntity> entity= new
 * HttpEntity<updatePizzaEntity>(updatePizza, headers); return
 * restTemplate.exchange( "http://localhost:8080/update/"+orderId,
 * HttpMethod.PATCH, entity, String.class).getBody(); }
 */

/*
 * public static void callUpdate() { org.springframework.http.HttpHeaders header
 * = new org.springframework.http.HttpHeaders();
 * header.setContentType(MediaType.APPLICATION_JSON);
 * HttpEntity<PizzaOrderEntity> requestEntity = new HttpEntity(header);
 * ResponseEntity<String> responseEntity = restTemplate.exchange(Update_Info +
 * "5001", HttpMethod.PUT, requestEntity, String.class); HttpStatus httpStatus =
 * responseEntity.getStatusCode(); System.out.println("Status code: " +
 * httpStatus); String orderEntity = responseEntity.getBody();
 * System.out.println("response body: " + orderEntity);
 * org.springframework.http.HttpHeaders responseHeader =
 * responseEntity.getHeaders(); System.out.println("Response headers " +
 * responseHeader); PizzaOrderEntity pizzaOrderEntity = new PizzaOrderEntity();
 * pizzaOrderEntity.setOrderId(5001);
 * pizzaOrderEntity.setCustomerName("Aadhar");
 * pizzaOrderEntity.setContactNumber("1234567809");
 * 
 * }
 */
