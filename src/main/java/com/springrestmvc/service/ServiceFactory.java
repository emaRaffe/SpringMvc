package com.springrestmvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceFactory {

    @Autowired
    private RealmService realmService;

    @Autowired
    private RealmBuilder realmBuilder;

    public RealmService createRealmService() {
	return realmService;
    }

    public RealmBuilder createRealmBuilder() {
	return realmBuilder;
    }
}
