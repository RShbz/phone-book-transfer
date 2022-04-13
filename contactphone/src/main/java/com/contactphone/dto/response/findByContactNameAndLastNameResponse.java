package com.contactphone.dto.response;

import java.util.Objects;

public class findByContactNameAndLastNameResponse {

	private Long contactId;
	private Long phoneId;
	
	
	public findByContactNameAndLastNameResponse() {
	}
	public Long getContactid() {
		return contactId;
	}
	public void setContactid(Long contactid) {
		this.contactId = contactid;
	}
	public Long getPhoneId() {
		return phoneId;
	}
	public void setPhoneId(Long phoneId) {
		this.phoneId = phoneId;
	}
	@Override
	public int hashCode() {
		return Objects.hash(contactId, phoneId);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		findByContactNameAndLastNameResponse other = (findByContactNameAndLastNameResponse) obj;
		return Objects.equals(contactId, other.contactId) && Objects.equals(phoneId, other.phoneId);
	}
	@Override
	public String toString() {
		return "Contact Id [contactid=" + contactId + ", phoneId=" + phoneId + "]";
	}
	
	
}
