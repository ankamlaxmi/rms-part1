package com.jfsd.rms.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.jfsd.rms.dao.RoommateDAO;
import com.jfsd.rms.model.RMSResponseModel;
import com.jfsd.rms.model.Roommate;
import com.jfsd.rms.util.JDBCUtils;
import com.jfsd.rms.util.RMSException;

public class RoommateDatabaseDAOImpl implements RoommateDAO {

	private static final String INSERT_SQL = "insert into roommate(id, name,address,mobile,dateOfJoining) values(NEXT VALUE FOR roommate_sequence, ?,?,?,?);";
	private static final String UPDATE_SQL = "update roommate set address=?,mobile=? where id=?";
	private static final String DELETE_SQL = "delete from roommate where id=?";
	private static final String SELECT_SQL = "select * from roommate where id=?";
	private static final String SELECT_ALL_SQL = "select * from roommate";

	@Override
	public RMSResponseModel addRoommate(Roommate rmt) throws RMSException {
		RMSResponseModel response = new RMSResponseModel();
		Connection con = JDBCUtils.getInstance().getConnection();
		int insertedCount = 0;
		try (PreparedStatement ps = con.prepareStatement(INSERT_SQL)) {
			ps.setString(1, rmt.getName());
			ps.setString(2, rmt.getAddress());
			ps.setString(3, rmt.getMobile());
			ps.setDate(4, java.sql.Date.valueOf(rmt.getDateOfJoining()));
			insertedCount = ps.executeUpdate();
			if (insertedCount > 0) {
				response.setStatus(true);
				response.setResult("Roommate Created Successfully");
			}
		} catch (Exception e) {
			throw new RMSException("Roommate Add Failed : " + e.getMessage());
		} finally {
			JDBCUtils.closeConnection(con);
		}
		return response;
	}

	@Override
	public RMSResponseModel editRoommate(Roommate rmt) throws RMSException {
		searchRoommate(rmt.getNo());
		RMSResponseModel response = new RMSResponseModel();
		Connection con = JDBCUtils.getInstance().getConnection();
		int updatedCount = 0;
		try (PreparedStatement ps = con.prepareStatement(UPDATE_SQL)) {
			ps.setString(1, rmt.getAddress());
			ps.setString(2, rmt.getMobile());
			ps.setInt(3, rmt.getNo());
			updatedCount = ps.executeUpdate();
			if (updatedCount > 0) {
				response.setStatus(true);
				response.setResult("Roommate ID '" + rmt.getNo() + "' Updated Successfully");
			}
		} catch (Exception e) {
			throw new RMSException("Update Roommate Failed : " + e.getMessage());
		} finally {
			JDBCUtils.closeConnection(con);
		}
		return response;
	}

	@Override
	public RMSResponseModel deleteRoommate(int rmtNo) throws RMSException {
		searchRoommate(rmtNo);
		RMSResponseModel response = new RMSResponseModel();
		Connection con = JDBCUtils.getInstance().getConnection();
		int deletedCount = 0;
		try (PreparedStatement ps = con.prepareStatement(DELETE_SQL)) {
			ps.setInt(1, rmtNo);
			deletedCount = ps.executeUpdate();
			if (deletedCount > 0) {
				response.setStatus(true);
				response.setResult("Roommate ID '" + rmtNo + "' Deleted Successfully");
			}
		} catch (Exception e) {
			throw new RMSException("Delete Roommate Failed : " + e.getMessage());
		} finally {
			JDBCUtils.closeConnection(con);
		}
		return response;
	}

	@Override
	public RMSResponseModel getAllRoommates() throws RMSException {
		RMSResponseModel response = new RMSResponseModel();
		List<Roommate> rmtList = null;
		Connection con = JDBCUtils.getInstance().getConnection();
		try (PreparedStatement ps = con.prepareStatement(SELECT_ALL_SQL)) {
			rmtList = new ArrayList<>();
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Roommate result = new Roommate();
				result.setNo(rs.getInt("id"));
				result.setName(rs.getString("name"));
				result.setAddress(rs.getString("address"));
				result.setMobile(rs.getString("mobile"));
				result.setDateOfJoining(rs.getDate("dateOfJoining").toLocalDate());
				rmtList.add(result);
			}
			if (!rmtList.isEmpty()) {
				response.setStatus(true);
				response.setResponseObject(rmtList);
			}
		} catch (Exception e) {
			throw new RMSException("Roommate List Retrivel Failed : " + e.getMessage());
		} finally {
			JDBCUtils.closeConnection(con);
		}
		return response;
	}

	@Override
	public RMSResponseModel searchRoommate(int rmtNo) throws RMSException {
		RMSResponseModel response = new RMSResponseModel();
		Connection con = JDBCUtils.getInstance().getConnection();
		try (PreparedStatement ps = con.prepareStatement(SELECT_SQL)) {
			ps.setInt(1, rmtNo);
			ResultSet rs = ps.executeQuery();
			if (!rs.next()) {
				throw new RMSException("Roommate ID '" + rmtNo + "' not found");
			} else {
				do {
					Roommate result = new Roommate();
					result.setNo(rs.getInt("id"));
					result.setName(rs.getString("name"));
					result.setAddress(rs.getString("address"));
					result.setMobile(rs.getString("mobile"));
					result.setDateOfJoining(rs.getDate("dateOfJoining").toLocalDate());
					response.setStatus(true);
					response.setResponseObject(result);
				} while (rs.next());
			}
		} catch (Exception e) {
			throw new RMSException("Roommate Search Failed : " + e.getMessage());
		} finally {
			JDBCUtils.closeConnection(con);
		}
		return response;
	}
}
