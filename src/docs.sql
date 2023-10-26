create table search_count(
     search_count_seq bigint not null auto_increment,
     keyword varchar(50),
     count bigint not null default 0,
     created_date datetime,
     modified_date datetime,
     primary key(search_count_seq)
);
