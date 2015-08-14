<#-- @ftlvariable name="error" type="java.util.Optional<String>" -->
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Log in</title>
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
</head>
<body>

<div class="container">
    <div class="row">
        <div class="col-md-4 col-md-offset-4">
            <h1>Hello!</h1>
            <br/>

            <h2>Please, signin <br/> or </h2>
            <a href="/signup" class="btn btn-default btn-lg active" role="button">SignUp</a>
            <br/>
            <br/>
            <a href="/hello" class="btn btn-default btn-lg active" role="button">hello</a>
            <br/>
            <br/>

            <form class="form-horizontal" role="form" action="/login" method="post">
                <div class="form-group">
                    <label for="name">Name</label>
                    <input id="name" type="text" name="name"/>
                </div>
                <div class="form-group"><label for="password">Password</label>
                    <input id="password" type="text" name="password"/>
                </div>
                <button type="submit" class="btn btn-default">Submit</button>
            </form>
        <#if error.isPresent()>
            <div class="alert alert-danger" role="alert">
                <span class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span>
                <span class="sr-only">Error:</span>
                The name or password you have entered is invalid, try again.
            </div>
        </#if>
        </div>
    </div>
</div>
</body>
</html>