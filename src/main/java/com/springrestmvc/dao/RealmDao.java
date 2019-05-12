package com.springrestmvc.dao;

import java.util.Optional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.springrestmvc.model.Realm;

@Repository
@Transactional
public class RealmDao {

    @Autowired
    private SessionFactory sessionFactory;

    public Optional<Realm> getRealm(final int id) {
	return Optional.ofNullable(sessionFactory.getCurrentSession().get(Realm.class, id));
    }

    public void saveRealm(final Realm realm) {
	sessionFactory.getCurrentSession().save(realm);
    }
}
