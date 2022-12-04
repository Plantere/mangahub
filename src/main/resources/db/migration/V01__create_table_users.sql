CREATE TABLE users (
   id uuid PRIMARY KEY,
   name text NOT NULL,
   email text UNIQUE NOT NULL,
   password text NOT NULL,
   status integer NOT NULL,
   role serial NOT NULL,
   deleted_at timestamp,
   created_at timestamp NOT NULL,
   updated_at timestamp
);