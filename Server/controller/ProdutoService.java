package controller;

import connection.ConnectionFactory;
import model.Fornecedor;
import model.Produto;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.PreparedStatement;

public class ProdutoService extends UnicastRemoteObject implements IProdutoService {

    public ProdutoService() throws java.rmi.RemoteException {
        super();
    }

    @Override
    public void inserir(Produto p) throws RemoteException {
        ConnectionFactory con = new ConnectionFactory();
        con.conectar();
        String sql = "INSERT INTO tb_produto (nm_nome, vl_preco, cod_fornecedor) VALUES (?, ?, ?)";
        try {
            PreparedStatement ps = con.conector.prepareStatement(sql);
            ps.setString(1, p.getNome());
            ps.setDouble(2, p.getPreco());
            ps.setInt(3, p.getFornecedor().getId());
            ps.execute();
        } catch (Exception e) {
            System.err.println("Erro ao inserir: " + e.getMessage());
        }
        con.desconectar();
    }

    @Override
    public void alterar(Produto p) throws RemoteException {
        ConnectionFactory con = new ConnectionFactory();
        con.conectar();
        String sql = "UPDATE tb_produto SET nm_nome = ?, vl_preco = ?, cod_fornecedor = ? WHERE cod_id = ?";
        try {
            PreparedStatement ps = con.conector.prepareStatement(sql);
            ps.setString(1, p.getNome());
            ps.setDouble(2, p.getPreco());
            ps.setInt(3, p.getFornecedor().getId());
            ps.setInt(4, p.getId());
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
        String sql = "DELETE FROM tb_produto WHERE cod_id = ?";
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
    public Produto consultarPorId(Integer id) throws RemoteException {
        ConnectionFactory con = new ConnectionFactory();
        con.conectar();

        String sql = "SELECT p.*, f.cod_id AS cod_fornecedor, f.nm_nome AS nm_fornecedor, f.nm_contato FROM tb_produto p INNER JOIN tb_fornecedor f ON f.cod_id = p.cod_fornecedor WHERE p.cod_id = ?";
        Produto produto = null;
        try {
            PreparedStatement ps = con.conector.prepareStatement(sql);
            ps.setInt(1, id);
            var rs = ps.executeQuery();
            if (rs.next()) {
                produto = new Produto(
                    rs.getInt("cod_id"),
                    rs.getString("nm_nome"),
                    rs.getDouble("vl_preco"),
                    new Fornecedor(rs.getInt("cod_fornecedor"),
                            rs.getString("nm_fornecedor"),
                            rs.getString("nm_contato"))
                );
            }
        } catch (Exception e) {
            System.err.println("Erro ao consultar: " + e.getMessage());
        }
        con.desconectar();
        return produto;
    }
}
