CREATE TABLE favorites (
   id serial PRIMARY KEY,
   user_id integer NOT NULL,
   manga_id integer NOT NULL,
   deleted_at timestamp,
   created_at timestamp NOT NULL,
   updated_at timestamp,
   CONSTRAINT fk_user FOREIGN KEY(user_id) REFERENCES users(id),
   CONSTRAINT fk_manga FOREIGN KEY(manga_id) REFERENCES mangas(id)
);
