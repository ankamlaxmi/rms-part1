package com.jfsd.rms.service;

import com.jfsd.rms.dao.RoommateDAO;
import com.jfsd.rms.daoimpl.RoommateDatabaseDAOImpl;
import com.jfsd.rms.model.RMSResponseModel;
import com.jfsd.rms.model.Roommate;
import com.jfsd.rms.util.RMSException;

public class RoommateService {
	
	private RoommateDAO rmtDao = new RoommateDatabaseDAOImpl();
	
	public RMSResponseModel addRoommate(Roommate rmt) throws RMSException {
		return rmtDao.addRoommate(rmt);
	}

	public RMSResponseModel searchRoommate(int no) throws RMSException {
		return rmtDao.searchRoommate(no);
	}
	
	public RMSResponseModel getAllRoommates() throws RMSException {
		return rmtDao.getAllRoommates();
	}
	
	public RMSResponseModel editRoommate(Roommate rmt) throws RMSException {
		return rmtDao.editRoommate(rmt);
	}
	
	public RMSResponseModel deleteRoommate(int rmtNo) throws RMSException {
		return rmtDao.deleteRoommate(rmtNo);
	}
}
