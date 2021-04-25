-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 25, 2021 at 01:50 PM
-- Server version: 10.4.17-MariaDB
-- PHP Version: 8.0.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `gadgetbadget`
--

-- --------------------------------------------------------

--
-- Table structure for table `funders`
--

CREATE TABLE `funders` (
  `funderID` int(11) NOT NULL,
  `funderCode` varchar(10) CHARACTER SET latin1 NOT NULL,
  `funderName` varchar(30) CHARACTER SET latin1 NOT NULL,
  `funderAddress` varchar(100) CHARACTER SET latin1 NOT NULL,
  `funderTel` varchar(11) CHARACTER SET latin1 NOT NULL,
  `funderEmail` varchar(30) CHARACTER SET latin1 NOT NULL,
  `funderGender` varchar(10) CHARACTER SET latin1 NOT NULL,
  `funderFund` double NOT NULL,
  `funderTime` varchar(20) NOT NULL,
  `funderDes` varchar(300) CHARACTER SET latin1 NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `funders`
--

INSERT INTO `funders` (`funderID`, `funderCode`, `funderName`, `funderAddress`, `funderTel`, `funderEmail`, `funderGender`, `funderFund`, `funderTime`, `funderDes`) VALUES
(1, 'F001', 'WQRS', 'Colombo', '011-2559255', 'ccc@mail.com', 'Male', 100000, '2020-2021', 'Our company offers for some artificial inteligence projects. IF someone wants to contact our company please contact. so we are here to fund your project.'),
(2, 'F002', 'GDF', 'Kandy', '081-2559255', 'GDF@gmail.com', 'Male', 2000000, '2020-2023', 'Our company offers some automation projects. IF someone wants to contact our company please contact. so we are here to fund your project.'),
(3, 'F003', 'FCA', 'Colombo 2', '011-2759278', 'fca@gmail.com', 'Female', 5000000, '2021-2024', 'Intrested in chemical reseraches. please contact us to more informations.'),
(4, 'F004', 'Kasun', 'Colombo 2', '011-2759278', 'kasun@gmail.com', 'Male', 5000000, '2021-2024', 'Intrested in biological reseraches. please contact us to more informations.');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `funders`
--
ALTER TABLE `funders`
  ADD PRIMARY KEY (`funderID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `funders`
--
ALTER TABLE `funders`
  MODIFY `funderID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
