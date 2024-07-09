-- 1-1. DML -------------
-- kh.employee 테이블에서 사번, 이름, 부서명, 입사일 가져오기
INSERT INTO emp
SELECT emp_id, emp_name, dept_title, hire_date
FROM kh.employee
    JOIN kh.department ON (dept_code = dept_id);
    
-- 컬럼명을 명시하는 방법 => 컬럼명 순서만 맞으면 상관 없음
INSERT INTO emp(dept_title, emp_name, hire_date)
SELECT dept_title, emp_name, emp_id, hire_date
FROM kh.employee
    JOIN kh.department ON (dept_code = dept_id);    
    
-- emp_dept 테이블에 employee에서 부서코드가 D1인 직원의 사번, 이름, 부서코드, 입사일 추가하고
-- emp_manager 테이블에 employee에서 부서코드가 D1인 직원의 사번, 이름, 관리자 사번 추가
INSERT INTO emp_dept
SELECT emp_id, emp_name, dept_code, hire_date
FROM kh.employee
WHERE dept_code = 'D1';

INSERT INTO emp_manager
SELECT emp_id, emp_name, manager_id
FROM kh.employee
WHERE dept_code = 'D1';

SELECT * FROM emp;

-- 아시아 지역의 근무하는 직원들의 보너스를 0.3으로 변경
SELECT * FROM kh.employee;
SELECT * FROM kh.department;
SELECT * FROM kh.location;

SELECT emp_id
FROM kh.employee
    JOIN kh.department ON (dept_code = dept_id)
    JOIN kh.location ON (local_code = local_id);


UPDATE emp_salary
SET bonus = 0.3
WHERE emp_id IN (SELECT emp_id
                 FROM kh.employee
                     JOIN kh.department ON (dept_code = dept_id)
					 JOIN kh.location ON (location_id = local_code)
                 WHERE local_name LIKE 'ASIA%');   

-- 1-2 SELECT ------------
-- 3. 급여가 400만원 이상인 사원들의 사원명, 부서코드, 급여조회
SELECT emp_name, dept_code, salary
FROM employee
WHERE salary >= '4000000';

-- 4. 재직중(ent_yn 컬럽값이 'N')인 사원들의 사번, 사원명, 입사일(hire_date) 조회
SELECT emp_id, emp_name, hire_date
FROM employee
WHERE ent_yn = 'N';

-- OR(또는), AND(그리고) -----
-- 부서코드가 'D6'이거나 급여가 300만원 이상인 사원들의 사원명, 부서코드, 급여 조회
SELECT emp_name, dept_code, salary
FROM employee
WHERE dept_code = 'D6' AND salary >= '3000000';

-- 급여 350만원 이상이면서 600만원 이하를 받는 사원들의 사원명, 사번, 급여 조회
SELECT emp_name, emp_id, salary
FROM employee
WHERE salary >= '3500000' AND salary >= '6000000';


-- 이름의 가운데 글자가 '하'인 사원들의 사원명, 전화번호 조회 (이름이 3글자)
SELECT emp_name, phone
FROM employee
WHERE emp_name LIKE '_하_';

-- 전화번호의 3번째 자리가 1인 사원들의 사번, 사원명, 전화번호, 이메일 조회
SELECT emp_id, emp_name, phone, email
FROM employee
WHERE phone LIKE '_1%';

-- 이메일 중 _ 앞글자가 3글자인 사원들의 사번, 이름, 이메일 조회
-- ESCAPE OPTION : 나만의 와일드 카드를 만들어서 사용!
SELECT emp_id, emp_name, email
FROM employee
WHERE email LIKE '___$_%' ESCAPE '$';

-- 2. 사수가 없고 부서배치도 받지 않은 사원들의 사원명 사수사번(manager_id), 부서코드 조회
SELECT emp_name, manager_id, dept_code
FROM employee
WHERE manager_id IS NULL AND dept_code IS NULL;

-- 3. 연봉(보너스포함x)이 4000만원 이상이고 보너스를 받지 않은 사원들의 사번, 사원명, 급여, 보너스 조회
SELECT emp_id, emp_name, salary, bonus
FROM employee
WHERE salary * 12 >= 40000000 AND bonus IS NULL;

-- 5. 급여가 200만원 이상 500만원 이하이고 입사일이 '2001-01-01' 이상이고 보너스를
--    받지 않은 사원들의 사번, 사원명, 급여, 입사일, 보너스 조회
SELECT emp_id, emp_name, salary, hire_date, bonus
FROM employee
WHERE salary BETWEEN 2000000 AND 5000000
AND hire_date >= '2001-01-01'
AND bonus IS NULL;

-- 사원명, 사원명의 글자수, 이메일, 이메일의 글자수 조회
SELECT emp_name, char_length(emp_name), email, char_length(email)
FROM employee;

-- 여자 사원들의 이름, 주민등록번호 조회
SELECT emp_name, emp_no, substr(emp_no, 8, 1)
FROM employee
WHERE substr(emp_no, 8, 1) IN (2, 4);

-- 남자 사원들의 이름, 주민등록번호 조회
-- SELECT emp_name, emp_no, substr(emp_no, 8, 1)
SELECT emp_name, emp_no
FROM employee
WHERE substr(emp_no, instr(emp_no, '-') +1, 1) IN (1, 3);

