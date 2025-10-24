package controller;

import model.Fornecedor;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IFornecedorService extends Remote {
    public void inserir(Fornecedor f) throws RemoteException;

    public void alterar(Fornecedor f) throws RemoteException;

    public void remover(Integer id) throws RemoteException;

    public Fornecedor consultarPorId(Integer id) throws RemoteException;
}