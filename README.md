Custom Servlet 구현
=== 
# 목표 
웹 서버에 의해서 실행되고, CGI 규칙에 따라 웹 서버와 데이터를 주고 받을 수 있는 CGI 프로그램 중 하나인 Servlet을 만들어 보면서 Servelt을 이해

# Servlet을 학습해야 하는 이유
- Spring을 통해 개발 시 servlet을 모르고 개발이 가능한데, servlet을 학습해야 하는 이유
- Spring MVC Architecture를 살펴보면 WAS를 통한 모든 Web 요청을 수신 및 적절한 요청 처리 Controller로 분배하는  FrontContoller 역할을 Dispatcher Servlet이 수행하고 있기 때문
- 따라서 Sevelt을 직접적으로 사용하지 않고 Spring을 통해 개발은 가능하지만, Spring 역시 Servelt을 통해 구동되는 CGI 프로그램이므로 Servlet에 대한 학습이 필요

# Servlet Interface 구조
- javax.servlet.Servlet : interface
- javax.servlet.GenericServlet : abstract class
- javax.servlet.HttpServlet : abstract class
- UserDefinedServlet : concrete class 

# CGI : Common Gateway Interface
- 웹 서버와 애플리케이션 사이(Servlet Container)에 데이터를 주고 받는 규약
- CGI 규칙에 따라서 만들어진 프로그램을 CGI 프로그램이라고 함
- CGI 프로그램 종류로는 컴파일 방식(C, C++, Java 등)과 인터프리터 방식(PHP, Python 등)이 있음

# Servlet : Server + Applet의 합성어
- 자바에서 웹 어플리케이션을 만드는 기술
- 자바에서 동적인 웹페이지를 구현하기 위한 표준

# Servlet Container
- Container : 라이프싸이클을 관리
- 서블릿의 생성부터 소멸까지의 라이프싸이클을 관리하는 역할
- 서블릿 컨테이너는 웹 서버와 소켓을 만들고 통신하는 과정을 대신 처리하므로, 개발자는 비지니스 로직 개발에만 집중하면 된다.
- 서블릿 객체를 싱글톤으로 관리(하나의 인스턴스만 생성하여 공유하는 방식)
  - Thread safety하지 않음으로 상태를 유지(stateful)하게 설계하면 안됨

# WAS vs Servlet Container
- WAS는 서블릿 컨테이너를 포함하는 개념
- WAS는 매 요청마다 스레드 풀에서 기존 스레드를 사용
- WAS의 주요 튜닝 포인트는 max thread count
- 대표적인 WAS로는 톰캣이 있다.

# Servlet interface
- 서블릿 인터페이스에 있는 메소드들을 서블릿 컨테이너가 호출
- 서블릿의 생명 주기와 관련된 메서드
  - init() : 서블릿 컨테이너가 서블릿 생성 후 초기화 작업을 수행하기 위해 호출하는 메서드
  - service() : 클라이언트 요청이 들어올 때마다 서블릿 컨테이너가 호출하는 메서드
  - destroy() : 서블릿 컨테이너가 종료될 때 자원을 정리하기 위해 호출하는 메서드
- 서블릿과 관련된 기타 메서드
  - getServletConfig() : 서블릿 초기 설정 정보를 담고 있는 개체를 반환하는 메서드(서블릿 이름, 서블릿 초기 변수값)
  - getServletInfo() : 서블릿 작성자, 서블릿 버전, 저작권과 같은 서블릿에 대한 정보를 반환하는 메서드

# 실습
## 실습 단계
- Step1. Servlet interface를 이용한 사칙 연산기 구현
- Step2. GenericServlet을 이용한 사칙 연산기 구현
- Step3. HttpServlet을 이용한 사칙 연산기 구현

### Step1 : Servlet interface를 이용한 사칙 연산기 구현
#### Step1의 구현 내용
- 클라이언트 요청 시 로직을 수행할 servlet interface를 구현한 servelt 생성
- 웹 요청 URL path와 대상 Servlet 매핑을 위한 @WebServlet Annotation 적용
- 클라이언트 요청 시, 서블릿 컨테이너에 의해 init(), service() 메서드가 실행되며, 종료 시 destroy 메서드가 호출되어 자원을 반납

### Step 2 : GenericServlet을 이용한 사칙 연산기 구현
#### Step2의 구현 내용
- 클라이언트 요청 시 로직을 수행할 GenericServlet 추상클래스의 service()를 구현한 servelt 생성
- 웹 요청 URL path와 대상 Servlet 매핑을 위한 @WebServlet Annotation 적용
- 클라이언트 요청 시, service() 메서드에 작성된 비지니스 로직을 수행

### Step 3 : HttpServlet을 이용한 사칙 연산기 구현
#### Step3의 구현 내용
- 클라이언트 요청 시 로직을 수행할 HttpServlet을 상속받은 servlet 생성
- HttpServlet의 doGet() 메서드를 Override하여 비니지스 로직 구현
- 클라이언트 요청 시 Tomcat은 HttpServelt의 service() 메서드를 호출하고 HttpMethod에 따라 개발자가 재 정의 한 doGet(), doPost()등의 메서드가 호출되어 비지니스 로직을 수행