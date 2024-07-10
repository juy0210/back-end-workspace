-- 다음은 직원 테이블에서 사원명, 직급코드, 보너스를 받는 사원 수를 조회하여 
-- 직급코드 순으로 오름차순 정렬하는 구문이다.

SELECT emp_name, job_code, count(*) as 사원수
FROM employee
WHERE bonus != NULL
GROUP BY job_code;

SELECT * FROM job;

SELECT emp_name, job_code
FROM employee
WHERE bonus IS NOT NULL
ORDER BY job_code;

SELECT emp_name, job_code
FROM employee
WHERE bonus IS NOT NULL
ORDER BY job_code;

-- 다음 두 개의 테이블을 조인하여 emp_id, emp_name, dept_id, dept_title 컬럼을 조회하였을 때 문제가 발생한다
SELECT emp_id, emp_name, dept_id, dept_title
FROM employee
JOIN department USING (dept_id);

SELECT emp_id, emp_name, dept_id, dept_title
FROM employee
JOIN department ON dept_id = 'D9';

SELECT dept_code, format(sum(salary), 0) 합계, format(avg(salary), 0) 평균, count(*) 인원수
FROM employee
GROUP BY dept_code
HAVING avg(salary) > 2800000
ORDER BY dept_code;

SELECT job_code "직급 코드", format(avg(salary), 0) "평균 급여"
FROM employee
WHERE bonus is not null
GROUP BY job_code
HAVING avg(salary) >= 3000000;

SELECT emp_name, job_code, count(*) as 사원수
FROM employee
WHERE bonus is not null
GROUP BY emp_name, job_code
ORDER BY job_code;











