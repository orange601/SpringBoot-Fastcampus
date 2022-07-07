# Fastcampus
강의내용정리

## 목차 ##

[1.IOC, DI](#1장-IOC-DI)

[2.AOP](#2장-AOP)

[3.Validation](#3장-Validation)

## 1장. IOC, DI ##

### 제어의 역전 ###
* JAVA 객체를 new로 생성하여 개발자가 관리하는 것이 아닌 Spring Container에 모두 맡긴다.
### 예제설명 ###
* 예제에서는 ApplicationContext를 직접 생성했지만, 실무에서는 @Autowired를 사용하여 개발한다.


## 2장. AOP ##

### 관점지향 프로그램 ###
![2022-07-07 11 26 49](https://user-images.githubusercontent.com/24876345/177677400-74a91bfb-655f-4a1e-bd8d-c56aabf0bc46.png)

[출처-패스트캠퍼스](https://github.com/steve-developer/fastcampus-springboot-introduction/blob/master/05.%20Spring%20%EC%A1%B0%EA%B8%88%20%EB%8D%94%20%EB%93%A4%EC%97%AC%EB%8B%A4%EB%B3%B4%EA%B8%B0/%EA%B0%95%EC%9D%98%EC%9E%90%EB%A3%8C/03.%20AOP/03.%20AOP.pdf)

### 예제설명 ###
* AOP는 실무에서 Method parameter log를 출력하여 외부에서 어떠한 요청을 했는지, 어떠한 값을 리턴했는지 파악하며 디버깅 할 수 있다.
* 또한 method의 실행시간을 가지고 서버의 부하와 서버의 상태를 log를 출력한다. 
* ParameterAop.java 에서는 request 파라미터와 response 결과를 log로 한다.
* TimerAop.java에서는 method의 실행시간을 출력한다.


## 3장. Validation ##
![2022-07-07 11 15 38](https://user-images.githubusercontent.com/24876345/177676055-44198a35-4571-4a6e-ba7c-73149f49a7b4.png)

[출처-패스트캠퍼스](https://github.com/steve-developer/fastcampus-springboot-introduction/blob/master/06.%20%EC%8A%A4%ED%94%84%EB%A7%81%EC%9D%98%20%EA%B8%B0%EB%8A%A5%EC%9D%84%20%ED%99%9C%EC%9A%A9%ED%95%B4%EB%B3%B4%EC%9E%90/%EA%B0%95%EC%9D%98%EC%9E%90%EB%A3%8C/01.%20Spring%20Boot%20Validation/01.%20Spring%20Boot%20Validation.pdf)

### 예제설명 ###
* BindingResult 파라미터로 @Valid의 결과 값을 확인 할 수 있다.


