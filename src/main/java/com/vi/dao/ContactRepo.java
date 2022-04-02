package com.vi.dao;




import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.vi.entity.Contact;




@Repository
public interface ContactRepo extends JpaRepository<Contact, Integer> {

}
