package com.jfsd.rms.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.jfsd.rms.dao.RoommateDAO;
import com.jfsd.rms.model.RMSResponseModel;
import com.jfsd.rms.model.Roommate;
import com.jfsd.rms.util.RMSException;

@RunWith(MockitoJUnitRunner.class)
public class RoommateServiceTest {

	@Mock
	RoommateDAO rmtDao;
	
	@InjectMocks
	RoommateService rmtService;
	
	@Mock
	RMSResponseModel response;
	
	Roommate rmt;
	
	@Before
	public void setUp() throws Exception {
		rmt = new Roommate();
	}

	@Test
	public void testAddRoommate() throws RMSException {
		when(rmtDao.addRoommate(any())).thenReturn(response);
		assertEquals(true, (rmtService.addRoommate(rmt) != null));
	}

	@Test
	public void testSearchRoommate() throws RMSException {
		when(rmtDao.searchRoommate(anyInt())).thenReturn(response);
		assertEquals(true, (rmtService.searchRoommate(1) != null));
	}

	@Test
	public void testGetAllRoommates() throws RMSException {
		when(rmtDao.getAllRoommates()).thenReturn(response);
		assertEquals(true, (rmtService.getAllRoommates() != null));
	}

	@Test
	public void testEditRoommate() throws RMSException {
		when(rmtDao.editRoommate(any())).thenReturn(response);
		assertEquals(true, (rmtService.editRoommate(rmt) != null));
	}

	@Test
	public void testDeleteRoommate() throws RMSException {
		when(rmtDao.deleteRoommate(anyInt())).thenReturn(response);
		assertEquals(true, (rmtService.deleteRoommate(1) != null));
	}
	
	@After
	public void tearDown() throws Exception {
		rmt = null;
	}

}
