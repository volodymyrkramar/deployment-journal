package com.dev.deploymentjournal.exception;

public class DateFormatExceptionResponse {

    private String date;

    public DateFormatExceptionResponse(String date) {
        this.date = date;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

}
