package com.gupao.vip.rmi;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

/**
 * @author xl48886
 * @version Id : SayHelloServer, v 0.1 2018/01/13 上午12:54 xl48886 Exp $
 */
public class SayHelloServer {

    public static void main(String[] args) {

        try {
            ISayHello sayHello = new SayHelloImpl();

            LocateRegistry.createRegistry(8888);

            Naming.bind("rmi://localhost:8888/sayHello", sayHello);

            System.out.println("server start success");
        } catch (RemoteException | AlreadyBoundException | MalformedURLException e) {
            e.printStackTrace();
        }
    }
}
