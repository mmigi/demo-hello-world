<#-- @ftlvariable name="form" type="com.company.model.UserCreateForm" -->
<#import "/spring.ftl" as spring>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Home page</title>
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-md-4 col-md-offset-4">
            <br/>

            <h2>Please, signUp <br/></h2>

            <form class="form-horizontal" name="form" role="form" action="/signup" method="post" enctype="multipart/form-data">
                <div class="form-group">
                    <label for="name">Name</label>
                    <input id="name" type="text" name="name"/>
                </div>
                <div class="form-group"><label for="password">Password</label>
                    <input id="password" type="text" name="password"/>
                </div>
                <button type="submit" class="btn btn-default">Submit</button>
            </form>
        </div>
    </div>
</div>
<@spring.bind "form" />
<#if spring.status.error>
<div class="alert alert-danger" role="alert">
    <ul>
        <#list spring.status.errorMessages as error>
            <li>${error}</li>
        </#list>
    </ul>
</div>
</#if>
</body>
</html>