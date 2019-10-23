# base-json模块
> json数据交互注册登录

## 【未登录】获取个人信息

`curl -X GET http://localhost:8080/user`

### 结果

`{"code":"401","message":"authenticate fail"}`

## 【未登录】注册账号（可选操作）

```
curl -X POST \
  http://localhost:8080/register \
  -H 'Content-Type: application/json' \
  -d '{
	"username":"anoyi",
	"password":"anoyi",
	"nickname":"Anoyi"
}'
```
### 结果

`{"code": "0","message": "success","result": "注册成功"}`

## 登录账号

```
curl -v -X POST \
  http://localhost:8080/login \
  -H 'Content-Type: application/json' \
  -d '{
        "username":"anoyi",
        "password":"anoyi"
}'
```

### 结果

```
*   Trying 127.0.0.1...
* TCP_NODELAY set
* Connected to localhost (127.0.0.1) port 8080 (#0)
> POST /login HTTP/1.1
> Host: localhost:8080
> User-Agent: curl/7.54.0
> Accept: */*
> Content-Type: application/json
> Content-Length: 44
>
* upload completely sent off: 44 out of 44 bytes
< HTTP/1.1 200
< X-Content-Type-Options: nosniff
< X-XSS-Protection: 1; mode=block
< Cache-Control: no-cache, no-store, max-age=0, must-revalidate
< Pragma: no-cache
< Expires: 0
< X-Frame-Options: DENY
< Set-Cookie: JSESSIONID=37A9E0E7143FC52E77639069A6F8C3B3; Path=/; HttpOnly
< Content-Type: application/json;charset=UTF-8
< Content-Length: 56
< Date: Tue, 02 Apr 2019 07:38:34 GMT
<
* Connection #0 to host localhost left intact
{"code":"0","message":"success","result":"登录成功"}
登录成功，并返回 SESSION 信息：Set-Cookie: JSESSIONID=37A9E0E7143FC52E77639069A6F8C3B3; Path=/; HttpOnly
```

## 【已登录】获取个人信息

`curl -X GET http://localhost:8080/user -H 'Cookie: JSESSIONID=19CE7D4D28E32073226AEAC0529B3523'`

### 结果

`{"code":"0","message":"success","result":"anoyi"}`

## 【已登录】获取 ADMIN 信息

`curl -X GET http://localhost:8080/admin -H 'Cookie: JSESSIONID=19CE7D4D28E32073226AEAC0529B3523'`

### 结果

`{"code":"2","message":"forbidden"}`

## 【已登录】退出登录

`curl -X GET http://localhost:8080/logout`

### 结果

`{"code":"0","message":"success","result":"退出成功"}`