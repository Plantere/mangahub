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
VALUES(991, 'Administrador', 'administrador@admin.com', '$2a$12$xAs5mbeBxFLY0xSeX3yt9u3xgqKPCiwPsXCS9cNUA5An0W06jeaWK', 1, NULL, NULL, '2022-12-20 00:32:42.951', '2022-12-20 00:32:42.951');
INSERT INTO public.users
(id, name, email, "password", status, "role", deleted_at, created_at, updated_at)
VALUES(992, 'Fabio Torres', 'FabioTorres@admin.com', '$2a$12$xAs5mbeBxFLY0xSeX3yt9u3xgqKPCiwPsXCS9cNUA5An0W06jeaWK', 1, NULL, NULL, '2022-12-20 00:32:42.951', '2022-12-20 00:32:42.951');
INSERT INTO public.users
(id, name, email, "password", status, "role", deleted_at, created_at, updated_at)
VALUES(993, 'Pedro Santos', 'PedroSantos@admin.com', '$2a$12$xAs5mbeBxFLY0xSeX3yt9u3xgqKPCiwPsXCS9cNUA5An0W06jeaWK', 1, NULL, NULL, '2022-12-20 00:32:42.951', '2022-12-20 00:32:42.951');


INSERT INTO public.users
(id, name, email, "password", status, "role", deleted_at, created_at, updated_at)
VALUES(994, 'Usuario comum', 'usuario@user.com', '$2a$12$xAs5mbeBxFLY0xSeX3yt9u3xgqKPCiwPsXCS9cNUA5An0W06jeaWK', 1, NULL, NULL, '2022-12-20 00:32:42.951', '2022-12-20 00:32:42.951');
INSERT INTO public.users
(id, name, email, "password", status, "role", deleted_at, created_at, updated_at)
VALUES(995, 'João Gomes', 'JoaoGomes@user.com', '$2a$12$xAs5mbeBxFLY0xSeX3yt9u3xgqKPCiwPsXCS9cNUA5An0W06jeaWK', 1, NULL, NULL, '2022-12-20 00:32:42.951', '2022-12-20 00:32:42.951');
INSERT INTO public.users
(id, name, email, "password", status, "role", deleted_at, created_at, updated_at)
VALUES(996, 'Pablo Escobar', 'PabloEscobar@user.com', '$2a$12$xAs5mbeBxFLY0xSeX3yt9u3xgqKPCiwPsXCS9cNUA5An0W06jeaWK', 1, NULL, NULL, '2022-12-20 00:32:42.951', '2022-12-20 00:32:42.951');


INSERT INTO public.roles_users
(id, user_id, role_id)
VALUES(991, 991, 1);
INSERT INTO public.roles_users
(id, user_id, role_id)
VALUES(992, 992, 1);
INSERT INTO public.roles_users
(id, user_id, role_id)
VALUES(993, 993, 1);

INSERT INTO public.roles_users
(id, user_id, role_id)
VALUES(994, 994, 2);
INSERT INTO public.roles_users
(id, user_id, role_id)
VALUES(995, 995, 2);
INSERT INTO public.roles_users
(id, user_id, role_id)
VALUES(996, 996, 2);