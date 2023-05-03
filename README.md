# S914_BackEnd_TRIP_KimSeungGyu_YooSeungAh



## F01 지역별 관광지 정보 수집

![1](https://user-images.githubusercontent.com/68517303/235854637-dd585984-4492-4ad8-9f6c-bb076e8b06b9.png)
/trip
#### 1. 메인 페이지(/trip)에서 관광 정보 8개를 미리 볼 수 있다.
#### 2. '관광지 찾아보기' 버튼으로 관광지를 찾아볼 수 있는 페이지(/trip/searchAttraction)로 이동
<br>

![2](https://user-images.githubusercontent.com/68517303/235854649-61ceee92-d292-42d7-82af-e6161f596083.png)
/trip/searchAttraction
#### 3. sido table에서 sido_name을 가져와 지역을 선택할 수 있게 하고, 선택 지역에 해당하는 관광지 정보 검색 페이지(/trip/attractionList)로 이동
<br>

![3](https://user-images.githubusercontent.com/68517303/235854662-734997d9-9ad7-4e2c-b63e-3c0c207e5f91.png)
/trip/attractionList
#### 4. (3)번에서 선택한 지역에 해당하는 관광지 정보 리스트
#### 5. '상세 정보' 클릭 시, 해당 관광지에 대한 위치, 설명, 편의 시설 등을 볼 수 있는 페이지(/trip/detail?content_id=)로 이동
<br>

## F02 ~ F03 숙박, 음식점, 문화시설, 쇼핑 등 조회

![4](https://user-images.githubusercontent.com/68517303/235854671-c4778d5f-c8d1-46b4-a965-a57b837e5e2d.png)
/trip/detail?content_id=
#### 6. content_id에 해당하는 관광지 정보에 대해 위치를 kakao map으로 확인할 수 있고 관광지에 대한 설명을 볼 수 있는 페이지
<br>

![5](https://user-images.githubusercontent.com/68517303/235854695-dfab0569-d35e-4b04-909e-9bae1835ce76.png)
#### 7. 보고 싶은 주변 시설을 선택한 후 '찾아보기' 버튼을 누르면 맵에 해당 시설이 마크 찍힌다.
<br>

## F07 회원 관리 (회원가입, 수정, 조회, 탈퇴)

![6](https://user-images.githubusercontent.com/68517303/235854703-7709406a-eef6-4cbb-83ac-a0406c0c71db.png)
/trip/signupForm
#### 8. 회원 정보를 입력 후 회원가입 할 수 있는 페이지
<br>

![7](https://user-images.githubusercontent.com/68517303/235854716-bc73c062-d86b-497c-ad76-f70f7881d248.png)
#### 9. 회원가입 후 DB에 저장된 모습 확인
<br>

![8](https://user-images.githubusercontent.com/68517303/235854725-56da4a19-f402-420a-abfd-568f6523b094.png)
/trip/userInfo
#### 10. 회원정보 조회 페이지. '회원정보 수정'을 누르면 회원정보 수정 페이지(/trip/modifyForm)로 넘어간다. '회원 탈퇴'를 누르면 회원 정보가 삭제되며 로그아웃된 메인 페이지(/trip)로 넘어간다. '로그아웃'을 누르면 session에 저장된 user 정보가 지워지며 메인 페이지(/trip)로 이동.
<br>

![9](https://user-images.githubusercontent.com/68517303/235854734-d11b6a7b-9547-4788-a827-fe94acb96c49.png)
/trip/modifyForm
#### 11. 회원 정보 수정 페이지. 수정을 원하는 아이디 입력 후 '이름 수정' 버튼을 누르면 수정 완료
<br>

![10](https://user-images.githubusercontent.com/68517303/235854745-cb73f2b8-4c5e-4023-b6f8-0bc5851d2f4c.png)
#### 12. 회원 정보 수정 완료된 모습
<br>

## F07 로그인 관리 (로그인 / 로그아웃)

![11](https://user-images.githubusercontent.com/68517303/235854762-0e1bf0a5-6e92-4d31-8fa2-7e485ba23a09.png)
/trip
#### 13. 메인 페이지 상단에 '로그인' 버튼을 누르면 로그인 페이지(/trip/loginForm)로 이동
<br>

![12](https://user-images.githubusercontent.com/68517303/235854776-c509f021-b46c-4bde-9987-fec4a3a7e96f.png)
/trip/loginForm
#### 14. 올바른 아이디와 비밀번호 입력 시, 로그인 되어 session에 user 정보 저장 후 메인 페이지(/trip)로 이동
<br>

![13](https://user-images.githubusercontent.com/68517303/235854787-a1407beb-229c-4e34-b4c6-72666d86c68e.png)
/trip
#### 15. 로그인 완료 시, 상단의 '로그인' 버튼이 'user id + 환영합니다!'로 변경
<br>

![14](https://user-images.githubusercontent.com/68517303/235854791-b5966e7e-a4e3-4c7d-bf47-dad0a3ec7f31.png)
#### 16. 로그아웃이나 회원 탈퇴 시, 다시 상단이 '로그인'으로 바뀐다.
<br>
