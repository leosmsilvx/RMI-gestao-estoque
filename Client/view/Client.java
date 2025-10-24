package view;

import controller.IEstoqueService;
import controller.IFornecedorService;
import controller.IProdutoService;
import model.Estoque;
import model.Fornecedor;
import model.Produto;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws RemoteException, NotBoundException {
        Scanner sc = new Scanner(System.in);
        Registry con = LocateRegistry.getRegistry("127.0.0.1", 9911);
        do {
            System.out.println("=== Menu ===");
            System.out.println("1. Gerenciar Estoque");
            System.out.println("2. Gerenciar Fornecedor");
            System.out.println("3. Gerenciar Produto");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opcao: ");
            int opcao = sc.nextInt();
            sc.nextLine();
            switch (opcao) {
                case 1:
                    gerenciarEstoque(sc, con);
                    break;
                case 2:
                    gerenciarFornecedor(sc, con);
                    break;
                case 3:
                    gerenciarProduto(sc, con);
                    break;
                case 0:
                    sc.close();
                    return;
                default:
                    System.out.println("Opcao invalida. Tente novamente.");
            }

        } while (true);
    }

    private static void gerenciarEstoque(Scanner sc, Registry con) throws NotBoundException, RemoteException {
        IEstoqueService service = (IEstoqueService) con.lookup("estoqueService");
        do {
            System.out.println("=== Gerenciar estoque ===");
            System.out.println("1. Inserir Estoque");
            System.out.println("2. Alterar Estoque");
            System.out.println("3. Remover Estoque");
            System.out.println("4. Consultar Estoque por ID");
            System.out.println("0. Voltar");
            System.out.print("Escolha uma opcao: ");
            int opcao = sc.nextInt();
            sc.nextLine();
            switch (opcao) {
                case 1:
                    Estoque e = lerEstoque(sc);
                    service.inserir(e);
                    System.out.println("Estoque inserido com sucesso.");
                    break;
                case 2:
                    System.out.println("Digite o id do estoque a ser alterado: ");
                    Integer idAlterar = sc.nextInt();
                    sc.nextLine();
                    Estoque eAlt = lerEstoque(sc);
                    eAlt.setId(idAlterar);
                    service.alterar(eAlt);
                    System.out.println("Estoque alterado com sucesso.");
                    break;
                case 3:
                    System.out.println("Digite o id do estoque a ser removido: ");
                    Integer idRemover = sc.nextInt();
                    sc.nextLine();
                    service.remover(idRemover);
                    System.out.println("Estoque removido com sucesso.");
                    break;
                case 4:
                    System.out.println("Digite o id do estoque a ser consultado: ");
                    Integer idConsultar = sc.nextInt();
                    sc.nextLine();
                    Estoque eConsul = service.consultarPorId(idConsultar);
                    if (eConsul != null) {
                        System.out.println("Estoque encontrado: Produto " + eConsul.getProduto().getNome() + ", Quantidade: " + eConsul.getQuantidade() + ", Movimentacao: " + eConsul.getMovimentacao());
                    } else {
                        System.out.println("Estoque nao encontrado.");
                    }
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Opcao invalida. Tente novamente.");
            }
        } while (true);
    }

    private static void gerenciarProduto(Scanner sc, Registry con) throws NotBoundException, RemoteException {
        IProdutoService service = (IProdutoService) con.lookup("produtoService");
        do {
            System.out.println("=== Gerenciar produtos ===");
            System.out.println("1. Inserir Produto");
            System.out.println("2. Alterar Produto");
            System.out.println("3. Remover Produto");
            System.out.println("4. Consultar Produto por ID");
            System.out.println("0. Voltar");
            System.out.print("Escolha uma opcao: ");
            int opcao = sc.nextInt();
            sc.nextLine();
            switch (opcao) {
                case 1:
                    Produto p = lerProduto(sc);
                    service.inserir(p);
                    System.out.println("Produto inserido com sucesso.");
                    break;
                case 2:
                    System.out.println("Digite o id do produto a ser alterado: ");
                    Integer idAlterar = sc.nextInt();
                    sc.nextLine();
                    Produto pAlt = lerProduto(sc);
                    pAlt.setId(idAlterar);
                    service.alterar(pAlt);
                    System.out.println("Produto alterado com sucesso.");
                    break;
                case 3:
                    System.out.println("Digite o id do produto a ser removido: ");
                    Integer idRemover = sc.nextInt();
                    sc.nextLine();
                    service.remover(idRemover);
                    System.out.println("Produto removido com sucesso.");
                    break;
                case 4:
                    System.out.println("Digite o id do produto a ser consultado: ");
                    Integer idConsultar = sc.nextInt();
                    sc.nextLine();
                    Produto pConsul = service.consultarPorId(idConsultar);
                    if (pConsul != null) {
                        System.out.println("Produto encontrado: " + pConsul.getNome() + ", Preco: " + pConsul.getPreco());
                    } else {
                        System.out.println("Produto nao encontrado.");
                    }
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Opcao invalida. Tente novamente.");
            }
        } while (true);
    }

    private static void gerenciarFornecedor(Scanner sc, Registry con) throws NotBoundException, RemoteException {
        IFornecedorService service = (IFornecedorService) con.lookup("fornecedorService");
        do {
            System.out.println("=== Gerenciar fornecedor ===");
            System.out.println("1. Inserir Fornecedor");
            System.out.println("2. Alterar Fornecedor");
            System.out.println("3. Remover Fornecedor");
            System.out.println("4. Consultar Fornecedor por ID");
            System.out.println("0. Voltar");
            System.out.print("Escolha uma opcao: ");
            int opcao = sc.nextInt();
            sc.nextLine();
            switch (opcao) {
                case 1:
                    Fornecedor f = lerFornecedor(sc);
                    service.inserir(f);
                    System.out.println("Fornecedor inserido com sucesso.");
                    break;
                case 2:
                    System.out.println("Digite o id do fornecedor a ser alterado: ");
                    Integer idAlterar = sc.nextInt();
                    sc.nextLine();
                    Fornecedor fAlt = lerFornecedor(sc);
                    fAlt.setId(idAlterar);
                    service.alterar(fAlt);
                    System.out.println("Fornecedor alterado com sucesso.");
                    break;
                case 3:
                    System.out.println("Digite o id do fornecedor a ser removido: ");
                    Integer idRemover = sc.nextInt();
                    sc.nextLine();
                    service.remover(idRemover);
                    System.out.println("Fornecedor removido com sucesso.");
                    break;
                case 4:
                    System.out.println("Digite o id do fornecedor a ser consultado: ");
                    Integer idConsultar = sc.nextInt();
                    sc.nextLine();
                    Fornecedor fConsul = service.consultarPorId(idConsultar);
                    if (fConsul != null) {
                        System.out.println("Fornecedor encontrado: " + fConsul.getNome() + ", Contato: " + fConsul.getContato());
                    } else {
                        System.out.println("Fornecedor nao encontrado.");
                    }
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Opcao invalida. Tente novamente.");
            }
        } while (true);
    }

    private static Produto lerProduto(Scanner sc) {
        System.out.println("Digite o nome do produto: ");
        String nome = sc.nextLine();
        System.out.println("Digite o preco do produto: ");
        String strPreco = sc.nextLine();
        double preco = Double.parseDouble(strPreco);
        System.out.println("Digite o id do fornecedor: ");
        int fornecedorId = sc.nextInt();
        sc.nextLine();
        Fornecedor fornecedor = new Fornecedor(fornecedorId, null, null);
        return new Produto(null, nome, preco, fornecedor);
    }

    private static Fornecedor lerFornecedor(Scanner sc) {
        System.out.println("Digite o nome do fornecedor: ");
        String nome = sc.nextLine();
        System.out.println("Digite o contato do fornecedor: ");
        String contato = sc.nextLine();
        return new Fornecedor(null, nome, contato);
    }

    private static Estoque lerEstoque(Scanner sc) {
        System.out.println("Digite o id do produto: ");
        int produtoId = sc.nextInt();
        sc.nextLine();
        System.out.println("Digite a quantidade: ");
        int quantidade = sc.nextInt();
        sc.nextLine();
        System.out.println("Digite o tipo de movimentacao E (entrada) ou S (saida): ");
        String movimentacao = sc.nextLine();
        Produto produto = new Produto(produtoId, null, 0.0, null);
        return new Estoque(null, produto, quantidade, movimentacao);
    }
}
