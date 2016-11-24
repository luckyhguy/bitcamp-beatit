package bitcamp.java89.ems;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;

public class LectureViewController implements Command {

  private LectureDao lectureDao;

  public LectureViewController() {
    lectureDao = LectureDao.getInstance();
  }

  public void service(HashMap<String,String> paramMap, PrintStream out) {
    ArrayList<Lecture> list = lectureDao.getListByName(paramMap.get("name"));
    for (Lecture lecture : list) {
      if (lecture.getName().equals(paramMap.get("name"))) {       
        out.println("============================");
        out.printf("강좌명 : %s\n", lecture.getName());
        out.printf("강좌기수 : %d기\n", lecture.getNo());
        out.printf("강좌시작일 : %s\n", lecture.getDstart());
        out.printf("강좌종료일 : %s\n", lecture.getDend());
        out.printf("교육시간 : %s\n", lecture.getTime());
        out.printf("강좌 센터명 : %s\n", lecture.getCompany());
        out.printf("강좌 센터 위치 : %s\n", lecture.getLocation());
        out.printf("강좌 담당 강사 : %s\n", lecture.getTeachname());
        out.printf("강좌 등록비 : %d원\n", lecture.getMoney());
        out.printf("강좌 모집 정원 : %d명\n", lecture.getNum());
        out.printf("국비지원여부 : %s\n", (lecture.isGovernment())? "yes" : "No");
        out.println("============================");
        break;
      }
      out.println("해당 이름을 찾지 못했습니다.");
    }
  }
} // class
