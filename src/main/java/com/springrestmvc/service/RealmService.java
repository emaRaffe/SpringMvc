package com.springrestmvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springrestmvc.dao.RealmDao;
import com.springrestmvc.exception.RealmNotFoundException;
import com.springrestmvc.model.Realm;

@Service
public class RealmService {

    @Autowired
    private RealmDao realmDao;

    public RealmService() {
    }

    public void createRealm(final Realm realm) {
	realmDao.saveRealm(realm);
    }

    public Realm getRealm(final String realmId) {
	return realmDao.getRealm(Integer.valueOf(realmId)).orElseThrow(RealmNotFoundException::new);
    }

}
