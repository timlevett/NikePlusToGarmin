
<%@ include file="/WEB-INF/views/taglibs.jsp"%>
<z:layout pageTitle="Token Encryption">

    <div class="container">
        <form class="form-signin" name="login" action="${pageContext.request.contextPath}/apps/Login" method="post" autocomplete="off">
        	<h2 class="form-signin-heading">Please sign in</h2>
        	<input type="text" name="name" id="name" class="form-control" placeholder="Name" />
        	<input type="text" name="token" id="token" class="form-control" placeholder="Nike+ Token" />
			<button class="btn btn-lg btn-primary btn-block" type="submit">Login</button>
			<div class="alert alert-info">
				You have to login via the nike+ developer site and go to the console to get the token. (API interface is a later feature I'm planning on doing)
				You can find that <a href="https://developer.nike.com/console" target='_blank'>here</a>.  Click that and login. 
			</div>
    	</form>
    </div>
    

</z:layout>