create schema customer;

create table customer.customer
(
    id     serial8,
    customer_name    varchar,
    create_time  timestamptz not null,
    update_time timestamptz not null default to_timestamp(0),
);
comment on table customer.customer is '用户表';
comment on column customer.customer.id is '用户id';
comment on column customer.customer.customer_name is '客户名称';
comment on column customer.customer.create_time is '创建时间';
comment on column customer.customer.update_time is '更新时间';