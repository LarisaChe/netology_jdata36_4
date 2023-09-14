SELECT *
FROM person p
WHERE UPPER(p.city_of_living) = UPPER(:paramCity);
