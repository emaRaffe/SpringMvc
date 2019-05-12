package com.springrestmvc.controller;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "error")
public class ErrorDetails {

    private String code;

    public ErrorDetails() {
    }

    public ErrorDetails(final String code) {
	super();
	this.code = code;
    }

    public String getCode() {
	return code;
    }

    public void setCode(final String code) {
	this.code = code;
    }
}
