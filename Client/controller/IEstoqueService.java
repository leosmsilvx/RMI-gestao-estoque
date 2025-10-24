package controller;

import java.rmi.Remote;
import java.rmi.RemoteException;
import model.Estoque;

public interface IEstoqueService extends Remote {
    public void inserir(Estoque e) throws RemoteException;

    public void alterar(Estoque e) throws RemoteException;

    public void remover(Integer id) throws RemoteException;

    public Estoque consultarPorId(Integer id) throws RemoteException;
}