CREATE TABLE roles (
   id serial PRIMARY KEY,
   name text NOT NULL,
   status boolean NOT NULL
);


INSERT INTO public.roles
(id, name, status)
VALUES(1, 'ROLE_ADMIN', true);
INSERT INTO public.roles
(id, name, status)
VALUES(2, 'ROLE_USER', true);
