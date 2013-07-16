package com.octo.training.legacy;

public class CV {

    private Long intId;
    private Long nivCode;
    private Integer cuvPourcentFormation;

    public CV() {
	}


	public void setIntId(Long intId) {
		this.intId = intId;
	}

	public void setNivCode(Long nivCode) {
		this.nivCode = nivCode;
	}

	public void setCuvPourcentFormation(Integer decimal) {
		cuvPourcentFormation = decimal;
	}


	public Long getIntId() {
		return intId;
	}


	public Long getNivCode() {
		return nivCode;
	}


	public Integer getCuvPourcentFormation() {
		return cuvPourcentFormation;
	}
	
}