package bitcamp.java89.ems;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;

public class LectureListController implements Command {

  private LectureDao lectureDao;

  public LectureListController() {
    lectureDao = LectureDao.getInstance();
  }

  public void service(HashMap<String,String> paramMap, PrintStream out) {
    ArrayList<Lecture> list = lectureDao.getList();
    for (Lecture lecture : list) {
      out.printf("%s %d %s %s %s %s %s %s %d %d %s\n",
          lecture.getName(), lecture.getNo(), lecture.getDstart(), lecture.getDend(), lecture.getTime(), lecture.getCompany()
          , lecture.getLocation(), lecture.getTeachname(), lecture.getMoney(), lecture.getNum(), (lecture.isGovernment()? "yes" : "No"));
    }
  }
} // class
