/*
*
*/
//onload 시점 => 모든 요소들이 브라우저에 표시된 상태

onload = () =>{
//[인증요청] 버튼 클릭 이벤트 ->알림창 표시 : "인증요청"
//document.getElementRyId("btn-auth")
//$("#btn-auth").click
document.querySelector("#btn-auth").onclick = () => {
   // alert("인증요청");
   $.ajax({
        url:'mail',  //요청주소
        type:'post',  //요청방식
        data:{        //요청 시 전달 데이터
            email:$('#email').val()
        },
        success:(result) =>{
            alert(result);
        },
        error:(err) =>{
            console.log(err);
        }



   })
}
//[확인] 버튼 클릭 이벤트 -> 알림창 표시 : "확인"
$("#btn-check").click(()=> {
    alert("확인");
})


}