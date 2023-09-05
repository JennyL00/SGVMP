-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1:33068
-- Tiempo de generación: 22-03-2021 a las 19:21:35
-- Versión del servidor: 10.4.18-MariaDB
-- Versión de PHP: 7.4.16

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `baseimportadoraespinoza`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `clientes`
--

CREATE TABLE `clientes` (
  `Nombre` varchar(60) NOT NULL,
  `Apellido` varchar(60) NOT NULL,
  `Tipo_de_Documento` varchar(9) NOT NULL,
  `Numero_de_Documento` varchar(13) NOT NULL,
  `Telefono_Celular` varchar(10) NOT NULL,
  `Direccion` varchar(60) NOT NULL,
  `Correo_Electronico` varchar(60) NOT NULL,
  `Estado` varchar(8) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `clientes`
--

INSERT INTO `clientes` (`Nombre`, `Apellido`, `Tipo_de_Documento`, `Numero_de_Documento`, `Telefono_Celular`, `Direccion`, `Correo_Electronico`, `Estado`) VALUES
('Anahi', 'Vasquez', 'RUC', '1752413268001', '0983132578', 'La Magdalena', 'anahivasquezp@gmail.com', 'Activo'),
('Timoteo', 'Camuendo', 'Pasaporte', '1725664641', '0990554840', 'Carapungo', 'timo@gmail.com', 'Activo'),
('Jenny', 'Llano', 'C.I.', '1712198900', '0983132578', 'Guamani', 'jenny.llano@epn.com', 'Activo'),
('William', 'Zapata', 'RUC', '1711545978001', '0912675498', 'El Valle', 'william.zapata@gmail.com', 'Activo');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `detalle_factura`
--

CREATE TABLE `detalle_factura` (
  `numero_detalle` varchar(7) NOT NULL,
  `detalle` longtext NOT NULL,
  `anulado` varchar(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `detalle_factura`
--

INSERT INTO `detalle_factura` (`numero_detalle`, `detalle`, `anulado`) VALUES
('d000001', 'Cédula del Cliente: 1712198900\nFecha: 2021-03-21\n\nCódigo	Nombre	Tipo	Cantidad	Precio Unitario\n\nAAA001	Cable HDMI 1	Generico	2	4.0\nAAB001	Laptop	Computador	1	1357.44\n\n\nTotal a pagar (más IVA): 1529.29', 'si'),
('d000002', 'Cédula del Cliente: 1712198900\nFecha: 2021-03-21\n\nCódigo	Nombre	Tipo	Cantidad	Precio Unitario\n\nAAA002	Cable HDMI	Original	10	5.0\nABC079	Mouse Raizen	Mouse	1	60.0\n\n\nTotal a pagar (más IVA): 123.2', 'si'),
('d000003', 'Factura Nº 0000003\nCédula del Cliente: 1712198900\n\nFecha: 2021-03-21\n\n______________________________________________________________\nCódigo	Nombre	Tipo	Cantidad	Precio Unitario\n\nAAA001	Cable HDMI 1	Generico	10	4.0\nAAB001	Laptop	Computador	1	1357.44\nABC079	Mouse Raizen	Mouse	1	60.0\n______________________________________________________________\n\n\nTotal a pagar (más IVA): 1632.33', 'no'),
('d000004', 'Factura Nº 0000004\n\nCédula del Cliente: 1725664641\n\nFecha: 2021-03-21\n\n______________________________________________________________\nCódigo	Nombre			Tipo	Cantidad	Precio Unitario\n\nAAB001	Laptop			Computador	1	1357.44\nBBB003	Cargador de Laptop HP			Original	1	65.0\n______________________________________________________________\n\n\nTotal a pagar (más IVA): 1593.13', 'no'),
('d000005', 'Factura Nº 0000005\n\nCédula del Cliente: 1725664641\n\nFecha: 2021-03-21\n\n_________________________________________________________________________\nCódigo	Nombre		Tipo	Cantidad	Precio Unitario\n\nAAA001	Cable HDMI 1	Generico	5	4.0\nBBB003	Cargador de Laptop HP	Original	1	65.0\n_________________________________________________________________________\n\n\nTotal a pagar (más IVA): 95.2', 'no'),
('d000006', 'Factura Nº 0000006\n\nCédula del Cliente: 1725664641\n\nFecha: 2021-03-21\n\n___________________________________________________________________________\nCódigo	Nombre		Tipo	Cantidad	Precio Unitario\n\nAAA001	Cable HDMI 1		Generico	5	4.0\nBBB003	Cargador de Laptop HP	Original	1	65.0\n___________________________________________________________________________\n\nTotal a pagar (más IVA): 95.2', 'si'),
('d000007', 'Factura Nº 0000007\n\nCédula del Cliente: 1712198900\n\nFecha: 2021-03-22\n\n___________________________________________________________________________\nCódigo	Nombre		Tipo	Cantidad	Precio Unitario\n\nAAA001	Cable HDMI 1		Generico	20	4.0\nAAB001	Laptop		Computador	2	1357.44\nABC079	Mouse Raizen		Mouse	1	60.0\n___________________________________________________________________________\n\nTotal a pagar (más IVA): 3197.47', 'no');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `empleados`
--

CREATE TABLE `empleados` (
  `nombre` varchar(60) NOT NULL,
  `apellido` varchar(60) NOT NULL,
  `numero_cedula` varchar(10) NOT NULL,
  `correo_electronico` varchar(60) NOT NULL,
  `telefono_celular` varchar(10) NOT NULL,
  `direccion` varchar(60) NOT NULL,
  `sueldo` double NOT NULL,
  `sucursal_asignada` varchar(60) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `empleados`
--

INSERT INTO `empleados` (`nombre`, `apellido`, `numero_cedula`, `correo_electronico`, `telefono_celular`, `direccion`, `sueldo`, `sucursal_asignada`) VALUES
('Ariel', 'Rosero', '1711545978', 'ariel.rosero@gmail.com', '0987917666', 'Las Casas', 700, 'Bodega - Valle'),
('Enrique', 'Peñafiel', '1711754562', 'enrique.penafiel@gmail.com', '0998516978', 'El Valle de los Chillos', 800, 'Matriz - Av. América'),
('Francisco', 'Rodriguez', '1712017688', 'francisco.rodriguez@gmail.com', '0987917800', 'Parque el Ejido', 750, 'Local - Av. Lauro Guerrero y Av. Angulo'),
('Cristopher', 'Perez', '1719087999', 'cristopher.perez@gmail.com', '0998516975', 'La Magdalena', 600, 'Local - C.C Espiral');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `facturas`
--

CREATE TABLE `facturas` (
  `numero_factura` varchar(7) NOT NULL,
  `fecha` date NOT NULL,
  `cedula_cliente` varchar(10) NOT NULL,
  `numero_detalle` varchar(7) NOT NULL,
  `anulada` varchar(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `facturas`
--

INSERT INTO `facturas` (`numero_factura`, `fecha`, `cedula_cliente`, `numero_detalle`, `anulada`) VALUES
('0000001', '2021-03-21', '1712198900', 'd000001', 'si'),
('0000002', '2021-03-21', '1712198900', 'd000002', 'si'),
('0000003', '2021-03-21', '1712198900', 'd000003', 'no'),
('0000004', '2021-03-21', '1725664641', 'd000004', 'no'),
('0000005', '2021-03-21', '1725664641', 'd000005', 'no'),
('0000006', '2021-03-21', '1725664641', 'd000006', 'si'),
('0000007', '2021-02-08', '1712198900', 'd000007', 'no');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `productos`
--

CREATE TABLE `productos` (
  `codigo` varchar(6) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `tipo` varchar(40) NOT NULL,
  `stock` int(11) NOT NULL,
  `precio_unitario` double NOT NULL,
  `precio_distribuidor` double NOT NULL,
  `proveedor` varchar(40) NOT NULL,
  `sucursal` varchar(40) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `productos`
--

INSERT INTO `productos` (`codigo`, `nombre`, `tipo`, `stock`, `precio_unitario`, `precio_distribuidor`, `proveedor`, `sucursal`) VALUES
('AAA001', 'Cable HDMI 1', 'Generico', 383, 4, 3.56, 'GuHan', 'Bodega - Valle'),
('AAA002', 'Cable HDMI', 'Original', 490, 5, 4, 'Gu Han', 'Bodega - Valle'),
('AAA003', 'Cable HDMI tres metros', 'Original', 500, 6, 3.56, 'Gu Han', 'Bodega - Valle'),
('AAB001', 'Laptop', 'Computador', 389, 1357.44, 1000, 'NoviCompu', 'Local - Av. Lauro Guerrero y Av. Angulo'),
('ABC079', 'Mouse Raizen', 'Mouse', 21, 60, 55.75, 'Raizen', 'Matriz - Av. América'),
('BBB003', 'Cargador de Laptop HP', 'Original', 13, 65, 52, 'TechnoMega', 'Local - C.C El Caracol');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

CREATE TABLE `usuarios` (
  `cedula` varchar(10) NOT NULL,
  `usuario` varchar(10) NOT NULL,
  `password` varchar(30) NOT NULL,
  `tipo_usuario` varchar(21) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`cedula`, `usuario`, `password`, `tipo_usuario`) VALUES
('1711545978', 'ariel2021', '@riel_rosero...', 'Encargado de Bodega'),
('1711754562', 'enrique202', 'enrique@21', 'Gerente General'),
('1719087999', 'cris2021', '@perez21.-.', 'Vendedor de Mostrador');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `detalle_factura`
--
ALTER TABLE `detalle_factura`
  ADD PRIMARY KEY (`numero_detalle`);

--
-- Indices de la tabla `empleados`
--
ALTER TABLE `empleados`
  ADD PRIMARY KEY (`numero_cedula`);

--
-- Indices de la tabla `facturas`
--
ALTER TABLE `facturas`
  ADD PRIMARY KEY (`numero_factura`);

--
-- Indices de la tabla `productos`
--
ALTER TABLE `productos`
  ADD PRIMARY KEY (`codigo`);

--
-- Indices de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`cedula`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
