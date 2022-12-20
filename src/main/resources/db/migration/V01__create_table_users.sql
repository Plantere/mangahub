CREATE TABLE users (
   id serial PRIMARY KEY,
   name text NOT NULL,
   email text UNIQUE NOT NULL,
   password text NOT NULL,
   status integer NOT NULL,
   role integer,
   deleted_at timestamp,
   created_at timestamp NOT NULL,
   updated_at timestamp
);