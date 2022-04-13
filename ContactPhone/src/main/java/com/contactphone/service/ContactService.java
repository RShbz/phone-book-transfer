package com.contactphone.service;

import java.util.Optional;

import com.contactphone.dto.request.AddContactRequest;
import com.contactphone.dto.response.AddContactResponse;
import com.contactphone.dto.response.getContactResponse;

/**
 * @author Remzi ŞAHBAZ
 *
 */

public interface ContactService {

	 Optional<AddContactResponse> addContact(AddContactRequest request) ;
	 Optional<getContactResponse> getContact(String name,String lastName);
	
	
}
