package controller;

import connection.ConnectionFactory;
import model.Fornecedor;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.PreparedStatement;

public class FornecedorService extends UnicastRemoteObject implements IFornecedorService {

    public FornecedorService() throws java.rmi.RemoteException {
        super();
    }

    @Override
    public void inserir(Fornecedor f) throws RemoteException {
        ConnectionFactory con = new ConnectionFactory();
        con.conectar();

        String sql = "INSERT INTO tb_fornecedor (nm_nome, nm_contato) VALUES (?, ?)";
        try {
            PreparedStatement ps = con.conector.prepareStatement(sql);
            ps.setString(1, f.getNome());
            ps.setString(2, f.getContato());
            ps.execute();
        } catch (Exception e) {
            System.err.println("Erro ao inserir: " + e.getMessage());
        }
        con.desconectar();
    }

    @Override
    public void alterar(Fornecedor f) throws RemoteException {
        ConnectionFactory con = new ConnectionFactory();
        con.conectar();

        String sql = "UPDATE tb_fornecedor SET nm_nome = ?, nm_contato = ? WHERE cod_id = ?";
        try {
            PreparedStatement ps = con.conector.prepareStatement(sql);
            ps.setString(1, f.getNome());
            ps.setString(2, f.getContato());
            ps.setInt(3, f.getId());
            ps.execute();
        } catch (Exception e) {
            System.err.println("Erro ao alterar: " + e.getMessage());
        }
        con.desconectar();
    }

    @Override
    public void remover(Integer id) throws RemoteException {
        ConnectionFactory con = new ConnectionFactory();
        con.conectar();

        String sql = "DELETE FROM tb_fornecedor WHERE cod_id = ?";
        try {
            PreparedStatement ps = con.conector.prepareStatement(sql);
            ps.setInt(1, id);
            ps.execute();
        } catch (Exception e) {
            System.err.println("Erro ao remover: " + e.getMessage());
        }
        con.desconectar();
    }

    @Override
    public Fornecedor consultarPorId(Integer id) throws RemoteException {
        ConnectionFactory con = new ConnectionFactory();
        con.conectar();

        String sql = "SELECT * FROM tb_fornecedor WHERE cod_id = ?";
        Fornecedor fornecedor = null;
        try {
            PreparedStatement ps = con.conector.prepareStatement(sql);
            ps.setInt(1, id);
            var rs = ps.executeQuery();
            if (rs.next()) {
                fornecedor = new Fornecedor(
                    rs.getInt("cod_id"),
                    rs.getString("nm_nome"),
                    rs.getString("nm_contato")
                );
            }
        } catch (Exception e) {
            System.err.println("Erro ao consultar: " + e.getMessage());
        }
        con.desconectar();
        return fornecedor;
    }
}
