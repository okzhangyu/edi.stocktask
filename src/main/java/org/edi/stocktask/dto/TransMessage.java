package org.edi.stocktask.dto;

import java.util.List;

/**
 * Created by asus on 2018/8/18.
 */
public class TransMessage implements ITransMessage {
    private String code;
    private String message;


    @Override
    public String getCode() {
        return code;
    }

    @Override
    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public void setMessage(String message) {
        this.message = message;
    }


}
