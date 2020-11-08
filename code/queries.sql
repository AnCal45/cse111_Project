
/* 
    create tables
   populate tables
   make queries
   
*/

--drop the tables that we currently have
drop table NormalIdentity;
drop table Superhero;
drop table Antihero;
drop table Villain;
drop table Team;
drop table Version;
drop table Superpower;
drop table Archenemy;
drop table Race;
drop table Dimension;




--create the tables that we currently have
create table NormalIdentity (
    nl_ID integer,
    nl_PersonID integer, 
    nl_Name char(40) not null,
    nl_Occupation char(40) not null,
    nl_Gender char(2) not null,
    nl_DoB Date not null,
    nl_Location char(40) not null
);

create table Superhero(
    sh_ID integer,
    sh_SuperheroID integer,
    sh_Name char(40) not null,
    sh_SuperpowerID integer,
    sh_Description char(100) not null
);

create table Antihero(
    ah_ID integer,
    ah_AntiheroID integer,
    ah_Name char(40) not null,
    ah_SuperpowerID integer,
    ah_Description char(100) not null
);

create table Villain(
    v_ID integer,
    v_VillainID integer,
    v_Name char(40) not null,
    v_SuperpowerID integer,
    v_Description char(100) not null
);

create table Team(
    t_SuperheroID integer,
    t_AntiheroID integer,
    t_VillainID integer,
    t_Name char(40) not null,
    t_TeamID integer
);

create table Version(
    ver_ID integer,
    ver_SuperheroID integer,
    ver_AntiheroID integer,
    ver_VillainID integer,
    ver_Name char(40) not null
);

create table Superpower(
    sp_ID integer,
    sp_PowerID integer
    sp_Name char(40) not null,
    sp_Description char(100) not null
);

create table Archenemy(
    ae_ID integer,
    ae_SuperheroID integer,
    ae_VillainID integer
);

create table Race(
    r_ID integer,
    r_Name char(40) not null
);

create table Dimension(
    d_DimensionID integer,
    d_VersionID integer,
    d_Name integer
);



-- populate table


-- create queries that are useful
