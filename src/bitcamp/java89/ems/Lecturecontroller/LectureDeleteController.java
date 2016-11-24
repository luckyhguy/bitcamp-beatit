package bitcamp.java89.ems.Lecturecontroller;

import java.io.PrintStream;
import java.util.HashMap;

import bitcamp.java89.ems.dao.LectureDao;
import bitcamp.java89.ems.Command;

public class LectureDeleteController implements Command {

  private LectureDao lectureDao;

  public LectureDeleteController() {
    lectureDao = LectureDao.getInstance();
  }

  public void service(HashMap<String,String> paramMap, PrintStream out) {
    if (!lectureDao.existName(paramMap.get("name"))) {
      out.println("해당 데이터가 없습니다.");
      return;
    }
    out.println("해당 이름을 찾지 못했습니다.");
    lectureDao.delete(paramMap.get("name"));
    out.println("해당 데이터를 삭제 완료하였습니다.");
  }
} // class
