/**
 * 
 */
package com.contactphone.entity;

import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


/**
 * @author Remzi ŞAHBAZ
 *
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "phones")
public class Phone implements java.io.Serializable{

	/**
	 * 
	 */
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String value;
	
	@ManyToOne(cascade = CascadeType.PERSIST , fetch = FetchType.LAZY ,optional = false)
	@JsonIgnore
	private Contact contact;
	
	
	/**
	 * 
	 */
	public Phone() {
	}


	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}


	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}


	/**
	 * @return the value
	 */
	public String getValue() {
		return value;
	}


	/**
	 * @param value the value to set
	 */
	public void setValue(String value) {
		this.value = value;
	}


	/**
	 * @return the contact
	 */
	public Contact getContact() {
		return contact;
	}


	/**
	 * @param contact the contact to set
	 */
	public void setContact(Contact contact) {
		this.contact = contact;
	}


	@Override
	public int hashCode() {
		return Objects.hash(id, value);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Phone other = (Phone) obj;
		return Objects.equals(id, other.id) && Objects.equals(value, other.value);
	}


	@Override
	public String toString() {
		return " *************"+ value ;
	}
	
	
	
}
