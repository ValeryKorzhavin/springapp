# Spring Application

### API Endpoints
- GET /api/users&emsp;&emsp;&emsp;&emsp;_Retrieve all users_
- POST /api/users&emsp;&emsp;&emsp;&nbsp;_Create new user_
- GET /api/users/id&emsp;&emsp;&nbsp;&nbsp;_Get user by id_
- PUT /api/users&emsp;&emsp;&emsp;&nbsp;&nbsp;&nbsp;_Update user_
- DELETE /api/users/id&emsp;_Delete user by id_ 



- GET /api/roles&emsp;&emsp;&emsp;&emsp;_Retrieve all roles_
- POST /api/roles&emsp;&emsp;&emsp;&nbsp;_Create new role_
- GET /api/roles/id&emsp;&emsp;&nbsp;&nbsp;_Get role by id_
- PUT /api/roles&emsp;&emsp;&emsp;&nbsp;&nbsp;&nbsp;_Update role_
- DELETE /api/roles/id&emsp;_Delete role by id_ 

### Migrations
```shell script
$ make apply-migration
```