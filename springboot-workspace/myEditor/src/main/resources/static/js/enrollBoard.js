$(document).ready(function(){
    // 1) 텍스트 에디터 표시
    $('#summernote').summernote({
      placeholder: 'Hello stand alone ui',
      tabsize: 2,
      height: 120,
      toolbar: [
        ['style', ['style']],
        ['font', ['bold', 'underline', 'clear']],
        ['color', ['color']],
        ['para', ['ul', 'ol', 'paragraph']],
        ['table', ['table']],
        ['insert', ['picture']],
        ['view', ['fullscreen', 'codeview', 'help']]
      ]
    });

    $('#btn-reset').click(function () {
      // summernote가 실행되기 전으로 돌아감
      $('#summernote').summernote('reset');
      $('.form-control').val('');
    });

    $('#btn-write').click(()=>{
      
      const title = $('.form-control').val();  // 제목 가져오기
      const content = $('#summernote').summernote('code');  // Summernote의 HTML 콘텐츠 가져오기

      $.ajax({
        url: "/board",
        type: "POST",
        contentType: "application/json",
        data: JSON.stringify({
            title: title,
            content: content
        }),
        success: function(result) {
          if(result ==='ok'){
            alert("게시글 작성 성공");
          } else {
            alert("게시글 작성 실패");
          }
        },
        error: function(error) {
            // 요청이 실패하면 실행되는 코드
            console.error("오류 발생:", error);
            alert("데이터 전송에 실패했습니다.");
        }
    });
    })
const formData = new FormData();
for(let file of imgList){
  
}
$.ajax({
  url:'upload',
  type:'post',
  data:formData,
  processData: false,
  contentType:false,
  success: (result)=>{
    console.log(result);
  }
})
})