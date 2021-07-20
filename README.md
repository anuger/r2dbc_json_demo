### create table

``` sql
create table message_test(
    id serial8 primary key,
    body json not null
)
```