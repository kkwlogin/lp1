import org.omg.CORBA.*;                 // Import CORBA core classes
import java.io.*;                       // For reading reference file
import java.util.*;                     // For Scanner (user input)

public class Client {
  public static void main(String[] args)throws Exception {
    ORB orb = ORB.init(args,null);                       // Start ORB
    BufferedReader br = new BufferedReader(              // Open reference file
        new FileReader("ref.txt"));
    String refStr = br.readLine(); br.close();           // Read one line (IOR)
    Calc calc = CalcHelper.narrow(                       // Convert to Calc object
        orb.string_to_object(refStr));

    Scanner sc = new Scanner(System.in);                 // For user input
    System.out.print("Enter first number: "); long a = sc.nextLong();
    System.out.print("Enter second number: "); long b = sc.nextLong();
    System.out.print("Choose + - * / : "); char op = sc.next().charAt(0);

    switch(op){                                          // Select operation
      case '+': System.out.println("Result = "+calc.add(a,b)); break;
      case '-': System.out.println("Result = "+calc.sub(a,b)); break;
      case '*': System.out.println("Result = "+calc.mul(a,b)); break;
      case '/': System.out.println("Result = "+calc.div(a,b)); break;
      default : System.out.println("Invalid choice");
    }
  }
}
