package oy.interact.tira.student;
import oy.interact.tira.model.Coder;
import java.util.Comparator;

public class CoderFullNameComparator implements Comparator<Coder>{

    @Override
    public int compare(Coder o1, Coder o2) {
        String fullName1 = o1.getFullName();
        String fullName2 = o2.getFullName();

        return fullName1.compareTo(fullName2);
    }
    
}
