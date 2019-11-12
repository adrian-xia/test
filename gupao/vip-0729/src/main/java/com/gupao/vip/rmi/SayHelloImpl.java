package com.gupao.vip.rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * @author xl48886
 * @version Id : SayHelloImpl, v 0.1 2018/01/13 上午12:52 xl48886 Exp $
 */
public class SayHelloImpl extends UnicastRemoteObject implements ISayHello {

    public SayHelloImpl() throws RemoteException {
    }

    @Override
    public String sayHello(String name) throws RemoteException {
        return "Hello Mic -> " + name;
    }
}
