## Demonstrate how to use spring-data-r2dbc to save json to postgres

### database table

``` sql
create table message_test(
    id serial8 primary key,
    body json not null
)
```
