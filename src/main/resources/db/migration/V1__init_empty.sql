CREATE TABLE  if not exists person(
    id int auto_increment primary key,
    name varchar (40),
    email varchar (50),
    telephone varchar (20)
);

CREATE TABLE  if not exists  ingredient(
    id int auto_increment primary key,
    name varchar (50),
    lysine double,
    methyonine double,
    proteine_brute double,
    energie_metabolisable double
);

CREATE TABLE  if not exists  apportnutritif(
    id int auto_increment primary key,
    name varchar (30),
    value double
);

CREATE TABLE  if not exists  proportionstandard(
    id int auto_increment primary key,
    description varchar (100),
    lysine double,
    methyonine double,
    proteine_brute double,
    energie_metabolisable double
);