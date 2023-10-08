package Comparators;

import org.apache.commons.lang3.StringUtils;
import org.example.StudyProfile;
import org.example.University;

public class UniverMainProfileComparator implements UniverComparator {
    @Override
    public int compare(University o1, University o2) {
        return StringUtils.compare(o1.getMainProfile().toString(), o2.getMainProfile().toString());
    }
}
