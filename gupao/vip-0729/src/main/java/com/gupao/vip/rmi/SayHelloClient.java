package com.gupao.vip.rmi;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

/**
 * @author xl48886
 * @version Id : SayHelloClient, v 0.1 2018/01/13 上午12:58 xl48886 Exp $
 */
public class SayHelloClient {

    public static void main(String[] args) {
        try {
            ISayHello sayHello = (ISayHello) Naming.lookup("rmi://localhost:8888/sayHello");
            System.out.println(sayHello.sayHello("hello, feifei"));
        } catch (RemoteException | NotBoundException | MalformedURLException e) {
            e.printStackTrace();
        }
    }

}
