## **Android Naming Convention**

### 1. Kotlin Language Rules <a href="https://kotlinlang.org/docs/coding-conventions.html"> link </a>

- 기본적으로 Kotlin Docs 에서 제공하는 Coding Convention을 따른다.
- IDE에 적용하고 이를 지킬 수 있도록 코드 자동정렬을 자주 이용한다.



### 2. Android Resource Naming Rules

- 기본 형식은 위 규칙을 따른다.



### 예외) IDS 규칙

- IDS 의 경우 Binding 을 사용할경우 where은 생략이 가능하다.
- IDS 의 경우 레이아웃 및 뷰의 이름을 CamelCase 앞글자로 요약 가능하다.
      
    ex TextView IDS ) `tv_login_label`



### 추가 규칙) Color

- 컬러 name의 경우는 디자이너가 명시한 이름과 동일하게 맞추되, 필요한 경우 Camel Case 를 사용한다.  
 → 개발에 있어 가장 명확한 컬러를 사용하기 위함, 디자이너는 blue300 이라 하였으나 개발에서 이를 skyblue와 같은 명명을 사용하여 생기는 혼란을 방지하기 위함.
 


