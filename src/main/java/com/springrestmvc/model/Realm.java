package com.springrestmvc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

@Entity(name = "Realm")
@XmlRootElement(name = "realm")
public class Realm {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(unique = true)
    private String name;
    private String description;
    private String key;

    public Realm(final String name, final String description, final String key) {
	this.name = name;
	this.description = description;
	this.key = key;
    }

    public Realm() {
    }

    public int getId() {
	return id;
    }

    public void setId(final int id) {
	this.id = id;
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

    public String getKey() {
	return key;
    }

    public void setKey(final String key) {
	this.key = key;
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + (description == null ? 0 : description.hashCode());
	result = prime * result + id;
	result = prime * result + (key == null ? 0 : key.hashCode());
	result = prime * result + (name == null ? 0 : name.hashCode());
	return result;
    }

    @Override
    public boolean equals(final Object obj) {
	if (this == obj) {
	    return true;
	}
	if (obj == null) {
	    return false;
	}
	if (getClass() != obj.getClass()) {
	    return false;
	}
	final Realm other = (Realm) obj;
	if (description == null) {
	    if (other.description != null) {
		return false;
	    }
	} else if (!description.equals(other.description)) {
	    return false;
	}
	if (id != other.id) {
	    return false;
	}
	if (key == null) {
	    if (other.key != null) {
		return false;
	    }
	} else if (!key.equals(other.key)) {
	    return false;
	}
	if (name == null) {
	    if (other.name != null) {
		return false;
	    }
	} else if (!name.equals(other.name)) {
	    return false;
	}
	return true;
    }
}
