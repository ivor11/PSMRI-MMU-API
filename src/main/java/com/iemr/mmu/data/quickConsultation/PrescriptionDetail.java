package com.iemr.mmu.data.quickConsultation;

import java.sql.Timestamp;
import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.google.gson.annotations.Expose;

@Entity
@Table(name = "t_prescription")
public class PrescriptionDetail {
	@Id
	@GeneratedValue
	@Expose
	@Column(name = "PrescriptionID")
	private Long prescriptionID;
	
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
	@Column(name = "DiagnosisProvided")
	private String diagnosisProvided;
	
	@Expose
	@Column(name = "Instruction")
	private String instruction;
	
	@Expose
	@Column(name = "ConfirmatoryDiagnosis")
	private String confirmatoryDiagnosis;
	
	@Expose
	@Column(name = "ExternalInvestigation")
	private String externalInvestigation;
	
	@Expose
	@Column(name = "Remarks")
	private String remarks;
	
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
	
	@Transient
	private ArrayList<PrescribedDrugDetail> prescribedDrugs;
	
	
	public ArrayList<PrescribedDrugDetail> getPrescribedDrugs() {
		return prescribedDrugs;
	}

	public void setPrescribedDrugs(ArrayList<PrescribedDrugDetail> prescribedDrugs) {
		this.prescribedDrugs = prescribedDrugs;
	}

	public PrescriptionDetail() {
		super();
		// TODO Auto-generated constructor stub
	}

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

	public Integer getProviderServiceMapID() {
		return providerServiceMapID;
	}

	public void setProviderServiceMapID(Integer providerServiceMapID) {
		this.providerServiceMapID = providerServiceMapID;
	}

	public String getDiagnosisProvided() {
		return diagnosisProvided;
	}

	public void setDiagnosisProvided(String diagnosisProvided) {
		this.diagnosisProvided = diagnosisProvided;
	}

	public String getInstruction() {
		return instruction;
	}

	public void setInstruction(String instruction) {
		this.instruction = instruction;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
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

	public Long getPrescriptionID() {
		return prescriptionID;
	}
	
	public String getConfirmatoryDiagnosis() {
		return confirmatoryDiagnosis;
	}

	public void setConfirmatoryDiagnosis(String confirmatoryDiagnosis) {
		this.confirmatoryDiagnosis = confirmatoryDiagnosis;
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

	public void setPrescriptionID(Long prescriptionID)
	{
		this.prescriptionID = prescriptionID;
	}

	public String getExternalInvestigation() {
		return externalInvestigation;
	}

	public void setExternalInvestigation(String externalInvestigation) {
		this.externalInvestigation = externalInvestigation;
	}
	
	
	public PrescriptionDetail(Long prescriptionID, Long beneficiaryRegID, Long benVisitID, Integer providerServiceMapID,
			String externalInvestigation) {
		super();
		this.prescriptionID = prescriptionID;
		this.beneficiaryRegID = beneficiaryRegID;
		this.benVisitID = benVisitID;
		this.providerServiceMapID = providerServiceMapID;
		this.externalInvestigation = externalInvestigation;
	}

	
	public PrescriptionDetail(Long prescriptionID, Long beneficiaryRegID, Long benVisitID, Integer providerServiceMapID,
			String diagnosisProvided, String instruction) {
		super();
		this.prescriptionID = prescriptionID;
		this.beneficiaryRegID = beneficiaryRegID;
		this.benVisitID = benVisitID;
		this.providerServiceMapID = providerServiceMapID;
		this.diagnosisProvided = diagnosisProvided;
		this.instruction = instruction;
	}

	public static ArrayList<PrescriptionDetail> getPrescriptions(ArrayList<Object[]> resList) {
		ArrayList<PrescriptionDetail> resArray = new ArrayList<PrescriptionDetail>();
		PrescriptionDetail cOBJ=null;
		if (resList != null && resList.size() > 0) {
			
			for (Object[] obj : resList) {
				
				cOBJ = new PrescriptionDetail((Long)obj[0], (Long)obj[1], (Long)obj[2], (Integer)obj[3], (String)obj[4]);
				resArray.add(cOBJ);
			}
		}
		return resArray;
	}
	
	public static ArrayList<PrescriptionDetail> getGeneralOPDDiagnosis(ArrayList<Object[]> resList) {
		ArrayList<PrescriptionDetail> resArray = new ArrayList<PrescriptionDetail>();
		PrescriptionDetail cOBJ=null;
		if (resList != null && resList.size() > 0) {
			
			for (Object[] obj : resList) {
				
				cOBJ = new PrescriptionDetail((Long)obj[0], (Long)obj[1], (Long)obj[2], (Integer)obj[3], (String)obj[4], (String)obj[5]);
				resArray.add(cOBJ);
			}
		}
		return resArray;
	}
}
