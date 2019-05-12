package com.springrestmvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springrestmvc.model.Realm;
import com.springrestmvc.model.RealmRequest;

@Service
public class RealmBuilder {

    @Autowired
    private KeyGeneratorService keyGeneratorService;

    public Realm buildRealm(final RealmRequest realmRequest) {
	return new Realm(realmRequest.getName(), realmRequest.getDescription(), keyGeneratorService.generateKey());
    }

}
