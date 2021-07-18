package generective;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class Util {
    private static ArrayList<Group> roots = new ArrayList<>();

    public static void addToRoots(Group group) {
        roots.add(group);
    }

    public static boolean addGroup(Group addedGroup, ArrayList<Group> groups) {
        boolean isAdded = false;
        ArrayList<Group>copyGroup= new ArrayList<>(groups);
        Group g;
        Iterator<Group> iterator = copyGroup.iterator();
        while (iterator.hasNext()) {
            Group next = iterator.next();
                if (next instanceof Group) {
                    g = (Group) next;
                    if (g.getId().equals(addedGroup.getParentId())) {
                        groups.add(addedGroup);
                        return true;
                    } else {
                        isAdded = addGroup(addedGroup, g.getGroups());
                        if (isAdded) return true;
                    }
                }
            }

        if (!isAdded)
            roots.add(addedGroup);

        return false;
    }

    public static ArrayList<Group> getRoots() {
        return roots;
    }

}
