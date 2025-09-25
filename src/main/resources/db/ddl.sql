-- DROP SCHEMA public;

CREATE SCHEMA public AUTHORIZATION pg_database_owner;

-- DROP SEQUENCE public.checkin_id_seq;

CREATE SEQUENCE public.checkin_id_seq
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 2147483647
	START 1
	CACHE 1
	NO CYCLE;
-- DROP SEQUENCE public.companies_id_seq;

CREATE SEQUENCE public.companies_id_seq
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 2147483647
	START 1
	CACHE 1
	NO CYCLE;
-- DROP SEQUENCE public.events_id_seq;

CREATE SEQUENCE public.events_id_seq
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 2147483647
	START 1
	CACHE 1
	NO CYCLE;
-- DROP SEQUENCE public.events_users_id_seq;

CREATE SEQUENCE public.events_users_id_seq
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 2147483647
	START 1
	CACHE 1
	NO CYCLE;
-- DROP SEQUENCE public.feedbacks_id_seq;

CREATE SEQUENCE public.feedbacks_id_seq
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 2147483647
	START 1
	CACHE 1
	NO CYCLE;
-- DROP SEQUENCE public.permissions_users_id_seq;

CREATE SEQUENCE public.permissions_users_id_seq
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 2147483647
	START 1
	CACHE 1
	NO CYCLE;
-- DROP SEQUENCE public.users_id_seq;

CREATE SEQUENCE public.users_id_seq
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 2147483647
	START 1
	CACHE 1
	NO CYCLE;-- public.companies definição

-- Drop table

-- DROP TABLE public.companies;

CREATE TABLE public.companies (
	id serial4 NOT NULL,
	"name" varchar(100) NOT NULL,
	CONSTRAINT companies_pk PRIMARY KEY (id)
);


-- public.events definição

-- Drop table

-- DROP TABLE public.events;

CREATE TABLE public.events (
	id serial4 NOT NULL,
	description varchar(255) NULL,
	title varchar(100) NOT NULL,
	image_url varchar(100) NULL,
	event_page_qrcode varchar(100) NULL,
	checkin_qrcode varchar(100) NULL,
	CONSTRAINT events_pk PRIMARY KEY (id)
);


-- public.permissions definição

-- Drop table

-- DROP TABLE public.permissions;

CREATE TABLE public.permissions (
	id int4 NOT NULL,
	description varchar(30) NOT NULL,
	CONSTRAINT permissions_pk PRIMARY KEY (id),
	CONSTRAINT permissions_unique UNIQUE (description)
);


-- public.users definição

-- Drop table

-- DROP TABLE public.users;

CREATE TABLE public.users (
	id serial4 NOT NULL,
	email varchar(100) NOT NULL,
	company_id int4 NOT NULL,
	"name" varchar(60) NOT NULL,
	CONSTRAINT users_pk PRIMARY KEY (id),
	CONSTRAINT users_unique UNIQUE (email),
	CONSTRAINT users_companies_fk FOREIGN KEY (company_id) REFERENCES public.companies(id) ON DELETE RESTRICT ON UPDATE CASCADE
);


-- public.checkin definição

-- Drop table

-- DROP TABLE public.checkin;

CREATE TABLE public.checkin (
	id serial4 NOT NULL,
	user_id int4 NOT NULL,
	event_id int4 NOT NULL,
	CONSTRAINT checkin_pk PRIMARY KEY (id),
	CONSTRAINT checkin_events_fk FOREIGN KEY (event_id) REFERENCES public.events(id) ON DELETE CASCADE ON UPDATE CASCADE,
	CONSTRAINT checkin_users_fk FOREIGN KEY (user_id) REFERENCES public.users(id) ON DELETE CASCADE ON UPDATE CASCADE
);


-- public.events_users definição

-- Drop table

-- DROP TABLE public.events_users;

CREATE TABLE public.events_users (
	id serial4 NOT NULL,
	user_id int4 NOT NULL,
	event_id int4 NOT NULL,
	CONSTRAINT events_users_pk PRIMARY KEY (id),
	CONSTRAINT events_users_events_fk FOREIGN KEY (event_id) REFERENCES public.events(id) ON DELETE CASCADE ON UPDATE CASCADE,
	CONSTRAINT events_users_users_fk FOREIGN KEY (user_id) REFERENCES public.users(id) ON DELETE CASCADE ON UPDATE CASCADE
);


-- public.feedbacks definição

-- Drop table

-- DROP TABLE public.feedbacks;

CREATE TABLE public.feedbacks (
	id serial4 NOT NULL,
	event_id int4 NOT NULL,
	user_id int4 NOT NULL,
	feedback varchar(255) NOT NULL,
	CONSTRAINT feedbacks_pk PRIMARY KEY (id),
	CONSTRAINT feedbacks_events_fk FOREIGN KEY (event_id) REFERENCES public.events(id) ON DELETE CASCADE ON UPDATE CASCADE,
	CONSTRAINT feedbacks_users_fk FOREIGN KEY (user_id) REFERENCES public.users(id) ON DELETE CASCADE ON UPDATE CASCADE
);


-- public.permissions_users definição

-- Drop table

-- DROP TABLE public.permissions_users;

CREATE TABLE public.permissions_users (
	id serial4 NOT NULL,
	user_id int4 NOT NULL,
	permission_id int4 NOT NULL,
	CONSTRAINT permissions_users_pk PRIMARY KEY (id),
	CONSTRAINT permissions_users_permissions_fk FOREIGN KEY (permission_id) REFERENCES public.permissions(id) ON DELETE CASCADE ON UPDATE CASCADE,
	CONSTRAINT permissions_users_users_fk FOREIGN KEY (user_id) REFERENCES public.users(id) ON DELETE CASCADE ON UPDATE CASCADE
);