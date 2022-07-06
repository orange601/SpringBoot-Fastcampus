# Fastcampus
강의내용정리

## 목차 ##

[1.IOC, DI](#1장-IOC-DI)

[2.AOP](#2장-AOP)

## 1장. IOC, DI ##

### 제어의 역전 ###
* JAVA 객체를 new로 생성하여 개발자가 관리하는 것이 아닌 Spring Container에 모두 맡긴다.
### 예제설명 ###
* 예제에서는 ApplicationContext를 직접 생성했지만, 실무에서는 @Autowired를 사용하여 개발한다.


## 2장. AOP ##

### 관점지향 프로그램 ###
![2022-07-06 14 28 29](https://user-images.githubusercontent.com/24876345/177475501-ea53b915-8d04-400b-bc90-7fc191073808.png)
[출처](https://github.com/steve-developer/fastcampus-springboot-introduction/blob/master/05.%20Spring%20%EC%A1%B0%EA%B8%88%20%EB%8D%94%20%EB%93%A4%EC%97%AC%EB%8B%A4%EB%B3%B4%EA%B8%B0/%EA%B0%95%EC%9D%98%EC%9E%90%EB%A3%8C/03.%20AOP/03.%20AOP.pdf)

### 예제설명 ###
* ParameterAop.java 에서는 request 파라미터와 response 결과를 print한다.
* TimerAop.java에서는 
