package bitcamp.java89.ems.vo;

import java.io.Serializable;

public class Lecture implements Serializable {
  private static final long serialVersionUID = 1L;
  
  protected String name;        //강좌 이름
  protected int no;          //강좌 기수
  protected String dstart;      //강좌 시작일
  protected String dend;        //강좌 종료일
  protected String time;        //교육 시간
  protected String company;     //강좌 센터명
  protected String location;    //강좌 센터위치
  protected String teachname;   //강사 이름
  protected int money;          //강좌 등록비
  protected int num;            //강좌 모집정원
  protected boolean government; //국비지원여부


  public Lecture () {}
/*
  public Lecture(String name, String company, int money, boolean government) {
    this.name = name;
    this.company = company;
    this.money = money;
    this.government = government;
  }
*/
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDstart() {
    return dstart;
  }

  public void setDstart(String dstart) {
    this.dstart = dstart;
  }

  public String getDend() {
    return dend;
  }

  public void setDend(String dend) {
    this.dend = dend;
  }

  public String getTime() {
    return time;
  }

  public void setTime(String time) {
    this.time = time;
  }

  public String getCompany() {
    return company;
  }

  public void setCompany(String company) {
    this.company = company;
  }

  public String getLocation() {
    return location;
  }

  public void setLocation(String location) {
    this.location = location;
  }

  public String getTeachname() {
    return teachname;
  }

  public void setTeachname(String teachname) {
    this.teachname = teachname;
  }

  public int getMoney() {
    return money;
  }

  public void setMoney(int money) {
    this.money = money;
  }

  public int getNum() {
    return num;
  }

  public void setNum(int num) {
    this.num = num;
  }

  public int getNo() {
    return no;
  }

  public void setNo(int no) {
    this.no = no;
  }

  public boolean isGovernment() {
    return government;
  }

  public void setGovernment(boolean government) {
    this.government = government;
  }

  public static long getSerialversionuid() {
    return serialVersionUID;
  }

  @Override
  public String toString() {
    return "Lecture [name=" + name + ", dstart=" + dstart + ", dend=" + dend + ", time=" + time + ", company=" + company
        + ", location=" + location + ", teachname=" + teachname + ", money=" + money + ", num=" + num + ", no=" + no
        + ", government=" + government + "]";
  }
}
