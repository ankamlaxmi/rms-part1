package com.jfsd.rms.daoimpl;

import java.util.ArrayList;
import java.util.List;

import com.jfsd.rms.dao.RoommateDAO;
import com.jfsd.rms.model.RMSResponseModel;
import com.jfsd.rms.model.Roommate;
import com.jfsd.rms.util.RMSException;

public class RoommateCacheDAOImpl implements RoommateDAO {

	private static List<Roommate> rmtCache = new ArrayList<Roommate>();
	private static Integer counter = Integer.valueOf(1);
	
	public RMSResponseModel addRoommate(Roommate rmt) throws RMSException {
		RMSResponseModel response = new RMSResponseModel();
		rmt.setNo(counter++);
		if(rmtCache.add(rmt)) {
			response.setStatus(true);
			response.setResult("Roommate ID '" + rmt.getNo() + "' Created Successfully");
		}
		return response;
	}

	public RMSResponseModel editRoommate(Roommate rmt) throws RMSException {
		RMSResponseModel response = new RMSResponseModel();
		if(rmtCache.contains(rmt)) {
			int rmtIndex = rmtCache.indexOf(rmt);
			rmtCache.set(rmtIndex, rmt);
			response.setStatus(true);
			response.setResult("Roommate ID '" + rmt.getNo() + "' Updated Successfully");
		}
		return response;
	}

	public RMSResponseModel deleteRoommate(int rmtNo) throws RMSException {
		RMSResponseModel response = searchRoommate(rmtNo);
		Roommate rmt = (Roommate) response.getResponseObject();
		if(rmtCache.contains(rmt) && rmtCache.remove(rmt)) {
			response.setStatus(true);
			response.setResult("Roommate ID '" + rmt.getNo() + "' Deleted Successfully");
		}
		return response;
	}

	public RMSResponseModel searchRoommate(int rmtNo) throws RMSException {
		RMSResponseModel response = new RMSResponseModel();
		for (Roommate rmt : rmtCache) {
			if(rmtNo == rmt.getNo()) {
				response.setStatus(true);
				response.setResponseObject(rmt);
				return response;
			}
		}
		throw new RMSException("Roommate ID '" + rmtNo + "' not found");
	}
	
	public RMSResponseModel getAllRoommates() throws RMSException {
		RMSResponseModel response = new RMSResponseModel();
		response.setResponseObject(rmtCache);
		return response;
	}

}
