DROP TABLE `user`;

CREATE TABLE `test`.`user` (
  `userid` INT(8) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(25) NOT NULL,
  `age` INT(11) NOT NULL,
  `isAdmin` TINYINT NOT NULL,
  `createDate` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '\n',
  PRIMARY KEY (`userid`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

INSERT INTO `user` (`name`,`age`,`isAdmin`) VALUES ("Rashad",53,1),("Tanek",70,1),("Nash",37,1),("Alexander",18,1),("Brett",4,1),("Valentine",58,1),("Armando",11,0),("Palmer",11,0),("Ferris",46,1),("Armando",93,0);
INSERT INTO `user` (`name`,`age`,`isAdmin`) VALUES ("Steel",37,1),("Reed",36,0),("Anthony",55,1),("Carlos",63,0),("Marsden",11,0),("Kuame",72,1),("Griffith",11,1),("Ryan",43,0),("Nehru",19,0),("Hedley",16,1);
INSERT INTO `user` (`name`,`age`,`isAdmin`) VALUES ("Nehru",31,1),("Thor",93,1),("Mannix",40,0),("Coby",46,1),("Dorian",64,0),("Leroy",30,0),("Galvin",19,0),("Hamish",63,1),("Geoffrey",44,0),("Stone",83,0);
INSERT INTO `user` (`name`,`age`,`isAdmin`) VALUES ("Geoffrey",57,1),("Benedict",29,1),("Chaim",8,1),("Moses",13,1),("Gil",2,1),("Declan",13,0),("Cadman",71,0),("Kirk",7,1),("Isaiah",72,1),("Henry",24,1);
INSERT INTO `user` (`name`,`age`,`isAdmin`) VALUES ("Scott",34,1),("Howard",99,0),("Channing",66,1),("Amos",17,0),("Vincent",17,0),("Peter",96,1),("Yoshio",33,0),("Xanthus",43,0),("Brian",4,0),("Keaton",28,0);
INSERT INTO `user` (`name`,`age`,`isAdmin`) VALUES ("Jason",41,0),("Kenyon",4,1),("Samuel",36,1),("Rooney",79,0),("Shad",54,0),("Timothy",25,0),("Colby",86,0),("Wing",100,0),("Vance",61,1),("Griffin",67,1);
INSERT INTO `user` (`name`,`age`,`isAdmin`) VALUES ("Jared",94,0),("John",58,1),("Tobias",84,0),("Declan",2,0),("Finn",89,1),("Cairo",97,0),("Kenneth",7,1),("Rudyard",98,0),("Cade",60,1),("Boris",35,0);
INSERT INTO `user` (`name`,`age`,`isAdmin`) VALUES ("Vaughan",20,1),("Merrill",6,0),("Wayne",34,1),("Emerson",94,0),("Hilel",65,1),("Finn",35,0),("Keegan",61,1),("Dolan",89,1),("Clayton",32,1),("Adrian",47,0);
INSERT INTO `user` (`name`,`age`,`isAdmin`) VALUES ("Honorato",64,1),("Devin",78,1),("Malcolm",24,0),("Hashim",86,1),("Aquila",63,0),("Dillon",21,0),("Travis",41,0),("Cole",32,0),("Kevin",73,0),("Baker",79,0);
INSERT INTO `user` (`name`,`age`,`isAdmin`) VALUES ("Jacob",11,1),("Lane",54,1),("Felix",81,0),("Caesar",44,1),("Brenden",1,1),("Dexter",26,0),("Flynn",95,0),("Zane",96,0),("Nero",18,0),("Hashim",4,0);
