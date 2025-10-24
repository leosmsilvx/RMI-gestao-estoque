package controller;

import java.rmi.Remote;
import java.rmi.RemoteException;
import model.Produto;

public interface IProdutoService extends Remote {
    public void inserir(Produto p) throws RemoteException;

    public void alterar(Produto p) throws RemoteException;

    public void remover(Integer id) throws RemoteException;

    public Produto consultarPorId(Integer id) throws RemoteException;
}