package com.jfsd.rms.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import com.jfsd.rms.util.RMSUtil;

public class Roommate implements Serializable, Cloneable, Comparable<Roommate> {

	private static final long serialVersionUID = 1L;

	private int no;
	private String name;
	private String address;
	private String mobile;
	private LocalDate dateOfJoining; 
	private Boolean laxmi_vegitarian;
	private String email_address;
	private String vegitarian;

	public Roommate() {
	}

	public Roommate(String name, String address, String mobile, LocalDate dateOfJoining, String vegiterian, String email) throws Exception {
		this.name = name;
		this.address = address;
		this.mobile = mobile;
		this.dateOfJoining = dateOfJoining;
		this.vegitarian=vegiterian;
		this.email_address=email;
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
	
	public void setVegiterian(Boolean vegiterian) {
		this.laxmi_vegitarian = vegiterian;
	}
	
	public void setEmailAddress(String email) {
		this.email_address = email;
	}

	
	@Override
	public String toString() {
		return "Roommate [no=" + no + ", name=" + name + ", address=" + address + ", mobile=" + mobile
				+ ", dateOfJoining=" + dateOfJoining + ", laxmi_vegitarian=" + laxmi_vegitarian + ", email_address="
				+ email_address + "]";
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
		
		 if(!RMSUtil.hasContent(email_address)) {
			// if(Pattern.matches("*@*.com", email_address))
			errors.add("email address is null");
		}
		 
		 if(vegitarian.equalsIgnoreCase("Yes"))
			{
			 laxmi_vegitarian=true;
			}
			else if(vegitarian.equalsIgnoreCase("No"))
			{
				laxmi_vegitarian=false;
			}
			else
				errors.add("Invalid value for Vegiterian");


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

	public Boolean getLaxmi_vegitarian() {
		return laxmi_vegitarian;
	}

	public void setLaxmi_vegitarian(Boolean laxmi_vegitarian) {
		this.laxmi_vegitarian = laxmi_vegitarian;
	}

	public String getEmail_address() {
		return email_address;
	}

	public void setEmail_address(String email_address) {
		this.email_address = email_address;
	}

}