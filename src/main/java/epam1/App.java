package epam1;
//import org.graalvm.compiler.nodes.NodeView;

import java.util.*;
/**
 * Hello world!
 *
 */
class Sweets{
    private String name;
    private int sweetness, weight;
    private double size;

    Sweets(String name, double s1, int s2, int w){
        setName(name);
        setSize(s1);
        setSweetness(s2);
        setWeight(w);
    }

    private void setWeight(int w) { weight = w ; }
    private void setName(String n) {
        name = n;
    }
    private void setSize(double s) {
        size = s;
    }
    private void setSweetness(int s) {
        sweetness = s;
    }

    String getName() { return name ; }
    double getSize(){ return size ; }
    int getWeight(){ return weight ; }
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

        Scanner input = new Scanner(System.in);
        Sweets g;
        int i = 1, sweetness, weight, totalwgt = 0, wgt;
        String name, more;
        double size;
        do {
            System.out.println("Gift " + i + " :");
            g1 = new ArrayList<>();
            wgt = 0;
            do {
                System.out.print("Name : "); name = input.next();
                System.out.print("Sweetness : "); sweetness = input.nextInt();
                System.out.print("Size : "); size = input.nextDouble();
                System.out.print("Weight : "); weight = input.nextInt();

                wgt += weight;

                g = new Sweets(name, size, sweetness,weight);
                g1.add(g);

                System.out.print("More? (y/n) : ");
                more = input.next();

            } while (!more.equals("n"));
            gifts.add(g1);
            System.out.print("Okay...\nMore Gifts? (y/n) : ");
            more = input.next();
            totalwgt += wgt;
            ++i;
        } while (!more.equals("n"));

        String sweet;
        System.out.println("What do you want to do?\n 1. Get total weight\n 2. Sort the Sweets and get output\n 3. Search for sweets in the Gifts");
        int k = input.nextInt();
        switch (k) {
            case 1:
                System.out.println("Total weight of all the gifts combined = " + totalwgt);
                break;

            case 2:
                System.out.println("How do you want to sort the chocolate in the gifts? \n 1. Size\n 2. Sweetness\n 3. Weight");
                i = input.nextInt();
                switch (i) {
                    case 1:
                        showSizeSort(gifts);
                        break;

                    case 2:
                        showSweetSort(gifts);
                        break;

                    case 3:
                        showWgtSort(gifts);
                        break;

                    default:
                        System.out.println("Select from 1 or 2 from above... Retry");
                }
                break;

            case 3:
                sweet = input.next();
                searchingSweet(gifts,sweet);
                break;

            default:
                System.out.println("Please enter your selection number(1/2/3) from above... \nRetry");
        }
    }

    private static void searchingSweet(List<List<Sweets>> gifts, String name){
        int nos,i=1,totsweets = 0;
        for(List<Sweets> s : gifts){
            nos = sS(s, name);
            System.out.println("Number of requested sweets present in the gift "+i+" is : "+nos);
            ++i;
            totsweets += nos;
        }

        System.out.println("Total no. of requested sweet present in all the presents is : "+totsweets);
    }

    private static int sS(List<Sweets>s, String sweet){
        int nos = 0;
        for(Sweets k : s){
            if(sweet.equals(k.getName())){
                ++nos;
            }
        }

        return nos;
    }


    private static void showSizeSort(List<List<Sweets>> gifts){
        int i = 1;
        System.out.println("Sorting according to Size : ");
        for(List<Sweets> s : gifts){
            s = sizeSort(s);
            System.out.println("Sorted gift "+i+" :");
            for(Sweets k : s){
                System.out.print(k.getName()+",");
            }
            System.out.println("\b");
            ++i;
        }
    }

    private static void showWgtSort(List<List<Sweets>> gifts){
        int i = 1;
        System.out.println("Sorting according to Weight : ");
        for(List<Sweets> s : gifts){
            s = wgtSort(s);
            System.out.println("Sorted gift "+i+" :");
            for(Sweets k : s){
                System.out.print(k.getName()+",");
            }
            System.out.println("\b");
            ++i;
        }
    }

    private static void showSweetSort(List<List<Sweets>> gifts){
        int i = 1;
        System.out.println("Sorting according to Sweetness : ");
        for(List<Sweets> s : gifts){
            s = sweetSort(s);
            System.out.println("Sorted gift "+i+" :");
            for(Sweets k : s){
                System.out.print(k.getName()+",");
            }
            System.out.println("\b");
            ++i;
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

    private static List<Sweets> wgtSort(List<Sweets> s){
        List<Sweets> arr = new ArrayList<>();

        Sweets l, ll;

        for(int i = 0 ; i < s.size() ; i++) {
            l = s.get(i) ;
            for (int j = i+1; j < s.size(); j++) {
                ll = s.get(j);
                if (l.getWeight() > ll.getWeight()) {
                    l = ll;
                }
            }
            arr.add(l);
        }
        return arr;
    }
}
