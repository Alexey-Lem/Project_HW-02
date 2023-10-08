package Comparators;

import org.apache.commons.lang3.StringUtils;
import org.example.University;

public class UniverShortNameComparator implements UniverComparator {
    @Override
    public int compare(University o1, University o2) {
        return StringUtils.compare(o1.getShortName(), o2.getShortName());
    }
}
