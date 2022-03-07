package disburse.vo;

public class HouseDisburseDetail {
	private String BIOGUIDE_ID, OFFICE, CATEGORY, PAYEE, START_DATE, END_DATE, PURPOSE, YEAR;
	private double AMOUNT;
	public String getBIOGUIDE_ID() {
		return BIOGUIDE_ID;
	}
	public void setBIOGUIDE_ID(String bIOGUIDE_ID) {
		BIOGUIDE_ID = bIOGUIDE_ID;
	}
	public String getOFFICE() {
		return OFFICE;
	}
	public void setOFFICE(String oFFICE) {
		OFFICE = oFFICE;
	}
	public String getCATEGORY() {
		return CATEGORY;
	}
	public void setCATEGORY(String cATEGORY) {
		CATEGORY = cATEGORY;
	}
	public String getPAYEE() {
		return PAYEE;
	}
	public void setPAYEE(String pAYEE) {
		PAYEE = pAYEE;
	}
	public String getSTART_DATE() {
		return START_DATE;
	}
	public void setSTART_DATE(String sTART_DATE) {
		START_DATE = sTART_DATE;
	}
	public String getEND_DATE() {
		return END_DATE;
	}
	public void setEND_DATE(String eND_DATE) {
		END_DATE = eND_DATE;
	}
	public String getPURPOSE() {
		return PURPOSE;
	}
	public void setPURPOSE(String pURPOSE) {
		PURPOSE = pURPOSE;
	}
	public String getYEAR() {
		return YEAR;
	}
	public void setYEAR(String yEAR) {
		YEAR = yEAR;
	}
	public double getAMOUNT() {
		return AMOUNT;
	}
	public void setAMOUNT(double aMOUNT) {
		AMOUNT = aMOUNT;
	}
	@Override
	public String toString() {
		return "HouseDisburseDetail [BIOGUIDE_ID=" + BIOGUIDE_ID + ", OFFICE=" + OFFICE + ", CATEGORY=" + CATEGORY
				+ ", PAYEE=" + PAYEE + ", START_DATE=" + START_DATE + ", END_DATE=" + END_DATE + ", PURPOSE=" + PURPOSE
				+ ", YEAR=" + YEAR + ", AMOUNT=" + AMOUNT + "]";
	}
	
}
