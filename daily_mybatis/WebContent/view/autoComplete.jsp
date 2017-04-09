<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>autocomplete</title>
<script type="text/javascript" src="../source/css/jquery-ui.css"></script>
<script type="text/javascript" src="../source/css/jquery-ui.theme.css"></script>
<script type="text/javascript" src="../source/css/jquery-ui.structure.css"></script>
<script type="text/javascript" src="../source/js/jquery.js"></script>
<script type="text/javascript" src="../source/js/jquery-ui.js"></script>
<script type="text/javascript">
$(function(){
	localautocomplete();
	remoteAutocomplete2();
});
function localautocomplete()
{
	var availableTags = [
	                     "ActionScript",
	                     "AppleScript",
	                     "Asp",
	                     "BASIC",
	                     "C",
	                     "C++",
	                     "Clojure",
	                     "COBOL",
	                     "ColdFusion",
	                     "Erlang",
	                     "Fortran",
	                     "Groovy",
	                     "Haskell",
	                     "Java",
	                     "JavaScript",
	                     "Lisp",
	                     "Perl",
	                     "PHP",
	                     "Python",
	                     "Ruby",
	                     "Scala",
	                     "Scheme"
	                   ];
	$("#localtype").autocomplete({
		source: availableTags
	});
}
function remoteAutocomplete(){
	$("#remotetype").autocomplete({
		source: function( request, response ) {
	        $.ajax({
	          url: "/daily_mybatis/servlet.test",
	          dataType: "json",
	          type:"post",
	          data: {
	            q: request.term
	          },
	          success: function( data ) {
	        	alert(data[1].company_name);
	            response( data );
	          }
	        });
	      },
	      parse:function(data) {
	    	  alert(data[1].company_name+"---");
	      },
	      minLength: 1,
	      select: function( event, ui ) {
	    	  alert(ui.company_name);
	      },
	      open: function() {
	        $( this ).removeClass( "ui-corner-all" ).addClass( "ui-corner-top" );
	      },
	      close: function() {
	        $( this ).removeClass( "ui-corner-top" ).addClass( "ui-corner-all" );
	      }
	});
	
}
	function remoteAutocomplete2(){
		$("#remotetype").autocomplete({
		  source: function(request, response) {
		        $.ajax({
		            url: "/daily_mybatis/servlet.test",
		            dataType: "json",
		            type:"post",
		            data: {
		            },
		            success: function(data) {
		                response($.map(data, function(item) {
		                    return {
		                        label: item.company_name,
		                        value: item.company_name+"--"+item.id
		                    }
		                }));
		            }
		        });
		    },
		    minLength: 1,
		    select: function( event, ui ) {
		    	  alert(ui.item.label);
		    	  $("#used").val(111);
		      },
		   create:function(event,ui){
			   alert(ui.item);
		   }
	});
	}

</script>

</head>
<body>
<div class="ui-widget">
<input type="text" id="localtype"  />
</div>
<p/>
<p/>

<input type="text" id="remotetype"  />
<input type="text" id="used" />

</body>
</html>