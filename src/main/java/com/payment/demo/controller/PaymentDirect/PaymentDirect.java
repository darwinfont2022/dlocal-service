package com.payment.demo.controller.PaymentDirect;

import com.payment.demo.clients.model.response.PaymentMethod;
import com.payment.demo.clients.model.response.ResponsePayment;
import com.payment.demo.controller.PaymentDirect.dto.request.RequestPaymentCardInfoDto;
import com.payment.demo.controller.PaymentDirect.dto.request.RequestPaymentCardTokenDto;
import com.payment.demo.dtos.CurrencyExchangeDto;
import com.payment.demo.service.DirectPaymentService.CardToken.CardTokenServiceImp;
import com.payment.demo.service.DirectPaymentService.PaymentServiceImp;

import com.payment.demo.service.DirectPaymentService.WithCardInfo.WithInfoServiceImp;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("")
@CrossOrigin(origins = "*")
public class PaymentDirect {
    private final PaymentServiceImp service;
    private final WithInfoServiceImp withInfoService;

    private  final CardTokenServiceImp cardTokenService;

    public PaymentDirect(PaymentServiceImp service, WithInfoServiceImp withInfoService, CardTokenServiceImp cardTokenService){
        this.service = service;
        this.withInfoService = withInfoService;
        this.cardTokenService = cardTokenService;
    }
/*
Esta url se usa para pagos directos tengo que revisar los datos que se requieren para procesar el pagao
devido a que retorna un error en la data que se necesita. Principalmente en el token que crean los Smart Fields
de Dlocal
 */
//    @CrossOrigin(origins = "*")
//    @PostMapping(value = "/payments", produces = "application/json")
//    public ResponseEntity<String > createPayment(@RequestBody DataDto data){
//       return ResponseEntity.ok(service.createPayment(data));
//    }
    @CrossOrigin(origins = "*")
    @GetMapping(value = "/methods", produces = "application/json")
    public ResponseEntity<List<PaymentMethod>> getMethods(@RequestParam(name = "country", defaultValue = "UY") String country, @RequestParam(name = "type", defaultValue = "") String type){
        return ResponseEntity.ok(service.getMethods(country, type));
    }
    @CrossOrigin(origins = "*")
    @GetMapping(value = "/currency-exchange", produces = "application/json")
    public ResponseEntity<CurrencyExchangeDto> getCurrencyExchanges(@RequestParam(name = "from", defaultValue = "USD") String from, @RequestParam(name = "to", defaultValue = "UYU") String to){
        return ResponseEntity.ok(service.getCurrencyExchanges(from, to));
    }


    @PostMapping("/payments/cardInfo")
    public ResponseEntity<ResponsePayment> paymentsWithCardInfo(@RequestBody RequestPaymentCardInfoDto requestDto){
        return ResponseEntity.ok(this.withInfoService.payWithCardInfo(requestDto));
    }

    @PostMapping("/payments/cardToken")
    public ResponseEntity<ResponsePayment> paymentsWithCardToken(@RequestBody RequestPaymentCardTokenDto dto){
        return ResponseEntity.ok(this.cardTokenService.createPaymentWithCardToken(dto));
    }

    @PostMapping("/payments/cardSaved")
    public ResponseEntity<?> paymentsWithCardSaved(){
        return ResponseEntity.ok().build();
    }

    @PostMapping("/callback")
    public String collback(@RequestHeader Map<String, String> headers){
        //headers.forEach((key, value) -> {
          //  System.out.printf("Header '%s' = %s%n", key, value);
        //});

        System.out.println("Collback from dlocal");
        return "Redirecrt from dlocal \n";
    }


}