-- 2. GROUP BY -----------------
-- 직급 코드(job_code)별 사원 수 조회
SELECT job_code, count(*)
FROM employee
GROUP BY job_code;

-- 성별(남자/여자) 별 사원 수 조회
SELECT if(substr(emp_no, 8, 1) = 1, '남자', '여자') 성별, count(*)
FROM employee
GROUP BY 성별;

-- 부서별 평균 급여가 300만원 이상인 부서의 평균 급여 조회
SELECT dept_code, avg(salary)
FROM employee
GROUP BY dept_code
HAVING 평균급여 >= 3000000;

-- 직급별 총 급여의 합이 1000만원 이상인 직급과 급여의 합 조회
SELECT job_code, sum(salary)
FROM employee
GROUP BY job_code
HAVING sum(salary) >= 10000000;

-- 부서별 보너스를 받는 사원이 없는 부서만 조회
SELECT dept_code, count(bonus)
FROM employee
GROUP BY dept_code
HAVING count(bonus) = 0;

-- 부서별 보너스를 받는 사원들 수 조회
SELECT dept_code, count(bonus)
FROM employee
GROUP BY dept_code
HAVING count(bonus) != 0;

SELECT dept_code, count(*) -- 보너스가 null이 아닌 경우
FROM employee
WHERE bonus is not null
GROUP BY dept_code;

-- 부서 코드가 D5이거나 급여가 300만원 초과인 사원들의 사번, 사원명, 부서코드, 급여 조회
-- 2. UNION ALL
SELECT emp_id, emp_name, dept_code, salary
FROM employee
WHERE dept_code = 'D5'
UNION ALL -- 두 쿼리문을 UNION ALL로 이은다 (1)(2)가 하나의 쿼리임-중복되는 행까지 나옴
SELECT emp_id, emp_name, dept_code, salary
FROM employee
WHERE salary > 3000000;

-- 3. JOIN -------------
-- 1) 연결할 두 컬럼명이 다른 경우 (employee : dept_code - department : dept_id)
-- 사번, 사원명, 부서코드, 부서명(dept_title(department)) 조회
SELECT emp_id, emp_name, dept_code, dept_title
FROM employee, department
WHERE dept_code = dept_id;

-- >> ANSI 구문
SELECT emp_id, emp_name, dept_code, dept_title
FROM employee
JOIN department ON (dept_code = dept_id); 

-- 2) 연결할 두 컬럼명이 같은 경우 (employee : job_code - job : job_code)
-- 사번, 사원명, 직급코드, 직급명(job_name) 조회
SELECT emp_id, emp_name, job_code, job_name
FROM employee, job
WHERE job_code = job_code; -- 오류 발생 ambiguous : 애매한, 모호한 / 에러 발생!

-- 해결방법 1) 테이블명 이용
SELECT emp_id, emp_name, job.job_code, job_name
FROM employee, job
WHERE employee.job_code = job.job_code;

-- 해결방법 2) 테이블명에 별칭 부여해서 이용
SELECT emp_id, emp_name, j.job_code, job_name
FROM employee e, job j
WHERE e.job_code = j.job_code;

-- >> ANSI 구문
SELECT emp_id, emp_name, e.job_code, job_name
FROM employee e
JOIN job j ON (e.job_code = j.job_code);

-- 두 컬럼명이 같을 때만 USING 구문 사용 가능!
SELECT emp_id, emp_name, job_code, job_name
FROM employee
JOIN job USING (job_code);

-- 2. 전체 부서의 부서코드, 부서명, 지역코드, 지역명 조회 (department, location)
SELECT * FROM department; -- dept_id, dept_title, location_id
SELECT * FROM location; -- local_code, national_code, local_name

SELECT dept_code, dept_title, local_code, local_name
FROM employee
JOIN location ON (local_code = local_id);


-- 3. 보너스를 받는 사원들의 사번, 사원명, 보너스, 부서명 조회 (employee, department)
SELECT * FROM employee; -- emp_id, emp_name, bonus, dept_code
SELECT * FROM department; -- dept_id, dept_title

SELECT emp_id, emp_name, bonus, dept_title
FROM employee
     JOIN department ON (dept_code = dept_id)
WHERE bonus IS NOT NULL;     

-- 실습문제 ---
-- 1. 부서가 인사관리부인 사원들의 이름, 보너스 조회 (employee, department)
SELECT * FROM employee; -- emp_id, emp_name, bonus, dept_code
SELECT * FROM department; -- dept_id, dept_title

-- >> WHERE 구문
SELECT emp_name, bonus
FROM employee
WHERE dept_code = dept_id AND dept_title = '인사관리부';

-- >> ANSI
SELECT emp_id, emp_name, bonus
FROM employee
JOIN department ON (dept_code = dept_id)
AND dept_title = '인사관리부';

-- 4. 부서가 총무부가 아닌 사원들의 사원명, 급여 조회 (employee, department)
SELECT * FROM employee; -- emp_name, salary, dept_code
SELECT * FROM department; -- dept_id, dept_title

SELECT emp_name, salary
FROM employee
right JOIN department ON (dept_code = dept_id)
WHERE dept_title != '총무부';