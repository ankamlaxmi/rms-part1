package com.jfsd.rms.daoimpl;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.jfsd.rms.model.RMSResponseModel;
import com.jfsd.rms.model.Roommate;
import com.jfsd.rms.util.RMSException;

@RunWith(MockitoJUnitRunner.class)
public class RoommateCacheDAOImplTest {
	
	
	@Mock
	Roommate rmt;
	
	@InjectMocks
	RoommateCacheDAOImpl rmtDaoImpl;

	RMSResponseModel response;
	
	@Before
	public void setUp() throws Exception {
		response = new RMSResponseModel();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testAddRoommate() throws RMSException {
		assertTrue(rmtDaoImpl.addRoommate(rmt).isStatus());
	}

	@Test
	public void testEditRoommate() throws Exception {
		
		
	}

	@Test
	public void testDeleteRoommate() throws RMSException {
	}

	@Test
	public void testSearchRoommate() throws RMSException {
	}

	@Test
	public void testGetAllRoommates() throws RMSException {
	}

}
