
import java.util.List;

//LEETCODE solution
/*
    Approach O(n2) : 
        Step 1 Do to level Sorting of events
        level 1 on the basis of time stamps and
        level 2 if time stamps are same then offline must come before message event
        Then its ery simple just handle all the cases in if else conditionng
 */
class Solution {

    public int[] countMentions(int numberOfUsers, List<List<String>> events) {
        events.sort((o1, o2) -> {
            int t1 = Integer.parseInt(o1.get(1));
            int t2 = Integer.parseInt(o2.get(1));
            int comTime = Integer.compare(t1, t2);
            if (comTime != 0) {
                return comTime;
            }

            String e1 = o1.get(0);
            String e2 = o2.get(0);
            if (e1.equalsIgnoreCase("Message") && e2.equalsIgnoreCase("Offline")) {
                return 1;
            } else if (e1.equalsIgnoreCase("Offline") && e2.equalsIgnoreCase("Message")) {
                return -1;
            }
            return 0;
        });

        int offline[] = new int[numberOfUsers];
        int m[] = new int[numberOfUsers];
        for (int i = 0; i < events.size(); i++) {
            List<String> e = events.get(i);
            if (e.get(0).equals("MESSAGE")) {
                String str = e.get(2);
                if (str.equals("ALL")) {
                    for (int j = 0; j < numberOfUsers; j++) {
                        m[j]++;
                    }
                } else if (str.equals("HERE")) {
                    for (int j = 0; j < numberOfUsers; j++) {
                        int t = Integer.parseInt(e.get(1));
                        if (offline[j] <= t) {
                            m[j]++;
                        }
                    }
                } else {
                    String ids[] = str.split(" ");
                    for (int j = 0; j < ids.length; j++) {
                        if (ids[j].equals("")) {
                            continue;
                        }
                        m[Integer.parseInt(ids[j].substring(2))] += 1;
                    }
                }
            } else {
                offline[Integer.parseInt(e.get(2))] = Integer.parseInt(e.get(1)) + 60;
            }
        }
        return m;

    }
}
