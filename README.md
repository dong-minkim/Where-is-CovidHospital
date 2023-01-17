# 🏥 우리동네 코로나 병원
(공공 데이터 오픈 API와 지도 API를 사용해보고자 제작해보았습니다.)<br>
다양한 코로나 검사 및 치료 방식이 나옴에 따라 진료를 받고자 하는 사람들은 자신에게 맞는 정보를 찾기가 어려워졌습니다. 사람들의 이러한 불편함을 해소하고자 전국에 있는 코로나 관련 병원들의 정보를 쉽게 얻을 수 있는 웹 사이트를 제작하였습니다.<br>
병원의 정보는 계속 수정될 수 있기 때문에 데이터 최신성을 고려하여 매일 일정 시간에 병원 정보가 갱신되도록 구현하였습니다. 
<br>
추후 다른 기능들을 추가해나갈 예정입니다.
 

### 🛠 개발 환경 및 사용 기술
- IntelliJ
- Java 11 verion
- SpringBoot
- Spring Scheduler
- Gradle
- H2(내부 DB)
- JPA
- mustache
- BootStrap
- Ajax
- JUnit
- 공공 데이터 오픈 API
- Kakao Map API


### 📷 주요 화면
><b>[ 처음 접속 화면 ]</b>
>![initImage](https://user-images.githubusercontent.com/77737179/209795133-0e752852-e426-4e98-8920-5af7a1e9708c.png)

><b>[ 지역 등록 혹은 검색으로 병원 찾기 ]</b>
> 
><img src="https://user-images.githubusercontent.com/77737179/209795671-a2b6c0f7-945c-49df-a132-63c1c1f2e6ea.png" width="42%">
><img src="https://user-images.githubusercontent.com/77737179/209796289-3ae3f53a-f28b-4cc4-93c8-636954a57918.png" width="56%">


><b>[ 주소 클릭 시 지도 출력 ]</b>
> ![지도 출력](https://user-images.githubusercontent.com/77737179/211153937-714b0eb1-3efc-4abc-8c2b-26b56eab1e44.png)

><b>[ 길찾기 기능 ]</b>
> ![길찾기](https://user-images.githubusercontent.com/77737179/211154490-7c28e593-a9af-4643-8570-f18456cf21c1.png)