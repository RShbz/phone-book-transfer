package com.contactphone.dto.response;

import java.util.Objects;
import java.util.Set;

public class getContactResponse {

	private String name;
	private String lastName;
	private Set<String> phone;
	
	
	
	/**
	 * @return the phone
	 */
	public Set<String> getPhone() {
		return phone;
	}
	/**
	 * @param phone the phone to set
	 */
	public void setPhone(Set<String> phone) {
		this.phone = phone;
	}
	/**
	

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * 
	 */
	public getContactResponse() {
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}


	@Override
	public int hashCode() {
		return Objects.hash(lastName, name, phone);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		getContactResponse other = (getContactResponse) obj;
		return Objects.equals(lastName, other.lastName) && Objects.equals(name, other.name)
				&& Objects.equals(phone, other.phone);
	}
	@Override
	public String toString() {
		return "{ name=" + name + ", lastName=" + lastName + ", phone=[" + phone + "]}";
	}
	
}
