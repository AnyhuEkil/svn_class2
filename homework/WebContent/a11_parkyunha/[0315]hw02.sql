/* 숙제 1 */
-- sal을 연봉이라고 할때, 이달 급여분(1/13)을 처리하시오, 단 이달은 보너스가 있는 달입니다.
-- 출력내용 : 사번, 연봉, 이달급여, 보너스, 총급여액(급여와, 총급여액은 10단위로 반올림 처리한다.
select 
	empno 	사번, 
	sal 	연봉, 
	round(sal/13,-1) 이달급여, 
	nvl(comm,0) 보너스, 
	round(sal/13 + nvl(comm,0),-1) 총급여액
from emp;

/* 
숙제 2
sal을 기준으로 
1000미만			- 10% 보너스
1000~2000미만		- 20% 보너스
2000~3000미만		- 30% 보너스
3000~4000미만		- 40% 보너스
4000~5000미만 	- 50% 보너스
5000~이상			- 60% 보너스
를 지급하기로 했다. 함수를 활용해서 아래 내용을 처리하세요.
사번	이름	연봉	보너스(%)	보너스
 */
select
	empno	사번,
	ename	이름,
	sal		연봉,
	trunc(sal+900,-3)*0.01 "보너스(%)",	-- 보통 이런 방식으로 올림을 처리한다?
	sal*trunc(sal+900,-3)*0.0001 보너스
from emp;

/*
숙제3
사원을 부서기준으로 1팀과 2팀으로 나누어서 체육대회를 하기로 했다.
부서번호가 10, 30 ==> 1팀
부서번호가 20, 40 ==> 2팀
으로 나누고 다음과 같이 출력하세요.
부서번호	이름	팀
*/
select
	deptno	부서번호,
	empno	사원번호,
	ename	사원명,
	mod(deptno/10+1,2)+1 팀 
	-- 10의 자라숫자에 대해 1을 더하고 2로 나눈 나머지를 구한다음 최종적으로 1을더한다.
from emp;

/*
숙제4
함수를 이용하여 다음 내용을 출력하세요.
@@@님 입사일이 @@년 @@월 @@일 이며, 현재 연봉은 @@@ 만원 받고 있습니다.
*/
select
	ename
	||'님 입사일이 '||
	substr(hiredate,1,2)
	||'년 '||
	substr(hiredate,4,2)
	||'월 '||
	substr(hiredate,7,2)
	||'일 이며, 현재 연봉은 '||
	sal
	||'만원 받고 있습니다.'
	empinfo
from emp;

/*
숙제5
substr을 활용하여 JOB이 MAN으로 끝나는 데이터를 출력하세요
*/
select *
from emp
where
	substr(job, length(job)-2, length(job)) = 'MAN';

/*
숙제6
입사일이 12월인  데이터를 이름과 입사일을 출력하세요 instr() 활용
*/
select ename, hiredate
from emp
where instr(hiredate, '12', 1, 1) = 4; 
