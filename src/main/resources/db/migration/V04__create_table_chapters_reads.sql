CREATE TABLE chapters_reads (
   id serial PRIMARY KEY,
   user_id uuid NOT NULL,
   chapter_id serial NOT NULL,
   page_stop integer NOT NULL,
   deleted_at timestamp,
   created_at timestamp NOT NULL,
   updated_at timestamp,
   CONSTRAINT fk_user FOREIGN KEY(user_id) REFERENCES users(id),
   CONSTRAINT fk_chapter FOREIGN KEY(chapter_id) REFERENCES chapters(id)
);