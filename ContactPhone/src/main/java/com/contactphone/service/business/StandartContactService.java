package com.contactphone.service.business;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.contactphone.dto.request.AddContactRequest;
import com.contactphone.dto.response.AddContactResponse;
import com.contactphone.dto.response.getContactResponse;
import com.contactphone.entity.Contact;
import com.contactphone.entity.Phone;
import com.contactphone.repository.ContactRepository;
import com.contactphone.repository.PhoneRepository;
import com.contactphone.service.ContactService;

import antlr.collections.List;

/**
 * @author Remzi ŞAHBAZ
 *
 */
@Service
public class StandartContactService implements ContactService {

	private ModelMapper modelmapper;
	private ContactRepository contactRepository;
	private PhoneRepository phoneRepository;

	/**
	 * @param modelmapper
	 * @param contactRepository
	 * @param phoneRepository
	 */
	public StandartContactService(ModelMapper modelmapper, ContactRepository contactRepository,
			PhoneRepository phoneRepository) {
		this.modelmapper = modelmapper;
		this.contactRepository = contactRepository;
		this.phoneRepository = phoneRepository;
	}

	@Override
	public Optional<AddContactResponse> addContact(AddContactRequest request) {

		var existContact = contactRepository.findByNameAndLastName(request.getName(), request.getLastName());

		//var existphone= contactRepository.findByPhoneContaining(request.getPhone());
		
		
		if (!existContact.isEmpty()) {

			var existPhone = existContact.get().getPhone().stream().map(p -> {

				if (p.getValue() == request.getPhone()) {
					return true;
				}
				return Optional.empty();
			});
			
			Set<String> exist= new HashSet<>();
			
			exist.addAll(existContact.get().getPhone().stream().map(p-> { return p.getValue();}).toList());
			
			if (!exist.contains(request.getPhone())) {
				var phone = new Phone();
				//create new phone object , set string phone value
				phone.setValue(request.getPhone());
				//set contact in the found contact for new phone object
				phone.setContact(existContact.get());
				
				Set<Phone> newPhones = new HashSet<Phone>();
				// old phones
				newPhones.addAll(existContact.get().getPhone());
				// new phone
				newPhones.add(phone);
				existContact.get().setPhone(newPhones);

				System.out.println("exist--->"+existContact.get());
								contactRepository.save(existContact.get());
				return Optional.of(modelmapper.map(existContact.get(), AddContactResponse.class));
			}

		}

		else {
			try {
				var newContact = contactRepository.save(modelmapper.map(request, Contact.class));

				 System.out.println(modelmapper.map(newContact, AddContactResponse.class));
			//	return Optional.of(modelmapper.map(newContact, AddContactResponse.class));

			} catch (Exception e) {
				throw new IllegalAccessError();
			}
		}

		return Optional.empty();
	}

	@Override
	public Optional<getContactResponse> getContact(String name, String lastName) {
		var existContact = contactRepository.findByNameAndLastName(name, lastName);
		if (existContact != null) {

			System.out.println("found contact");
			return Optional.of(modelmapper.map(existContact.get(), getContactResponse.class));

		}
		return Optional.empty();
	}

}
