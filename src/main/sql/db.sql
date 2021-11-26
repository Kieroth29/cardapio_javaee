create database `cardapio`;
use cardapio;

create table `pratos`(
    `id` int(10) primary key not null auto_increment,
    `nome` varchar(50) not null,
    `ingredientes` varchar(200) not null,
    `preco` float(8) not null
	)engine=innodb default charset=utf8;