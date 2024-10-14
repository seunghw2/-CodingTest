-- 코드를 입력하세요
SELECT category, sum(sales) as total_sales
from book_sales bs
    join book b on bs.book_id = b.book_id
where left(sales_date, 7) = '2022-01'
group by category
order by category;