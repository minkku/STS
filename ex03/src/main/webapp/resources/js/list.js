$(document).ready(function() {
	var result = '<c:out value="${result}"/>';
	
	checkModal(result);
	
	history.replaceState({}, null, null);
	
	function checkModal(result) {
		if (result === '' || histroy.state) {
			return;
		}
		
		if (parseInt(result) > 0 ) {
			$(".modal-body").html("게시글 " + parseInt(result) + " 번이 등록되었습니다.");
			}
			
			$("#myModal").modal("show");
		}
		
			//버튼 클릭시 /board/register 로 이동
			$("#regBtn").on("click", function() {
				self.location = "/board/register";
		});
});

$(document).ready(function() {
		var formObj = $("form");
		
		$('button').on("click", function(e) {
		
		e.preventDefault();
		
		var operation = $(this).data("oper");
		
		console.log(operation);
		
		if(operation === 'remove') {
			formObj.attr("action", "/board/remove");
		} else if(operation === 'list') {
			//move to list
			formObj.attr("action", "/board/list").attr("method", "get");
			formObj.empty();
		}
			formObj.submit();
	});
});