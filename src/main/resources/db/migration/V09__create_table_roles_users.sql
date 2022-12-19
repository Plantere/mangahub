CREATE TABLE roles_users (
   id serial PRIMARY KEY,
   user_id uuid,
   role_id serial,
   CONSTRAINT fk_user FOREIGN KEY(user_id) REFERENCES users(id),
   CONSTRAINT fk_role FOREIGN KEY(role_id) REFERENCES roles(id)
);
