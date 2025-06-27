DECLARE
    num NUMBER := &Enter_Number;
    i   NUMBER := 1;
BEGIN
    IF num > 0 THEN
        DBMS_OUTPUT.PUT_LINE('Positive');
    ELSIF num < 0 THEN
        DBMS_OUTPUT.PUT_LINE('Negative');
    ELSE
        DBMS_OUTPUT.PUT_LINE('Zero');
    END IF;

    CASE num
        WHEN 1 THEN DBMS_OUTPUT.PUT_LINE('ONE');
        WHEN 2 THEN DBMS_OUTPUT.PUT_LINE('TWO');
        WHEN 3 THEN DBMS_OUTPUT.PUT_LINE('THREE');
        WHEN 4 THEN DBMS_OUTPUT.PUT_LINE('FOUR');
        WHEN 5 THEN DBMS_OUTPUT.PUT_LINE('FIVE');
        ELSE DBMS_OUTPUT.PUT_LINE('Out of range');
    END CASE;

    WHILE i <= num LOOP
        DBMS_OUTPUT.PUT_LINE(i);
        i := i + 1;
    END LOOP;
END;
/