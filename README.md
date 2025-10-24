# RMI - Gestão de Estoque

Este projeto implementa um sistema de gestão de estoque utilizando Java RMI (Remote Method Invocation) e um banco de dados relacional MySQL.

O sistema permite gerenciar produtos em estoque, realizar consultas e atualizações de forma remota através do cliente Java, enquanto o servidor gerencia a lógica de negócio e persiste os dados no MySQL.

## Colaboradores
- [Leonardo Moura](https://github.com/leosmsilvx) 16-86151
- [Thiago Luiz Pereira](https://github.com/thimicelio) 16-86228

## Estrutura do Projeto

```
RMI-gestao-estoque/
├── Client/                  # Código do cliente
│   ├── controller/          # Interfaces de serviços RMI do cliente
│   │   ├── ...
│   ├── model/               # Classes de modelo do cliente
│   │   ├── ...
│   └── view/                # Interface de visualização do cliente
│       └── Client.java
├── Server/                  # Código do servidor
│   ├── connection/          # Conexão com MySQL
│   │   └── ConnectionFactory.java
│   ├── controller/          # Interfaces e Implementações dos serviços RMI do servidor
│   │   ├── ...
│   ├── model/               # Classes de modelo do servidor
│   │   ├── ...
│   ├── view/                # Interface de visualização do cliente
│   │   └── Server.java
│   ├── ddl-controle_estoque.sql  # Script DDL para criação de tabelas
│   └── mysql-connector-j-9.5.0.jar  # Driver JDBC do MySQL
└── .gitignore
```
