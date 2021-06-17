package org.htlleo;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Identity Service!" );
        int port = 3333;
        String serviceName = "UIDService";

        try {
            IdentityServiceObject service = new IdentityServiceObject();
            IdentityService stub = (IdentityService) UnicastRemoteObject.exportObject(service, port);

            // Bind the remote object's stub in the registry
            Registry registry = LocateRegistry.createRegistry(port);
            registry.bind(serviceName, stub);

            System.err.println("Server ready");
        } catch (Exception e) {
            System.out.println("Server exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
