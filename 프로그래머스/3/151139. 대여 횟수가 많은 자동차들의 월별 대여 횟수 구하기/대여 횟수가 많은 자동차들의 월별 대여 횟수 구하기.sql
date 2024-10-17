WITH car_count AS (
    SELECT 
        car_id, 
        COUNT(car_id) AS rental_count
    FROM 
        CAR_RENTAL_COMPANY_RENTAL_HISTORY
    WHERE 
        start_date >= TO_DATE('2022-08', 'YYYY-MM') 
        AND start_date < TO_DATE('2022-11', 'YYYY-MM')
    GROUP BY 
        car_id
),
car_select_id AS (
    SELECT 
        car_id
    FROM 
        car_count
    WHERE 
        rental_count >= 5
),
filtered_rentals AS (
    SELECT 
        ch.car_id,
        EXTRACT(MONTH FROM ch.start_date) AS month
    FROM 
        car_select_id ci
    JOIN 
        CAR_RENTAL_COMPANY_RENTAL_HISTORY ch
        ON ci.car_id = ch.car_id
    WHERE 
        ch.start_date >= TO_DATE('2022-08', 'YYYY-MM') 
        AND ch.start_date < TO_DATE('2022-11', 'YYYY-MM')
)

SELECT 
    month,
    car_id,
    COUNT(*) AS records
FROM 
    filtered_rentals
GROUP BY 
    month, 
    car_id
ORDER BY 
    month ASC,
    car_id DESC;
