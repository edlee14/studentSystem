//Taken from example from previous year
package my.studentSystem.bean;

public class Student {
    private String studentCode,studentNo,
            studentName, studentNationality, studentType,
            studentSex;
    private double studentAge;

    


    public String getStudentCode() {
        return studentCode;
    }
    public void setStudentCode(String studentCode) {
        this.studentCode = studentCode;
    }


    public String getStudentNo() {
        return studentNo;
    }
    public void setStudentNo(String studentNo) {
        this.studentNo = studentNo;
    }


    public String getStudentName() {
        return studentName;
    }
    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }


    public String getStudentNationality() {
        return studentNationality;
    }
    public void setStudentNationality(String studentNationality) {
        this.studentNationality = studentNationality;
    }


    public String getStudentType() {
        return studentType;
    }
    public void setStudentType(String studentType) {
        this.studentType = studentType;
    }


    public String getStudentSex() {
        return studentSex;
    }
    public void setStudentSex(String studentSex) {
        this.studentSex = studentSex;
    }

    public double getStudentAge() {
        return studentAge;
    }
    public void setStudentAge(double studentAge) {
        this.studentAge = studentAge;
    }
    
    


    public Student() {
		super();
	}

	public Student(String studentCode, String studentNo, String studentName, String studentNationality,
			String studentType, String studentSex, double studentAge) {
		super();
		this.studentCode = studentCode;
		this.studentNo = studentNo;
		this.studentName = studentName;
		this.studentNationality = studentNationality;
		this.studentType = studentType;
		this.studentSex = studentSex;
		this.studentAge = studentAge;
	}

	public String toString() {
        return "StudentAccount{" + "studentCode=" + studentCode + ", studentNo=" + studentNo + ", studentName=" + studentName + ", studentNationality=" + studentNationality + ", studentType=" + studentType + ", studentSex=" + studentSex + ", studentAge=" + studentAge + '}';
    }
    

}
