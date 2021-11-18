
CREATE TABLE role (
                role_id INT NOT NULL,
                libelle VARCHAR(100) NOT NULL,
                PRIMARY KEY (role_id)
);


CREATE TABLE user (
                user_id INT NOT NULL,
                role_id INT NOT NULL,
                lastname VARCHAR(100) NOT NULL,
                firstname VARCHAR(100) NOT NULL,
                email VARCHAR(100) NOT NULL,
                password VARCHAR(100) NOT NULL,
                PRIMARY KEY (user_id)
);
CREATE TABLE user_friends (
                user_friends_id INT AUTO_INCREMENT NOT NULL,
                user_id INT NOT NULL,
                PRIMARY KEY (user_friends_id)
);


CREATE TABLE bank_account (
                bank_account_id INT AUTO_INCREMENT NOT NULL,
                user_id INT NOT NULL,
                rib VARCHAR(100) NOT NULL,
                PRIMARY KEY (bank_account_id)
);


CREATE TABLE transaction_account (
                transaction_account_id INT AUTO_INCREMENT NOT NULL,
                bank_account_id INT NOT NULL,
                date_transaction_account DATETIME NOT NULL,
                amount DECIMAL(6,2) NOT NULL,
                PRIMARY KEY (transaction_account_id)
);


CREATE TABLE pmb_account (
                pmb_account_id INT AUTO_INCREMENT NOT NULL,
                user_id INT NOT NULL,
                account_number INT NOT NULL,
                account_balance DECIMAL(6,2) NOT NULL,
                PRIMARY KEY (pmb_account_id)
);


CREATE TABLE transaction (
                transaction_id INT AUTO_INCREMENT NOT NULL,
                pmb_account_id INT NOT NULL,
                transaction_number INT NOT NULL,
                date_transaction DATETIME NOT NULL,
                description VARCHAR(100) NOT NULL,
                amount DECIMAL(6,2) NOT NULL,
                cost DECIMAL(6,2) NOT NULL,
                PRIMARY KEY (transaction_id)
);


ALTER TABLE user ADD CONSTRAINT role_user_fk
FOREIGN KEY (role_id)
REFERENCES role (role_id)
ON DELETE NO ACTION
ON UPDATE NO ACTION;

ALTER TABLE pmb_account ADD CONSTRAINT utilisateur_compte_pay_my_buddy_fk
FOREIGN KEY (user_id)
REFERENCES user (user_id)
ON DELETE NO ACTION
ON UPDATE NO ACTION;

ALTER TABLE bank_account ADD CONSTRAINT utilisateur_compte_bancaire_fk
FOREIGN KEY (user_id)
REFERENCES user (user_id)
ON DELETE NO ACTION
ON UPDATE NO ACTION;

ALTER TABLE user_friends ADD CONSTRAINT user_user_friends_fk
FOREIGN KEY (user_id)
REFERENCES user (user_id)
ON DELETE NO ACTION
ON UPDATE NO ACTION;


ALTER TABLE transaction_account ADD CONSTRAINT compte_bancaire_transaction_account_fk
FOREIGN KEY (bank_account_id)
REFERENCES bank_account (bank_account_id)
ON DELETE NO ACTION
ON UPDATE NO ACTION;

ALTER TABLE transaction ADD CONSTRAINT compte_pay_my_buddy_transactions_fk
FOREIGN KEY (pmb_account_id)
REFERENCES pmb_account (pmb_account_id)
ON DELETE NO ACTION
ON UPDATE NO ACTION;
