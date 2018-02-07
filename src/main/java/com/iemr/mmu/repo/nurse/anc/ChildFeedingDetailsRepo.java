package com.iemr.mmu.repo.nurse.anc;

import java.sql.Timestamp;
import java.util.ArrayList;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.iemr.mmu.data.anc.ChildFeedingDetails;

@Repository
public interface ChildFeedingDetailsRepo extends CrudRepository<ChildFeedingDetails, Long>{
	
	@Query("select Date(createdDate), childID, benMotherID, typeOfFeed, compFeedStartAge, noOfCompFeedPerDay, foodIntoleranceStatus,"
			+ " typeofFoodIntolerance "
			+ "from ChildFeedingDetails a where a.beneficiaryRegID = :beneficiaryRegID AND (typeOfFeed is not null OR "
			+ "compFeedStartAge is not null OR foodIntoleranceStatus is not null)"
			+ "AND deleted = false ORDER BY createdDate DESC ")
	public ArrayList<Object[]> getBenFeedingHistoryDetail(@Param("beneficiaryRegID") Long beneficiaryRegID);
		
	@Query("select beneficiaryRegID, benVisitID, providerServiceMapID, childID, benMotherID, typeOfFeed, compFeedStartAge, "
			+ "noOfCompFeedPerDay, foodIntoleranceStatus, typeofFoodIntolerance "
			+ "from ChildFeedingDetails a where a.beneficiaryRegID = :beneficiaryRegID and a.benVisitID = :benVisitID")
	public ArrayList<Object[]> getBenFeedingDetails(@Param("beneficiaryRegID") Long beneficiaryRegID,
			@Param("benVisitID") Long benVisitID);
	
	@Query("SELECT processed from ChildFeedingDetails where beneficiaryRegID=:benRegID AND benVisitID = :benVisitID AND deleted = false")
	public String getBenChildFeedingDetailStatus(@Param("benRegID") Long benRegID,
			@Param("benVisitID") Long benVisitID);
		
	@Transactional
	@Modifying
	@Query("update ChildFeedingDetails set childID=:childID, benMotherID=:benMotherID, "
			+ "typeOfFeed=:typeOfFeed, compFeedStartAge=:compFeedStartAge,"
			+ " noOfCompFeedPerDay=:noOfCompFeedPerDay, foodIntoleranceStatus=:foodIntoleranceStatus, typeofFoodIntolerance=:typeofFoodIntolerance,"
			+ "  modifiedBy=:modifiedBy, processed=:processed where "
			+ "beneficiaryRegID=:beneficiaryRegID AND benVisitID = :benVisitID")
	public int updateFeedingDetails(
			@Param("childID") Long childID,
			@Param("benMotherID") Long benMotherID,
			@Param("typeOfFeed") String typeOfFeed,
			@Param("compFeedStartAge") String compFeedStartAge,
			@Param("noOfCompFeedPerDay") Character noOfCompFeedPerDay,
			@Param("foodIntoleranceStatus") Character foodIntoleranceStatus,
			@Param("typeofFoodIntolerance") String typeofFoodIntolerance,
			@Param("modifiedBy") String modifiedBy,
			@Param("processed") String processed,
			@Param("beneficiaryRegID") Long beneficiaryRegID,
			@Param("benVisitID") Long benVisitID);
	
}
