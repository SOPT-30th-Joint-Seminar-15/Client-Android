## **Git Branch Convention**

1. branch 이름은 snake_case 표기법 이용
2. "feature/이슈번호-작업위치-작업단위"로 형식 통일  
 ex)feature/1-main-layout  
 ex)feature/2-read-inflate  
 ex)feature/3-create-remote  
3. default branch는 develop
   
-> develop에서 본인 브랜치 생성  
-> add-commit-pull-push-merge  
-> merge 후 다시 develop에서 새로운 브랜치 생성 (새로운 기능 구현할 때)  
-> 반복  
-> 작업시작할때 pull받고 시작하는거 잊지않기





## **Git Commit Message Convention**

### **Issue Number**

- 이슈 단위 커밋으로 기능 개발을 관리합니다  
ex) [Layout, Inflate, Remote] 문의뷰 구현

### **Base Structure**

```
[TYPE] subject

body
```

**예시**

```
[Chore] 기초세팅중

1. 아이콘에셋추가
2. 폰트추가
```
### **TYPE**

- FEAT: 새로운 기능 개발(kotlin 작업)
- FIX: 버그 수정
- CHORE: Gradle이나 설정 세팅할 때

### **Subject**

- 제목은 50글자 내외로 작성하는 것을 권장
- 첫 글자가 영어인 경우 대문자 표기

### **Body**

- Title에 Commit의 충분한 정보가 포함되지 않은 경우 그 내용을 표기
- 각 행은 100글자가 넘지 않도록 주의
- 
### **Footer**

- 참조정보가 있는경우 그 내용을 표기
