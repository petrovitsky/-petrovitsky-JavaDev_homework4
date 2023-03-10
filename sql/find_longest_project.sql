SELECT ID AS NAME,  DATEDIFF (month, START_DATE , FINISH_DATE  ) AS MONTH_COUNT
FROM PROJECT
ORDER BY MONTH_COUNT DESC
LIMIT
  SELECT COUNT (ID)
  FROM PROJECT
  GROUP BY DATEDIFF (month, START_DATE , FINISH_DATE)
  ORDER BY DATEDIFF (month, START_DATE , FINISH_DATE) DESC
  LIMIT 1