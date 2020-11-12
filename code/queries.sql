
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
drop table FromWhere;




--create the tables that we currently have
create table NormalIdentity (
    nl_ID integer,
    nl_PersonID integer, 
    nl_Name char(40) ,--not null,
    nl_Gender char(2) ,--not null,
    nl_DoB char(40) --null,
);

create table Superhero(
    sh_ID integer,
    sh_SuperheroID integer,
    sh_Name char(40) not null,
    sh_SuperpowerID integer,
    sh_from integer,
    sh_race integer,
    sh_Description char(100)
);

create table Antihero(
    ah_ID integer,
    ah_AntiheroID integer,
    ah_Name char(40) not null,
    ah_SuperpowerID integer,
    ah_from integer,
    ah_race integer,
    ah_Description char(100) 
);

create table Villain(
    v_ID integer,
    v_VillainID integer,
    v_Name char(40) not null,
    v_SuperpowerID integer,
    v_from integer,
    v_race integer,
    v_Description char(100)
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
    sp_PowerID integer,
    sp_Name char(60) not null,
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

create table FromWhere(
    where_id integer,
    where_name char(20) not null
);



-- populate table
.mode "csv"
.separator ","
.import database_normalIdentity.csv NormalIdentity
-- we can do it in 3 different ways:
    -- importing using the .import command
    -- importing using sqliteStudio
    -- inserting values manually


-- create queries that are useful

-- 1. Find a specific hero by secret hero name
SELECT *
from Superhero
WHERE sh_Name = 'Superman';  --  <-- 'hero name'


-- 2. find al characters' name and hero name
-- SELECT *
-- from NormalIdentity, Superhero, Villain, Antihero
-- where 


-- 3. find all villains born on earth that are not human


-- 4. Find all characters from a specific team


-- 5. find a character from "_______" that is 


-- 6. Find all teams from DC that have at least one female character






  




