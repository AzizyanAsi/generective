package generective;

import java.util.Scanner;
import java.util.UUID;

import static generective.Util.getRoots;

public class MenuMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean isMenuActive = true;
        while (isMenuActive) {
            System.out.println("type group name or continue");

            System.out.println("0. exit");
            String s = sc.nextLine();
            switch (s) {
                case "continue":
                    isMenuActive=false;
                    generateItem(sc);

                    break;
                default:
                    if(s.isEmpty()){
                        break;
                    }
                    Group g=new Group(UUID.randomUUID().toString(),s);
                    System.out.println("type root id");
                    String s1 = sc.nextLine();
                    g.setParentId(s1);
                    Util.addGroup(g,getRoots());
                    System.out.println(g);

                    System.out.println("invalid number");
            }
        }
        for (Group x:getRoots()) {
          x.printGroups();

        }
    }

    private static void generateItem(Scanner sc) {

    }
}