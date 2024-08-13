package com.william.crm.clients.crm_clients.dtos;

import java.util.Date;

public class HandlerExceptionDto {

    String typeOfError;
    String message;
    Integer status;
    Date date;
    public String getTypeOfError() {
        return typeOfError;
    }
    public void setTypeOfError(String typeOfError) {
        this.typeOfError = typeOfError;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public Integer getStatus() {
        return status;
    }
    public void setStatus(Integer status) {
        this.status = status;
    }
    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }

    
}
