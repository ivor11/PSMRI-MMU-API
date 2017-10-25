package com.iemr.mmu.service.registrar;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.iemr.mmu.data.registrar.BenGovIdMapping;
import com.iemr.mmu.data.registrar.BeneficiaryData;
import com.iemr.mmu.data.registrar.BeneficiaryDemographicAdditional;
import com.iemr.mmu.data.registrar.BeneficiaryDemographicData;
import com.iemr.mmu.data.registrar.BeneficiaryImage;
import com.iemr.mmu.data.registrar.BeneficiaryPhoneMapping;
import com.iemr.mmu.data.registrar.FetchBeneficiaryDetails;
import com.iemr.mmu.data.registrar.V_BenAdvanceSearch;
import com.iemr.mmu.data.registrar.WrapperRegWorklist;
import com.iemr.mmu.repo.registrar.BeneficiaryDemographicAdditionalRepo;
import com.iemr.mmu.repo.registrar.BeneficiaryImageRepo;
import com.iemr.mmu.repo.registrar.RegistrarRepoBenData;
import com.iemr.mmu.repo.registrar.RegistrarRepoBenDemoData;
import com.iemr.mmu.repo.registrar.RegistrarRepoBenGovIdMapping;
import com.iemr.mmu.repo.registrar.RegistrarRepoBenPhoneMapData;
import com.iemr.mmu.repo.registrar.RegistrarRepoBeneficiaryDetails;
import com.iemr.mmu.repo.registrar.ReistrarRepoBenSearch;

@Service
public class RegistrarServiceImpl implements RegistrarService {
	private RegistrarRepoBenData registrarRepoBenData;
	private RegistrarRepoBenDemoData registrarRepoBenDemoData;
	private RegistrarRepoBenPhoneMapData registrarRepoBenPhoneMapData;
	private RegistrarRepoBenGovIdMapping registrarRepoBenGovIdMapping;
	private ReistrarRepoBenSearch reistrarRepoBenSearch;
	private BeneficiaryDemographicAdditionalRepo beneficiaryDemographicAdditionalRepo;
	private RegistrarRepoBeneficiaryDetails registrarRepoBeneficiaryDetails;
	private BeneficiaryImageRepo beneficiaryImageRepo;

	@Autowired
	public void setBeneficiaryImageRepo(BeneficiaryImageRepo beneficiaryImageRepo) {
		this.beneficiaryImageRepo = beneficiaryImageRepo;
	}

	@Autowired
	public void setBeneficiaryDemographicAdditionalRepo(
			BeneficiaryDemographicAdditionalRepo beneficiaryDemographicAdditionalRepo) {
		this.beneficiaryDemographicAdditionalRepo = beneficiaryDemographicAdditionalRepo;
	}

	@Autowired
	public void setRegistrarRepoBenData(RegistrarRepoBenData registrarRepoBenData) {
		this.registrarRepoBenData = registrarRepoBenData;
	}

	@Autowired
	public void setRegistrarRepoBenDemoData(RegistrarRepoBenDemoData registrarRepoBenDemoData) {
		this.registrarRepoBenDemoData = registrarRepoBenDemoData;
	}

	@Autowired
	public void setRegistrarRepoBenPhoneMapData(RegistrarRepoBenPhoneMapData registrarRepoBenPhoneMapData) {
		this.registrarRepoBenPhoneMapData = registrarRepoBenPhoneMapData;
	}

	@Autowired
	public void setRegistrarRepoBenGovIdMapping(RegistrarRepoBenGovIdMapping registrarRepoBenGovIdMapping) {
		this.registrarRepoBenGovIdMapping = registrarRepoBenGovIdMapping;
	}

	@Autowired
	public void setReistrarRepoAdvanceBenSearch(ReistrarRepoBenSearch reistrarRepoBenSearch) {
		this.reistrarRepoBenSearch = reistrarRepoBenSearch;
	}

	@Autowired
	public void setRegistrarRepoBeneficiaryDetails(RegistrarRepoBeneficiaryDetails registrarRepoBeneficiaryDetails) {
		this.registrarRepoBeneficiaryDetails = registrarRepoBeneficiaryDetails;
	}

	@Override
	public BeneficiaryData createBeneficiary(JsonObject benD) {
		Long benRegID = null;
		// Call repository for saving data in
		// Table: i_beneficairy
		// Persistence Class: BeneficiaryData
		BeneficiaryData benData = registrarRepoBenData.save(getBenOBJ(benD));
		return benData;
	}

