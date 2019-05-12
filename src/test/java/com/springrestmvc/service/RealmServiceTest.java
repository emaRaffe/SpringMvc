package com.springrestmvc.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.springrestmvc.dao.RealmDao;
import com.springrestmvc.exception.RealmNotFoundException;
import com.springrestmvc.model.Realm;

public class RealmServiceTest {

    private static final String NAME = "name";
    private static final int ID = 1;
    private static final String KEY1 = "key1";
    private static final String DESCRIPTION = "description";

    @InjectMocks
    private RealmService service;

    @Mock
    private RealmDao realmDaoMock;

    private final Realm realm = createRealm();

    @Before
    public void setUp() {
	MockitoAnnotations.initMocks(this);
	// when(keyGeneratorServiceMock.generateKey()).thenReturn(KEY_MOCK);
    }

    @Test
    public void testCreateRealm() {
	service.createRealm(realm);
	verify(realmDaoMock).saveRealm(realm);
    }

    @Test
    public void testGetRealm() {
	when(realmDaoMock.getRealm(1)).thenReturn(Optional.of(createRealm()));

	final Realm realm = service.getRealm("1");

	assertEquals(realm.getKey(), KEY1);
	assertEquals(realm.getName(), NAME);
	assertEquals(realm.getDescription(), DESCRIPTION);
	assertEquals(realm.getId(), ID);
    }

    @Test(expected = RealmNotFoundException.class)
    public void testGetRealmNotFound() {
	when(realmDaoMock.getRealm(1)).thenReturn(Optional.ofNullable(null));
	service.getRealm("1");
    }

    private Realm createRealm() {
	final Realm realm = new Realm();
	realm.setDescription(DESCRIPTION);
	realm.setId(ID);
	realm.setKey(KEY1);
	realm.setName(NAME);
	return realm;
    }
}
