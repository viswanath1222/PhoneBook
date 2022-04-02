package com.vi.controllers;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.servlet.ModelAndView;

import com.vi.entity.Contact;
import com.vi.service.ContactServiceImpl;



@Controller
public class ContactInfoController {

	@Autowired
	private ContactServiceImpl contactServiceImpl;

	@GetMapping(path = "/loadform")
	public ModelAndView loadForm() {
		ModelAndView mav = new ModelAndView();
		Contact c = new Contact();
		mav.addObject("contact", c);
		mav.setViewName("contact");
		return mav;

	}

	@PostMapping(path = "/save")
	public ModelAndView saveContact(@ModelAttribute("contact") Contact c) {
		ModelAndView mav = new ModelAndView();
		if (contactServiceImpl.isContactExists(c)) {
			mav.addObject("msg", "duplicate contact found");
			mav.setViewName("contact");
			return mav;

		} else {

			// System.out.println(c.getId());
			// System.out.println(c.getName());
			c.setIsActive("Y");
			boolean b = contactServiceImpl.saveContact(c);

			mav.setViewName("contact");
			if (b == true) {
				mav.addObject("msg", "Contact inserted successfully");
			}
			return mav;

		}
	}

	@GetMapping(path = "/viewAllContacts")
	public ModelAndView viewAllContacts() {
		List<Contact> list = contactServiceImpl.viewAllContacts();
		ModelAndView mav = new ModelAndView();
		ArrayList<Contact> cl = new ArrayList<Contact>();
		Iterator<Contact> it = list.iterator();
		while (it.hasNext()) {
			Contact c = it.next();
			// String s=c.getIsActive();
			// System.out.println(c.getIsActive());
			if (("Y").equalsIgnoreCase(c.getIsActive())) {

				cl.add(c);
			} else {

			}
		}

		// System.out.println(cl);
		mav.addObject(cl);

		mav.setViewName("viewAllContacts");
		return mav;

	}

	@GetMapping("/edit")
	public ModelAndView edit(@PathParam("id") String id) {
		int id1 = Integer.parseInt(id);
		Contact c = contactServiceImpl.editContact(id1);
		ModelAndView mav = new ModelAndView();
		mav.addObject("contact", c);
		mav.setViewName("contact");

		return mav;

	}

	@GetMapping("/delete")
	public ModelAndView delete(@PathParam("id") int id) {
		boolean b = contactServiceImpl.deleteContact(id);
		if (b == true) {
			List<Contact> list = contactServiceImpl.viewAllContacts();

			ModelAndView mav = new ModelAndView();
			ArrayList<Contact> cl = new ArrayList<Contact>();
			Iterator<Contact> it = list.iterator();
			while (it.hasNext()) {
				Contact c = it.next();
				if (c.getIsActive() == "Y") {

					cl.add(c);
				}
			}

			System.out.println(cl);
			mav.addObject(cl);

			mav.setViewName("viewAllContacts");
			return mav;

		}
		return null;
	}

	@GetMapping("viewAllContactsNew")
	public ModelAndView viewAllContactsNew(HttpServletRequest req) {
		Integer pageSize = 3;
		Integer pageNumber = 1;
		String reqParam = req.getParameter("pno");
		if (reqParam != null && !"".equals(reqParam)) {
			pageNumber = Integer.parseInt(reqParam);
			System.out.println("Pgno:" + pageNumber);
		}
		Page<Contact> page = contactServiceImpl.viewAllContactsNew(pageNumber - 1, pageSize);
		int totalPages = page.getTotalPages();
		List<Contact> allContacts = page.getContent();

		ModelAndView mav = new ModelAndView();
		mav.addObject("contactList", allContacts);
		mav.addObject("tp", totalPages);
		mav.addObject("currPno", pageNumber);
		mav.setViewName("viewAllContacts");
		return mav;

	}

}
