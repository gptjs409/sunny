--회원 테이블 생성
create table t_member(
  id varchar2(10) primary key,
  pwd varchar2(10),
  name varchar2(50),
  email varchar2(50),
  joinDate date default sysdate --명시적으로 추가하지 않을 경우 현재 시각 입력
);


-- 회원 정보 추가
insert into t_member
values ('hong', '1212', '홍길동', 'hong@gmail.com', sysdate);

insert into t_member
values ('lee', '1212', '이순신', 'lee@test.com', sysdate);

insert into t_member
values ('kim', '1212', '김유신', 'kim@jweb.com', sysdate);

commit; -- SQL Developer에서 테이블에 회원정보를 추가 후 반드시 커밋(commit)을 해줘야 영구적 반영이 됨

select * from t_member;

