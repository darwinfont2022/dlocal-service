package com.payment.demo.config;

import com.google.gson.Gson;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorFormatDlocal {
    private String code;
    private String message;
    private String param;

    public static ErrorFormatDlocal getDlocalError(String error_mensage){
        var fragment = error_mensage.split("\\[\\{")[1].replace("]", "");//.getBytes(StandardCharsets.UTF_8);
        return new Gson().fromJson("{" + fragment, ErrorFormatDlocal.class);
    }
}
