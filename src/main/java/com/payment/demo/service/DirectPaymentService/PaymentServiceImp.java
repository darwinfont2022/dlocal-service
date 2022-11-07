package com.payment.demo.service.DirectPaymentService;

import com.google.gson.Gson;
import com.payment.demo.clients.FeignClientDlocal;
import com.payment.demo.dtos.PaymentRequest;
import com.payment.demo.dtos.CurrencyExchangeDto;
import com.payment.demo.clients.model.response.PaymentMethod;
import com.payment.demo.dtos.DataDto;
import java.util.List;
import java.util.stream.Collectors;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class PaymentServiceImp implements PaymentService {
    private final FeignClientDlocal dlocalClient;

    public PaymentServiceImp(FeignClientDlocal dlocalClient) { this.dlocalClient = dlocalClient; }
    
    // Create payment
    public String createPayment(DataDto dataDto){
        //ModelMapper modelMapper = new ModelMapper();
        //System.out.println("Init Body Request");
        Gson gson = new Gson();
        //DataDto dataDto = gson.fromJson((String) data, DataDto.class);
        System.out.println("Token: " + dataDto.token + "\nIp: " + dataDto.ip);
        System.out.println();

        var body= PaymentRequest.createBodyRequest(dataDto);//Creando body request
        try {
            System.out.println(new Gson().toJson(body));
//            var result = dlocalClient.createPayment(new Gson().toJson(body));
//            System.out.println(result);
            return "";//result;
        } catch (Exception e) {
            System.out.println("Error creating payment: " + e.getMessage());
            return  (e.getMessage());
        }
    }

    public List<PaymentMethod> getMethods(String country, String type) {
        try {
            var methods = dlocalClient.getPaymentsMethods(country);
            //Filtrado de metodos por tipo CARD
            if(!type.isBlank()) {
                methods = methods.stream().filter(method -> method.getType().equals(type)).collect(Collectors.toList());
            }
            return methods;
        } catch (Exception e) {
            log.error("Error getting payments methods");
            return null;
        }
    }

    //Currency Exchanges
    public CurrencyExchangeDto getCurrencyExchanges(String from, String to) {
        return dlocalClient.currencyExchanges(from, to);
    }

    public Object geTOrderById(String order_id){
        try {
            return dlocalClient.getOrderById(order_id);
        } catch (Exception e) {
            System.out.println("Error getting payment order: " + e.getMessage());
            return e.getMessage();
        }
    }
    @Override
    public void payWithCardTocken() {

    }

    @Override
    public void payWithCardSaved() {

    }
}

/*
    String cuerpo = "{\n" +
            "    \"amount\": 399.80,\n" +
            "    \"currency\": \"USD\",\n" +
            "    \"country\": \"BR\",\n" +
            "    \"payment_method_id\": \"CARD\",\n" +
            "    \"payment_method_flow\": \"DIRECT\",\n" +
            "    \"payer\":{\n" +
            "        \"name\": \"Thiago Gabriel\",\n" +
            "        \"email\": \"thiago@example.com\",\n" +
            "        \"document\": \"53033315550\",\n" +
            "        \"user_reference\": \"12345\",\n" +
            "        \"phone\": \"5512345678901\",\n" +
            "        \"address\": {\n" +
            "            \"state\": \"Rio de Janeiro\",\n" +
            "            \"city\": \"Volta Redonda\",\n" +
            "            \"zip_code\": \"27275-595\",\n" +
            "            \"street\": \"Servidao B-1\",\n" +
            "            \"number\": \"1106\"\n" +
            "        },\n" +
            "        \"ip\" : \"179.27.83.210\",\n" +
            "        \"device_id\" : \"2fg3d4gf234\"\n" +
            "    },\n" +
            "    \"card\":{\n" +
            "        \"holder_name\": \"Thiago Gabriel\",\n" +
            "        \"number\": \"4111111111111111\",\n" +
            "        \"cvv\": \"123\",\n" +
            "        \"expiration_month\": 10,\n" +
            "        \"expiration_year\": 2040\n" +
            "    },\n" +
            "    \"order_id\": \"657434343\",\n" +
            "    \"notification_url\": \"http://merchant.com/notifications\",\n" +
            "    \"additional_risk_data\": {\n" +
            "        \"submerchant\": {\n" +
            "            \"merchant_reference\": \"12534\",\n" +
            "            \"name\": \"Submerchant name\",\n" +
            "            \"website\": \"https://www.submerchant.com\",\n" +
            "            \"industry\": 17,\n" +
            "            \"document\": \"15236713521\",\n" +
            "            \"nationality\": \"BR\",\n" +
            "            \"email\": \"submerchant@gmail.com\",\n" +
            "            \"username\": \"submerchant_username\",\n" +
            "            \"phone\": \"123456712345\",\n" +
            "            \"created_date\": \"20210311\"\n" +
            "        },\n" +
            "        \"shipping\": {\n" +
            "            \"address\": {\n" +
            "                \"state\": \"Montevideo\",\n" +
            "                \"city\": \"Montevideo\",\n" +
            "                \"zip_code\": \"11300\",\n" +
            "                \"street\": \"Avda. Brasil\",\n" +
            "                \"number\": \"1234 Ap. 501\"\n" +
            "            },\n" +
            "            \"cost\": 12.34,\n" +
            "            \"delivery_company\": \"FadEx\",\n" +
            "            \"method\": \"FREE\",\n" +
            "            \"is_forwarding_address\": false,\n" +
            "            \"geolocation\": \"-34.8798853,-56.1867859\"\n" +
            "        },\n" +
            "        \"beneficiary\": {\n" +
            "            \"email\": \"beneficiary@example.org\",\n" +
            "            \"name\": \"John Doe\",\n" +
            "            \"phone\": \"09671268364\",\n" +
            "            \"document\": \"513672561\"\n" +
            "        },\n" +
            "        \"basket\": [\n" +
            "            {\n" +
            "                \"unit_price\": 199.90,\n" +
            "                \"brand\": \"Smoogle\",\n" +
            "                \"category\": \"Smartphone\",\n" +
            "                \"item_reference\": \"SP-562138\",\n" +
            "                \"upc\": \"1758929364928\",\n" +
            "                \"manufacturer\": \"Smoogle\",\n" +
            "                \"product_name\": \"Pexel 25\",\n" +
            "                \"quantity\": 2,\n" +
            "                \"published_date\": \"20201113\",\n" +
            "                \"rating\": 4.5\n" +
            "            }\n" +
            "        ],\n" +
            "        \"payer\" : {\n" +
            "            \"email_is_valid\": true,\n" +
            "            \"phone_is_valid\": false,\n" +
            "            \"account_creation_date\": \"20201110\",\n" +
            "            \"first_purchase_date\": \"20201110\",\n" +
            "            \"is_positive\": false,\n" +
            "            \"total_order_count\": 12,\n" +
            "            \"total_order_amount\": 152.03\n" +
            "        },\n" +
            "        \"purchase\": {\n" +
            "            \"is_retry\": false\n" +
            "        },\n" +
            "        \"device\": {\n" +
            "            \"user_agent\": \"Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/86.0.4240.198 Safari/537.36\",\n" +
            "            \"geolocation\" : \"-34.8798853,-56.1867859\",\n" +
            "            \"locale\": \"en-US\",\n" +
            "            \"event_uuid\": \"ab825a72-62c3-4df5-9886-25c75856fac7\"\n" +
            "        }\n" +
            "     }\n" +
            "  }";
 */