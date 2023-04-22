package assignment7;


public class Student {
	private String first;
	private String last;
	private int id;
	private int credAtt;
	private int credPass;
	private double[] qp;
	private int ind;
	private double bbb;

	public Student(String firstName, String lastName, int idNum) {
		first = firstName;
		last = lastName;
		id = idNum;
		credAtt=0;
		credPass=0;
		ind=1;
		qp=new double[300];

	}
/**
 * 
 * @return full name of student
 */
	public String getFullName() {
		return first+" "+last;
	}
/**
 * 
 * @return id number
 */
	public int getId() {
		return id;
	}


/**
 * 
 * @param grade - grade on a scale of 1-4
 * @param credits - number of credits for the class to which the grade corresponds
 */
	public void submitGrade(double grade, int credits) {
		credAtt = credAtt+credits;
		if(grade>=1.7) {
			credPass = credPass+credits;
		}

		qp[ind-1]=grade*credits;
		ind++;



	}
/**
 * 
 * @return total number of credits attempted
 */
	public int getTotalAttemptedCredits() {
		return credAtt;
	}
/**
 * 
 * @return total number of pasing credits
 */
	public int getTotalPassingCredits() {
		return credPass;
	}
/**
 * 
 * @return GPA of the student based on classes taken
 */
	public double calculateGradePointAverage() {
		double totalQP=0;
		for(int j=0; j<ind-1;j++) {
			totalQP = totalQP + qp[j];
		}
		return totalQP/credAtt;
	}
/**
 * 
 * @return year in school based on credits taken
 */
	public String getClassStanding() {
		if (credPass<30) {
			return "First Year";
		} else if(credPass>=30&&credPass<60) {
			return "Sophomore";
		}else if(credPass>=60&&credPass<90) {
			return "Junior";
		} else {
			return "Senior";
		}
	}
/**
 * 
 * @return whether or not the student is eligible
 */
	public boolean isEligibleForPhiBetaKappa() {
		if((credAtt>=98&&calculateGradePointAverage()>=3.60) ||(credAtt>=75&&calculateGradePointAverage()>=3.80)) {
			return true;
		} else {
			return false;
		}
	}
/**
 * depositing bear bucks
 * @param amount - amount of bear bucks to be deposited
 */
	public void depositBearBucks(double amount) {
		bbb=bbb+amount;
	}
	/**
	 * 
	 * @param amount - amount to be withdrawn
	 */
	public void deductBearBucks(double amount) {
		bbb=bbb-amount;
	}
	/**
	 * 
	 * @return current balance
	 */
	public double getBearBucksBalance() {
		return bbb;
	}
	/**
	 * 
	 * @return number of bear bucks cashed out
	 */
	public double cashOutBearBucks() {
		double cashOut=bbb-10;
		bbb=0;
		if(cashOut>0) {
			return cashOut;
		} else {
			return 0;
		}

	}
	
	/**
	 * 
	 * @param firstName - of child
	 * @param otherParent - other parent of child
	 * @param isHyphenated - whether or not last name changes
	 * @param id - student legacy id number
	 * @return new student that is a legacy
	 */
	public Student createLegacy(String firstName, Student otherParent, boolean isHyphenated, int id) {
		String lastName="";
		if(isHyphenated) {
			 lastName = this.last+"-"+otherParent.last;
		} else {
			 lastName = this.last;
		}
		double bearBucks = this.cashOutBearBucks()+otherParent.cashOutBearBucks();
		Student legacy = new Student(firstName, lastName, id);
		legacy.depositBearBucks(bearBucks);
		
		return legacy;
		
	}
	
	public String toString() {
		return getFullName() + id;
	}
	
}
