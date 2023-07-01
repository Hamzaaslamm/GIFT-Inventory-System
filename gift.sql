DROP DATABASE IF EXISTS gift;

CREATE DATABASE gift;
CREATE TABLE Computer_Operator
(
  User_Name VARCHAR(255) NOT NULL,
  Password INT(55) NOT NULL,
  Pin INT(55) NOT NULL,
  PRIMARY KEY (User_Name)
);

CREATE TABLE Product
(
    pId INT(55) NOT NULL AUTO_INCREMENT,
  Product_Name VARCHAR(255) Unique NOT NULL,
  pQuantity INT(55) NOT NULL,
  pprice INT(55) NOT NULL,
  pDescription VARCHAR(255) NOT NULL,
  FkP_User_Name VARCHAR(255) NOT NULL,
  PRIMARY KEY (pId),
  FOREIGN KEY (FkP_User_Name) REFERENCES Computer_Operator(User_Name)
);

CREATE TABLE Bill
(
  bId INT(55) NOT NULL AUTO_INCREMENT,
  cName VARCHAR(255) NOT NULL,
  Amount INT(55) NOT NULL,
  Discount INT(55) NOT NULL,
  date DATE NOT NULL,
  FkB_User_Name VARCHAR(255) NOT NULL,
  PRIMARY KEY (bId),
  FOREIGN KEY (FkB_User_Name) REFERENCES Computer_Operator(User_Name)
);

CREATE TABLE OrderLine
(
    OlId INT(55) NOT NULL AUTO_INCREMENT,
  pName VARCHAR(255) NOT NULL,
  pQuantity INT(55) NOT NULL,
  pPrice INT(55) NOT NULL,
  pAmount INT(55) NOT NULL,
  Fk_bId INT(55) NOT NULL,
  PRIMARY KEY (OlId),
  FOREIGN KEY (Fk_bId) REFERENCES Bill(bId)
);
INSERT INTO `computer_operator`(`User_Name`, `Password`, `Pin`) VALUES ('Ahsan Ali','191400070','1122');

INSERT INTO `bill`(`bId`, `cName`, `Amount`, `Discount`, `date`, `FkB_User_Name`) VALUES ('1','Wahab','200','20',CURRENT_DATE,'Ahsan Ali');
INSERT INTO `bill`(`bId`, `cName`, `Amount`, `Discount`, `date`, `FkB_User_Name`) VALUES ('2','Hamza Aslam','500','40',CURRENT_DATE,'Ahsan Ali');
INSERT INTO `bill`(`bId`, `cName`, `Amount`, `Discount`, `date`, `FkB_User_Name`) VALUES ('3','Tehseen','150','10',CURRENT_DATE,'Ahsan Ali');

INSERT INTO `orderline`(`OlId`, `pName`, `pQuantity`, `pPrice`, `pAmount`, `Fk_bId`) VALUES ('1','Sooper Biscuit',4,20,80,'1');
INSERT INTO `orderline`(`OlId`, `pName`, `pQuantity`, `pPrice`, `pAmount`, `Fk_bId`) VALUES ('2','Salted Lays',10,30,300,'2');
INSERT INTO `orderline`(`OlId`, `pName`, `pQuantity`, `pPrice`, `pAmount`, `Fk_bId`) VALUES ('3','Mango Juice',5,30,150,'3');


INSERT INTO `product`(`pId`, `Product_Name`, `pQuantity`, `pprice`, `pDescription`, `FkP_User_Name`) VALUES ('1','Rio Biscuit',50,25,'Rio Biscuit Big pack','Ahsan Ali');
INSERT INTO `product`(`pId`, `Product_Name`, `pQuantity`, `pprice`, `pDescription`, `FkP_User_Name`) VALUES ('2','Rani Juice',200,110,'Fresh cold Rani Juice','Ahsan Ali');