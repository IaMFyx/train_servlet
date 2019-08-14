# --1.查询 "001" 课程比 "002" 课程成绩高的所有学生的学号；(子查询/连表)
select a.student_id
from t_score a
inner join t_score b
on a.student_id=b.student_id
       and a.course_id=1
       and b.course_id=2
       and a.score>b.score;

#--2.查询平均成绩大于60分的同学的学号和平均成绩：
select student_id , avg(score)
from t_score
group by student_id
having avg(score)>60;
/*3.查询所有同学的学号、姓名、选课数、总成绩(比较有难度 group by 和 函数)*/
select a.student_id,student_name,count(course_id),sum(score)
from t_student a left outer join t_score b
on a.student_id=b.student_id
group by a.student_id;

#--4.查询 姓 李 同学的个数(考察like和count)
select count(*) num
from t_student
where student_name like'李%';
#--5.查询没有 003课程成绩的学生
select a.student_id,a.student_name
from t_student a left outer join t_score b
on a.student_id=b.student_id
where b.course_id is null or b.score is null;

#--6.查询学过"001"并且也学过编号"002"课程的同学的学号、姓名；
select a.student_id
from t_score a
inner join t_score b
on a.student_id=b.student_id
       and a.course_id=1
       and b.course_id=2;

#--7.查询所有课程平均成绩小于70分的同学的学号、姓名；
select student_id,student_name
from t_student
where student_id in(
select student_id
from t_score
group by student_id
having avg(score)<70);

#--8.查询没有学全所有课的同学的学号、姓名；
select student_id,student_name
from t_student
where student_id in(
select student_id
from(
select student_id,count(*) num
from t_score
group by student_id) a
where a.num<5);
#--改进：
select student_id,student_name
from t_student
where student_id in(
select student_id
from t_score
group by student_id
having count(score)<5);


#--9.查询各科成绩最高和最低的分：以如下形式显示：课程ID，最高分，最低分
SELECT course_id 课程ID,MAX(score) 最高分,MIN(score) 最低分
FROM t_score
GROUP BY course_id;

#--10.查询每门课程有成绩的学生数
SELECT course_id,COUNT(*)num
FROM t_score
GROUP BY course_id;

#--11.查询男生、女生人数
SELECT gender,COUNT(*)
FROM t_student
GROUP BY gender;
#--12.统计同名同姓人数
SELECT student_name , num
from(
    SELECT student_name,COUNT(*) num
    FROM t_student group by student_name) a
WHERE a.num>1;
#--改进：
SELECT student_name,COUNT(*) num
FROM t_student group by student_name
having num>1;

