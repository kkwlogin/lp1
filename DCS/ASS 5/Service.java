import javax.jws.*;                                   // Import JAX-WS annotations
import javax.xml.ws.Endpoint;                         // Used to publish the web service

@WebService(targetNamespace = "http://myservice/")    // Define SOAP service + namespace
public class Service {

    @WebMethod                                         // Make this method remotely accessible
    public int add(int a, int b) {                     // Method performs addition
        return a + b;                                  // Return sum to client
    }

    public static void main(String[] args) {
        // Publish the web service locally at given URL
        Endpoint.publish("http://localhost:8080/calc", new Service());  // Start SOAP service
        System.out.println("Service running at: http://localhost:8080/calc?wsdl"); // Display WSDL link
    }
}
