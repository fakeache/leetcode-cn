select
    score as Score,
    (select count(distinct b.score) from Scores b where b.score >= a.score) as `Rank`
from Scores a
order by a.score desc