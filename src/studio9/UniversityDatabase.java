package studio9;
import java.util.HashMap;
import java.util.Map;

import assignment7.Student;


public class UniversityDatabase {
	//TODO: Complete this class according to the studio instructions
	private final  Map<String, Student> data;
	
	public UniversityDatabase() {
		data = new HashMap<>();
	}
	public void addStudent(String accountName, Student student) {
		data.put(accountName, student);
	}

	public int getStudentCount() {
		return data.size();
	}

	public String lookupFullName(String accountName) {
		Student stud = data.get(accountName);
		if(stud==null) {
			return null;
		}
		
		return stud.getFullName();
	}

	public double getTotalBearBucks() {
		double tbb = 0;
		for(String i : data.keySet()) {
			tbb+=data.get(i).getBearBucksBalance();
		}
		return tbb;
	}
}
