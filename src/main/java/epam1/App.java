package epam1;
import org.graalvm.compiler.nodes.NodeView;

import java.util.*;
/**
 * Hello world!
 *
 */
class Sweets{
    private String name;
    private int sweetness;
    private double size;

    Sweets(String name, double s1, int s2){
        setName(name);
        setSize(s1);
        setSweetness(s2);
    }

    private void setName(String name) {
        this.name = name;
    }

    private void setSize(double s) {
        size = s;
    }

    private void setSweetness(int s) {
        sweetness = s;
    }

    double getSize(){ return size ; }

    int getSweetness() {
        return sweetness;
    }
}

public class App
{
    public static void main( String[] args )
    {
        List<List<Sweets>> gifts = new ArrayList<>();
        List<Sweets> g1;

        Scanner input = new Scanner("System.in");
        Sweets g;
        int i = 1, sweetness;
        String name, more;
        double size;
        do {
            System.out.println("Gift " + i + " :");
            g1 = new ArrayList<>();
            do {
                name = input.next();
                sweetness = input.nextInt();
                size = input.nextDouble();

                g = new Sweets(name, size, sweetness);
                g1.add(g);

                System.out.print("More? (y/n) : ");
                more = input.next();

            } while (!more.equals("n"));
            gifts.add(g1);
            System.out.print("Okay...\nMore Gifts? (y/n) : ");
            more = input.next();

        } while (!more.equals("n"));

        System.out.println("How do you want to sort the chocolate in the gifts? \n 1. Size\n 2. Sweetness");
        i = input.nextInt();
        switch (i){
            case 1:
                showSizeSort(gifts);
                break;

            case 2:
                showSweetSort(gifts);
                break;

            default:
                System.out.println("Select from 1 or 2 from above... Retry");
        }
    }

    private static void showSizeSort(List<List<Sweets>> gifts){
        for(List<Sweets> s : gifts){
            s = sizeSort(s);
            System.out.println(s);
        }
    }

    private static void showSweetSort(List<List<Sweets>> gifts){
        for(List<Sweets> s : gifts){
            s = sweetSort(s);
            System.out.println(s);
        }
    }

    private static List<Sweets> sizeSort(List<Sweets> s){
        List<Sweets> arr = new ArrayList<>();

        Sweets l, ll;

        for(int i = 0 ; i < s.size() ; i++) {
            l = s.get(i) ;
            for (int j = i+1; j < s.size(); j++) {
                ll = s.get(j);
                if (l.getSize() > ll.getSize()) {
                    l = ll;
                }
            }
            arr.add(l);
        }
        return arr;
    }

    private static List<Sweets> sweetSort(List<Sweets> s){
        List<Sweets> arr = new ArrayList<>();

        Sweets l, ll;

        for(int i = 0 ; i < s.size() ; i++) {
            l = s.get(i) ;
            for (int j = i+1; j < s.size(); j++) {
                ll = s.get(j);
                if (l.getSweetness() > ll.getSweetness()) {
                    l = ll;
                }
            }
            arr.add(l);
        }
        return arr;
    }
}
