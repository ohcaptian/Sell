<!doctype html>
<html lang="en">
<#include "../common/header.ftl">
<body>
<form class="form-signin" action="seller/login">
    <img class="mb-4" src=" " alt="" width="72" height="72">
    <h1 class="h3 mb-3 font-weight-normal">Please sign in</h1>
    <label class="sr-only">Username</label>
    <input type="text" class="form-control" id="name" name="name">
    <label class="sr-only">Password</label>
    <input type="password" class="form-control" id="password" name="password">
    <div class="checkbox mb-3">
        <label>
            <input type="checkbox" value="remember-me"> Remember me
        </label>
    </div>
    <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
    <p text="${msg?if_exists}"></p>
    <p class="mt-5 mb-3 text-muted">© 2017-2018</p>
    <a class="btn btn-sm">中文</a>
    <a class="btn btn-sm">English</a>
</form>
</body>
</html>