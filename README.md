# S914_BackEnd_TRIP_KimSeungGyu_YooSeungAh



## F01 지역별 관광지 정보 수집

![1](/uploads/0a32888f46f51e7ea985390e1ea1cbfe/1.png)
/trip
#### 1. 메인 페이지(/trip)에서 관광 정보 8개를 미리 볼 수 있다.
#### 2. '관광지 찾아보기' 버튼으로 관광지를 찾아볼 수 있는 페이지(/trip/searchAttraction)로 이동

![2](/uploads/aecf1a6020bfc5111b6ee8c4ba0415b9/2.png)
/trip/searchAttraction
#### 3. sido table에서 sido_name을 가져와 지역을 선택할 수 있게 하고, 선택 지역에 해당하는 관광지 정보 검색 페이지(/trip/attractionList)로 이동

![3](/uploads/cafa61f8210e270cd8d22ac9213827ed/3.png)
/trip/attractionList
#### 4. (3)번에서 선택한 지역에 해당하는 관광지 정보 리스트
#### 5. '상세 정보' 클릭 시, 해당 관광지에 대한 위치, 설명, 편의 시설 등을 볼 수 있는 페이지(/trip/detail?content_id=)로 이동 

## F02 ~ F03 숙박, 음식점, 문화시설, 쇼핑 등 조회

![4](/uploads/dc469ef8191af40dfa2e655696f15166/4.png)
/trip/detail?content_id=
#### 6. content_id에 해당하는 관광지 정보에 대해 위치를 kakao map으로 확인할 수 있고 관광지에 대한 설명을 볼 수 있는 페이지

![5](/uploads/92942ddeffb55c378b2ff8205ea9d34a/5.png)
#### 7. 보고 싶은 주변 시설을 선택한 후 '찾아보기' 버튼을 누르면 맵에 해당 시설이 마크 찍힌다.

## F07 회원 관리 (회원가입, 수정, 조회, 탈퇴)

![2-1](/uploads/e9aef76ac5bef6a9af76cc8c5b8cbf07/2-1.png)
/trip/signupForm
#### 8. 회원 정보를 입력 후 회원가입 할 수 있는 페이지

![2-2](/uploads/65633d0fd88a9754430ae08f7fc1acfb/2-2.png)
#### 9. 회원가입 후 DB에 저장된 모습 확인

![4](/uploads/afea2b353731ba2403ba14d749eed4eb/4.png)
/trip/userInfo
#### 10. 회원정보 조회 페이지. '회원정보 수정'을 누르면 회원정보 수정 페이지(/trip/modifyForm)로 넘어간다. '회원 탈퇴'를 누르면 회원 정보가 삭제되며 로그아웃된 메인 페이지(/trip)로 넘어간다. '로그아웃'을 누르면 session에 저장된 user 정보가 지워지며 메인 페이지(/trip)로 이동.

![5](/uploads/8e919cf70c72c0e21e705b4af2d42bfa/5.png)
/trip/modifyForm
#### 11. 회원 정보 수정 페이지. 수정을 원하는 아이디 입력 후 '이름 수정' 버튼을 누르면 수정 완료

![6](/uploads/3f58888ebb36423ad539ef0b8da2ea41/6.png)
#### 12. 회원 정보 수정 완료된 모습

## F07 로그인 관리 (로그인 / 로그아웃)

![1](/uploads/15f4cf247bb23462b6d65c2a406e4aee/1.png)
/trip
#### 13. 메인 페이지 상단에 '로그인' 버튼을 누르면 로그인 페이지(/trip/loginForm)로 이동

![2-3](/uploads/23d477b84a508599e595e1e20f14e1ae/2-3.png)
/trip/loginForm
#### 14. 올바른 아이디와 비밀번호 입력 시, 로그인 되어 session에 user 정보 저장 후 메인 페이지(/trip)로 이동

![3](/uploads/98c10d132ffbe8b2ca7f6eee6aeb10ef/3.png)
/trip
#### 15. 로그인 완료 시, 상단의 '로그인' 버튼이 'user id + 환영합니다!'로 변경

![7](/uploads/270a207c43f3c29b138cce595739267e/7.png)
#### 16. 로그아웃이나 회원 탈퇴 시, 다시 상단이 '로그인'으로 바뀐다.
