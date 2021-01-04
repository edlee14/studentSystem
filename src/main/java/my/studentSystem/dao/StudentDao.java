package my.studentSystem.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import my.studentSystem.bean.Student;
import my.studentSystem.util.DB_Util;



public class StudentDao {
	
	Connection conn = null;
	PreparedStatement pstmt  = null;
	ResultSet rs = null;
//查询
	public  List<Student> query() {
		List<Student> list = new ArrayList<Student>();
		try {
			conn = DB_Util.open();
			String sql = "select * from STUDENT_TABLE";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				
			    Student student = new Student(
	                    rs.getString("studentCode"),
	                    rs.getString("studentNo"),
	                    rs.getString("studentName"),
	                    rs.getString("studentNationality"),
	                    rs.getString("studentType"),
	                    rs.getString("studentSex"),
	                    rs.getDouble("studentAge"));
				
				
				
//
//				int f_orderId = rs.getInt("f_orderId");
//				String f_orderName = rs.getString("f_orderName");
//				int money = rs.getInt("money");
//				Student food_order = new Student(f_orderId, f_orderName, money);

				list.add(student);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DB_Util.close(conn, pstmt, rs);
		}
		return list;
	}
	
	
	//查询 studentCode，studentNo有没有
	public Student getAccountDetails(String studentCode,
            String studentNo) {
		
        Student student = null;

        try {
        	conn = DB_Util.open();
            PreparedStatement ps = conn.prepareStatement(
                    "SELECT * FROM student_table WHERE studentCode = ? and studentNo=?");
            ps.setString(1, studentCode);
            ps.setString(2, studentNo);

            ResultSet rs = ps.executeQuery();

            // move the cursor to the first row
            if (!rs.next()) {  // !F==T
                return null;
            }

            // process the record
            student = new Student(
            		   rs.getString("studentCode"),
	                    rs.getString("studentNo"),
	                    rs.getString("studentName"),
	                    rs.getString("studentNationality"),
	                    rs.getString("studentType"),
	                    rs.getString("studentSex"),
	                    rs.getDouble("studentAge"));

        } catch (SQLException sqle) {
            System.err.println("SQLException in getAccountDetails()");
            sqle.printStackTrace();
        }
        finally {
			DB_Util.close(conn, pstmt, rs);
		}

        return student;
    }

//修改
	public int update(Student ba) {
		try {
			
	        if (getAccountDetails(ba.getStudentCode(), ba.getStudentNo()) == null) {
                // bank account is not in the db
                return -1;
            } else {
            	conn = DB_Util.open();
                // account is in the db 
                PreparedStatement ps = conn.prepareStatement(
                        "UPDATE student_table "
                                + "SET studentName=?, studentNationality=?, studentType=?,"
                                + "studentSex=?, studentAge=? "
                                + "WHERE (studentCode=? AND studentNo=?)");


                ps.setString(1, ba.getStudentName());
                ps.setString(2, ba.getStudentNationality());
                ps.setString(3, ba.getStudentType());
                ps.setString(4, ba.getStudentSex());
                ps.setDouble(5, ba.getStudentAge());
                ps.setString(6, ba.getStudentCode());
                ps.setString(7, ba.getStudentNo());
                ps.executeUpdate();
            }} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  finally {
			DB_Util.close(conn, pstmt, rs);
		}
		return 1;

	}
	
	//添加
	  public int addStudentAccount(Student ba) {
	        try {
	            // make sure that this account is not already
	            // in the db
	            if (getAccountDetails(ba.getStudentCode(), ba.getStudentNo()) != null) {
	                // bank account is already in the db
	                return -1;
	            } else {
	            	
	            	conn = DB_Util.open();
	                // account is not in the db already
	                PreparedStatement ps = conn.prepareStatement(
	                        "INSERT INTO STUDENT_TABLE "
	                                + "(studentCode, studentNo,"
	                                + "studentName, studentNationality, studentType,"
	                                + "studentSex, studentAge) "
	                                + "VALUES (?,?,?,?,?,?,?)");

	                ps.setString(1, ba.getStudentCode());
	                ps.setString(2, ba.getStudentNo());
	                ps.setString(3, ba.getStudentName());
	                ps.setString(4, ba.getStudentNationality());
	                ps.setString(5, ba.getStudentType());
	                ps.setString(6, ba.getStudentSex());
	                ps.setDouble(7, ba.getStudentAge());
	                ps.executeUpdate();
	            }   
	        } catch (SQLException sqle) {
	            System.err.println("SQLException in addBankAccount()");
	            sqle.printStackTrace();
	            return -1;
	        }
	        finally {
				DB_Util.close(conn, pstmt, rs);
			}
	        
	        return 1; // ok
	    }
	  
	  
	    public int deleteStudentAccount(String studentCode,
	            String studentNo) {
	    	int a =0;
	        try {
	        	
	        	conn = DB_Util.open();
	            PreparedStatement ps = conn.prepareStatement(
	                    "DELETE FROM STUDENT_TABLE WHERE "
	                    + "(studentCode = ? AND studentNo=?)");
	            ps.setString(1, studentCode);
	            ps.setString(2, studentNo);

	            a= ps.executeUpdate();

	        } catch (SQLException sqle) {
	            System.err.println("SQLException in deleteBankAccount()");
	            sqle.printStackTrace();
	        }
	        finally {
				DB_Util.close(conn, pstmt, rs);
			}
	        return a;
	        
	    }

	
	

}