	@Override
	public Long createBeneficiaryDemographic(JsonObject benD, Long benRegID) {
		Long tmpBenDemoID = null;
		// Call repository for saving data in
		// Table: i_bendemographics
		// Persistence Class: BeneficiaryDemographicData
		BeneficiaryDemographicData benDemoData = registrarRepoBenDemoData.save(getBenDemoOBJ(benD, benRegID));
		if (benDemoData != null) {
			tmpBenDemoID = benDemoData.getBenDemographicsID();
		}
		return tmpBenDemoID;
	}

	@Override
	public Long createBeneficiaryDemographicAdditional(JsonObject benD, Long benRegID) {
		Long tmpBenDemoAddID = null;
		BeneficiaryDemographicAdditional beneficiaryDemographicAdditional = beneficiaryDemographicAdditionalRepo
				.save(getBeneficiaryDemographicAdditional(benD, benRegID));
		if (beneficiaryDemographicAdditional != null) {
			tmpBenDemoAddID = beneficiaryDemographicAdditional.getBenDemoAdditionalID();
		}
		return tmpBenDemoAddID;
	}

	@Override
	public Long createBeneficiaryImage(JsonObject benD, Long benRegID) {
		Long tmpBenImageID = null;
		BeneficiaryImage beneficiaryImage = new BeneficiaryImage();
		beneficiaryImage.setBeneficiaryRegID(benRegID);
		if (!benD.get("image").isJsonNull())
			beneficiaryImage.setBenImage(benD.get("image").getAsString());
		if (!benD.get("createdBy").isJsonNull())
			beneficiaryImage.setCreatedBy(benD.get("createdBy").getAsString());

		BeneficiaryImage benImage = beneficiaryImageRepo.save(beneficiaryImage);
		if (benImage != null) {
			tmpBenImageID = benImage.getBeneficiaryRegID();
		}
		return tmpBenImageID;
	}

	private BeneficiaryDemographicAdditional getBeneficiaryDemographicAdditional(JsonObject benD, Long benRegID) {
		BeneficiaryDemographicAdditional benDemoAd = new BeneficiaryDemographicAdditional();
		benDemoAd.setBeneficiaryRegID(benRegID);

		if (!benD.get("literacyStatus").isJsonNull()) {
			benDemoAd.setLiteracyStatus(benD.get("literacyStatus").getAsString());
		}

		if (!benD.get("motherName").isJsonNull()) {
			benDemoAd.setMotherName(benD.get("motherName").getAsString());
		}
		if (!benD.get("emailID").isJsonNull()) {
			benDemoAd.setEmailID(benD.get("emailID").getAsString());
		}
		if (!benD.get("bankName").isJsonNull()) {
			benDemoAd.setBankName(benD.get("bankName").getAsString());
		}
		if (!benD.get("branchName").isJsonNull()) {
			benDemoAd.setBranchName(benD.get("branchName").getAsString());
		}
		if (!benD.get("IFSCCode").isJsonNull()) {
			benDemoAd.setiFSCCode(benD.get("IFSCCode").getAsString());
		}
		if (!benD.get("accountNumber").isJsonNull()) {
			benDemoAd.setAccountNo(benD.get("accountNumber").getAsString());
		}
		if (!benD.get("createdBy").isJsonNull())
			benDemoAd.setCreatedBy(benD.get("createdBy").getAsString());

		return benDemoAd;
	}

	@Override
	public Long createBeneficiaryPhoneMapping(JsonObject benD, Long benRegID) {
		Long tmpBenPhonMapID = null;
		// Call repository for saving data in
		// Table: m_benphonemap
		// Persistence Class: BeneficiaryPhoneMapping
		BeneficiaryPhoneMapping benPhoneMap = registrarRepoBenPhoneMapData.save(getBenPhoneOBJ(benD, benRegID));
		if (benPhoneMap != null) {
			tmpBenPhonMapID = benPhoneMap.getBenPhMapID();
		}
		return tmpBenPhonMapID;
	}

	public int createBenGovIdMapping(JsonObject benD, Long benRegID) {
		Long tempBenGovMapID = null;
		// Call repository for saving Data to table m_bengovidmap and
		// Persistence Class = BenGovIdMapping
		System.out.println("hello");
		ArrayList<BenGovIdMapping> benGovIDMap = (ArrayList<BenGovIdMapping>) registrarRepoBenGovIdMapping
				.save(BenGovIdMapping.getBenGovIdMappingOBJList(benD, benRegID));
		System.out.println("hello");
		return benGovIDMap.size();
	}

