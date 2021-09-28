import java.util.*;
public class Test{

    public double calculateAverage(int[] age){
        double avg,t=0.00;
        
        for(int j=0;j<age.length;j++){
            t=age[j]+t;
        }
        avg=t/age.length;
        return avg;
    }
    
    
    
    public static void main (String[] args) {
        Scanner sc=new Scanner(System.in);
        Test t=new Test();
        
        System.out.println("Enter total no.of employees:");
        int n=sc.nextInt();
        if(n<2)
        System.out.println("Please enter a valid employee count");
        else{
            System.out.println("Enter the age for "+n+" employees:");
        int age[]=new int[n];
        for(int i=0;i<n;i++)
        {
            age[i]=sc.nextInt();
            if(age[i]<28||age[i]>40){
                System.out.println("Invalid age encountered!");
                break;
            }
            
        }
        for(int i=0;i<n;i++){
            if(age[i]>28&&age[i]<40){
                System.out.printf("The average age is %.2f",t.calculateAverage(age));
                break;
            }
        }
    }
        
    }
}