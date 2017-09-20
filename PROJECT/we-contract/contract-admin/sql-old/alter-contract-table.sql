ALTER TABLE `finance_plan_contract`
ADD COLUMN 
(md5_value VARCHAR(64) DEFAULT NULL ,
salt_value VARCHAR(64) DEFAULT NULL ,
file_path VARCHAR(256) DEFAULT NULL) ;

ALTER TABLE `loan_transfer_contract`
ADD COLUMN 
(md5_value VARCHAR(64) DEFAULT NULL ,
salt_value VARCHAR(64) DEFAULT NULL ,
file_path VARCHAR(256) DEFAULT NULL) ;

ALTER TABLE `contract`
ADD COLUMN 
(md5_value VARCHAR(64) DEFAULT NULL ,
salt_value VARCHAR(64) DEFAULT NULL ,
file_path VARCHAR(256) DEFAULT NULL) ;

ALTER TABLE `contract` RENAME  borrow_contract;
