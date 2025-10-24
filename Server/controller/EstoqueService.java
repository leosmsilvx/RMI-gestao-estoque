package controller;

import connection.ConnectionFactory;
import model.Estoque;
import model.Produto;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.PreparedStatement;

public class EstoqueService extends UnicastRemoteObject implements IEstoqueService {

    public EstoqueService() throws java.rmi.RemoteException {
        super();
    }

    @Override
    public void inserir(Estoque e) throws RemoteException {
        ConnectionFactory con = new ConnectionFactory();
        con.conectar();

        String sql = "INSERT INTO tb_estoque (cod_produto, vl_quantidade, tp_movimentacao) VALUES (?, ?, ?)";
        try {
            PreparedStatement ps = con.conector.prepareStatement(sql);
            ps.setInt(1, e.getProduto().getId());
            ps.setInt(2, e.getQuantidade());
            ps.setString(3, e.getMovimentacao());
            ps.execute();
        } catch (Exception ex) {
            System.err.println("Erro ao inserir: " + ex.getMessage());
        }
        con.desconectar();
    }

    @Override
    public void alterar(Estoque e) throws RemoteException {
        ConnectionFactory con = new ConnectionFactory();
        con.conectar();

        String sql = "UPDATE tb_estoque SET cod_produto = ?, vl_quantidade = ?, tp_movimentacao = ? WHERE cod_id = ?";
        try {
            PreparedStatement ps = con.conector.prepareStatement(sql);
            ps.setInt(1, e.getProduto().getId());
            ps.setInt(2, e.getQuantidade());
            ps.setString(3, e.getMovimentacao());
            ps.setInt(4, e.getId());
            ps.execute();
        } catch (Exception ex) {
            System.err.println("Erro ao alterar: " + ex.getMessage());
        }
        con.desconectar();
    }

    @Override
    public void remover(Integer id) throws RemoteException {
        ConnectionFactory con = new ConnectionFactory();
        con.conectar();

        String sql = "DELETE FROM tb_estoque WHERE cod_id = ?";
        try {
            PreparedStatement ps = con.conector.prepareStatement(sql);
            ps.setInt(1, id);
            ps.execute();
        } catch (Exception ex) {
            System.err.println("Erro ao remover: " + ex.getMessage());
        }
        con.desconectar();
    }

    @Override
    public Estoque consultarPorId(Integer id) throws RemoteException {
        ConnectionFactory con = new ConnectionFactory();
        con.conectar();

        String sql = "SELECT e.*, p.cod_id AS cod_produto, p.nm_nome AS nm_produto, p.vl_preco FROM tb_estoque e INNER JOIN tb_produto p ON e.cod_produto = p.cod_id WHERE e.cod_id = ?";
        Estoque estoque = null;

        try {
            PreparedStatement ps = con.conector.prepareStatement(sql);
            ps.setInt(1, id);
            var rs = ps.executeQuery();
            if (rs.next()) {
                estoque = new Estoque(
                        rs.getInt("cod_id"),
                        new Produto(
                                rs.getInt("cod_produto"),
                                rs.getString("nm_produto"),
                                rs.getDouble("vl_preco"),
                                null // A preguiça consome o homem...
                        ),
                        rs.getInt("vl_quantidade"),
                        rs.getString("tp_movimentacao")
                );
            }
        } catch (Exception ex) {
            System.err.println("Erro ao consultar: " + ex.getMessage());
        }
        return estoque;
    }
}
