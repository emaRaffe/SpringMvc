package com.springrestmvc.controller;

import java.util.logging.Logger;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springrestmvc.exception.RealmException;
import com.springrestmvc.model.Realm;
import com.springrestmvc.model.RealmRequest;
import com.springrestmvc.service.RealmService;
import com.springrestmvc.service.ServiceFactory;

@RestController
@RequestMapping(path = "/service/user/realm")
@Validated
public class RealmController {
    private final static Logger LOG = Logger.getLogger(RealmController.class.getName());

    @Autowired
    private ServiceFactory serviceFactory;

    @PostMapping("/")
    public ResponseEntity<Realm> addRealm(@Valid @RequestBody final RealmRequest realmRequest, final Errors errors) {
	if (errors.hasErrors()) {
	    if (errors.getFieldError("name") != null) {
		throw new RealmException();
	    }
	}

	final RealmService realmService = serviceFactory.createRealmService();
	final Realm realm = serviceFactory.createRealmBuilder().buildRealm(realmRequest);
	realmService.createRealm(realm);

	return ResponseEntity.ok().body(realm);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Realm> getRealm(@PathVariable("id") final String realmId) {
	final RealmService realmService = serviceFactory.createRealmService();
	return ResponseEntity.ok().body(realmService.getRealm(realmId));
    }
}