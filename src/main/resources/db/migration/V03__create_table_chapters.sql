CREATE TABLE chapters (
   id serial PRIMARY KEY,
   manga_id serial NOT NULL,
   chapter integer NOT NULL,
   released_at timestamp NOT NULL,
   deleted_at timestamp,
   created_at timestamp NOT NULL,
   updated_at timestamp,
   CONSTRAINT fk_manga FOREIGN KEY(manga_id) REFERENCES mangas(id)
);