drop table users;
drop table blog;
drop table category;
drop table post;
drop table comments;

drop sequence seq_users_no;
drop sequence seq_blog_no;
drop sequence seq_category_no;
drop sequence seq_post_no;
drop sequence seq_comments_no;

-----------------------------users-------------------------------------------
create table users (
    userNo   number,
    id       varchar2(50) unique not null,
    userName varchar2(100) not null,
    password varchar2(50) not null,
    joinDate date not null,
    primary key(userNo)
);

-----------------------------blog-------------------------------------------
create table blog (
    id       varchar2(50),
    blogTitle varchar2(200) not null,
    logoFile varchar2(200),
    primary key(id),
    constraint j_blog_id foreign key (id)
    references users(id)
);

-----------------------------category-------------------------------------------
create table category(
    cateNo      number,
    id          varchar2(50),
    cateName    varchar2(200) not null,
    description varchar2(500),
    regDate     date not null,
    primary key(cateNo),
    constraint c_category_fk foreign key(id)
    references blog(id)
);

---------------------------------post-------------------------------------

create table post (
    postNo      number,
    cateNo      number,
    postTitle   varchar2(300) not null,
    postContent varchar2(4000),
    regDate     date not null,
    primary key(postNo),
    constraint c_post_fk foreign key(cateNo)
    references category(cateNo)
);

--------------------------comments---------------------------------

create table comments (
    cmtNo       number,
    postNo      number,
    userNo      number,
    cmtContent  varchar2(1000) not null,
    regDte      date not null,
    primary key(cmtNo),
    constraint c_comments_fk foreign key(postNo)
    references post(postNo),
    constraint u_comments_fk foreign key(userNo)
    references users(userNo)
);


create sequence seq_users_no
increment by 1
start with 1
nocache;

create sequence seq_category_no
increment by 1 
start with 1 
nocache;

create sequence seq_post_no
increment by 1 
start with 1 
nocache;

create sequence seq_comments_no
increment by 1
start with 1
nocache
;

insert into users values(seq_users_no.nextval,'KDB', 'kevin', '1234', sysdate);
select * from users;

select * from users;
