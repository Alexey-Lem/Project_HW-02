package Comparators;

import org.apache.commons.lang3.StringUtils;
import org.example.University;

public class UniverIdComparator implements UniverComparator {
    @Override
    public int compare(University o1, University o2) {
        return StringUtils.compare(o1.getId(), o2.getId());
    }
}
