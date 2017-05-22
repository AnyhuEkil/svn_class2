CREATE SEQUENCE PRODUCT_SEQ START WITH 1
                            INCREMENT BY 1
                            MAXVALUE 9999;
CREATE TABLE PRODUCT(
	PNO NUMBER(4) PRIMARY KEY,
	PNAME VARCHAR2(100) NOT NULL, 
	PS NUMBER DEFAULT 0
);
INSERT INTO PRODUCT VALUES(PRODUCT_SEQ.NEXTVAL, '공책', 3);
INSERT INTO PRODUCT VALUES(PRODUCT_SEQ.NEXTVAL, '볼펜', 10);
INSERT INTO PRODUCT VALUES(PRODUCT_SEQ.NEXTVAL, 'A', 10);
SELECT * FROM PRODUCT WHERE PNAME = '공책';
COMMIT;
SELECT * FROM PRODUCT;