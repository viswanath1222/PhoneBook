package com.vi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.vi.dao.ContactRepo;
import com.vi.entity.Contact;





@Service
public class ContactServiceImpl implements ContactService {

	@Autowired()
	private ContactRepo contactRepo;

	@Override
	public Boolean saveContact(Contact c) {

		Contact con = contactRepo.save(c);
		if (con == null) {
			return false;
		} else {
			return true;
		}

	}

	@Override
	public List<Contact> viewAllContacts() {

		return contactRepo.findAll();

	}

	@Override
	public Contact editContact(int id) {
		Contact c = contactRepo.getById(id);

		return c;

	}

	@Override
	public Boolean deleteContact(int id) {
		Contact c = contactRepo.getById(id);
		/*
		 * try { contactRepo.deleteById(id); } catch (Exception e) {
		 * 
		 * e.getMessage(); return false; }
		 */

		c.setIsActive("N");

		contactRepo.save(c);

		return true;
	}

	@Override
	public Page<Contact> viewAllContactsNew(Integer pageNo, Integer pageSize) {
		Contact contactFilter = new Contact();
		contactFilter.setIsActive("Y");

		Example<Contact> example = Example.of(contactFilter);
		PageRequest pageRequest = PageRequest.of(pageNo, pageSize);

		return contactRepo.findAll(example, pageRequest);
		
	}
	@Override
	public boolean isContactExists(Contact contact) {
		Example<Contact> example = Example.of(contact);
		return contactRepo.exists(example);
		
	}

	
}
