package com.vi.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.vi.entity.Contact;



@Service
public interface ContactService {

	public Boolean saveContact(Contact c);

	public List<Contact> viewAllContacts();

	public Contact editContact(int id);

	public Boolean deleteContact(int id);

	public Page<Contact> viewAllContactsNew(Integer pageNo, Integer pageSize);

    public boolean isContactExists(Contact contact);
}
