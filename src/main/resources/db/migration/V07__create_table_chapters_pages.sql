CREATE TABLE chapters_pages (
   id serial PRIMARY KEY,
   chapter_id serial NOT NULL,
   number integer NOT NULL,
   image bytea NOT NULL,
   deleted_at timestamp,
   created_at timestamp NOT NULL,
   updated_at timestamp,
   CONSTRAINT fk_chapter FOREIGN KEY(chapter_id) REFERENCES chapters(id)
);