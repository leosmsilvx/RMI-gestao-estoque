package controller;

import model.Estoque;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IEstoqueService extends Remote {
    public void inserir(Estoque e) throws RemoteException;

    public void alterar(Estoque e) throws RemoteException;

    public void remover(Integer id) throws RemoteException;

    public Estoque consultarPorId(Integer id) throws RemoteException;
}