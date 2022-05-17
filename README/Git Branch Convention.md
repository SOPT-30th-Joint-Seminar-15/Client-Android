## **Git Branch Convention**

1. branch 이름은 snake_case 표기법 이용
2. "feature/이슈번호-작업위치-작업단위"로 형식 통일
 ex)feature/1-main-layout
 ex)feature/2-read-inflate
 ex)feature/3-create-remote

default branch는 develop
-> develop에서 본인 브랜치 생성
-> add-commit-pull-push-merge
-> merge 후 다시 develop에서 새로운 브랜치 생성 (새로운 기능 구현할 때)
-> 반복
-> 작업시작할때 pull받고 시작하는거 잊지않기





## **Git Commit Message Convention**

### **Base Structure**

```
[TYPE] subject

body
```

**예시**

=> 하나의 이슈 처리하고 커밋 할 때

```
[Chore] 기초세팅중

1. 아이콘에셋추가
2. 폰트추가
```

=> 여러개의 이슈를 처리하고 커밋 할 때

```
[REFACTOR] ReFactor Code From OtherPage

- OtherPage : 답변하지 않은 답변도 볼 수 있도록 수정
- OtherPage : 답변하지 않은 답변도 스크랩할 수 있도록 수정
- modified file : OtherPageAdapter, OtherPageActivity, OtherPageViewModel, item_other_page
```

### **Issue Number**

- 이슈 단위 커밋으로 기능 개발을 관리합니다

### **TYPE**

- FEAT: 새로운 기능 개발(kotlin 작업)
- FIX: 버그 수정
- CHORE: Gradle이나 설정 세팅할 때

### **Subject**

- 제목은 50글자 내외로 작성하는 것을 권장한다.
- 첫 글자가 영어인 경우 대문자 표기하라

### **Body**

- Title에 Commit의 충분한 정보가 포함되지 않은 경우 그 내용을 표기한다.
- 각 행은 100글자가 넘지 않도록 주의한다.
- 
### **Footer**

- 참조정보가 있는경우 그 내용을 표기함



- Tag (1.1 참고), 필수항목
- Scope
    
    어떤 기능에서 작업인지 commit 이 해당되는 위치
    
    이는 상황에 따라 기능명, 이슈번호등으로 부여한다
