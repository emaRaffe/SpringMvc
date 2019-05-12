package com.springrestmvc.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "realmResponse")
public class RealmsResponse implements Serializable {
    private static final long serialVersionUID = 1L;

    private List<Realm> realms;

    public RealmsResponse() {
    }

    public RealmsResponse(final List<Realm> realms) {
	super();
	this.realms = realms;
    }

    public List<Realm> getRealms() {
	if (realms == null) {
	    realms = new ArrayList<>();
	}
	return realms;
    }

    public void setRealms(final List<Realm> realms) {
	this.realms = realms;
    }
}
