# auction-shortened-url

-> createUser

POST localhost:8080/user/signup

request: {
    "username": "username",
    "password": "password"
}

------------------------------------------------------------------------------------------------------------------------

-> createShortUrl

POST localhost:8080/user/1/url/create

request: {
    "longUrl": "https://www.tapu.com/l/uygulamaya-ozel-kampanyali-tapular"
}

------------------------------------------------------------------------------------------------------------------------

-> getLongUrlByShortUrl

GET localhost:8080/user/url?shortUrl=http://localhost:8080/6133397771

------------------------------------------------------------------------------------------------------------------------

-> getAllUrl

GET localhost:8080/user/1/url/list

------------------------------------------------------------------------------------------------------------------------

-> getUrl

GET localhost:8080/user/1/url/detail/1

------------------------------------------------------------------------------------------------------------------------

-> deleteUrl

DELETE localhost:8080/user/1/url/detail/1