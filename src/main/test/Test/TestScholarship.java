package Test;

import scholarship.entity.Institution;
import scholarship.entity.Scholarship;
import scholarship.entity.User;
import scholarship.model.ScholarshipDao;
import scholarship.model.ScholarshipInMemory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;

public class TestScholarship {

    public static void main(String[] args) throws ParseException {
        ScholarshipDao dao = new ScholarshipInMemory();

        // 加入 institutions
        Institution institution1 = new Institution("25464112", "行天宮", "李先生", "0922555444");
        Institution institution2 = new Institution("25464112", "教育部", "陳小姐", "0989876543");
        dao.addInstitution(institution1);
        dao.addInstitution(institution2);

        // 加入 users
        User user1 = new User(101, "dave11", "password1", "25444111");
        User user2 = new User(102, "lyndon22", "password2", "88854115");
        dao.addUser(user1);
        dao.addUser(user2);

        institution1.setUser(user1);
        institution2.setUser(user2);

        // 加入 scholarships
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date startDate1 = dateFormat.parse("2023-11-01");
        Date startDate2 = dateFormat.parse("2023-12-01");
        Date endDate1 = dateFormat.parse("2023-11-30");
        Date endDate2 = dateFormat.parse("2023-12-30");

        Scholarship scholarship1 = new Scholarship(201, 101, "行天宮助寒獎學金", "國小", 50000, new Date(), startDate1,
                endDate1, "http://example.com");
        Scholarship scholarship2 = new Scholarship(202, 102, "文昌帝君助寒獎學金", "國小", 60000, new Date(), startDate2,
                endDate2, "http://example.com");
        dao.addScholarship(scholarship1);
        dao.addScholarship(scholarship2);

        // 輸出
        System.out.println( dao.findAllInstitution());
        System.out.println("All Users: " + dao.findAllUsers());
        System.out.println("All Scholarships: " + dao.findAllscholarship());

        System.out.println("-------------------------------");
        List<Scholarship> entityScholarships = dao.findScholarshipByEntity("國小");
        for (Scholarship scholarship : entityScholarships) {
            System.out.printf("Scholarship ID: %d, Scholarship Name: %s, Amount: %d, Entity: %s\n",
                    scholarship.getScholarshipId(), scholarship.getScholarshipName(),
                    scholarship.getScholarshipAmount(), scholarship.getEntity());
        }
        
        
    }
}
