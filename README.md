# Spring-Boot-Starter
Starter project comes with<br />
-hibernate<br />
-jpa<br />
-spring data<br />
-spring security<br />
-envers 'audit history' <br />
-cache eh <br />

<br />
### Notable URLS<br />
Swagger UI - http://localhost:9000/swagger-ui.html

<br />



### Auditing<br />
Auditing is configured using annotation add the following annotation to any pojo you would like audited.
Auditing also captures time, IPaddress and username of user
<br />
```
@Audited
@AuditTable(value="__THINGS_AUD")
```


