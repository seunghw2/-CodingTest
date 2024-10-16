with rental_price as (
    SELECT history_id, daily_fee, (end_date - start_date + 1) as rent_date,
        case 
            when end_date - start_date + 1 >= 90 then '90일 이상'
            when end_date - start_date + 1 >= 30 then '30일 이상'
            when end_date - start_date + 1 >= 7 then '7일 이상'
            else null
            end as duration_type
    from car_rental_company_car c
        join car_rental_company_rental_history h 
            on c.car_id = h.car_id
    where car_type = '트럭'
),

rental_discount as (
    select history_id, daily_fee * rent_date as price, coalesce(discount_rate, 0) as discount_rate
    from rental_price r
        left outer join car_rental_company_discount_plan p
        on r.duration_type = p.duration_type AND p.car_type = '트럭'
)

select history_id, floor(price * (100 - discount_rate) / 100) as fee
from rental_discount
order by fee desc, history_id desc;
