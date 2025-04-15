package com.udea.bancoudea.response;

public class TransactionResponse<T> {
    private T data;
    private String errorMessage;
    private boolean success;

    public TransactionResponse(T data){
        this.data = data;
        this.success = true;
    }

    public TransactionResponse(String errorMessage){
        this.errorMessage = errorMessage;
        this.success = false;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }



}
