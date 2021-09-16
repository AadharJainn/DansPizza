package ct.dp.RestClient;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.node.ObjectNode;

import ct.dp.business.bean.PizzaOrderBean;
import ct.dp.business.bean.UpdatePizzaOrderBean;
import ct.dp.entity.PizzaOrderEntity;

public class RestClient {
	private static String Update_Info = "http://localhost:9191/update/";

	private static final String Get_Info = "http://localhost:9191/pizzalist";

	static RestTemplate restTemplate = new RestTemplate(new HttpComponentsClientHttpRequestFactory());

	public static void main(String[] args) throws IOException {

		getPizza();
	}

	public static void getPizza() {

		org.springframework.http.HttpHeaders headers = new org.springframework.http.HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		@SuppressWarnings("unused")
		HttpEntity<String> entity = new HttpEntity("parameters", headers);
		String result = restTemplate.getForObject(Get_Info, String.class);
		System.out.print(result);
	}

	public UpdatePizzaOrderBean tryUpdate(UpdatePizzaOrderBean updatePizzaOrderBean) {
		final HttpEntity<UpdatePizzaOrderBean> requestEntity = new HttpEntity(updatePizzaOrderBean);
		ResponseEntity<Void> responseEntity = restTemplate.exchange(Update_Info + updatePizzaOrderBean.getOrderId(),
				HttpMethod.PATCH, requestEntity, Void.class);
		return updatePizzaOrderBean;
	}

}
