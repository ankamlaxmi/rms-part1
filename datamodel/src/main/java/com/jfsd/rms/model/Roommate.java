package com.jfsd.rms.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.jfsd.rms.util.RMSUtil;

public class Roommate implements Serializable, Cloneable, Comparable<Roommate> {

	private static final long serialVersionUID = 1L;

	private int no;
	private String name;
	private String address;
	private String mobile;
	private LocalDate dateOfJoining; 

	public Roommate() {
	}

	public Roommate(String name, String address, String mobile, LocalDate dateOfJoining) throws Exception {
		this.name = name;
		this.address = address;
		this.mobile = mobile;
		this.dateOfJoining = dateOfJoining;
		validate();
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public LocalDate getDateOfJoining() {
		return dateOfJoining;
	}

	public void setDateOfJoining(LocalDate dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}

	@Override
	public String toString() {
		return "Roommate [no=" + no + ", name=" + name + ", address=" + address + ", mobile=" + mobile
				+ ", dateOfJoining=" + dateOfJoining + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + no;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Roommate)) {
			return false;
		}
		Roommate other = (Roommate) obj;
		if (no != other.no) {
			return false;
		}
		return true;
	}

	public void validate() throws Exception {
		List<String> errors = new ArrayList<>();

		if (!RMSUtil.hasContent(name)) {
			errors.add("Name has no content.");
		}
		
		if (!RMSUtil.hasContent(address)) {
			errors.add("Address has no content.");
		}
		
		if (!RMSUtil.hasContent(mobile)) {
			errors.add("Mobile has no content.");
		}
		else if(!RMSUtil.isValidMobileNo(mobile)) {
			errors.add("Mobile is invalid.");
		}

		boolean passes = RMSUtil.ensureNotNull(dateOfJoining, "Date of joining has no content.", errors);
		if (passes) {
			if (dateOfJoining.isAfter(LocalDate.now())) {
				errors.add("Date of joining can't be greater than Today.");
			}
		}

		if (!errors.isEmpty()) {
			Exception ex = new Exception();
			for (String error : errors) {
				ex.addSuppressed(new Exception(error));
			}
			throw ex;
		}
	}

	@Override
	public int compareTo(Roommate that) {
		return 0;
	}

}