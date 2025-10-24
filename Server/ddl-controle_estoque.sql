-- controle_estoque.tb_fornecedor definição

CREATE TABLE `tb_fornecedor` (
  `COD_ID` int NOT NULL AUTO_INCREMENT,
  `NM_NOME` varchar(200) NOT NULL,
  `NM_CONTATO` varchar(100) NOT NULL,
  PRIMARY KEY (`COD_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- controle_estoque.tb_produto definição

CREATE TABLE `tb_produto` (
  `COD_ID` int NOT NULL AUTO_INCREMENT,
  `NM_NOME` varchar(200) NOT NULL,
  `VL_PRECO` double NOT NULL,
  `COD_FORNECEDOR` int NOT NULL,
  PRIMARY KEY (`COD_ID`),
  KEY `TB_PRODUTO_tb_fornecedor_FK` (`COD_FORNECEDOR`),
  CONSTRAINT `TB_PRODUTO_tb_fornecedor_FK` FOREIGN KEY (`COD_FORNECEDOR`) REFERENCES `tb_fornecedor` (`COD_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- controle_estoque.tb_estoque definição

CREATE TABLE `tb_estoque` (
  `COD_ID` int NOT NULL AUTO_INCREMENT,
  `COD_PRODUTO` int NOT NULL,
  `VL_QUANTIDADE` int NOT NULL,
  `TP_MOVIMENTACAO` varchar(1) NOT NULL,
  PRIMARY KEY (`COD_ID`),
  KEY `TB_ESTOQUE_tb_produto_FK` (`COD_PRODUTO`),
  CONSTRAINT `TB_ESTOQUE_tb_produto_FK` FOREIGN KEY (`COD_PRODUTO`) REFERENCES `tb_produto` (`COD_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
