import org.omg.CORBA.*;                 // Import CORBA core classes
import org.omg.PortableServer.*;        // For Portable Object Adapter (POA)
import java.io.*;                       // For writing reference file

// === Implementation of remote methods ===
class CalcImpl extends CalcPOA {        // Inherit generated skeleton CalcPOA
  public long add(long a,long b){return a+b;}     // Add two numbers
  public long sub(long a,long b){return a-b;}     // Subtract
  public long mul(long a,long b){return a*b;}     // Multiply
  public double div(long a,long b){ return b!=0 ? (double)a/b : 0; }// Divide safely
}

public class Server {
  public static void main(String[] args)throws Exception {
    ORB orb = ORB.init(args,null);                  // Start ORB (object broker)
    POA poa = POAHelper.narrow(                     // Get reference to RootPOA
        orb.resolve_initial_references("RootPOA"));
    poa.the_POAManager().activate();                // Activate POA manager

    CalcImpl obj = new CalcImpl();                  // Create servant object
    org.omg.CORBA.Object ref =                     // Get CORBA reference
        poa.servant_to_reference(obj);

    PrintWriter pw = new PrintWriter("ref.txt");    // Open file to store reference
    pw.println(orb.object_to_string(ref));          // Convert ref → string
    pw.close();                                     // Save and close file

    System.out.println("✅ Server ready. Waiting for client...");
    orb.run();                                      // Keep server running
  }
}
