INSERT INTO role (role_id,libelle) VALUES (1,"ADMIN");
INSERT INTO role (role_id,libelle) VALUES (2,"USER");
INSERT INTO user (user_id,role_id,lastname,firstname,email,password,balance) VALUES (1,1,"cli","gui","gui@gmail.com","1234",1000);
INSERT INTO user (user_id,role_id,lastname,firstname,email,password,balance) VALUES (2,2,"cli","aiko","aiko@gmail.com","0000",1000);
INSERT INTO user (user_id,role_id,lastname,firstname,email,password,balance) VALUES (2,2,"cli","estelle","est@gmail.com","4321",1000);
