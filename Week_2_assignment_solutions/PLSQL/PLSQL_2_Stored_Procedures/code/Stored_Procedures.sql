CREATE OR REPLACE PROCEDURE greet_user(name IN VARCHAR2) AS
BEGIN
    DBMS_OUTPUT.PUT_LINE('Hello, ' || name);
END;
/

BEGIN
    greet_user('Alice');
END;
/
