package com.payment.demo.status;

import java.util.HashMap;
import java.util.Map;

public class Status {
    private Map<String, String> status;

    public Status(){
        status = new HashMap<>();
        status.put("PENDING", "Oreden pendiente a pagar");
        status.put("PAID", "Orden pagada");
        status.put("REJECTED", "Orden rechasada");
        status.put("CANCELLED", "Orden cancelada");
        status.put("EXPIRED", "Orden EXPIRED");
        status.put("AUTHORIZED", "Orden de pago authorizada");
        status.put("VERIFIED", "Orden verific");
    }
    public String hasStatus(String statusName) { return status.get(statusName); }
    public static String getStatus(String statusName){
        Status status = new Status();
        return status.hasStatus(statusName);
    }
}
