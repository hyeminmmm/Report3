create table search_count(
                             search_count_seq bigint not null auto_increment,
                             keyword varchar(50),
                             count bigint default 1,
                             created_date datetime,
                             modified_date datetime,
                             primary key(search_count_seq)
);

create table search_count_view (
                                   search_count_view_seq bigint auto_increment,
                                   keyword varchar(50),
                                   count bigint default 1,
                                   created_date datetime,
                                   modified_date datetime,
                                   primary key (search_count_view_seq)
);

alter table search_count add unique key uniqueKeyword(keyword);

alter table search_count_view add unique key uniqueKeyword(keyword);

create index IDX_keyword on search_count_view(keyword);