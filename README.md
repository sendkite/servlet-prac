### Spring MVC 정리


## Web Server, WAS 나누는 이유

- Web Server
    - 정적 리소스 제공, 기타 부가기능
    - HTML, CSS, JS, Image, Video
    - 예) Nginx, Apache

- Web Application Server
    - Web Server + 어플리케이션 로직 수행
    - 동적 HTML, HTTP API
    - 서블릿, JSP, 스프링 MVC
    - 예) 톰캣, Jetty, Undertow


## Servlet / 서블릿을 지원하는 WAS는 아래의 서버의 업무 중 "비즈니스 로직"을 제외하고 알아서 처리.

```
- 서버 TCP/IP 대기, 소켓 연결
- HTTP 요청 메시지 파싱해서 읽기
- POST 방식, /save url 인식
- HTTP Body 내용 파싱
- 저장 프로세스 실행

- 비즈니스 로직 실행
    - 데이터베이스에 저장 요청

- HTTP 응답 메세지 생성
- TCP/IP에 응딥 전달, 소켓 종료
```

## 동작 순서

1. 브라우저 요청 with url
2. WAS에서 HTTP메시지 기반으로 request, response 객체 생성
3. WAS는 서블릿 컨테이너에 Servlet 객체 생성하고 request, response 호출
4. 응답 값 반환
5. WAS는 이미 생성된 response로 HTTP 응답 만들어서 브라우저에 전달

* 톰캣처럼 서블릿을 지원하는 WAS를 서블릿 컨테이너라고 함
* 서블릿 객체는 싱글톤으로 관리
    * 최초 로딩 시점에 서블릿 객체를 미리 만들어두고 재활용
    * JSP도 서블릿으로 변환 되어서 사용
    * 서블릿을 호출은 멀티 쓰레드로 요청할 수 있다. (톰캣이 쓰레드 풀 생성 - 기본 200개)



