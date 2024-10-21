/*
*
*/

const CLIENT_ID=""
const REDIRECT_URL = ""
//onload 시점에 이벤트 핸ㄷ들러 추가
window.onload = () => {
    //btn-google 이라는 아이디 속성을 가진 요소의 클릭 이벤트
    document.querySelector("#btn-google").onclick = () => {
        //alert("구글 로그인@@");
        const url = "https://accounts.google.com/o/oauth2/v2/auth"
                     + "?client_id=" + CLIENT_ID
                     + "&redirect_uri=" + REDIRECT_URL
                     + "&response_type=code" 
                     + "&scope=email profile";

                     location.href = url;
    }
}