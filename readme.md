# FISA STS 버스 예약시스템
TEAM : 김둘우둘 <br>
DATE : 2024-01-16 <br>
MEMBERS : 김준우, 김윤성, 우선주, 이민수

## 만든이유
- java 문법을 복습하며 JDBC를 이용해 mysql과 연동을 하려고 했습니다.
- 그에따라 버스예약시스템이 적당하다고 생각하여 만들게 되었습니다.

## 개요
- Spring Tool Suite를 이용하여 MYSQL와 JAVA를 연동하였습니다.
- 기능으로는 사용자의 버스예약 시간을 Mysql에 Insert, Select를 구현하였습니다.

## TROUBLESHOOTHING
 1. 팀원들과 프로젝트에 대한 전반적인 구현을 하기 위한 대화를 하였습니다. 이 때 아이디어를 조율하는 과정에서 어려움을 겪었습니다. 처음에 각자 종이에 자신이 생각하는 구현방식을 적고 설명하며 각자 생각의 차이가 어디서 났는지 파악 후 의견을 통합시켯습니다.
 2. SQL에서 INSERT 문으로PRIMARY KEY의 AUTO INCREAMENT를 문자열을 넣어서 생성하고 싶었으나 (ex : abc_001 -> abc_002) 실패하였습니다.
 3. JAVA에서 STS를 이용해서 JOIN을 구현하려고 하였으나, 많은 오류를 겪었습니다. 대표적으로 ResultSet에 쿼리문을 작성하고 그 결과값을 preparestatement에서 사용하는 insert 쿼리문에 넣으려고 했으나 while문(ex : rs.next())이 없으면 첫 포인터 적용이 안되어서 자리를 못찾는 문제가 발생했고 수정했으나 사용하지않아서 슬펐습니다.
 