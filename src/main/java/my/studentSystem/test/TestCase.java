package my.studentSystem.test;

import java.util.List;

import org.junit.Test;

import my.studentSystem.bean.Student;
import my.studentSystem.dao.StudentDao;

public class TestCase {
	static StudentDao dao = new StudentDao();
	@Test//add
	public void add() {
		Student student =new Student();
		student.setStudentCode("2134");
		student.setStudentNo("1234");
		student.setStudentName("LiSa");
		student.setStudentNationality("China");
		student.setStudentSex("female");
		student.setStudentType("FT");
		student.setStudentAge(25.0);
		
		int a =dao.addStudentAccount(student);
		if(a==1) {
			System.out.println("Add record successful");
		}else {
			System.out.println("studentCode or studentNo is already exist");
		}
	}
		
		
	@Test //query
	public void query() {
		List<Student>list= dao.query();
		if(list!=null) {
			System.out.println("query ok");
		}else {
			System.out.println("record is null");
		}
		
		for (Student student : list) {
			System.out.println(student);
		}
		
	}
	
	@Test //delete
	public void deleteByCodeAndNo() {
		int a =dao.deleteStudentAccount("2134", "1234");
		if(a>0) {
			System.out.println("delete ok");
		}else {
			System.out.println("studentCode or studentNO  is no exist ");
		}
	}
	
	@Test //update
	public void UpdateByCodeAndNo() {
//		 "UPDATE SUTDNET_TABLE "
//                 + "SET studentName=?, studentNationality=?, studentType=?,"
//                 + "studentSex=?, studentAge=? "
//                 + "WHERE (studentCode=? AND studentNo=?)");
		Student student = new Student("2134","1234","XiaoMing","England","FT","male",25);
		int a= dao.update(student);
		if(a>0) {
			System.out.println("update OK");
		}else {
			System.out.println("update failure ,because Code or No is not exist ");
		}
		
	}
	
	
	
		
	

}
