package com.springrestmvc.controller;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.validation.Errors;

import com.springrestmvc.model.Realm;
import com.springrestmvc.model.RealmRequest;
import com.springrestmvc.service.RealmBuilder;
import com.springrestmvc.service.RealmService;
import com.springrestmvc.service.ServiceFactory;

public class RealmControllerTest {

    private final Realm realm1 = createRealm();
    private final String NAME = "name";
    private final int ID = 1;
    private final String KEY1 = "key1";
    private final String DESCRIPTION = "description";

    @Mock
    ServiceFactory serviceFactory;

    @Mock
    RealmService realmServiceMock;

    @Mock
    RealmBuilder realmBuilderMock;

    @Mock
    Errors errorsMock;

    @InjectMocks
    RealmController controller;

    private final RealmRequest request = new RealmRequest(NAME, DESCRIPTION);

    @Before
    public void setUp() {
	MockitoAnnotations.initMocks(this);
	when(serviceFactory.createRealmService()).thenReturn(realmServiceMock);
	when(serviceFactory.createRealmBuilder()).thenReturn(realmBuilderMock);
	when(realmServiceMock.getRealm("1")).thenReturn(realm1);
	when(realmBuilderMock.buildRealm(request)).thenReturn(realm1);
    }

    @Test
    public void testGetRealm() {
	final Realm realmResponse = controller.getRealm("1").getBody();
	assertEquals(realmResponse, realm1);
    }

    @Test
    public void tesCreateRealm() {
	final Realm realmResponse = controller.addRealm(request, errorsMock).getBody();
	assertEquals(realmResponse, realm1);
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
