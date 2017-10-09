/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javarmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author nguyenhung
 */
public class PhuongThucTuXa extends UnicastRemoteObject implements KhuonMauTuXa {

    public PhuongThucTuXa() throws RemoteException {
        super();
    }

    @Override
    public float ChuyenDoi(float a) throws RemoteException {
        return (float) (a * 0.61);
    }
}
