/* EduAppServer(사용자)와 컨트롤러(피사용자) 사이의 호출 규칙을 정의 */

package bitcamp.java89.ems;

import java.io.PrintStream;
import java.util.HashMap;

public interface Command {
  void service(HashMap<String,String> paramMap, PrintStream out);
}
