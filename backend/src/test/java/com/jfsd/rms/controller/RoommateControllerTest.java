package com.jfsd.rms.controller;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.jfsd.rms.model.RMSResponseModel;
import com.jfsd.rms.model.Roommate;
import com.jfsd.rms.service.RoommateService;
import com.jfsd.rms.util.RMSException;

@RunWith(MockitoJUnitRunner.class)
public class RoommateControllerTest {
	
	@Mock
	RoommateService rmtService;
	
	@InjectMocks
	RoommateController rmtController;
	
	RMSResponseModel response;
	
	@Before
	public void setUp() throws Exception {
		response = new RMSResponseModel();
		response.setStatus(true);
	}

	@Test
	public void testAddRoommate() throws RMSException {
		response.setResult("Roommate ID '1' Created Successfully");
		when(rmtService.addRoommate(any())).thenReturn(response);
		assertEquals(true, rmtController.addRoommate(any()).isStatus());
	}
	
	@Test
	public void testAddRoommate_Exception() throws RMSException {
	    when(rmtService.addRoommate(any())).thenThrow(new RMSException("Test Exception"));
	    assertEquals(false, rmtController.addRoommate(any()).isStatus());
	    assertEquals("Error: Test Exception", rmtController.addRoommate(any()).getResult());
	}

	@Test
	public void testSearchRoommate() throws RMSException {
		when(rmtService.searchRoommate(anyInt())).thenReturn(response);
		assertEquals(true, rmtController.searchRoommate(1).isStatus());
	}
	
	@Test
	public void testSearchRoommate_Exception() throws RMSException {
	    when(rmtService.searchRoommate(1)).thenThrow(new RMSException("Test Exception"));
	    assertEquals(false, rmtController.searchRoommate(1).isStatus());
	    assertEquals("Error: Test Exception", rmtController.searchRoommate(1).getResult());
	}

	@Test
	public void testGetAllRoommates() throws RMSException {
		List<Roommate> rmtList = new ArrayList<Roommate>();
		rmtList.add(new Roommate());
		response.setResponseObject(rmtList);
		when(rmtService.getAllRoommates()).thenReturn(response);
		List<Roommate> rmtCache = (List<Roommate>) rmtController.getAllRoommates().getResponseObject();
		assertEquals(1, rmtCache.size());
	}
	
	@Test
	public void testGetAllRoommates_Exception() throws RMSException {
		when(rmtService.getAllRoommates()).thenThrow(new RMSException("Test Exception"));
		assertEquals(false, rmtController.getAllRoommates().isStatus());
	    assertEquals("Error: Test Exception", rmtController.getAllRoommates().getResult());
	}

	@Test
	public void testEditRoommate() throws RMSException {
		response.setResult("Roommate ID '1' Updated Successfully");
		when(rmtService.editRoommate(any())).thenReturn(response);
		assertEquals(true, rmtController.editRoommate(any()).isStatus());
	}
	
	@Test
	public void testEditRoommate_Exception() throws RMSException {
		when(rmtService.editRoommate(any())).thenThrow(new RMSException("Test Exception"));
		assertEquals(false, rmtController.editRoommate(any()).isStatus());
	    assertEquals("Error: Test Exception", rmtController.editRoommate(any()).getResult());
	}

	@Test
	public void testDeleteRoommate() throws RMSException {
		response.setResult("Roommate ID '1' Deleted Successfully");
		when(rmtService.deleteRoommate(anyInt())).thenReturn(response);
		assertEquals(true, rmtController.deleteRoommate(1).isStatus());
	}
	
	@Test
	public void testDeleteRoommate_Exception() throws RMSException {
		when(rmtService.deleteRoommate(anyInt())).thenThrow(new RMSException("Test Exception"));
		assertEquals(false, rmtController.deleteRoommate(1).isStatus());
		assertEquals("Error: Test Exception", rmtController.deleteRoommate(1).getResult());
	}
	
	@After
	public void tearDown() throws Exception {
		response = null;
	}

}
