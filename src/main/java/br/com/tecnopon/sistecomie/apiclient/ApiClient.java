package br.com.tecnopon.sistecomie.apiclient;

import br.com.tecnopon.sistecomie.apiclient.model.request.customer.FilterName;
import br.com.tecnopon.sistecomie.apiclient.model.request.customer.Param;
import br.com.tecnopon.sistecomie.apiclient.model.request.customer.Request;
import br.com.tecnopon.sistecomie.apiclient.model.response.customer.Response;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ApiClient {

    String apiUrl = "https://app.omie.com.br/api/v1/geral/clientes/";
    String employerIdentificationNumber;

    RestTemplate restTemplate = new RestTemplate();

    HttpHeaders headers = new HttpHeaders();

    public Response requestCustomer(String employerIdentificationNumber) {
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

        FilterName filterName = new FilterName(employerIdentificationNumber);

        Param param = new Param(filterName);

        List<Param> listOfParameters = new ArrayList<>();
        listOfParameters.add(param);

        Request request = new Request("ListarClientesResumido", "1560731700", "226dcf372489bb45ceede61bfd98f0f1", listOfParameters);

        ObjectMapper om = new ObjectMapper();

        String requestJson = null;
        try {
            requestJson = om.writeValueAsString(request);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        HttpEntity<String> httpEntity = new HttpEntity<>(requestJson, headers);

        ResponseEntity<String> responseEntity = restTemplate.postForEntity(apiUrl, httpEntity, String.class);

        if (responseEntity.getStatusCode() == HttpStatus.OK) {
            try {
                return new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false).readValue(responseEntity.getBody(), Response.class);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Request Failed");
            System.out.println(responseEntity.getStatusCode());
        }
        return null;
    }

}
