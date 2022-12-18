CREATE TABLE roles_users (
   user_id uuid,
   role_id serial,
   CONSTRAINT fk_user FOREIGN KEY(user_id) REFERENCES users(id),
   CONSTRAINT fk_role FOREIGN KEY(role_id) REFERENCES roles(id)
);
