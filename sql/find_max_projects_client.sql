SELECT NAME, COUNT(PROJECT.ID) AS PROJECT_COUNT
FROM  CLIENT
JOIN PROJECT ON CLIENT.ID = PROJECT.CLIENT_ID
GROUP BY CLIENT_ID
HAVING COUNT(PROJECT.ID) IN (
    SELECT COUNT(PROJECT.ID)
    FROM PROJECT
    GROUP BY CLIENT_ID
    ORDER BY COUNT(PROJECT.ID) DESC
    LIMIT 1)