package com.gupao.vip.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * @author xl48886
 * @version Id : ISayHello, v 0.1 2018/01/13 上午12:51 xl48886 Exp $
 */
public interface ISayHello extends Remote {

    String sayHello(String name) throws RemoteException;

}
