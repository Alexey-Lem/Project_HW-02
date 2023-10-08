package Comparators;

import org.example.University;

import java.util.Comparator;
import java.util.function.Function;

public class UniverYearOfFoundationComparator implements UniverComparator {
    @Override
    public int compare(University o1, University o2) {
        return Integer.compare(o1.getYearOfFoundation(), o2.getYearOfFoundation());
    }
}
