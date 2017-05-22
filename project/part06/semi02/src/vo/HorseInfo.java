package vo;

import java.sql.Date;

public class HorseInfo {
	private String horsename;
	private int horsenum;
	private Date birthdate;
	private String gender;
	private String color;
	private Date regdate;
	private String country;
	private String father;
	private String mother;
	private int trainernum;
	private String ownername;
	public HorseInfo() {}
	public String getHorsename() {
		return horsename;
	}
	public void setHorsename(String horsename) {
		this.horsename = horsename;
	}
	public int getHorsenum() {
		return horsenum;
	}
	public void setHorsenum(int horsenum) {
		this.horsenum = horsenum;
	}
	public Date getBirthdate() {
		return birthdate;
	}
	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getFather() {
		return father;
	}
	public void setFather(String father) {
		this.father = father;
	}
	public String getMother() {
		return mother;
	}
	public void setMother(String mother) {
		this.mother = mother;
	}
	public int getTrainernum() {
		return trainernum;
	}
	public void setTrainernum(int trainernum) {
		this.trainernum = trainernum;
	}
	public String getOwnername() {
		return ownername;
	}
	public void setOwnername(String ownername) {
		this.ownername = ownername;
	}
}
