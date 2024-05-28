-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 28, 2024 at 07:07 AM
-- Server version: 10.4.24-MariaDB
-- PHP Version: 7.4.29

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `servis_db_projek`
--

-- --------------------------------------------------------

--
-- Table structure for table `data_servis`
--

CREATE TABLE `data_servis` (
  `id_servis` int(11) NOT NULL,
  `nama_pelanggan` varchar(50) NOT NULL,
  `tanggal` date NOT NULL,
  `no_telepon` varchar(12) NOT NULL,
  `jenis_device` varchar(30) NOT NULL,
  `nama_device` varchar(30) NOT NULL,
  `jenis_servis` varchar(30) NOT NULL,
  `deskripsi` varchar(100) NOT NULL,
  `total_biaya` double NOT NULL,
  `id_status` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `data_servis`
--

INSERT INTO `data_servis` (`id_servis`, `nama_pelanggan`, `tanggal`, `no_telepon`, `jenis_device`, `nama_device`, `jenis_servis`, `deskripsi`, `total_biaya`, `id_status`) VALUES
(1, 'alfa ubah', '0014-09-17', '081278178262', 'Laptop', 'Ideapad', 'servis berat', 'Laptop kebelah', 5000000, 1),
(2, 'delta', '0017-09-14', '081278178262', 'Laptop', 'Ideapad', 'servis berat', 'Laptop kebelah', 5000000, 1),
(6, 'Zeka anung', '2009-05-23', '213131654654', 'SmartPhone', 'Samsung J2 Prime', 'Servis Sedang', 'ganti LCD', 800000, 1),
(8, 'kakas', '2024-07-04', '03213454454', 'PC', 'Dell epiad', 'servis berat', 'kerusakan motherboard', 300000, 1),
(9, 'Beta charlie yasin', '2024-05-15', '03213454454', 'Smartphone', 'Samsung J2 Prime', 'servis ringan', 'Ganti satu set tombol power dan volume', 300000, 1),
(12, 'kakas ukul', '0010-01-14', '03213454454', 'PC', 'PC gaming', 'Servis Berat', 'kerusakan motherboard', 300000, 1),
(15, 'anis', '2025-08-22', '897498732', 'Laptop', 'lenovo', 'Servis Ringan', 'jsajknd', 786876, 2);

-- --------------------------------------------------------

--
-- Table structure for table `status`
--

CREATE TABLE `status` (
  `id_status` int(11) NOT NULL,
  `keterangan` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `status`
--

INSERT INTO `status` (`id_status`, `keterangan`) VALUES
(1, 'LUNAS'),
(2, 'BELUM LUNAS');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `data_servis`
--
ALTER TABLE `data_servis`
  ADD PRIMARY KEY (`id_servis`);

--
-- Indexes for table `status`
--
ALTER TABLE `status`
  ADD PRIMARY KEY (`id_status`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `data_servis`
--
ALTER TABLE `data_servis`
  MODIFY `id_servis` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
