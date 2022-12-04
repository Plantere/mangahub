CREATE TABLE favorites (
   user_id uuid NOT NULL,
   manga_id serial NOT NULL,
   deleted_at timestamp,
   created_at timestamp NOT NULL,
   updated_at timestamp,
   CONSTRAINT fk_user FOREIGN KEY(user_id) REFERENCES users(id),
   CONSTRAINT fk_manga FOREIGN KEY(manga_id) REFERENCES mangas(id)
);
