CREATE TABLE roles_users (
   id serial PRIMARY KEY,
   user_id integer,
   role_id integer,
   CONSTRAINT fk_user FOREIGN KEY(user_id) REFERENCES users(id),
   CONSTRAINT fk_role FOREIGN KEY(role_id) REFERENCES roles(id)
);

INSERT INTO public.roles
(id, name, status)
VALUES(1, 'ROLE_ADMIN', true);
INSERT INTO public.roles
(id, name, status)
VALUES(2, 'ROLE_USER', true);

-- Senha 123456

INSERT INTO public.users
(id, name, email, "password", status, "role", deleted_at, created_at, updated_at)
VALUES(1, 'Administrador', 'administrador@admin.com', '$2a$12$xAs5mbeBxFLY0xSeX3yt9u3xgqKPCiwPsXCS9cNUA5An0W06jeaWK', 1, NULL, NULL, '2022-12-20 00:32:42.951', '2022-12-20 00:32:42.951');
INSERT INTO public.users
(id, name, email, "password", status, "role", deleted_at, created_at, updated_at)
VALUES(2, 'Fabio Torres', 'FabioTorres@admin.com', '$2a$12$xAs5mbeBxFLY0xSeX3yt9u3xgqKPCiwPsXCS9cNUA5An0W06jeaWK', 1, NULL, NULL, '2022-12-20 00:32:42.951', '2022-12-20 00:32:42.951');
INSERT INTO public.users
(id, name, email, "password", status, "role", deleted_at, created_at, updated_at)
VALUES(3, 'Pedro Santos', 'PedroSantos@admin.com', '$2a$12$xAs5mbeBxFLY0xSeX3yt9u3xgqKPCiwPsXCS9cNUA5An0W06jeaWK', 1, NULL, NULL, '2022-12-20 00:32:42.951', '2022-12-20 00:32:42.951');


INSERT INTO public.users
(id, name, email, "password", status, "role", deleted_at, created_at, updated_at)
VALUES(4, 'Usuario comum', 'usuario@user.com', '$2a$12$xAs5mbeBxFLY0xSeX3yt9u3xgqKPCiwPsXCS9cNUA5An0W06jeaWK', 1, NULL, NULL, '2022-12-20 00:32:42.951', '2022-12-20 00:32:42.951');
INSERT INTO public.users
(id, name, email, "password", status, "role", deleted_at, created_at, updated_at)
VALUES(5, 'João Gomes', 'JoaoGomes@user.com', '$2a$12$xAs5mbeBxFLY0xSeX3yt9u3xgqKPCiwPsXCS9cNUA5An0W06jeaWK', 1, NULL, NULL, '2022-12-20 00:32:42.951', '2022-12-20 00:32:42.951');
INSERT INTO public.users
(id, name, email, "password", status, "role", deleted_at, created_at, updated_at)
VALUES(6, 'Pablo Escobar', 'PabloEscobar@user.com', '$2a$12$xAs5mbeBxFLY0xSeX3yt9u3xgqKPCiwPsXCS9cNUA5An0W06jeaWK', 1, NULL, NULL, '2022-12-20 00:32:42.951', '2022-12-20 00:32:42.951');


INSERT INTO public.roles_users
(id, user_id, role_id)
VALUES(1, 1, 1);
INSERT INTO public.roles_users
(id, user_id, role_id)
VALUES(2, 2, 1);
INSERT INTO public.roles_users
(id, user_id, role_id)
VALUES(3, 3, 1);

INSERT INTO public.roles_users
(id, user_id, role_id)
VALUES(4, 4, 2);
INSERT INTO public.roles_users
(id, user_id, role_id)
VALUES(5, 5, 2);
INSERT INTO public.roles_users
(id, user_id, role_id)
VALUES(6, 6, 2);
