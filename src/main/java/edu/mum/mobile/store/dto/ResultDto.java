package edu.mum.mobile.store.dto;

public class ResultDto {
	private boolean success = false;
	
	public ResultDto(boolean success) {
		this.success = success;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}
	
}
