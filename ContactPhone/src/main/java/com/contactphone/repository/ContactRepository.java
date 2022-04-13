/**
 * 
 */
package com.contactphone.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.contactphone.entity.Contact;
import com.contactphone.entity.Phone;

/**
 * @author Remzi ŞAHBAZ
 *
 */
@Repository
public interface ContactRepository extends JpaRepository<Contact, Long>
{

	Optional<Contact> findByNameAndLastName(String name, String lastName);

	Optional<Contact> findByPhoneContaining(String phone);

	Object findByPhone(String phone);

}
