package com.mycompany.crudmem.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.RedirectView;

import com.mycompany.crudmem.LongProcess;
import com.mycompany.crudmem.model.Client;
import com.mycompany.crudmem.service.ClientService;

/**
 * @author Leonid Ivanov
 */
@Controller
@RequestMapping("/edit_client")
public class EditController {

	@Autowired
	ClientService service;

	@RequestMapping(params = "save", method = RequestMethod.POST)
	public RedirectView save(@Valid Client c, BindingResult bindingResult, Model model) {
		if (LongProcess.isLongProcessWork()) {
			return new RedirectView("/wait", true);
		}

		System.out.println("save editing id=" + c.id_client);
		this.service.editClient(c);
		return new RedirectView("/", true);
	}

	@RequestMapping(params = "cancel", method = RequestMethod.POST)
	public RedirectView cancel() {
		System.out.println("cancel");
		return new RedirectView("/", true);
	}
}
