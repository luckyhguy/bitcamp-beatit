package bitcamp.java89.ems.Lecturecontroller;

import java.io.PrintStream;
import java.util.HashMap;

import bitcamp.java89.ems.Command;
import bitcamp.java89.ems.dao.LectureDao;
import bitcamp.java89.ems.vo.Lecture;

public class LectureAddController implements Command {

  private LectureDao lectureDao;

  public LectureAddController() {
    lectureDao = LectureDao.getInstance();
  }
  // add?name=1&no=1&dstart=1&dend=1&time=1&company=1&location=1&teachname=1&money=1&num=1&government=y
  public void service(HashMap<String,String> paramMap, PrintStream out) {
    if (lectureDao.existName(paramMap.get("name"))) {
      out.println("같은 이름이 존재합니다. 등록을 취소합니다.");
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
    
    lectureDao.insert(lecture);
    out.println("등록하였습니다.");
  }
} // class