	@Override
	public String getRegWorkList(int i) {
		// Call repository for fetching data from
		// Table: i_beneficiary, i_bendemographics, m_benphonemap
		// Persistence Class: BeneficiaryData, BeneficiaryDemographicData,
		// ...................BeneficiaryPhoneMapping
		List<Object[]> resList = registrarRepoBenData.getRegistrarWorkList(i);
		System.out.println("helloo.....");
		return WrapperRegWorklist.getRegistrarWorkList(resList);
	}

	@Override
	public String getQuickSearchBenData(String benID) {
		// List<Object[]> resList = registrarRepoBenData.getQuickSearch(benID);
		List<Object[]> resList = reistrarRepoBenSearch.getQuickSearch(benID);
		System.out.println("hello...");
		return WrapperRegWorklist.getRegistrarWorkList(resList);
	}

	public String getAdvanceSearchBenData(V_BenAdvanceSearch v_BenAdvanceSearch) {
		try {
			String benID = "%%";
			String benFirstName = "%%";
			String benLastName = "%%";
			String benGenderID = "%%";
			String fatherName = "%%";
			String phoneNo = "%%";
			String aadharNo = "%%";
			String govIDNo = "%%";
			String districtID = "%%";

			if (null != v_BenAdvanceSearch.getBeneficiaryID()) {
				benID = v_BenAdvanceSearch.getBeneficiaryID();
			}
			if (null != v_BenAdvanceSearch.getFirstName()) {
				benFirstName = v_BenAdvanceSearch.getFirstName();
			}
			if (null != v_BenAdvanceSearch.getLastName()) {
				benLastName = v_BenAdvanceSearch.getLastName();
			}
			if (null != v_BenAdvanceSearch.getGenderID()) {
				benGenderID = v_BenAdvanceSearch.getGenderID() + "";
			}
			if (null != v_BenAdvanceSearch.getFatherName()) {
				fatherName = v_BenAdvanceSearch.getFatherName();
			}
			if (null != v_BenAdvanceSearch.getPhoneNo()) {
				phoneNo = v_BenAdvanceSearch.getPhoneNo();
			}
			if (null != v_BenAdvanceSearch.getAadharNo()) {
				aadharNo = v_BenAdvanceSearch.getAadharNo();
			}
			if (null != v_BenAdvanceSearch.getGovtIdentityNo()) {
				govIDNo = v_BenAdvanceSearch.getGovtIdentityNo();
			}
			if (null != v_BenAdvanceSearch.getDistrictID()) {
				districtID = v_BenAdvanceSearch.getDistrictID() + "";
			}
			System.out.println("helloo");
			/*
			 * reistrarRepoBenSearch.getAdvanceBenSearchList(benID,
			 * benFirstName, benLastName, benGenderID, fatherName, phoneNo,
			 * aadharNo, govIDNo, districtID);
			 */
			ArrayList<Object[]> resList = reistrarRepoBenSearch.getAdvanceBenSearchList("ben1");
			System.out.println("helloo");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "helloo";
	}

	public BeneficiaryData getBenOBJ(JsonObject benD) {
		// Initializing BeneficiaryData Class Object...

		BeneficiaryData benData = new BeneficiaryData();
		if (!benD.get("firstName").isJsonNull())
			benData.setFirstName(benD.get("firstName").getAsString());
		if (!benD.get("lastName").isJsonNull())
			benData.setLastName(benD.get("lastName").getAsString());
		if (!benD.get("gender").isJsonNull())
			benData.setGenderID(benD.get("gender").getAsShort());
		if (!benD.get("dob").isJsonNull()) {
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSX");
			java.util.Date parsedDate;
			try {
				parsedDate = dateFormat.parse(benD.get("dob").getAsString());
				Timestamp timestamp = new java.sql.Timestamp(parsedDate.getTime());
				benData.setDob(timestamp);
				System.out.println("hello");
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		if (!benD.get("maritalStatus").isJsonNull())
			benData.setMaritalStatusID(benD.get("maritalStatus").getAsShort());
		if (!benD.get("createdBy").isJsonNull())
			benData.setCreatedBy(benD.get("createdBy").getAsString());
		if (!benD.get("fatherName").isJsonNull())
			benData.setFatherName(benD.get("fatherName").getAsString());
		if (benD.has("husbandName")) {
			if (!benD.get("husbandName").isJsonNull())
				benData.setSpouseName(benD.get("husbandName").getAsString());
		}
		if (!benD.get("aadharNo").isJsonNull())
			benData.setAadharNo(benD.get("aadharNo").getAsString());
		return benData;
	}

	public BeneficiaryDemographicData getBenDemoOBJ(JsonObject benD, Long benRegID) {
		// Initializing BeneficiaryDemographicData Class Object...
		BeneficiaryDemographicData benDemoData = new BeneficiaryDemographicData();
		benDemoData.setBeneficiaryRegID(benRegID);
		if (!benD.get("countryID").isJsonNull())
			benDemoData.setCountryID(benD.get("countryID").getAsInt());
		if (!benD.get("stateID").isJsonNull())
			benDemoData.setStateID(benD.get("stateID").getAsInt());
		if (!benD.get("districtID").isJsonNull())
			benDemoData.setDistrictID(benD.get("districtID").getAsInt());
		if (!benD.get("areaID").isJsonNull())
			benDemoData.setBlockID(benD.get("areaID").getAsInt());
		if (!benD.get("servicePointID").isJsonNull())
			benDemoData.setServicePointID(benD.get("servicePointID").getAsInt());
		if (!benD.get("villageID").isJsonNull())
			benDemoData.setDistrictBranchID(benD.get("villageID").getAsInt());

		if (!benD.get("createdBy").isJsonNull())
			benDemoData.setCreatedBy(benD.get("createdBy").getAsString());

		if (!benD.get("community").isJsonNull())
			benDemoData.setCommunityID(benD.get("community").getAsShort());
		if (!benD.get("religion").isJsonNull())
			benDemoData.setReligionID(benD.get("religion").getAsShort());
		if (!benD.get("occupation").isJsonNull())
			benDemoData.setOccupationID(benD.get("occupation").getAsShort());
		if (!benD.get("educationQualification").isJsonNull())
			benDemoData.setEducationID(benD.get("educationQualification").getAsShort());
		if (!benD.get("income").isJsonNull())
			benDemoData.setIncomeStatusID(benD.get("income").getAsShort());
		return benDemoData;
	}

	public BeneficiaryPhoneMapping getBenPhoneOBJ(JsonObject benD, Long benRegID) {
		// Initializing BeneficiaryPhoneMapping Class Object...
		BeneficiaryPhoneMapping benPhoneMap = new BeneficiaryPhoneMapping();
		benPhoneMap.setBenificiaryRegID(benRegID);
		if (!benD.get("phoneNo").isJsonNull())
			benPhoneMap.setPhoneNo(benD.get("phoneNo").getAsString());
		if (!benD.get("createdBy").isJsonNull())
			benPhoneMap.setCreatedBy(benD.get("createdBy").getAsString());
		return benPhoneMap;
	}

	@Override
	public String getBeneficiaryDetails(Long beneficiaryRegID) {

		List<Object[]> resList = registrarRepoBeneficiaryDetails.getBeneficiaryDetails(beneficiaryRegID);

		System.out.println("hello");

		if (resList != null && resList.size() > 0) {

			ArrayList<Map<String, Object>> govIdList = new ArrayList<>();
			ArrayList<Map<String, Object>> otherGovIdList = new ArrayList<>();
			Map<String, Object> govIDMap;
			Map<String, Object> otherGovIDMap;
			Object[] objarr = resList.get(0);
			System.out.println("helooo");
			for (Object[] arrayObj : resList) {
				if (arrayObj[26] != null && (Boolean) arrayObj[26] == true) {
					govIDMap = new HashMap<>();
					govIDMap.put("type", arrayObj[24]);
					govIDMap.put("value", arrayObj[25]);
					govIDMap.put("isGovType", arrayObj[26]);
					govIdList.add(govIDMap);
				} else {
					otherGovIDMap = new HashMap<>();
					otherGovIDMap.put("type", arrayObj[24]);
					otherGovIDMap.put("value", arrayObj[25]);
					otherGovIDMap.put("isGovType", arrayObj[26]);
					otherGovIdList.add(otherGovIDMap);
				}

			}
			String s = beneficiaryImageRepo.getBenImage(beneficiaryRegID);
			FetchBeneficiaryDetails fetchBeneficiaryDetailsOBJ = FetchBeneficiaryDetails.getBeneficiaryDetails(objarr,
					govIdList, s, otherGovIdList);
			System.out.println("helooo");
			return new Gson().toJson(fetchBeneficiaryDetailsOBJ);
		} else {
			System.out.println("helooo");
			return null;
		}

		// System.out.println("helooo");

		// ArrayList<FetchBeneficiaryDetails> beneficiaryDetails =
		// FetchBeneficiaryDetails.getBeneficiaryDetails(resList);

	}

	@Override
	public String getBenImage(Long benRegID) {
		Map<String, String> benImageMap = new HashMap<String, String>();
		String s = beneficiaryImageRepo.getBenImage(benRegID);
		if (s != null)
			benImageMap.put("benImage", s);

		return new Gson().toJson(benImageMap);
	}

}
