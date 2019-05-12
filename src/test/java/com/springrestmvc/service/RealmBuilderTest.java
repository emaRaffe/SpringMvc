package com.springrestmvc.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.springrestmvc.model.Realm;
import com.springrestmvc.model.RealmRequest;

public class RealmBuilderTest {

    private static final String DESCRIPTION = "description";
    private static final String NAME = "name";
    private static final String KEY_MOCK = "key mock";

    @InjectMocks
    private RealmBuilder builder;

    @Mock
    private KeyGeneratorService keyGeneratorServiceMock;
    RealmRequest request = new RealmRequest(NAME, DESCRIPTION);

    @Before
    public void setUp() {
	MockitoAnnotations.initMocks(this);
	when(keyGeneratorServiceMock.generateKey()).thenReturn(KEY_MOCK);
    }

    @Test
    public void testBuldRealm() {
	final Realm realm = builder.buildRealm(request);
	assertEquals(realm.getDescription(), DESCRIPTION);
	assertEquals(realm.getKey(), KEY_MOCK);
	assertEquals(realm.getName(), NAME);
    }
}
