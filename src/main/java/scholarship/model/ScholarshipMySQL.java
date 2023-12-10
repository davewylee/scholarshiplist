package scholarship.model;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import scholarship.entity.Institution;
import scholarship.entity.Scholarship;
import scholarship.entity.User;

public class ScholarshipMySQL implements ScholarshipDao {
    private Connection conn;
    private AtomicInteger userIdGenerator = new AtomicInteger(101);
    public ScholarshipMySQL() {
        try {
            InitialContext ctx = new InitialContext(); // Initial context
            Context envContext = (Context) ctx.lookup("java:comp/env"); // Get environment object
            DataSource ds = (DataSource) envContext.lookup("jdbc/web"); // Get specified resource

            conn = ds.getConnection(); // Get resource connection

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

//    @Override
//    protected void finalize() throws Throwable {
//        if (conn != null) {
//            try {
//                conn.close();
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }
//    }

    @Override
    public void addInstitution(Institution institution) {
        String sql = "INSERT INTO Institution (institutionId, institutionName, contact, contactNumber) VALUES (?, ?, ?, ?)";

        try (PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
            preparedStatement.setString(1, institution.getInstitutionId());
            preparedStatement.setString(2, institution.getInstitutionName());
            preparedStatement.setString(3, institution.getContact());
            preparedStatement.setString(4, institution.getContactNumber());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
//    checked

    @Override
    public boolean updateContactById(String institutionId, String newContact) {
        String sql = "UPDATE Institution SET contact = ? WHERE organizationId = ?";

        try (PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
            preparedStatement.setString(1, newContact);
            preparedStatement.setString(2, institutionId);

            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
//  checked
    
    @Override
    public boolean updateContactNumberById(String institutionId, String newContactNumber) {
        String sql = "UPDATE Institution SET contactNumber = ? WHERE organizationId = ?";

        try (PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
            preparedStatement.setString(1, newContactNumber);
            preparedStatement.setString(2, institutionId);

            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
//  checked
    
    @Override
    public boolean checkInstitutionById(String institution) {
        String sql = "SELECT * FROM Institution WHERE institutionId = ?";

        try (PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
            String institutionId = null;
			preparedStatement.setString(1, institutionId);

            ResultSet resultSet = preparedStatement.executeQuery();
            return resultSet.next();

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
//  checked

    @Override
    public List<Institution> findAllInstitution() {
        List<Institution> institutions = new ArrayList<>();
        String sql = "SELECT * FROM Institution";

        try (PreparedStatement preparedStatement = conn.prepareStatement(sql);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                Institution institution = new Institution(sql, sql, sql, sql);

                institution.setInstitutionId(resultSet.getString("institutionId"));
                institution.setInstitutionName(resultSet.getString("institutionName"));
                institution.setContact(resultSet.getString("contact"));
                institution.setContactNumber(resultSet.getString("contactNumber"));

                institutions.add(institution);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return institutions;
    }
    
    //checked

    @Override
    public void addUser(User user) {
        // Assuming you want to automatically generate userId using AtomicInteger
        int userId = userIdGenerator.getAndIncrement();

        String sql = "INSERT INTO User (userId, institutionId, userName, password) VALUES (?, ?, ?, ?)";

        try (PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
            preparedStatement.setInt(1, userId);
            preparedStatement.setString(2, user.getInstitutionId());
            preparedStatement.setString(3, user.getUsername());
            preparedStatement.setString(4, user.getPassword());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //check
    
    @Override
    public Boolean updateUsernameById(Integer userId, String password, String newUserName) {
        String sql = "UPDATE User SET userName = ? WHERE userId = ? AND password = ?";

        try (PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
            preparedStatement.setString(1, newUserName);
            preparedStatement.setInt(2, userId);
            preparedStatement.setString(3, password);

            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
            // 如果>0 return true ? false  表示是否更新成功

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    // check
    @Override
    public Boolean updateUserPasswordById(Integer userId, String oldPassword, String newPassword) {
        String sql = "UPDATE User SET password = ? WHERE userId = ? AND password = ?";

        try (PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
            preparedStatement.setString(1, newPassword);
            preparedStatement.setInt(2, userId);
            preparedStatement.setString(3, oldPassword);

            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<User> findAllUsers() {
        List<User> users = new ArrayList<>();
        String sql = "SELECT * FROM User";

        try (PreparedStatement preparedStatement = conn.prepareStatement(sql);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                User user = new User(
                        resultSet.getInt("userId"),
                        resultSet.getString("institutionId"),
                        resultSet.getString("userName"),
                        resultSet.getString("password")
                );

                users.add(user);
            }

        } catch (SQLException e) {
           
            e.printStackTrace();
        }

        return users;
    }

    // check
    
    @Override
    public void addScholarship(Scholarship scholarship) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm");
        String formattedTimestamp = dateFormat.format(new Date(System.currentTimeMillis()));

        // The SQL statement only includes columns from the ScholarshipRecord table
        String sql = "INSERT INTO ScholarshipRecord (scholarshipId, userId, institutionId, scholarshipName, scholarshipAmount, entity, updatedTime, startDate, endDate, isExpired, webUrl, isUpdated) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
//            preparedStatement.setInt(1, scholarship.getScholarshipId());
//            preparedStatement.setInt(2, scholarship.getUserId());
//            preparedStatement.setString(3, scholarship.getInstitutionId());
            preparedStatement.setString(4, scholarship.getScholarshipName());
            preparedStatement.setInt(5, scholarship.getScholarshipAmount());
            preparedStatement.setString(6, scholarship.getEntity());
            preparedStatement.setString(7, formattedTimestamp);
            preparedStatement.setDate(8, new java.sql.Date(scholarship.getStartDate().getTime()));
            preparedStatement.setDate(9, new java.sql.Date(scholarship.getEndDate().getTime()));
//            preparedStatement.setBoolean(10, scholarship.getIsExpired());
            preparedStatement.setString(11, scholarship.getWebUrl());
            preparedStatement.setBoolean(12, true);

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


	@Override
	public boolean updateLauchStatusbyId(Integer scholoarshipId, boolean isUpdated) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeScholarshipById(Integer scholoarshipId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Scholarship> findScholarshipByInstitutionId(String institutionId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Scholarship> findAllscholarship() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Scholarship> findScholarshipByEntity(String entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Scholarship> findScholarshipByEntityAndAmount(String entity, Integer scholarshipAmount) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Scholarship> findScholarshipByAmount(Integer scholarshipAmount) {
		// TODO Auto-generated method stub
		return null;
	}


	public static Boolean updateUsernameById123546(Integer userId, String Password, String NewUserName) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
