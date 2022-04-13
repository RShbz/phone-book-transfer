package com.contactphone.dto.request;

import java.util.List;
import java.util.Objects;

import com.contactphone.entity.Phone;

/**
 * @author Remzi ŞAHBAZ
 *
 */
public class AddContactRequest {

	
	private String name;
	private String lastName;
	private String phone;
	/**
	 * 
	 */
	public AddContactRequest() {
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}
	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}
	/**
	 * @param phone the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
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
		AddContactRequest other = (AddContactRequest) obj;
		return Objects.equals(lastName, other.lastName) && Objects.equals(name, other.name)
				&& Objects.equals(phone, other.phone);
	}
	@Override
	public String toString() {
		return "AddContactRequest [name=" + name + ", lastName=" + lastName + ", phone=" + phone + "]";
	}
	
	

}
