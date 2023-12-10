package scholarship.model; // Replace with your actual package name

import java.util.*;
import scholarship.entity.*;

public interface ScholarshipDao {

	/*
	 * 
	
1. 獎助機構

+-----------+-------------+-------+--------+------------------------------+
| institutionId | institutionName| contact | contact number | isExisting |
+-----------+-------------+-------+--------+------------------------------+
|    25570111    |   行天宮助寒獎學金  |   陳小姐   |  0912345678    |  true     |
+-------+--------+--------------------------------------------------------+


2. 使用者
+--------+----------+----------+
| userId | institutionId | userName | password | 
+--------+----------+----------+
|  101   | 25575888 | jojo123  | pass123  |
|  102   | 25575889 | Nono456  | pass456  |
|  103   | 25575881 | Kiki789  | pass789  |
+--------+----------+----------+


3. 獎學金上傳紀錄
+-----------+-------+--------+------------------------------------------------------------------------------------------------------------------------------------------------+
| scholoarshipId   |    userId       |    institutionId      |   scholarshipName       |  scholarshipAmount    |    updatedTime     |   StartDate   |   EndDate   |   isExpired   |      web url         |   isUpdated   |
+-----------+-------------+-------+--------+----------------------------------------------------------------------------------------+------------------------------------
| 301          	   |      101        |      25570111          |   50000               |  2023/12/13 05:00 p.m |  2023/05/03   | 2023/05/10  |    true       |   www.book.com.tw    |	  true     |
	 
	 * 
	 * 功能 (API) : 獎助機構 
	 * 1. 註冊 (新增獎助機構資訊) 
	 * 2. 更改機構預設聯絡資訊 (聯絡人、連絡電話) 
	 * 3. 查詢機構是否已存在 
	 * 4.查詢所有機構
	 * 
	 * 使用者-Client: 
	 * 1. 註冊 (帳號、密碼) 
	 * 2. 修改帳號 
	 * 3. 修改密碼 
	 * 4. 查詢所有使用者
	 * 
	 * 
	 * 獎學金上傳紀錄 1. 新增一筆獎學金 2. 修改獎學金資訊 (1)根據 scholoarshipId 修改獎學金期間 (2)根據
	 * scholoarshipId 更改上架狀態 (3)根據 scholoarshipId 修改聯絡資訊 包含網址 3. 刪除一筆獎學金 4.
	 * 查詢獎學金紀錄(包含上架與否與過期與否 僅限項目所有方) 5. 查詢所有獎學金列表 6. 根據條件查詢獎學金
	 */

	// 1. 獎助機構

	/**
	 * 1. 新增使用者
	 * 
	 * @param userId 使用者ID
	 */

	void addInstitution(Institution institution);

	/**
	 * 2. 更改項目聯絡資訊 (聯絡人、連絡電話)
	 * 
	 * @param organizationI 機構id
	 * @return 聯絡資訊是否修改成功
	 */

	boolean updateContactById(String institutionId, String newContact);

	boolean updateContactNumberById(String organizationId, String newContactNumber);

	/**
	 * 3. 查詢機構是否已存在
	 * 
	 * @param organizationId
	 * @return 機構是否已存在
	 */

	boolean checkInstitutionById(String institutionId);
	// boolean updatePassword(int userId, String newPassword);

	/**
	 * 4. 查詢所有機構
	 * 
	 * @param
	 * @return 所有機構列表
	 */

	List<Institution> findAllInstitution();

	//
	// 使用者-Client:

	/**
	 * 
	 * 1. 註冊帳號密碼
	 * 
	 * @param user
	 */
	void addUser(User user);

	/**
	 * 2. 修改帳號
	 * 
	 * @param scholarshipId 獎學金ID
	 * @return 是否刪除成功
	 */

	Boolean updateUsernameById(Integer userId, String Password, String NewUserName);

	/**
	 * 3. 修改密碼
	 * 
	 * @param scholarshipId 獎學金ID
	 * @return 是否刪除成功
	 */
	Boolean updateUserPasswordById(Integer userId, String oldPassword, String newPassword);

	/**
	 * 4. 查詢所有使用者
	 * 
	 * @return 所有使用者列表
	 */

	List<User> findAllUsers();

	// 獎學金上傳紀錄

	/**
	 * 1. 新增一筆獎學金
	 * 
	 * @param Scholarship
	 */

	void addScholarship(Scholarship Scholarship);


	/**
	 * (2)根據 scholoarshipId 更改上架狀態
	 * 
	 * @param scholoarshipId
	 * @return 是否更改成功
	 */

	boolean updateLauchStatusbyId(Integer scholoarshipId, boolean isUpdated);

	/**
	 * 3. 刪除一筆獎學金
	 * 
	 * @param scholoarshipId
	 * @return 是否刪除成功
	 */

	boolean removeScholarshipById(Integer scholoarshipId);

    /**4. 查詢獎學金紀錄(包含上架與否與過期與否 僅限項目所有方)
     * 
     * @param institutionId
     * @return 所有獎學金資訊
     */
	
	List<Scholarship> findScholarshipByInstitutionId(String  institutionId);
  /**  5. 查詢所有獎學金列表 
   * 
   * @return 所有獎學金列表
   */

	List<Scholarship> findAllscholarship();
	
	/**
	 *  6. 根據條件查詢獎學金
	 * @param entity
	 * @return
	 */
	
	List<Scholarship> findScholarshipByEntity(String entity);


	/**
	 *  7.. 根據條件查詢獎學金
	 * @param entity
	 * @param cholarshipAmount
	 * @return
	 */
	
	List<Scholarship> findScholarshipByEntityAndAmount(String entity,  Integer scholarshipAmount);
	
	/**
	 *  8. 根據條件查詢獎學金
	 * @param cholarshipAmount
	 * @return
	 */
	
	List<Scholarship> findScholarshipByAmount( Integer scholarshipAmount);
	
}