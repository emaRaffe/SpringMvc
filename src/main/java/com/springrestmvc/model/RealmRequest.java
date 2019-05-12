package com.springrestmvc.model;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

@XmlRootElement(name = "realmRequest")
public class RealmRequest implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull(message = "Please provide first Name")
    @NotEmpty(message = "ddddd")
    @NotBlank(message = "ddddd")
    private String name;
    private String description;

    public RealmRequest() {
    }

    public RealmRequest(final String name, final String description) {
	this.name = name;
	this.description = description;
    }

    public String getName() {
	return name;
    }

    public void setName(final String name) {
	this.name = name;
    }

    public String getDescription() {
	return description;
    }

    public void setDescription(final String description) {
	this.description = description;
    }

}
