SELECT year(sales_date) as YEAR, month(sales_date) AS MONTH, GENDER, count(DISTINCT o.user_id) as USERS
From user_info u join online_sale o
on u.user_id = o.user_id
where gender is not null
group by year(sales_date), month(sales_date), gender
order by year(sales_date), month(sales_date), gender