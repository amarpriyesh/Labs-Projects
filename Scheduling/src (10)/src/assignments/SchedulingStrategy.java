package assignments;

import java.util.Comparator;
import java.util.List;

public interface SchedulingStrategy extends Comparator<Assignment> {

  public  String schedule(List<Assignment> list) ;
}
