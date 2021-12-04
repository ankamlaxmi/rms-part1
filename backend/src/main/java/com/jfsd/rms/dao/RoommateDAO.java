package com.jfsd.rms.dao;

import com.jfsd.rms.model.RMSResponseModel;
import com.jfsd.rms.model.Roommate;
import com.jfsd.rms.util.RMSException;

public interface RoommateDAO {

	public RMSResponseModel addRoommate(Roommate rmt) throws RMSException;

	public RMSResponseModel editRoommate(Roommate rmt) throws RMSException;

	public RMSResponseModel deleteRoommate(int rmtNo) throws RMSException;

	public RMSResponseModel searchRoommate(int rmtNo) throws RMSException;
	
	public RMSResponseModel getAllRoommates() throws RMSException;

}
