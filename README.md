# Report3
스프링 부트 검색 프로그램

## 프로젝트 소개
카카오, 네이버 검색 api를 이용한 위치 검색 프로그램

### 개발 환경
- Java 17
- Spring Boot
- Mysql

### 주요 기능
- 카카오, 네이버 검색 api를 이용한 위치 검색
- 키워드 입력 후 검색
- 공통 장소 있는 경우 공통 장소를 우선 순위로 정렬
- 최대 10개의 결과 출력
- 공통 장소 이외의 결과는 카카오 검색 결과->네이버 검색 결과 순서로 정렬
- 인기 키워드 상위 10위 조회 기능

### 사용 라이브러리
- lombok : 로그 출력 편리성을 위해 사용
- openfeign : 외부 api 사용 시 Feign Client 사용. 코드 간결화 및 편리성
- okhttp : Feign Client Configuration 설정 시 사용
- json-simple : 네이버 api 조회 시 json 파싱 기능 사용

### 테스트 방법
- 프로젝트 clone
- docs.sql 파일에 있는 ddl을 이용해 테이블 및 unique key, index 생성
- 프로젝트 빌드 후 curl을 이용해 api 실행

### CURL
- 키워드 검색 curl :
localhost:8080/v1/report/location?keyword=카카오
- 인기 키워드 조회 curl :
localhost:8080/v1/search/count
