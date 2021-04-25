-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 25, 2021 at 08:03 AM
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
-- Database: `researcher`
--

-- --------------------------------------------------------

--
-- Table structure for table `researcher`
--

CREATE TABLE `researcher` (
  `userID` int(10) NOT NULL,
  `name` varchar(100) NOT NULL,
  `surname` varchar(100) NOT NULL,
  `email` varchar(50) NOT NULL,
  `gender` varchar(50) NOT NULL,
  `productType` varchar(100) NOT NULL,
  `productID` int(11) NOT NULL,
  `phoneNo` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `researcher`
--

INSERT INTO `researcher` (`userID`, `name`, `surname`, `email`, `gender`, `productType`, `productID`, `phoneNo`) VALUES
(2, 'Priyanka', 'Kugapriya', 'it18215502@my.sliit.lk', 'Female', 'Finished product', 1, 771233453),
(7, 'Johsh', 'Steve', 'joe123@yahoo.com', 'Male', 'Finished product', 2, 772222222),
(8, 'Abhishek', 'Karthick', 'abhi87@yahoo.com', 'Male', 'Finished product', 3, 773333333),
(9, 'Fredrick', 'Micheal', 'fred@gmail.com', 'Male', 'Project in need of fund', 4, 774444444),
(11, 'Gayan', 'Arachi', 'gayan@yahoo.com', 'Male', 'Project in need of fund', 5, 775555555);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `researcher`
--
ALTER TABLE `researcher`
  ADD PRIMARY KEY (`userID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `researcher`
--
ALTER TABLE `researcher`
  MODIFY `userID` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
