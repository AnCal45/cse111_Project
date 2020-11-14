
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
    sh_SuperpowerID char(30),
    sh_from integer,
    sh_teamaffiliation char(40),
    sh_race integer,
    sh_Description char(100)
);

create table Antihero(
    ah_ID integer,
    ah_AntiheroID integer,
    ah_Name char(40) not null,
    ah_SuperpowerID char(30),
    ah_from integer,
    ah_race integer,
    ah_Description char(100) 
);

create table Villain(
    v_ID integer,
    v_VillainID integer,
    v_Name char(40) not null,
    v_SuperpowerID char(30),
    v_from integer,
    sh_teamaffiliation char(40),
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


-- 2. find all characters' name and hero name
SELECT nl_Name as realName, sh_Name as character
from NormalIdentity, Superhero
where nl_ID = sh_ID
UNION
SELECT nl_Name as realName, v_Name as character
from NormalIdentity, Villain
where nl_ID = v_ID
union 
SELECT nl_Name as realName, ah_Name as character
from NormalIdentity, Antihero
where nl_ID = ah_ID;


-- 3. find all villains born on earth that are not human
SELECT *
from Villain, NormalIdentity, Race
where nl_ID = v_ID and v_race = r_ID
    and r_Name <> 'human' and nl_DoB = 'Earth';          --  <-- type of race

-- 4. Find all characters from a specific team
SELECT *
from Team
where t_Name = 'Avengers';

-- 5. find characters from DC that are a villain and female
SELECT *
from NormalIdentity
join Villain on v_ID = nl_ID
join FromWhere on v_from = where_id
where nl_Gender = 'f' and where_name = 'DC';


-- 6. Find all teams from DC that have at least one female character
-- SELECT *
-- from (SELECT nl_Name as realName, sh_Name as character, sh_Team as teamID
--             from NormalIdentity, Superhero
--             where nl_ID = sh_ID
--             UNION
--             SELECT nl_Name as realName, v_Name as character, v_Team as teamID
--             from NormalIdentity, Villain
--             where nl_ID = v_ID
--             union 
--             SELECT nl_Name as realName, ah_Name as character, ah_Team as teamID
--             from NormalIdentity, Antihero
--             where nl_ID = ah_ID) AllChars
-- group by teamID

SELECT t_Name
from Team, (SELECT teamID
            from (SELECT nl_Name as realName, sh_Name as character, sh_Team as teamID, nl_Gender
                        from NormalIdentity, Superhero
                        where nl_ID = sh_ID and sh_from = 2
                        UNION
                        SELECT nl_Name as realName, v_Name as character, v_Team as teamID, nl_Gender
                        from NormalIdentity, Villain
                        where nl_ID = v_ID and v_from = 2
                        union 
                        SELECT nl_Name as realName, ah_Name as character, ah_Team as teamID, nl_Gender
                        from NormalIdentity, Antihero
                        where nl_ID = ah_ID and ah_from = 2) AllChars
            group by teamID
            having count(nl_Gender) >= 1)
where t_TeamID = teamID;

-- 7. Find the heroes with at least 3 archenemies
SELECT *
from Archenemy
group by ae_SuperheroID
having count(*)>= 3 ;


-- 8. Adding a new character (will need to find the highest ID and use that to get the ID for the character)
INSERT INTO NormalIdentity VALUES( ?, ?,'?','?', '?');


-- 9. All female villains, heroes, and antiheroes with their possible real names that are human
SELECT v_Name as character, nl_Name
from Villain, NormalIdentity, Race
where v_ID = nl_ID 
    and v_race = r_ID 
    and nl_Gender = 'f'
    and r_Name = 'Human'
union 
SELECT sh_Name as character, nl_Name
from Superhero, NormalIdentity, Race
where sh_ID = nl_ID 
    and sh_race = r_ID 
    and nl_Gender = 'f'
    and r_Name = 'Human'
UNION
SELECT ah_Name as character, nl_Name
from Antihero, NormalIdentity, Race
where ah_ID = nl_ID 
    and ah_race = r_ID 
    and nl_Gender = 'f'
    and r_Name = 'Human';



-- 10. select all characters that have no specific gender
SELECT *
from (SELECT nl_Name as realName, sh_Name as character, nl_Gender
        from NormalIdentity, Superhero
        where nl_ID = sh_ID
        UNION
        SELECT nl_Name as realName, v_Name as character, nl_Gender
        from NormalIdentity, Villain
        where nl_ID = v_ID
        union 
        SELECT nl_Name as realName, ah_Name as character, nl_Gender
        from NormalIdentity, Antihero
        where nl_ID = ah_ID) AllChars
where nl_Gender = 'binary'; 



-- 11.  All female villains, heroes with their possible real names that are Meta-Human
SELECT v_Name as character, nl_Name
from Villain, NormalIdentity, Race
where v_ID = nl_ID 
    and v_race = r_ID 
    and nl_Gender = 'f'
    and r_Name = 'Meta-Human'
union 
SELECT sh_Name as character, nl_Name
from Superhero, NormalIdentity, Race
where sh_ID = nl_ID 
    and sh_race = r_ID 
    and nl_Gender = 'f'
    and r_Name = 'Meta-Human';


-- 12. Find all characters that are in both avengers and shield
SELECT *
from Team
where t_Name = 'Avengers'
union
SELECT *
from Team
where t_Name = 'S.H.I.E.L.D.';


-- 13. INSERt a new race plus delete that new race
INSERT INTO Race VALUES( 42,'kree');

-- 14. delete waht we put in the 13
Delete FROM Race 
WHERE r_ID = 42;

-- 15 using the update fuction
UPDATE Race 
SET r_name = 'half-vampire'
WHERE r_ID = 40;


-- 16.  group all superheroes by gender and count how many characters are in each gender
SELECT nl_Gender, count(*)
from Superhero, NormalIdentity
where sh_ID = nl_ID
group by nl_Gender;

-- 17. Determine which group (Superhero, Villain, Antihero) has the most females

-- SELECT count(*) as femaleCount
-- from Superhero, NormalIdentity
-- where sh_ID = nl_ID and nl_Gender = 'f'
-- INTERSECT
-- SELECT count(*) as femaleCount
-- from Antihero, NormalIdentity
-- where ah_ID = nl_ID and nl_Gender = 'f'
-- intersect
-- SELECT count(*) as femaleCount
-- from Villain, NormalIdentity
-- where v_ID = nl_ID and nl_Gender = 'f'

-- SELECT 



  




