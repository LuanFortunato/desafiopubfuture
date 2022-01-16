-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 16-Jan-2022 às 18:59
-- Versão do servidor: 10.4.19-MariaDB
-- versão do PHP: 8.0.7

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `desafiopubfuture`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `conta`
--

CREATE TABLE `conta` (
  `id` int(11) NOT NULL,
  `saldo` double NOT NULL,
  `tipoConta` varchar(50) NOT NULL,
  `instituiçãoFinanceira` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `conta`
--

INSERT INTO `conta` (`id`, `saldo`, `tipoConta`, `instituiçãoFinanceira`) VALUES
(1, 1592, 'Carteira', 'Bradesco'),
(4, 1089, 'Poupança', 'Caixa Econômica');

-- --------------------------------------------------------

--
-- Estrutura da tabela `despesa`
--

CREATE TABLE `despesa` (
  `id` int(11) NOT NULL,
  `valor` double NOT NULL,
  `dataPagamento` varchar(50) NOT NULL DEFAULT '',
  `dataPagamentoEsperado` varchar(50) NOT NULL DEFAULT '',
  `tipoDespesa` varchar(50) NOT NULL,
  `conta_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `despesa`
--

INSERT INTO `despesa` (`id`, `valor`, `dataPagamento`, `dataPagamentoEsperado`, `tipoDespesa`, `conta_id`) VALUES
(1, 150, '19/12/2015', '26/01/2017', 'Educação', 1),
(4, 160, '24/10/2017', '31/12/2017', 'Outros', 1);

-- --------------------------------------------------------

--
-- Estrutura da tabela `receita`
--

CREATE TABLE `receita` (
  `id` int(11) NOT NULL,
  `valor` double NOT NULL,
  `dataRecebimento` varchar(50) NOT NULL DEFAULT '',
  `dataRecebimentoEsperado` varchar(50) NOT NULL DEFAULT '',
  `descrição` varchar(50) NOT NULL,
  `tipoReceita` varchar(50) NOT NULL,
  `conta_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `receita`
--

INSERT INTO `receita` (`id`, `valor`, `dataRecebimento`, `dataRecebimentoEsperado`, `descrição`, `tipoReceita`, `conta_id`) VALUES
(3, 100, '21/10/2021', '15/10/2021', 'Nenhuma', 'Prêmio', 4),
(4, 15, '23/12/2021', '23/01/2022', 'Nenhuma', 'Presente', 1);

--
-- Índices para tabelas despejadas
--

--
-- Índices para tabela `conta`
--
ALTER TABLE `conta`
  ADD PRIMARY KEY (`id`);

--
-- Índices para tabela `despesa`
--
ALTER TABLE `despesa`
  ADD PRIMARY KEY (`id`),
  ADD KEY `conta_id` (`conta_id`);

--
-- Índices para tabela `receita`
--
ALTER TABLE `receita`
  ADD PRIMARY KEY (`id`),
  ADD KEY `conta_id` (`conta_id`);

--
-- AUTO_INCREMENT de tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `conta`
--
ALTER TABLE `conta`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de tabela `despesa`
--
ALTER TABLE `despesa`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de tabela `receita`
--
ALTER TABLE `receita`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- Restrições para despejos de tabelas
--

--
-- Limitadores para a tabela `despesa`
--
ALTER TABLE `despesa`
  ADD CONSTRAINT `despesa_ibfk_1` FOREIGN KEY (`conta_id`) REFERENCES `conta` (`id`);

--
-- Limitadores para a tabela `receita`
--
ALTER TABLE `receita`
  ADD CONSTRAINT `receita_ibfk_1` FOREIGN KEY (`conta_id`) REFERENCES `conta` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
