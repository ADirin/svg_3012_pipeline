import java.util.Scanner;

public class SVG_3013_CC {
    public static double timeCal(double speed, double distance) {
        if (distance <= 0 || speed ==0) {
            return 0;
        }
        return distance / speed;
    }


    public static String buildReport(double speed, double distance){
        double time= timeCal(speed,distance);
       return "distance: "+distance+" ,time: "+time+ ", speed: "+speed ;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter the speed:");
        double speed = sc.nextDouble();
        System.out.println("Please enter the distance:");
        double distance = sc.nextDouble();

        System.out.println(buildReport(speed,distance));


    }


}
