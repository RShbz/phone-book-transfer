package com.contactphone.config;

import java.util.HashSet;
import java.util.Set;

import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.contactphone.dto.request.AddContactRequest;
import com.contactphone.dto.response.AddContactResponse;
import com.contactphone.dto.response.findByContactNameAndLastNameResponse;
import com.contactphone.dto.response.getContactResponse;
import com.contactphone.entity.Contact;
import com.contactphone.entity.Phone;

/**
 * @author Remzi ŞAHBAZ
 *
 */
@Configuration
public class ModelMapperConfiguration {

	public static final Converter<AddContactRequest, Contact> AddContactRequest_Convert_To_Contact = (context) -> {

		var request = context.getSource();
		var contact = new Contact();
		
		var phone= new Phone();
			phone.setValue(request.getPhone());
			
		contact.setLastName(request.getLastName());
		contact.setName(request.getName());
		//contact.setPhone(phone);
		return contact;
	};
	public static final Converter<AddContactRequest, AddContactResponse> AddContactRequest_Convert_To_Response = (context) -> {
		
		var request = context.getSource();
		var response = new AddContactResponse();
		
		response.setLastName(request.getLastName());
		response.setName(request.getName());
		var phones = request.getPhone();

		return response;
	};


	public static final Converter<Contact, AddContactResponse> Contact_Convert_To_ContactResponse = (context) -> {
		
		var contact = context.getSource();
		
		var response = new AddContactResponse();
		
		response.setLastName(contact.getLastName());
		response.setName(contact.getName());
		response.setPhone(contact.getPhone());
		
		return response;
	};
	public static final Converter<Contact, getContactResponse> Contact_Convert_To_getContactResponse = (context) -> {
		
		var contact = context.getSource();
		
		var response = new getContactResponse();
		
		response.setLastName(contact.getLastName());
		response.setName(contact.getName());
		
		Set<String> phones=new HashSet();
		phones.addAll(contact.getPhone().stream().map(p->{ return p.getValue();}).toList());
		response.setPhone(phones);
		
		return response;
	};
	public static final Converter<Contact, findByContactNameAndLastNameResponse> Contact_Convert_To_findByContactNameAndLastNameResponse = (context) -> {
		
		var contact = context.getSource();
		var response = context.getDestination();
		
		response.setContactid(contact.getId());
		
		var phones = contact.getPhone()
				.stream()
				.map(p->{
					
					var phone= new Phone();
					phone.setValue(p.getValue());
					
					return phone;
				})
				.toList();
				
		
		response.setPhoneId(3l);
		return response;
	};
	
	
	@Bean("modelMapperForCantact")
	public ModelMapper mapper() {
		
		var mapper= new ModelMapper();
		mapper.addConverter(AddContactRequest_Convert_To_Contact,AddContactRequest.class,Contact.class);
		mapper.addConverter(AddContactRequest_Convert_To_Response,AddContactRequest.class,AddContactResponse.class);
		mapper.addConverter(Contact_Convert_To_ContactResponse,Contact.class,AddContactResponse.class);
		mapper.addConverter(Contact_Convert_To_getContactResponse,Contact.class,getContactResponse.class);
		mapper.addConverter(Contact_Convert_To_findByContactNameAndLastNameResponse,Contact.class,findByContactNameAndLastNameResponse.class);
		
		return mapper;
	}
}
