package bitcamp.java89.ems;

import java.io.PrintStream;
import java.util.HashMap;

public class LectureUpdateController implements Command {

  private LectureDao lectureDao;

  public LectureUpdateController() {
    lectureDao = LectureDao.getInstance();
  }

  public void service(HashMap<String,String> paramMap, PrintStream out) {
    if (!lectureDao.existName(paramMap.get("name"))) {
      out.println("해당 이름을 찾지 못했습니다.");
      return;
    }
    Lecture lecture = new Lecture();
    
    lecture.setName(paramMap.get("name"));
    lecture.setNo(Integer.parseInt(paramMap.get("no")));
    lecture.setDstart(paramMap.get("dstart"));
    lecture.setDend(paramMap.get("dend"));
    lecture.setTime(paramMap.get("time"));
    lecture.setCompany(paramMap.get("company"));
    lecture.setLocation(paramMap.get("location"));
    lecture.setTeachname(paramMap.get("teachname"));
    lecture.setMoney(Integer.parseInt(paramMap.get("money")));
    lecture.setNum(Integer.parseInt(paramMap.get("num")));
    lecture.setGovernment(paramMap.get("government").equals("y") ? true : false);
    lectureDao.update(lecture);
    out.println("변경 하였습니다.");
  }
} // class
