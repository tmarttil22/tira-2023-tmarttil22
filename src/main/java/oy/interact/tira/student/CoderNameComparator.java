package oy.interact.tira.student;
import oy.interact.tira.model.Coder;
import java.util.Comparator;

public class CoderNameComparator implements Comparator<Coder>{

    @Override
    public int compare(Coder o1, Coder o2) {
      String coderName1 = o1.getCoderName();
      String coderName2 = o2.getCoderName();

      return coderName1.compareTo(coderName2);
    }

}
