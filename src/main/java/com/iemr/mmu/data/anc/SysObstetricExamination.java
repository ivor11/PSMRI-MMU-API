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
package com.iemr.mmu.data.anc;

import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import com.google.gson.annotations.Expose;

@Entity
@Table(name = "t_Sys_Obstetric")
public class SysObstetricExamination {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	@Expose
	@Column(name = "ID")
	private Long ID;

	@Expose
	@Column(name = "BeneficiaryRegID")
	private Long beneficiaryRegID;

	@Expose
	@Column(name = "BenVisitID")
	private Long benVisitID;
	
	@Expose
	@Column(name = "ProviderServiceMapID")
	private Integer providerServiceMapID;
	
	@Expose
	@Column(name = "VisitCode")
	private Long visitCode;

	@Expose
	@Column(name = "FundalHeight")
	private String fundalHeight;

	@Expose
	@Column(name = "FHAndPOA_Status")
	private String fHAndPOA_Status;

	@Expose
	@Column(name = "FHAndPOA_Interpretation")
	private String fHAndPOA_Interpretation;

	@Expose
	@Column(name = "FetalMovements")
	private String fetalMovements;

	@Expose
	@Column(name = "FetalHeartSounds")
	private String fetalHeartSounds;

	@Expose
	@Column(name = "FetalHeartRate_BeatsPerMinute")
	private String fetalHeartRate_BeatsPerMinute;

	@Expose
	@Column(name = "FetalPositionOrLie")
	private String fetalPositionOrLie;

	@Expose
	@Column(name = "FetalPresentation")
	private String fetalPresentation;

	@Expose
	@Column(name = "AbdominalScars")
	private String abdominalScars;
	
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
	@Column(name = "VanSerialNo")
	private Long vanSerialNo;
	
	@Expose
	@Column(name = "VehicalNo")
	private String vehicalNo;
	
    @Expose
	@Column(name = "vanID")
	private Integer vanID;
	
	@Expose
	@Column(name = "ParkingPlaceID")
	private Integer parkingPlaceID;
	
	@Expose
	@Column(name = "SyncedBy")
	private String syncedBy;
	
	@Expose
	@Column(name = "SyncedDate")
	private Timestamp syncedDate;
	
	@Expose
	@Column(name = "ReservedForChange")
	private String reservedForChange;
	
	public Long getBeneficiaryRegID() {
		return beneficiaryRegID;
	}

	public void setBeneficiaryRegID(Long beneficiaryRegID) {
		this.beneficiaryRegID = beneficiaryRegID;
	}

	public Long getBenVisitID() {
		return benVisitID;
	}

	public void setBenVisitID(Long benVisitID) {
		this.benVisitID = benVisitID;
	}

	public String getFundalHeight() {
		return fundalHeight;
	}

	public void setFundalHeight(String fundalHeight) {
		this.fundalHeight = fundalHeight;
	}

	public String getfHAndPOA_Status() {
		return fHAndPOA_Status;
	}

	public void setfHAndPOA_Status(String fHAndPOA_Status) {
		this.fHAndPOA_Status = fHAndPOA_Status;
	}

	public String getfHAndPOA_Interpretation() {
		return fHAndPOA_Interpretation;
	}

	public void setfHAndPOA_Interpretation(String fHAndPOA_Interpretation) {
		this.fHAndPOA_Interpretation = fHAndPOA_Interpretation;
	}

	public String getFetalMovements() {
		return fetalMovements;
	}

	public void setFetalMovements(String fetalMovements) {
		this.fetalMovements = fetalMovements;
	}

	public String getFetalHeartSounds() {
		return fetalHeartSounds;
	}

	public void setFetalHeartSounds(String fetalHeartSounds) {
		this.fetalHeartSounds = fetalHeartSounds;
	}

	public String getFetalHeartRate_BeatsPerMinute() {
		return fetalHeartRate_BeatsPerMinute;
	}

	public void setFetalHeartRate_BeatsPerMinute(String fetalHeartRate_BeatsPerMinute) {
		this.fetalHeartRate_BeatsPerMinute = fetalHeartRate_BeatsPerMinute;
	}

	public String getFetalPositionOrLie() {
		return fetalPositionOrLie;
	}

	public void setFetalPositionOrLie(String fetalPositionOrLie) {
		this.fetalPositionOrLie = fetalPositionOrLie;
	}

	public String getFetalPresentation() {
		return fetalPresentation;
	}

	public void setFetalPresentation(String fetalPresentation) {
		this.fetalPresentation = fetalPresentation;
	}

	public String getAbdominalScars() {
		return abdominalScars;
	}

	public void setAbdominalScars(String abdominalScars) {
		this.abdominalScars = abdominalScars;
	}

	public Boolean getDeleted() {
		return deleted;
	}

	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}

	public String getProcessed() {
		return processed;
	}

	public void setProcessed(String processed) {
		this.processed = processed;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Timestamp getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public Timestamp getLastModDate() {
		return lastModDate;
	}

	public void setLastModDate(Timestamp lastModDate) {
		this.lastModDate = lastModDate;
	}

	public Long getID() {
		return ID;
	}

	public Integer getProviderServiceMapID() {
		return providerServiceMapID;
	}

	public void setProviderServiceMapID(Integer providerServiceMapID) {
		this.providerServiceMapID = providerServiceMapID;
	}

	public Long getVanSerialNo() {
		return vanSerialNo;
	}

	public void setVanSerialNo(Long vanSerialNo) {
		this.vanSerialNo = vanSerialNo;
	}

	public String getVehicalNo() {
		return vehicalNo;
	}

	public void setVehicalNo(String vehicalNo) {
		this.vehicalNo = vehicalNo;
	}

	public Integer getParkingPlaceID() {
		return parkingPlaceID;
	}

	public void setParkingPlaceID(Integer parkingPlaceID) {
		this.parkingPlaceID = parkingPlaceID;
	}

	public String getSyncedBy() {
		return syncedBy;
	}

	public void setSyncedBy(String syncedBy) {
		this.syncedBy = syncedBy;
	}

	public Timestamp getSyncedDate() {
		return syncedDate;
	}

	public void setSyncedDate(Timestamp syncedDate) {
		this.syncedDate = syncedDate;
	}

	public String getReservedForChange() {
		return reservedForChange;
	}

	public void setReservedForChange(String reservedForChange) {
		this.reservedForChange = reservedForChange;
	}

	public void setID(Long iD)
	{
		ID = iD;
	}

	public Long getVisitCode() {
		return visitCode;
	}

	public void setVisitCode(Long visitCode) {
		this.visitCode = visitCode;
	}
	
	@Expose
	@Column(name = "sfh")
	private Double sfh;

	public Double getSfh() {
		return sfh;
	}

	public void setSfh(Double sfh) {
		this.sfh = sfh;
	}
}
