CREATE TABLE companies (
	id serial NOT NULL,
	"name" varchar(100) NOT NULL,
	CONSTRAINT companies_pk PRIMARY KEY (id)
);

CREATE TABLE events (
	id serial NOT NULL,
	description text NULL,
	"name" varchar(100) NOT NULL,
    "date" timestamptz NOT NULL,
	image_url text NULL,
	event_page_qrcode text NULL,
	checkin_qrcode text NULL,
	CONSTRAINT events_pk PRIMARY KEY (id)
);

CREATE TABLE users (
	id serial NOT NULL,
	email varchar(100) NOT NULL,
	company_id int NOT NULL,
	"name" varchar(60) NOT NULL,
	"role" text NOT NULL DEFAULT 'ROLE_USER',
	"password" text NOT NULL,
	CONSTRAINT users_pk PRIMARY KEY (id),
	CONSTRAINT users_unique UNIQUE (email),
	CONSTRAINT users_companies_fk FOREIGN KEY (company_id) REFERENCES public.companies(id) ON DELETE RESTRICT ON UPDATE CASCADE
);

CREATE TABLE checkin (
	id serial NOT NULL,
	user_id int NOT NULL,
	event_id int NOT NULL,
	CONSTRAINT checkin_pk PRIMARY KEY (id),
	CONSTRAINT checkin_events_fk FOREIGN KEY (event_id) REFERENCES public.events(id) ON DELETE CASCADE ON UPDATE CASCADE,
	CONSTRAINT checkin_users_fk FOREIGN KEY (user_id) REFERENCES public.users(id) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE events_users (
	id serial NOT NULL,
	user_id int NOT NULL,
	event_id int NOT NULL,
	CONSTRAINT events_users_pk PRIMARY KEY (id),
	CONSTRAINT events_users_events_fk FOREIGN KEY (event_id) REFERENCES public.events(id) ON DELETE CASCADE ON UPDATE CASCADE,
	CONSTRAINT events_users_users_fk FOREIGN KEY (user_id) REFERENCES public.users(id) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE feedbacks (
	id serial NOT NULL,
	event_id int NOT NULL,
	user_id int NOT NULL,
	feedback text NOT NULL,
	CONSTRAINT feedbacks_pk PRIMARY KEY (id),
	CONSTRAINT feedbacks_events_fk FOREIGN KEY (event_id) REFERENCES public.events(id) ON DELETE CASCADE ON UPDATE CASCADE,
	CONSTRAINT feedbacks_users_fk FOREIGN KEY (user_id) REFERENCES public.users(id) ON DELETE CASCADE ON UPDATE CASCADE
);

-- DROP TABLE feedbacks CASCADE;
-- DROP TABLE events_users CASCADE;
-- DROP TABLE checkin CASCADE;
-- DROP TABLE users CASCADE;
-- DROP TABLE events CASCADE;
-- DROP TABLE companies CASCADE;