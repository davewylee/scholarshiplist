package scholarship.model;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;
import static java.util.stream.Collectors.toList;

//import org.apache.tomcat.util.http.parser.TokenList;

import scholarship.entity.*;
import scholarship.entity.User;


public class ScholarshipInMemory implements ScholarshipDao {

	private static List<User> users = new CopyOnWriteArrayList<>();
	private static List<Institution> institutions = new CopyOnWriteArrayList<>();
	private static List<Scholarship> scholarships = new CopyOnWriteArrayList<>();
	private static List<Scholarship>garbageScholarships = new CopyOnWriteArrayList<>();

	
	@Override
	public void addInstitution(Institution institution) {
		institutions.add(institution);	
	}

	
	@Override
	public boolean updateContactById(String institutionId, String newContact) {
		return institutions.stream()
													.filter(institution -> institution.getInstitutionId().equals(institutionId))
													.peek(institution -> institution.setContact(newContact))
													.findAny()
													.isPresent();
	}

	
	@Override
	public boolean updateContactNumberById(String institutionId, String newContactNumber) {
		return institutions.stream()
													.filter(institution -> institution.getInstitutionId().equals(institutionId))
													.peek(institution -> institution.setContactNumber(newContactNumber))
													.findAny()
													.isPresent();
	}

	@Override
    public boolean checkInstitutionById(String institutionId) {
        return institutions.stream()
            .anyMatch(institution -> institution.getInstitutionId().equals(institutionId));
    }
	

	@Override
	public List<Institution> findAllInstitution() {
		return institutions;
	}

	@Override
	public void addUser(User user) {
		users.add(user);
	}

	@Override
	public Boolean updateUsernameById(Integer userId, String Password, String NewUserName) {
		return users.stream()
				  .filter(user -> user.getUserId().equals(userId))
				  .filter(user -> user.getPassword().equals(Password))
				  .peek(user -> user.setUsername(NewUserName))
				  .findAny()
				  .isPresent();
	}

	@Override
	public Boolean updateUserPasswordById(Integer userId, String oldPassword, String newPassword) {
	
		return users.stream()
				  .filter(user -> user.getUserId().equals(userId))
				  .peek(user -> user.setPassword(newPassword))
				  .findAny()
				  .isPresent();
	}

	@Override
	public List<User> findAllUsers() {
		// TODO Auto-generated method stub
		return users;
	}

	@Override
	public void addScholarship(Scholarship Scholarship) {
		scholarships.add(Scholarship);
		
	}

	@Override
	public boolean updateLauchStatusbyId(Integer scholarshipId, boolean isUpdated) {
		return scholarships.stream()
				.filter(scholarship->scholarship.getScholarshipId().equals(scholarshipId))
				.peek(scholarship->scholarship.setUpdated(isUpdated))
				.findAny()
				.isPresent();
	}

	@Override
	public boolean removeScholarshipById(Integer scholarshipId) {
		Optional<Scholarship>scholarshipOpt=scholarships .stream()
				  .filter(scholarship -> scholarship.getScholarshipId().equals(scholarshipId))
				  .findAny();
				 if(scholarshipOpt.isPresent()) {
					 scholarships.remove(scholarshipOpt.get());//移除物件需先從optional將物件取出
					 garbageScholarships.add(scholarshipOpt.get());
					 return true;					 
				 }
		
		
		return false;

	}

	@Override
	public List<Scholarship> findScholarshipByInstitutionId(String institutionId) {
		return scholarships. stream().filter(scholarship -> scholarship.getInstitutionId().equals(institutionId))
		.collect(toList());
	}

	@Override
	public List<Scholarship> findAllscholarship() {
		
		return scholarships;
	}


	@Override
	public List<Scholarship> findScholarshipByEntity(String entity) {
		return scholarships.stream().filter(scholarship -> scholarship.getEntity().equals(entity))
				.collect(toList());
	}




	@Override
	public List<Scholarship> findScholarshipByEntityAndAmount(String entity, Integer scholarshipAmount) {
		return scholarships.stream().filter(scholarship -> scholarship.getEntity().equals(entity)&&scholarship.getScholarshipAmount().equals(scholarshipAmount))
				.collect(toList());
	}

	@Override
	public List<Scholarship> findScholarshipByAmount(Integer scholarshipAmount) {
		return scholarships.stream().filter(scholarship -> scholarship.getScholarshipAmount().equals(scholarshipAmount))
				.collect(toList());
	}



}
