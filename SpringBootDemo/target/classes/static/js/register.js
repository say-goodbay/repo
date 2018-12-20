$(document).ready(
	function validateForm()
	{
		alert(1111)
		alert($("#user_password"));
	  if ($("#user_password") != $("#user_confirm_password"))
	  {
	    alert("两次密码不同");
	    return false;
	  }
	}
);