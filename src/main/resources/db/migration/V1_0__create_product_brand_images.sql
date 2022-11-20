create table brand (
    id bigint not null auto_increment primary key,
    name varchar(255) not null,
    description text not null default ('')
) ENGINE=InnoDB DEFAULT CHARSET=UTF8;

create table product (
    id bigint not null auto_increment primary key,
    title varchar(255) not null,
    description text not null default (''),
    price float not null,
    prp float,
    promotion_price float,
    quantity int unsigned not null,
    sku varchar(255),
    brand_id bigint,
    foreign key (brand_id) references brand(id) on delete set null on update cascade
) ENGINE=InnoDB DEFAULT CHARSET=UTF8;

create table product_image (
    id bigint not null auto_increment primary key,
    path varchar(255) not null,
    product_id bigint not null,
    foreign key (product_id) references product(id) on delete cascade on update cascade
) ENGINE=InnoDB DEFAULT CHARSET=UTF8;