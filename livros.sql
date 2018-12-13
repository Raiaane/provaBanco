-- phpMyAdmin SQL Dump
-- version 4.8.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: 13-Dez-2018 às 17:26
-- Versão do servidor: 10.1.34-MariaDB
-- PHP Version: 5.6.37

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `livros`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `categoria`
--

CREATE TABLE `categoria` (
  `id` int(11) NOT NULL,
  `nome` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `categoria`
--

INSERT INTO `categoria` (`id`, `nome`) VALUES
(1, 'RomanceA'),
(2, 'Comédia eae'),
(3, 'Acão'),
(4, 'Ficcão'),
(5, 'Drama'),
(6, 'Suspense'),
(8, 'eldson explendido');

-- --------------------------------------------------------

--
-- Estrutura da tabela `funcionario`
--

CREATE TABLE `funcionario` (
  `idfuncionario` int(11) NOT NULL,
  `nome` varchar(100) NOT NULL,
  `login` varchar(45) NOT NULL,
  `senha` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `funcionario`
--

INSERT INTO `funcionario` (`idfuncionario`, `nome`, `login`, `senha`) VALUES
(1, 'raiane', 'ray', 'ray');

-- --------------------------------------------------------

--
-- Estrutura da tabela `lidos`
--

CREATE TABLE `lidos` (
  `id` int(11) NOT NULL,
  `nome` varchar(200) NOT NULL,
  `autor` varchar(50) NOT NULL,
  `categoria` int(50) NOT NULL,
  `datat` varchar(50) NOT NULL,
  `capa` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `lidos`
--

INSERT INTO `lidos` (`id`, `nome`, `autor`, `categoria`, `datat`, `capa`) VALUES
(1, 'EclipseNOITE', 'saraiava', 6, '23/08/2018', 'person.jpg'),
(2, 'RosaFlor', 'Alberto', 2, '12/12/2018', 'fallen.jpg'),
(4, 'a vida de Nosdle', 'Nosdle', 8, '23/04/2019', 'copias.jpg');

-- --------------------------------------------------------

--
-- Estrutura da tabela `produto`
--

CREATE TABLE `produto` (
  `id` int(11) NOT NULL,
  `nome` varchar(200) NOT NULL,
  `autor` varchar(100) NOT NULL,
  `categoria` varchar(50) NOT NULL,
  `sinopse` varchar(200) NOT NULL,
  `qnt` varchar(50) NOT NULL,
  `dataC` varchar(50) NOT NULL,
  `dataT` varchar(50) NOT NULL,
  `capa` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `produto`
--

INSERT INTO `produto` (`id`, `nome`, `autor`, `categoria`, `sinopse`, `qnt`, `dataC`, `dataT`, `capa`) VALUES
(5, 'personjACK', 'ifgisGil', '2', 'ihdishgd', '333', '1ou193', 'y393y', 'harry.png'),
(6, 'adasdsa', 'ana', '2', 'jovem bonita', '222', '23/12/2018', '11/01/2019', 'lady.jpg'),
(7, 'morte e vida Eldson', 'Lourenço Eldson Borges', '5', 'Borges.', '9999999999999999999', '12/11/2018', '12/11/2400', '1_5ik6eH1kSnCVfYqxuXk4ew.jpeg'),
(9, 'teste', 'autor', '2', 'teste', '1', '12/11/1111', '11/11/1111', 'lady.jpg'),
(10, ' a volta de quem nao foi', 'eu', '1', 'um cara que voltou de onde não foi', '100', '11/11/1111', '11/11/1111', 'cabana.jpg');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `categoria`
--
ALTER TABLE `categoria`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `funcionario`
--
ALTER TABLE `funcionario`
  ADD PRIMARY KEY (`idfuncionario`);

--
-- Indexes for table `lidos`
--
ALTER TABLE `lidos`
  ADD PRIMARY KEY (`id`),
  ADD KEY `categoria` (`categoria`);

--
-- Indexes for table `produto`
--
ALTER TABLE `produto`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `categoria`
--
ALTER TABLE `categoria`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `funcionario`
--
ALTER TABLE `funcionario`
  MODIFY `idfuncionario` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `lidos`
--
ALTER TABLE `lidos`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `produto`
--
ALTER TABLE `produto`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- Constraints for dumped tables
--

--
-- Limitadores para a tabela `lidos`
--
ALTER TABLE `lidos`
  ADD CONSTRAINT `lidos_ibfk_1` FOREIGN KEY (`categoria`) REFERENCES `categoria` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
