package com.iemr.mmu.controller.generalOPD;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.iemr.mmu.service.generalOPD.GeneralOPDServiceImpl;
import com.iemr.mmu.utils.response.OutputResponse;

import io.swagger.annotations.ApiOperation;

/***
 * 
 * @author NE298657
 *
 */
@RestController
@CrossOrigin
@RequestMapping(value = "/generalOPD", headers = "Authorization")
public class GeneralOPDUpdateController {

	private Logger logger = LoggerFactory.getLogger(this.getClass().getSimpleName());

	private GeneralOPDServiceImpl generalOPDServiceImpl;

	@Autowired
	public void setGeneralOPDServiceImpl(GeneralOPDServiceImpl generalOPDServiceImpl) {
		this.generalOPDServiceImpl = generalOPDServiceImpl;
	}

	@CrossOrigin
	@ApiOperation(value = "update General OPD Visit screen Nurse Data in Doctor screen", consumes = "application/json", produces = "application/json")
	@RequestMapping(value = { "/update/visitDetailsScreen" }, method = { RequestMethod.POST })
	public String updateVisitNurse(@RequestBody String requestObj) {

		OutputResponse response = new OutputResponse();
		logger.info("updateVisitNurse request:" + requestObj);

		JsonObject jsnOBJ = new JsonObject();
		JsonParser jsnParser = new JsonParser();
		JsonElement jsnElmnt = jsnParser.parse(requestObj);
		jsnOBJ = jsnElmnt.getAsJsonObject();

		try {
			int result = generalOPDServiceImpl.UpdateVisitDetails(jsnOBJ);
			if (result > 0) {
				Map<String, Integer> resMap = new HashMap<String, Integer>();
				resMap.put("result", result);
				response.setResponse(new Gson().toJson(resMap));
			} else {
				response.setError(500, "Failed to update Visit Nurse Data");
			}
			logger.info("updateVisitNurse response:" + response);
		} catch (Exception e) {
			response.setError(e);
			logger.error("Error in updateVisitNurse :" + e);
		}

		return response.toString();
	}

	/**
	 * 
	 * @param requestObj
	 * @return success or failure response
	 * @objective Replace General OPD History Data entered by Nurse with the
	 *            details entered by Doctor
	 */

	@CrossOrigin
	@ApiOperation(value = "update History Data in Doctor screen", consumes = "application/json", produces = "application/json")
	@RequestMapping(value = { "/update/historyScreen" }, method = { RequestMethod.POST })
	public String updateHistoryNurse(@RequestBody String requestObj) {

		OutputResponse response = new OutputResponse();
		logger.info("updateHistoryNurse request:" + requestObj);

		JsonObject jsnOBJ = new JsonObject();
		JsonParser jsnParser = new JsonParser();
		JsonElement jsnElmnt = jsnParser.parse(requestObj);
		jsnOBJ = jsnElmnt.getAsJsonObject();

		try {
			int result = generalOPDServiceImpl.updateBenHistoryDetails(jsnOBJ);
			if (result > 0) {
				Map<String, Integer> resMap = new HashMap<String, Integer>();
				resMap.put("result", result);
				response.setResponse(new Gson().toJson(resMap));
			} else {
				response.setError(500, "Failed to update General OPD History Nurse Data");
			}
			logger.info("updateHistoryNurse response:" + response);
		} catch (Exception e) {
			response.setError(e);
			logger.error("Error in updateHistoryNurse :" + e);
		}

		return response.toString();
	}

	/**
	 * 
	 * @param requestObj
	 * @return success or failure response
	 * @objective Replace General OPD Vital Data entered by Nurse with the
	 *            details entered by Doctor
	 */

	@CrossOrigin
	@ApiOperation(value = "update General OPD Vital Data in Doctor screen", consumes = "application/json", produces = "application/json")
	@RequestMapping(value = { "/update/vitalScreen" }, method = { RequestMethod.POST })
	public String updateVitalNurse(@RequestBody String requestObj) {

		OutputResponse response = new OutputResponse();
		logger.info("updateVitalNurse request:" + requestObj);

		JsonObject jsnOBJ = new JsonObject();
		JsonParser jsnParser = new JsonParser();
		JsonElement jsnElmnt = jsnParser.parse(requestObj);
		jsnOBJ = jsnElmnt.getAsJsonObject();

		try {
			int result = generalOPDServiceImpl.updateBenVitalDetails(jsnOBJ);
			if (result > 0) {
				Map<String, Integer> resMap = new HashMap<String, Integer>();
				resMap.put("result", result);
				response.setResponse(new Gson().toJson(resMap));
			} else {
				response.setError(500, "Failed to update General OPD Vital Nurse Data");
			}
			logger.info("updateVitalNurse response:" + response);
		} catch (Exception e) {
			response.setError(e);
			logger.error("Error in updateVitalNurse :" + e);
		}

		return response.toString();
	}

	/**
	 * 
	 * @param requestObj
	 * @return success or failure response
	 * @objective Replace General OPD History Data entered by Nurse with the
	 *            details entered by Doctor
	 */

	@CrossOrigin
	@ApiOperation(value = "update General OPD Examination Data in Doctor screen", consumes = "application/json", produces = "application/json")
	@RequestMapping(value = { "/update/examinationScreen" }, method = { RequestMethod.POST })
	public String updateGeneralOPDExaminationNurse(@RequestBody String requestObj) {

		OutputResponse response = new OutputResponse();
		logger.info("updateGeneralOPDExaminationNurse request:" + requestObj);

		JsonObject jsnOBJ = new JsonObject();
		JsonParser jsnParser = new JsonParser();
		JsonElement jsnElmnt = jsnParser.parse(requestObj);
		jsnOBJ = jsnElmnt.getAsJsonObject();

		try {
			int result = generalOPDServiceImpl.updateBenExaminationDetails(jsnOBJ);
			if (result > 0) {
				Map<String, Integer> resMap = new HashMap<String, Integer>();
				resMap.put("result", result);
				response.setResponse(new Gson().toJson(resMap));
			} else {
				response.setError(500, "Failed to update General OPD Examination Nurse Data");
			}
			logger.info("updateGeneralOPDExaminationNurse response:" + response);
		} catch (Exception e) {
			response.setError(e);
			logger.error("Error in updateGeneralOPDExaminationNurse :" + e);
		}

		return response.toString();
	}
}
