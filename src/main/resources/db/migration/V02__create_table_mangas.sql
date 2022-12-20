CREATE TABLE mangas (
   id serial PRIMARY KEY,
   name text NOT NULL,
   description text NOT NULL,
   cover text NOT NULL,
   age_group integer NOT NULL,
   released_at timestamp NOT NULL,
   deleted_at timestamp,
   created_at timestamp NOT NULL,
   updated_at timestamp
);