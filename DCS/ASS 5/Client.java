// ===== SOAP Client (Fixed Version) =====
import java.net.URL;                                   // For connecting to WSDL URL
import javax.xml.namespace.QName;                      // For unique service identification
import javax.xml.ws.Service;                           // JAX-WS Service class to access server
import java.util.Scanner;                              // To take user input

public class Client {
    public static void main(String[] args) throws Exception {
        // URL where the WSDL is available (server must be running)
        URL url = new URL("http://localhost:8080/calc?wsdl");  // Web service description location

        // QName(namespaceURI, serviceName) — must match values from server
        QName qname = new QName("http://myservice/", "ServiceService");  // Identify the web service

        // Create a reference to the published service
        Service service = Service.create(url, qname);  // Create connection to the WSDL

        // Get the proxy (stub) to call remote methods
        myservice.Service calc = service.getPort(myservice.Service.class);  // Access remote Service interface

        // Take user input for addition
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter two numbers: ");       // Prompt for numbers
        int a = sc.nextInt(), b = sc.nextInt();        // Read numbers

        // Invoke remote method and print result
        System.out.println("Sum = " + calc.add(a, b)); // Remote method call & display output
    }
}
