# backendAssignment

1) Prerequisites:
Java 8
Maven
MySql

2) SQL Query to setup phpMyAdminMysql database "backenddeveloperassignment"

REVINFO
CREATE TABLE `revinfo` (
  `rev` int(11) NOT NULL,
  `revtstmp` bigint(20) DEFAULT NULL
) 

CREATE TABLE `notes_aud` (
  `id` int(11) NOT NULL,
  `rev` int(11) NOT NULL,
  `revtype` tinyint(4) DEFAULT NULL,
  `content` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `last_modified_date` datetime DEFAULT NULL,
  `title` varchar(255) COLLATE utf8_bin DEFAULT NULL
) 

CREATE TABLE `notes` (
  `id` int(11) NOT NULL,
  `content` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `create_date` datetime NOT NULL,
  `last_modified_date` datetime NOT NULL,
  `title` varchar(255) COLLATE utf8_bin DEFAULT NULL
)

3) Run the project. Clone or download https://github.com/lotars3/backendAssignment.git

4) Curl commands

a) GET /rest/all 

curl -X GET   http://localhost:8080/rest/all

Response:
{"id":4,"title":"Najnowsza ","content":"notatka","createDate":"2019-09-09T17:20:14.000+0000","lastModifiedDate":"2019-09-09T17:20:14.000+0000"}

b) GET /rest/note/{id}

curl -X GET http://localhost:8080/rest/note/4 

Response:
{"id":4,"title":"Najnowsza ","content":"notatka","createDate":"2019-09-09T17:20:14.000+0000","lastModifiedDate":"2019-09-09T17:20:14.000+0000"}

c) POST /rest/addNote/{id}

curl -X POST  http://localhost:8080/rest/addNote/12

Response: Post successfully

d) DELETE /rest/remove/{id}

curl -X DELETE http://localhost:8080/rest/remove/5

Respone: Deleted successfully

e) UPDATE /rest/updateNote/{id}

curl -X PUT http://localhost:8080/rest/updateNote/10

Respone: Updated successfully

f) GET history/{id}

curl -X GET http://localhost:8080/history/5

Response: 
{"noteDto":{"id":4,"content":"notatka","title":"Najnowsza "},"revision":7,"type":"add"}

