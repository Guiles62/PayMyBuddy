CREATE SCHEMA "paymybuddy" ;

CREATE TABLE role (
                role_id INT AUTO_INCREMENT NOT NULL,
                libelle VARCHAR(100) NOT NULL,
                PRIMARY KEY (role_id)
);


CREATE TABLE user (
                user_id INT AUTO_INCREMENT NOT NULL,
                role_id INT NOT NULL,
                lastname VARCHAR(100) NOT NULL,
                firstname VARCHAR(100) NOT NULL,
                email VARCHAR(100) NOT NULL,
                password VARCHAR(100) NOT NULL,
                balance DECIMAL(6,2) NOT NULL,
                PRIMARY KEY (user_id)
);


CREATE TABLE bank_transaction (
                bank_transaction_id INT AUTO_INCREMENT NOT NULL,
                date_transaction_account DATETIME NOT NULL,
                amount DECIMAL(6,2) NOT NULL,
                rib VARCHAR(100) NOT NULL,
                user_id INT NOT NULL,
                PRIMARY KEY (bank_transaction_id)
);


CREATE TABLE transaction (
                transaction_id INT AUTO_INCREMENT NOT NULL,
                date_transaction DATETIME NOT NULL,
                description VARCHAR(100) NOT NULL,
                amount DECIMAL(6,2) NOT NULL,
                cost DECIMAL(6,2) NOT NULL,
                user_transmitter_id INT NOT NULL,
                user_recipient_id INT NOT NULL,
                PRIMARY KEY (transaction_id)
);


CREATE TABLE user_friends (
                user_id INT NOT NULL,
                user_id_friends INT NOT NULL,
                PRIMARY KEY (user_id, user_id_friends)
);


ALTER TABLE user ADD CONSTRAINT role_user_fk
FOREIGN KEY (role_id)
REFERENCES role (role_id)
ON DELETE NO ACTION
ON UPDATE NO ACTION;

ALTER TABLE user_friends ADD CONSTRAINT user_user_friends_fk
FOREIGN KEY (user_id)
REFERENCES user (user_id)
ON DELETE NO ACTION
ON UPDATE NO ACTION;

ALTER TABLE user_friends ADD CONSTRAINT user_user_friends_fk1
FOREIGN KEY (user_id_friends)
REFERENCES user (user_id)
ON DELETE NO ACTION
ON UPDATE NO ACTION;

ALTER TABLE transaction ADD CONSTRAINT user_transaction_fk
FOREIGN KEY (user_transmitter_id)
REFERENCES user (user_id)
ON DELETE NO ACTION
ON UPDATE NO ACTION;

ALTER TABLE transaction ADD CONSTRAINT user_transaction_fk1
FOREIGN KEY (user_recipient_id)
REFERENCES user (user_id)
ON DELETE NO ACTION
ON UPDATE NO ACTION;

ALTER TABLE bank_transaction ADD CONSTRAINT user_transaction_account_fk
FOREIGN KEY (user_id)
REFERENCES user (user_id)
ON DELETE NO ACTION
ON UPDATE NO ACTION;
