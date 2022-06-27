-- Database: ecommerce_jsp

-- DROP DATABASE IF EXISTS ecommerce_jsp;

CREATE DATABASE ecommerce_jsp
    WITH
    OWNER = postgres
    ENCODING = 'UTF8'
    LC_COLLATE = 'Portuguese_Brazil.1252'
    LC_CTYPE = 'Portuguese_Brazil.1252'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1;

-- Table: public.app_user

-- DROP TABLE IF EXISTS public.app_user;

CREATE TABLE IF NOT EXISTS public.app_user
(
    id integer NOT NULL DEFAULT nextval('app_user_id_seq'::regclass),
    name character varying(255) COLLATE pg_catalog."default",
    email character varying(255) COLLATE pg_catalog."default" NOT NULL,
    password character varying(255) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT app_user_pkey PRIMARY KEY (id),
    CONSTRAINT app_user_uq_email UNIQUE (email)
    )

    TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.app_user
    OWNER to postgres;