/*
* AMRIT – Accessible Medical Records via Integrated Technology
* Integrated EHR (Electronic Health Records) Solution
*
* Copyright (C) "Piramal Swasthya Management and Research Institute"
*
* This file is part of AMRIT.
*
* This program is free software: you can redistribute it and/or modify
* it under the terms of the GNU General Public License as published by
* the Free Software Foundation, either version 3 of the License, or
* (at your option) any later version.
*
* This program is distributed in the hope that it will be useful,
* but WITHOUT ANY WARRANTY; without even the implied warranty of
* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
* GNU General Public License for more details.
*
* You should have received a copy of the GNU General Public License
* along with this program.  If not, see https://www.gnu.org/licenses/.
*/
package com.iemr.mmu.data.masterdata.anc;

import java.sql.Timestamp;
import java.util.ArrayList;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import com.google.gson.annotations.Expose;

@Entity
@Table(name = "m_diseasetype")
public class DiseaseType {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Expose
	@Column(name = "DiseaseTypeID")
	private Short diseaseTypeID;

	@Expose
	@Column(name = "DiseaseType")
	private String diseaseType;

	@Expose
	@Column(name = "DiseaseTypeDesc")
	private String diseaseTypeDesc;

	@Expose
	@Column(name = "Gender")
	private String gender;

	@Expose
	@Column(name = "Deleted", insertable = false, updatable = true)
	private Boolean deleted;

	@Expose
	@Column(name = "Processed", insertable = false, updatable = true)
	private String processed;

	@Expose
	@Column(name = "CreatedBy")
	private String createdBy;

	@Expose
	@Column(name = "CreatedDate", insertable = false, updatable = false)
	private Timestamp createdDate;

	@Expose
	@Column(name = "ModifiedBy")
	private String modifiedBy;

	@Expose
	@Column(name = "LastModDate", insertable = false, updatable = false)
	private Timestamp lastModDate;

	@Expose
	@Column(name = "Sctcode")
	private String snomedCode;

	@Expose
	@Column(name = "SctTerm")
	private String snomedTerm;
	
	public DiseaseType(Short diseaseTypeID, String diseaseType, String snomedCode, String snomedTerm) {
		super();
		this.diseaseTypeID = diseaseTypeID;
		this.diseaseType = diseaseType;
		this.snomedCode = snomedCode;
		this.snomedTerm = snomedTerm;
	}

	public static ArrayList<DiseaseType> getDiseaseTypes(ArrayList<Object[]> resList) {
		ArrayList<DiseaseType> resArray = new ArrayList<DiseaseType>();
		for (Object[] obj : resList) {
			DiseaseType cOBJ = new DiseaseType((Short) obj[0], (String) obj[1], (String) obj[2], (String) obj[3]);
			resArray.add(cOBJ);
		}
		return resArray;
	}

}
