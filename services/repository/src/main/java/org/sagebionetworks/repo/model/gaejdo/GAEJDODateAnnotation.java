package org.sagebionetworks.repo.model.gaejdo;

import java.util.Date;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import com.google.appengine.api.datastore.Key;

@PersistenceCapable(detachable = "true")
public class GAEJDODateAnnotation implements GAEJDOAnnotation<Date> {
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private Key id;

	// @Persistent
	// private GAEJDOAnnotations owner; // this is the backwards pointer for the
	// 1-1 owned relationship

	@Persistent
	private String attribute;

	// @Persistent
	// @Extension(vendorName = "datanucleus", key = "implementation-classes",
	// value =
	// "String,Integer,com.google.appengine.api.datastore.Text,Boolean,Float,java.util.Date")
	private Date value;

	public GAEJDODateAnnotation() {
	}

	public GAEJDODateAnnotation(String attr, Date value) {
		setAttribute(attr);
		setValue(value);
	}

	public Key getId() {
		return id;
	}

	public void setId(Key id) {
		this.id = id;
	}

	// public GAEJDOAnnotations getOwner() {
	// return owner;
	// }
	//
	// public void setOwner(GAEJDOAnnotations owner) {
	// this.owner = owner;
	// }

	public String getAttribute() {
		return attribute;
	}

	public void setAttribute(String attribute) {
		this.attribute = attribute;
	}

	public Date getValue() {
		return value;
	}

	public void setValue(Date value) {
		this.value = value;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((attribute == null) ? 0 : attribute.hashCode());
		result = prime * result + ((value == null) ? 0 : value.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GAEJDODateAnnotation other = (GAEJDODateAnnotation) obj;
		if (attribute == null) {
			if (other.attribute != null)
				return false;
		} else if (!attribute.equals(other.attribute))
			return false;
		if (value == null) {
			if (other.value != null)
				return false;
		} else if (!value.equals(other.value))
			return false;
		return true;
	}

}
