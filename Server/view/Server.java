package view;

import controller.*;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Server {
    public static void main(String[] args) throws RemoteException, AlreadyBoundException {
        Registry con = LocateRegistry.createRegistry(9911);

        IEstoqueService estoqueService = new EstoqueService();
        IFornecedorService fornecedorService = new FornecedorService();
        IProdutoService produtoService = new ProdutoService();

        con.bind("estoqueService", estoqueService);
        con.bind("fornecedorService", fornecedorService);
        con.bind("produtoService", produtoService);
    }
}
