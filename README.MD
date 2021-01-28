## 스프링 부트 스터디

### 1주차 과제

#### 과제 1. 영화 검색 API 사용 시 응답 데이터 가져오기 위한 필드 추가

* 필드 추가 [ResponseMovieApiDto.java](/src/main/java/com/study/task/domain/movie/dto/ResponseMovieApiDto.java)
* 응답데이터 검증 테스트 코드 [MovieServiceTest.java](/src/test/java/com/study/task/service/MovieServiceTest.java)

#### 과제 2. 테스트 코드 작성

* 전체 테스트 코드 [test code](/src/test/java/com/study/task)

#### 과제 3. 네이버 검색 도서 API 사용

* 프로덕션 코드 [book 도메인 참고](/src/main/java/com/study/task)
    
#### 셀프 추가 과제 4. 카카오 번역 API 사용

* 프로덕션 코드 [translation 도메인 참고](/src/test/java/com/study/task)

### 2주차 과제

#### 과제 1. 영화 검색 시 평점이 0인 데이터는 제외하는 기능을 개발

* 프로덕션 코드 [MovieGroup.java](/src/main/java/com/study/task/domain/movie/MovieGroup.java)

#### 과제 2. 영화 평점 순 정렬에 대한 단위 테스트를 작성(평점이 높은 순으로 정렬이 잘 되는지 검증)

* 테스트 코드 [MovieGroupTest.java](/src/test/java/com/study/task/domain/movie/MovieGroupTest.java)

#### 과제 3. 영화 검색시 평점이 0인 데이터를 제외하는 기능에 대해서 단위테스트를 작성해주세요. (단위테스트는 @SpringBootTest 사용하지 않고 작성)

* 테스트 코드 [MovieServiceUnitTest.java](/src/test/java/com/study/task/service/MovieServiceUnitTest.java)

#### 과제 4. 영화 검색 및 그외 다른 검색... 2개 이상의 검색 기능에 사용하는 로직에서, RestTemplate를 공통으로 사용하는 부분이 있다면, 중복코드가 없도록 리팩토링

* 프로덕션 코드 [NaverProperties.java](/src/main/java/com/study/task/config/NaverProperties.java)

#### 과제 5. RestTemplate Bean 설정 컨피그 클래스에서 매직넘버로 설정한 셋팅 값들 전부 application.yml 파일로 속성 분리하기

* 프로덕션 코드 [HttpClientConfig.java](/src/main/java/com/study/task/config/HttpClientConfig.java)
* 설정 파일     [application.yml](/src/main/resources/application.yml)

### 3주차 과제

#### 과제 1. 사용자에 의한 키워드 검색 시 네이버 Open API 영화 검색 결과를 애플리케이션 내부에 정의한 자료구조에 저장해놓기(캐싱 역할로 사용)

* 프로덕션 코드 [MovieController.java](/src/main/java/com/study/task/controller/MovieController.java)

#### 과제 2. 사용자에 의한 키워드 검색 시 특정 키워드에 해당하는 데이터가 자료구조에 이미 저장되어있다면, 네이버 오픈 API 호출하지 않고, 저장된(캐싱된) 데이터를 사용하도록 구현 (없으면 네이버 Open API 호출 후 자료구조 저장)

* 프로덕션 코드 [MovieController.java](/src/main/java/com/study/task/controller/MovieController.java)

#### 과제 3. 관리자에 의한 캐시 데이터를 강제로 업데이트(갱신)하는 RestController API 만들기 (RestAPI를 갱신해주는 API를 호출하면, 네이버 오픈 API를 호출 후 캐시에 저장)

* 프로덕션 코드 [CacheController.java](/src/main/java/com/study/task/controller/CacheController.java)

#### 과제 4. 자료구조에 저장한 데이터는 10분이 지나면 서버에서 자동으로 지우지

* 프로덕션 코드 [ScheduleTask.java](/src/main/java/com/study/task/util/ScheduleTask.java)