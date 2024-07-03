1. PostgreSQL Connection

![image](https://github.com/LukaszKrolicki/DAO/assets/54467678/a844e11c-27cb-454b-a8a0-1c93b945cb7d)

DockerCompose.yml

![image](https://github.com/LukaszKrolicki/DAO/assets/54467678/f5b042b5-d288-4b82-8477-ca144b4259e0)

Properties

![image](https://github.com/LukaszKrolicki/DAO/assets/54467678/97800b19-bca0-479d-a6cf-3192e638f9ac)

![image](https://github.com/LukaszKrolicki/DAO/assets/54467678/55b3a5a0-74ef-46f8-8e99-908e9cc1c587)

![image](https://github.com/LukaszKrolicki/DAO/assets/54467678/451a972f-d4c7-4e34-831b-478c4ec054f6)

2.Postgre Createing schema, populating schema

![image](https://github.com/LukaszKrolicki/DAO/assets/54467678/aafaf606-29c1-409f-8b4a-cbca008379ce)

![image](https://github.com/LukaszKrolicki/DAO/assets/54467678/99218233-0e99-4d33-83b6-d236f8ea3d97)

Change in properties:

![image](https://github.com/LukaszKrolicki/DAO/assets/54467678/65dbcd25-68ec-4fb7-9f89-bcc4cacbcf1c)

![image](https://github.com/LukaszKrolicki/DAO/assets/54467678/b1916c21-0845-47f3-8b08-afb1cfb55a02)

3. DAO
   
DAO - Data access object

![image](https://github.com/LukaszKrolicki/DAO/assets/54467678/fb48e6ce-c40e-4a2c-b71b-bf58969382d6)

![image](https://github.com/LukaszKrolicki/DAO/assets/54467678/16258e37-c0c9-4f46-ac4c-4e8c551923cd)

Each of servecies would have to know about structure of database, how to query etc.

Instead we can do:

![image](https://github.com/LukaszKrolicki/DAO/assets/54467678/ffb9bf76-f64e-4fec-981f-47717b5d720c)

Where BookDAO and AuthorDAO handle all of the mappings from/to database

4.Setting up DAO, Setting up H2 for tests

![image](https://github.com/LukaszKrolicki/DAO/assets/54467678/681bb5ff-b7d3-4f94-8979-28b426ea5520)

@Data - getters, setters, equals

@AllArgs - full constructor

@NoArgs - default constructor

@Builder - creates a builder

H2 for Tests

![image](https://github.com/LukaszKrolicki/DAO/assets/54467678/2246037b-1ff0-44ad-a148-f1c33f61f03e)

![image](https://github.com/LukaszKrolicki/DAO/assets/54467678/1b0148d8-65ce-468d-9533-dba1e050b939)


5. MockTest -Unit Tests

![image](https://github.com/LukaszKrolicki/DAO/assets/54467678/78fec483-73d9-429d-abb6-9547712dae38)

6. Find one, Raw Mapper

RawMapper is used to change result to object

![image](https://github.com/LukaszKrolicki/DAO/assets/54467678/9c7197d8-4fa4-4e88-a087-429c8a2ca515)

![image](https://github.com/LukaszKrolicki/DAO/assets/54467678/d99d4604-1605-47c9-852e-220c4f70ec46)

7. Creating Integration tests with H2

![image](https://github.com/LukaszKrolicki/DAO/assets/54467678/cd561968-bf95-44f1-ac51-1c0e0f82176d)

![image](https://github.com/LukaszKrolicki/DAO/assets/54467678/fd52c32f-d563-424c-8a94-a4a07e93f913)

@Dirties – cleans up database after each test

8. CRUD tests

Unit Tests:

![image](https://github.com/LukaszKrolicki/DAO/assets/54467678/1eba9182-4a1d-48b6-bae3-708f2d1fb543)

![image](https://github.com/LukaszKrolicki/DAO/assets/54467678/4f35a576-f895-4344-8c1d-03d3c747ce2c)

Integration Tests:

![image](https://github.com/LukaszKrolicki/DAO/assets/54467678/17b365ae-0bc9-4fdb-b205-772e2f7074d5)

![image](https://github.com/LukaszKrolicki/DAO/assets/54467678/8a5943c1-f17a-4d92-acb6-416517853311)

![image](https://github.com/LukaszKrolicki/DAO/assets/54467678/62b3a993-23bd-4dca-80e2-070c46e53cde)

![image](https://github.com/LukaszKrolicki/DAO/assets/54467678/db4e2e8f-3a70-48dc-aa70-de14f827a50a)













