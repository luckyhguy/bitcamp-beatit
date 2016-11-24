package bitcamp.java89.ems.dao;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import bitcamp.java89.ems.vo.Lecture;

public class LectureDao {
  static LectureDao obj;
  private ArrayList<Lecture> list;
  private String filename = "lecture-v1.8.data";

  public static LectureDao getInstance() {
    if (obj == null) {
      obj = new LectureDao();
    }
    return obj;
  }

  private LectureDao() {
    this.load();
  }

  @SuppressWarnings("unchecked")
  private void load() {
    ObjectInputStream in = null;

    try {
      in = new ObjectInputStream(new FileInputStream(this.filename));

      list = (ArrayList<Lecture>)in.readObject();

    } catch (EOFException e) {
      // 파일을 모두 읽었다.
    } catch (Exception e) {
      System.out.println("데이터 로딩 중 오류 발생!");
      list = new ArrayList<>();
    } 
  }

  synchronized public void save() throws Exception {
    try (
        // FileOutputStream out0 = new FileOutputStream(this.filename);
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(this.filename));) {

      out.writeObject(list);

    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  //add?name=1&no=1&dstart=1&dend=1&time=1&company=1&location=1&teachname=1&money=1&num=1&government=y
  //add?name=홍길동&position=대리&tel=111-1111&email=hong@test.com
  synchronized public void insert(Lecture lecture) {
    list.add(lecture);
    try {this.save();} catch (Exception e) {}
  }


  public boolean existName(String name) {
    for (Lecture lecture : list) {
      if (lecture.getName().equals(name)) {
        return true;
      }
    }
    return false;
  }

  public ArrayList<Lecture> getList() {
    return this.list;
  }

  synchronized public void delete(String name) {
    for (int i = 0; i < list.size(); i++) {
      if (list.get(i).getName().equals(name)) {
        list.remove(i);
        try {this.save();} catch (Exception e) {}
        return;
      }
    }
  }
  public ArrayList<Lecture> getListByName(String name) {
    ArrayList<Lecture> results = new ArrayList<>();
    for (Lecture lecture : list) {
      if (lecture.getName().equals(name)) {
        results.add(lecture);
      }
    }
    return results;
  }
  synchronized public void update(Lecture lecture) {
    for (int i = 0; i < list.size(); i++) {
      if (list.get(i).getName().equals(lecture.getName())) {
        list.set(i, lecture);
        try {this.save();} catch (Exception e) {}
        return;
      }
    }
  }
} // class
