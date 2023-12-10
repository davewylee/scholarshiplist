package scholarship.entity;

import java.io.File;

import java.util.Date;

import scholarship.model.ScholarshipDao;
import scholarship.model.ScholarshipInMemory;

/**
3. 獎學金上傳紀錄
+-----------+-------+--------+----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------+
| scholoarshipId   |    userId       |    institutionId      |   scholarshipName       |  scholarshipAmount    |    updatedTime     				 |     StartDate   	   |    EndDate   		|   isExpired   |      web url        			|   isUpdated   |
+-----------+-------------+-------+--------+----------------------------------------------------------------------------------------+------------------------------------
| 301          	   |      101        |      25570111          |  行天宮助寒獎學金	 |	 50000             			  |  2023/12/13 05:00 p.m |  2023/05/03   |  2023/05/10  |    true     		 |   www.book.com.tw   	 |	  true            |
+-----------+-------------+-------+--------+---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------+

 * 
 * 
 * 
 */

public class Scholarship {
	
	private Integer scholarshipId;
	private Integer userId;
	private String institutionId;
	private String  scholarshipName;
	private Integer scholarshipAmount;
	private  Date  updatedTime;
	private Date startDate ;
	private Date endDate;
	private boolean isExpired ;
	private String  webUrl;
	private boolean  isUpdated;
	private String entity;
	private Institution institution;
	
	
	public Scholarship(Integer scholarshipId, Integer userId, String scholarshipName,String entity, Integer scholarshipAmount,
			Date updatedTime, Date startDate, Date endDate, String webUrl) {
		this.scholarshipId = scholarshipId;
		this.userId = userId;
		this.scholarshipName = scholarshipName;
		this.entity= entity;
		this.scholarshipAmount = scholarshipAmount;
		this.updatedTime = updatedTime;
		this.startDate = startDate;
		this.endDate = endDate;
		this.webUrl = webUrl;
		//ScholarshipDao dao = new ScholarshipInMemory();
		//this.institutionId = dao.findInstitutionIdbyUserId(userId);
	}
	
	
	
	public String getInstitutionId() {
		return institutionId;
	}
	
	public String getEntity() {
		return entity;
	}

	public void setEntity(String entity) {
		this.entity = entity;
	}

	public String getScholarshipName() {
		return scholarshipName;
	}
	public void setScholarshipName(String scholarshipName) {
		this.scholarshipName = scholarshipName;
	}
	public Integer getScholarshipAmount() {
		return scholarshipAmount;
	}
	public void setScholarshipAmount(Integer scholarshipAmount) {
		this.scholarshipAmount = scholarshipAmount;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this. endDate = endDate;
	}
	public String getWebUrl() {
		return webUrl;
	}
	public void setWebUrl(String webUrl) {
		this.webUrl = webUrl;
	}
	public boolean isUpdated() {
		return isUpdated;
	}
	public void setUpdated(boolean isUpdated) {
		this.isUpdated = isUpdated;
	}
	public Integer getScholarshipId() {
		return scholarshipId;
	}
	public boolean isExpired() {
		return isExpired;
	}

	}

	
	
	

