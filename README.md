# Fastcampus
강의내용정리

## 목차 ##

[1.IOC, DI](#1장-IOC-DI)

[2.AOP](#2장-AOP)

[3.Validation](#3장-Validation)

[4.Exception](#4장-Exception)

[5.Swagger](#5장-Swagger)

## 1장. IOC, DI ##

### 제어의 역전 ###
* JAVA 객체를 new로 생성하여 개발자가 관리하는 것이 아닌 Spring Container에 모두 맡긴다.

### 예제설명 ###
* 예제에서는 ApplicationContext를 직접 생성했지만, 실무에서는 @Autowired를 사용하여 개발한다.

### DI 장점 ###
- 의존성으로 부터 격리시켜 코드테스트에 용이하다.
- DI를 통하여 불가능한 상황을 Mock와 같은 기술을 통하여 안정적으로 테스트 가능하다.
- 코드를 확장하거나 변경 할 때 영향을 최소화한다. (추상화)
- 순환참조를 막을 수 있다.
- [DI의간단한예제(spirng없이)](https://github.com/orange601/SpringBoot/tree/main/DI%EC%9D%98%EA%B0%84%EB%8B%A8%ED%95%9C%EC%98%88%EC%A0%9C(spirng%EC%97%86%EC%9D%B4))



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

### Validation 사용 이유 ###
1. 검증해야 할 값이 많은 경우 코드의 길이가 길어 진다.
2. 구현에 따라 달라질 수 있지만, Service Logic과 분리가 필요 하다.
3. 흩어져 있는 경우 어디에서 검증을 하는지 알기 어려우며, 재사용의 한계가 있다.
4. 구현에 따라 달라 질 수 있지만, 검증 Logic이 변경되어야 하는 부분이 발생 할 수 있다.

[출처-패스트캠퍼스](https://github.com/steve-developer/fastcampus-springboot-introduction/blob/master/06.%20%EC%8A%A4%ED%94%84%EB%A7%81%EC%9D%98%20%EA%B8%B0%EB%8A%A5%EC%9D%84%20%ED%99%9C%EC%9A%A9%ED%95%B4%EB%B3%B4%EC%9E%90/%EA%B0%95%EC%9D%98%EC%9E%90%EB%A3%8C/01.%20Spring%20Boot%20Validation/01.%20Spring%20Boot%20Validation.pdf)

### Validation Annotaion ###
@NotNull: Null만 허용하지 않는다. "" 이나 " " 은 허용 한다.   
@NotEmpty: null 과 "" 둘 다 허용하지 않는다. " " 은 허용   
@NotBlank: null 과 "" 과 " " 모두 허용하지 않는다.

### 예제설명 ###
* BindingResult 파라미터로 @Valid의 결과 값을 확인 할 수 있다.
* **@Validated** 는 GetMapping에서 자주 사용되고, **@valid** PostMapping에서  사용된다. 

### 주의사항 ###
* spring boot 2.3 version 이상부터는 spring-boot-starter-web 의존성 내부에 있던 validation이 사라졌다.
* spring boot version이 2.3 이상이라면 validation 의존성을 따로 추가해야 사용할 수 있다.
````java
  implementation 'org.springframework.boot:spring-boot-starter-validation'
````
* parameter가 List로 Binding되면 @Valid는 작동하지 않는다.


## 4장 Exception ##
Web Application의 입장에서 바라 보았을때, 에러가 났을 때 내려줄 수 있는 방법은 많지 않다.
1. 에러페이지
2. 4XX Error or 5XX Error
3. Client가 200 외에 처리를 하지 못할때는 200을 내려주고 별도의 에러 Message 전달

[출처-패스트캠퍼스](https://github.com/steve-developer/fastcampus-springboot-introduction/blob/master/06.%20%EC%8A%A4%ED%94%84%EB%A7%81%EC%9D%98%20%EA%B8%B0%EB%8A%A5%EC%9D%84%20%ED%99%9C%EC%9A%A9%ED%95%B4%EB%B3%B4%EC%9E%90/%EA%B0%95%EC%9D%98%EC%9E%90%EB%A3%8C/04.%20Spring%20Boot%20Exception%20%EC%B2%98%EB%A6%AC/04.%20Spring%20Boot%20Exception%20%EC%B2%98%EB%A6%AC.pdf)


### 예제 설명 ###
1. exception
    - DTO에서 Validation (이전에 Github에 올려놓음 [SpringBoot-Validation](https://github.com/orange601/SpringBoot-Validation))
    - 전역 예외처리
    ````java
    @RestControllerAdvice // 특정 Api가 설정되지 않았기 때문에 Global로 설정된다.
    ````
2. Exception(Step2) ( 1번 Step 연장 )
    - 특정 Controller만 예외처리
    ````java
    @RestControllerAdvice(basePackageClasses = ApiController.class) // 특정 Api설정
    ````
    - @Validated 를 이용한 Parameter Validation 체크
    ````java
    @GetMapping("") 
    public User get(
            @Size(min = 2)
            @RequestParam String name,

            @NotNull
            @Min(1)
            @RequestParam Integer age
            ) {
        User user = new User();
        user.setName(name);
        user.setAge(age);
        int a = 10 + age;

        return user;
    }
    ````
    - Client를 위한 공통 Response 처리
    ````java
    {
        "statusCode": "400 BAD_REQUEST",
        "requestUrl": "/api/user",
        "code": null,
        "message": "",
        "resultCode": "FAIL",
        "errorList": [
            {
                "field": "age",
                "message": "1 이상이어야 합니다",
                "invalidValue": "0"
            },
            {
                "field": "name",
                "message": "크기가 2에서 2147483647 사이여야 합니다",
                "invalidValue": ""
            }
        ]
    }
    ````

### Annotation 별 기능 ###
name | 설명
---- | ----
@ControllAdvice | Global 예외처리 및 특정 package / Controller 예외처리
@ExceptionHandler | 특정 Contorller의 예외처리

## 5장 Swagger ##

### 설명 ###
* dependency 추가시 바로 사용가능
* URL: localhost:8080/swagger-ui/ 
* implementation group: 'io.springfox', name: 'springfox-boot-starter', version: '3.0.0'

### 주의사항 ###
* 스프링부트 2.6 이상으로 업그레이드 시 에러발생
* spring boot 2.6.0부터 요청 경로를 ControllerHandler에 매칭시키기 위한 전략의 기본값이 ant_path_matcher 전략 -> path_pattern_parser 전략으로 변경되었기 때문이다.
* 해결방법1: application.properties에 spring.mvc.pathmatch.matching-strategy=ant-path-matcher 추가
* 해결방법2: spring boot의 버전을 2.5.x로 낮춘다.
