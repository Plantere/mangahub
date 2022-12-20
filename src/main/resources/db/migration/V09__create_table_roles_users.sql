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

INSERT INTO public.mangas
(id, "name", description, cover, age_group, released_at, deleted_at, created_at, updated_at)
VALUES(991, 'One Piece', 'One Piece começa quando Gol D. Roger, o Rei Dos Piratas que possuiu tudo nesse mundo, antes de ser executado, diz que escondeu o seu tesouro em algum lugar da Grand Line, um oceano extremamente perigoso. Desde então muitos piratas se aventuram pela Grand Line para tentar encontrar o tesouro chamado One Piece. Um deles é Monkey D. Luffy, o garoto que, acidentalmente, comeu uma das Akuma No Mi, a Gomu Gomu No Mi (Fruta da Borracha), e agora ele pode esticar seu corpo como se fosse uma borracha. A jornada dele começa atrás de companheiros e um barco, que ele vai conseguindo pouco a pouco, pois tem um objetivo: Se tornar o Rei Dos Piratas.', 'https://img-host.filestatic3.xyz/mangas_files/one-piece-br/image_one-piece-br_full.webp', 12, '2022-12-13 11:47:00.000', NULL, '2022-12-20 10:09:55.040', '2022-12-20 10:09:55.041');
INSERT INTO public.mangas
(id, "name", description, cover, age_group, released_at, deleted_at, created_at, updated_at)
VALUES(992, 'Goblin Slayer', 'Um homem deseja tornar-se um "aventureiro", cujo lema é: "Eu não vou salvar o mundo, eu apenas vou matar goblins." Após ouvir rumores sobre ele, uma elfa se aproxima dele com um pedido.', 'https://img-host.filestatic3.xyz/mangas_files/goblin-slayer/image_goblin-slayer_full.webp', 12, '2022-12-13 11:47:00.000', NULL, '2022-12-20 10:09:55.040', '2022-12-20 10:09:55.041');
INSERT INTO public.mangas
(id, "name", description, cover, age_group, released_at, deleted_at, created_at, updated_at)
VALUES(993, 'Hajime no Ippo', '

Makunouchi Ippo, um garoto humilde do segundo ano colegial que na maior parte do seu tempo livre ajuda a sua mãe no trabalho, que possui uma loja que aluga barcos para pesca. Por causa disto, ele não consegue tempo para fazer amigos, e o pior, ele é alvo de Umezawa e sua gangue, que não gostam de Ippo e batem nele desde criança. Um dia, embaixo de uma ponte onde Ippo apanhava de Umezawa, Takamura, um boxeador veterano que foi campeão do torneio entre os boxeadores novatos do Japão, salva Ippo de Umezawa e o leva para o ginásio de boxe para tratar de seus ferimentos. Lá, Takamura empresta alguns vídeos com lutas de boxe para encorajá-lo um pouco.

Depois de ver os vídeos, Ippo começa a se interessar em boxe, pois ele se convenceu de que nele poderia encontrar a resposta que procurava desde criança, que era "qual o significa de ser forte?" Ippo acaba convencendo Takamura e o treinador Kamogawa, provando que é capaz de se tornar um boxeador com a sua determinação e esforço.
', 'https://img-host.filestatic3.xyz/mangas_files/hajime-no-ippo/image_hajime-no-ippo_full.webp', 12, '2022-12-13 11:47:00.000', NULL, '2022-12-20 10:09:55.040', '2022-12-20 10:09:55.041');
INSERT INTO public.mangas
(id, "name", description, cover, age_group, released_at, deleted_at, created_at, updated_at)
VALUES(994, 'Wind Breaker', 'Tomokui Kanata reincarnou na raça mais fraca, a dos goblins e ganhou um novo nome, Rou, após ter morrido de forma infeliz. Entretanto, o goblin Rou preservou as lembranças de sua vida passada, ganhando uma evolução incomum, mas mantendo sua capacidade de ganhar habilidades por comê-los.

Neste mundo alternativo de sobrevivência do mais forte, com o desenrolar dos acontecimentos, irá o grupo do goblins se tornarem os heróis deste mundo e o transformarem em um cenário totalmente diferente do habitual? Ele irá se tornar o herói deste mundo ou um soberano das trevas dominará a todos?', 'https://img-host.filestatic3.xyz/mangas_files/remonster/image_remonster_full.webp', 12, '2022-12-13 11:47:00.000', NULL, '2022-12-20 10:09:55.040', '2022-12-20 10:09:55.041');
INSERT INTO public.mangas
(id, "name", description, cover, age_group, released_at, deleted_at, created_at, updated_at)
VALUES(995, 'Vinland Saga', 'Thorfinn é filho de Thors, um lendário guerreiro viking, mas que após anos no campo de batalha, descobre uma coisa mais maravilhosa que matar seus iguais. Viver sua própria vida, em paz. Mas os ventos lhe trazem uma notícia que atrapalhará seus dias de paz, e Thorfinn, seu filho, pouco sabe desta vida passada de guerra de seu pai. Após descobrir o passado de seu pai, Thorfinn se revolta contra ele, e sai para a guerra junto de seu pai, mas quando reconhece o verdadeiro valor dele, já é tarde demais. Agora Thorfinn deverá seguir sua própria vida, seguindo valores que seu pai lhe ensinou, mas sem perder sua coragem. Este é só o começo desta grande saga de Thorfinn que acompanha os Vikings no século XI!', 'https://img-host.filestatic3.xyz/mangas_files/vinland-saga/image_vinland-saga_full.webp', 12, '2022-12-13 11:47:00.000', NULL, '2022-12-20 10:09:55.040', '2022-12-20 10:09:55.041');
INSERT INTO public.mangas
(id, "name", description, cover, age_group, released_at, deleted_at, created_at, updated_at)
VALUES(996, 'Mahou Tsukai no Yome', 'Hatori Chise tem apenas 16 anos, mas ela já perdeu muito mais do que o esperado. Sem uma família nem esperança, parece que todas as portas estão fechadas para ela. Mas um encontro acidental começou a mover as rodas enferrujadas do destino. Na sua hora mais escura, um misterioso mago aparece diante de Chise, oferecendo uma chance que ela não poderia recusar. Esse mago, que parece mais um demônio do que um humano, irá ele trazer a ela a luz que desesperadamente busca, ou afogá-la em sombras ainda mais profundas?', 'https://img-host.filestatic3.xyz/mangas_files/mahou-tsukai-no-yome/image_mahou-tsukai-no-yome_full.webp', 12, '2022-12-13 11:47:00.000', NULL, '2022-12-20 10:09:55.040', '2022-12-20 10:09:55.041');
INSERT INTO public.mangas
(id, "name", description, cover, age_group, released_at, deleted_at, created_at, updated_at)
VALUES(997, 'Spy X Family', 'O mestre espião de codinome "Twilight" passou seus dias em missões secretas, tudo pelo sonho de um mundo melhor. Mas um dia, ele recebe uma nova ordem particularmente difícil da central de comando. Para sua missão, ele deve formar uma família temporária e começar uma nova vida!?', 'https://img-host.filestatic3.xyz/mangas_files/spy-x-family/image_spy-x-family_full.webp', 12, '2022-12-13 11:47:00.000', NULL, '2022-12-20 10:09:55.040', '2022-12-20 10:09:55.041');
INSERT INTO public.mangas
(id, "name", description, cover, age_group, released_at, deleted_at, created_at, updated_at)
VALUES(999, 'Eleceed', 'Jiwoo é um jovem de bom coração que aproveita os reflexos rápidos de um gato para tornar secretamente o mundo um lugar melhor - uma criança salva ou um animal adotivo de cada vez. Kayden é um agente secreto em fuga, que se vê preso no corpo de um ... hum ... decididamente gordo e fofo gato. Juntos, armados com os super poderes de Jiwoo e as super-esperanças de Kayden, eles lutam contra as forças que deixariam o mal governar este mundo. Ou seja, se eles puderem ficar juntos o tempo suficiente para fazer o trabalho.', 'https://img-host.filestatic3.xyz/mangas_files/eleceed/image_eleceed_full.webp', 12, '2022-12-13 11:47:00.000', NULL, '2022-12-20 10:09:55.040', '2022-12-20 10:09:55.041');
INSERT INTO public.mangas
(id, "name", description, cover, age_group, released_at, deleted_at, created_at, updated_at)
VALUES(9910, 'One Punch-Man', 'A história segue o dia-a-dia de um herói normal que está infeliz por ser forte o bastante para derrotar todos os seus oponentes com apenas um soco, já que isso não lhe traz mais a sensação de adrenalina ao enfrentar um inimigo poderoso.', 'https://img-host.filestatic3.xyz/mangas_files/one-punch-man/image_one-punch-man_full.webp', 12, '2022-12-13 11:47:00.000', NULL, '2022-12-20 10:09:55.040', '2022-12-20 10:09:55.041');
INSERT INTO public.mangas
(id, "name", description, cover, age_group, released_at, deleted_at, created_at, updated_at)
VALUES(9911, 'Tensei shitara', 'Depois de ser morto por um ladrão que fugia, um rapaz normal de 37 anos de idade se encontra reencarnado em um outro mundo como um slime cego com habilidades únicas. Com um novo nome "Rimuru Tempest" ele chegou depois de conhecer seu novo amigo, o "nível catástrofe", Dragão da Tempestade Verudora, ele começa sua vida de slime em outro mundo com seu crescente número de seguidores.', 'https://img-host.filestatic3.xyz/mangas_files/tensei-shitara-slime-datta-ken/image_tensei-shitara-slime-datta-ken_full.webp', 12, '2022-12-13 11:47:00.000', NULL, '2022-12-20 10:09:55.040', '2022-12-20 10:09:55.041');
INSERT INTO public.mangas
(id, "name", description, cover, age_group, released_at, deleted_at, created_at, updated_at)
VALUES(998, 'Wind Breaker', 'Jo Ja-Hyun (Jay) é o Presidente do Conselho estudantil da Taeyang (Sunny) High. ele não é somente um aluno na média e sim um ciclista incrível com ótimas técnicas. Enquanto você segue a bicicleta dele, irá conhecer seus amigos, amor e as aventuras.', 'https://img-host.filestatic3.xyz/mangas_files/wind-breaker/image_wind-breaker_full.webp', 12, '2022-12-13 11:47:00.000', NULL, '2022-12-20 10:09:55.040', '2022-12-20 10:09:55.041');
INSERT INTO public.mangas
(id, "name", description, cover, age_group, released_at, deleted_at, created_at, updated_at)
VALUES(9912, 'Jujutsu Kaisen', 'Yuji é um gênio do atletismo, mas não tem interesse algum em ficar correndo em círculos. Ele é feliz como membro no Clube de Estudo de Fenômenos Psíquicos. Apesar de estar no clube apenas por diversão, tudo fica sério quando um espírito de verdade aparece na escola! A vida está prestes a se tornar muito interessante na Escola Sugisawa…', 'https://img-host.filestatic3.xyz/mangas_files/jujutsu-kaisen/image_jujutsu-kaisen_full.webp', 12, '2022-12-13 11:47:00.000', NULL, '2022-12-20 10:09:55.040', '2022-12-20 10:09:55.041');

INSERT INTO public.chapters
(id, manga_id, "number", title, released_at, deleted_at, created_at, updated_at)
VALUES(991, 991, 1, 'A volta dos que não foram', '2022-05-22 12:12:13.000', NULL, '2022-12-20 10:16:15.332', '2022-12-20 10:16:15.332');
INSERT INTO public.chapters
(id, manga_id, "number", title, released_at, deleted_at, created_at, updated_at)
VALUES(993, 991, 3, 'A volta dos que não foram 3', '2022-05-22 12:12:13.000', NULL, '2022-12-20 10:16:15.332', '2022-12-20 10:16:15.332');
INSERT INTO public.chapters
(id, manga_id, "number", title, released_at, deleted_at, created_at, updated_at)
VALUES(992, 991, 2, 'A volta dos que não foram 2', '2022-05-22 12:12:13.000', NULL, '2022-12-20 10:16:15.332', '2022-12-20 10:16:15.332');
INSERT INTO public.chapters
(id, manga_id, "number", title, released_at, deleted_at, created_at, updated_at)
VALUES(994, 992, 1, 'A volta dos que não foram', '2022-05-22 12:12:13.000', NULL, '2022-12-20 10:16:15.332', '2022-12-20 10:16:15.332');
INSERT INTO public.chapters
(id, manga_id, "number", title, released_at, deleted_at, created_at, updated_at)
VALUES(995, 992, 2, 'A volta dos que não foram 2', '2022-05-22 12:12:13.000', NULL, '2022-12-20 10:16:15.332', '2022-12-20 10:16:15.332');
INSERT INTO public.chapters
(id, manga_id, "number", title, released_at, deleted_at, created_at, updated_at)
VALUES(996, 992, 3, 'A volta dos que não foram 3', '2022-05-22 12:12:13.000', NULL, '2022-12-20 10:16:15.332', '2022-12-20 10:16:15.332');
INSERT INTO public.chapters
(id, manga_id, "number", title, released_at, deleted_at, created_at, updated_at)
VALUES(997, 993, 1, 'A volta dos que não foram', '2022-05-22 12:12:13.000', NULL, '2022-12-20 10:16:15.332', '2022-12-20 10:16:15.332');
INSERT INTO public.chapters
(id, manga_id, "number", title, released_at, deleted_at, created_at, updated_at)
VALUES(998, 993, 2, 'A volta dos que não foram 2', '2022-05-22 12:12:13.000', NULL, '2022-12-20 10:16:15.332', '2022-12-20 10:16:15.332');
INSERT INTO public.chapters
(id, manga_id, "number", title, released_at, deleted_at, created_at, updated_at)
VALUES(999, 993, 3, 'A volta dos que não foram 3', '2022-05-22 12:12:13.000', NULL, '2022-12-20 10:16:15.332', '2022-12-20 10:16:15.332');
INSERT INTO public.chapters
(id, manga_id, "number", title, released_at, deleted_at, created_at, updated_at)
VALUES(910, 994, 1, 'A volta dos que não foram', '2022-05-22 12:12:13.000', NULL, '2022-12-20 10:16:15.332', '2022-12-20 10:16:15.332');
INSERT INTO public.chapters
(id, manga_id, "number", title, released_at, deleted_at, created_at, updated_at)
VALUES(911, 994, 2, 'A volta dos que não foram 2', '2022-05-22 12:12:13.000', NULL, '2022-12-20 10:16:15.332', '2022-12-20 10:16:15.332');
INSERT INTO public.chapters
(id, manga_id, "number", title, released_at, deleted_at, created_at, updated_at)
VALUES(912, 994, 3, 'A volta dos que não foram 3', '2022-05-22 12:12:13.000', NULL, '2022-12-20 10:16:15.332', '2022-12-20 10:16:15.332');
INSERT INTO public.chapters
(id, manga_id, "number", title, released_at, deleted_at, created_at, updated_at)
VALUES(913, 995, 1, 'A volta dos que não foram', '2022-05-22 12:12:13.000', NULL, '2022-12-20 10:16:15.332', '2022-12-20 10:16:15.332');
INSERT INTO public.chapters
(id, manga_id, "number", title, released_at, deleted_at, created_at, updated_at)
VALUES(914, 995, 2, 'A volta dos que não foram 2', '2022-05-22 12:12:13.000', NULL, '2022-12-20 10:16:15.332', '2022-12-20 10:16:15.332');
INSERT INTO public.chapters
(id, manga_id, "number", title, released_at, deleted_at, created_at, updated_at)
VALUES(915, 995, 3, 'A volta dos que não foram 3', '2022-05-22 12:12:13.000', NULL, '2022-12-20 10:16:15.332', '2022-12-20 10:16:15.332');
INSERT INTO public.chapters
(id, manga_id, "number", title, released_at, deleted_at, created_at, updated_at)
VALUES(916, 996, 1, 'A volta dos que não foram', '2022-05-22 12:12:13.000', NULL, '2022-12-20 10:16:15.332', '2022-12-20 10:16:15.332');
INSERT INTO public.chapters
(id, manga_id, "number", title, released_at, deleted_at, created_at, updated_at)
VALUES(917, 996, 2, 'A volta dos que não foram 2', '2022-05-22 12:12:13.000', NULL, '2022-12-20 10:16:15.332', '2022-12-20 10:16:15.332');
INSERT INTO public.chapters
(id, manga_id, "number", title, released_at, deleted_at, created_at, updated_at)
VALUES(918, 996, 3, 'A volta dos que não foram 3', '2022-05-22 12:12:13.000', NULL, '2022-12-20 10:16:15.332', '2022-12-20 10:16:15.332');

INSERT INTO public.chapters_pages
(id, chapter_id, "number", image, deleted_at, created_at, updated_at)
VALUES(991, 991, 1, 'https://img-host.filestatic3.xyz/mangas_files/dice-the-cube-that-changes-everything/367/img_or2012220950_0002.jpg', NULL, '2022-12-20 10:16:58.867', '2022-12-20 10:16:58.867');
INSERT INTO public.chapters_pages
(id, chapter_id, "number", image, deleted_at, created_at, updated_at)
VALUES(992, 991, 992, 'https://img-host.filestatic3.xyz/mangas_files/dice-the-cube-that-changes-everything/367/img_or2012220950_0003.jpg', NULL, '2022-12-20 10:16:58.867', '2022-12-20 10:16:58.867');
INSERT INTO public.chapters_pages
(id, chapter_id, "number", image, deleted_at, created_at, updated_at)
VALUES(993, 991, 993, 'https://img-host.filestatic3.xyz/mangas_files/dice-the-cube-that-changes-everything/367/img_or2012220950_0004.jpg', NULL, '2022-12-20 10:16:58.867', '2022-12-20 10:16:58.867');
INSERT INTO public.chapters_pages
(id, chapter_id, "number", image, deleted_at, created_at, updated_at)
VALUES(994, 991, 994, 'https://img-host.filestatic3.xyz/mangas_files/dice-the-cube-that-changes-everything/367/img_or2012220950_0005.jpg', NULL, '2022-12-20 10:16:58.867', '2022-12-20 10:16:58.867');
INSERT INTO public.chapters_pages
(id, chapter_id, "number", image, deleted_at, created_at, updated_at)
VALUES(995, 991, 995, 'https://img-host.filestatic3.xyz/mangas_files/dice-the-cube-that-changes-everything/367/img_or2012220950_0006.jpg', NULL, '2022-12-20 10:16:58.867', '2022-12-20 10:16:58.867');
INSERT INTO public.chapters_pages
(id, chapter_id, "number", image, deleted_at, created_at, updated_at)
VALUES(996, 991, 996, 'https://img-host.filestatic3.xyz/mangas_files/dice-the-cube-that-changes-everything/367/img_or2012220950_0007.jpg', NULL, '2022-12-20 10:16:58.867', '2022-12-20 10:16:58.867');
INSERT INTO public.chapters_pages
(id, chapter_id, "number", image, deleted_at, created_at, updated_at)
VALUES(997, 992, 991, 'https://img-host.filestatic3.xyz/mangas_files/dice-the-cube-that-changes-everything/366/img_or2911221216_0002.jpg', NULL, '2022-12-20 10:16:58.867', '2022-12-20 10:16:58.867');
INSERT INTO public.chapters_pages
(id, chapter_id, "number", image, deleted_at, created_at, updated_at)
VALUES(998, 992, 2, 'https://img-host.filestatic3.xyz/mangas_files/dice-the-cube-that-changes-everything/366/img_or2911221216_0003.jpg', NULL, '2022-12-20 10:16:58.867', '2022-12-20 10:16:58.867');
INSERT INTO public.chapters_pages
(id, chapter_id, "number", image, deleted_at, created_at, updated_at)
VALUES(999, 992, 993, 'https://img-host.filestatic3.xyz/mangas_files/dice-the-cube-that-changes-everything/366/img_or2911221216_0004.jpg', NULL, '2022-12-20 10:16:58.867', '2022-12-20 10:16:58.867');
INSERT INTO public.chapters_pages
(id, chapter_id, "number", image, deleted_at, created_at, updated_at)
VALUES(9910, 992, 994, 'https://img-host.filestatic3.xyz/mangas_files/dice-the-cube-that-changes-everything/366/img_or2911221216_0005.jpg', NULL, '2022-12-20 10:16:58.867', '2022-12-20 10:16:58.867');
INSERT INTO public.chapters_pages
(id, chapter_id, "number", image, deleted_at, created_at, updated_at)
VALUES(9911, 992, 995, 'https://img-host.filestatic3.xyz/mangas_files/dice-the-cube-that-changes-everything/366/img_or2911221216_0006.jpg', NULL, '2022-12-20 10:16:58.867', '2022-12-20 10:16:58.867');
INSERT INTO public.chapters_pages
(id, chapter_id, "number", image, deleted_at, created_at, updated_at)
VALUES(9912, 992, 996, 'https://img-host.filestatic3.xyz/mangas_files/dice-the-cube-that-changes-everything/366/img_or2911221216_0007.jpg', NULL, '2022-12-20 10:16:58.867', '2022-12-20 10:16:58.867');
INSERT INTO public.chapters_pages
(id, chapter_id, "number", image, deleted_at, created_at, updated_at)
VALUES(9915, 993, 991, 'https://img-host.filestatic3.xyz/mangas_files/dice-the-cube-that-changes-everything/365/img_or1911221815_0002.jpg', NULL, '2022-12-20 10:16:58.867', '2022-12-20 10:16:58.867');
INSERT INTO public.chapters_pages
(id, chapter_id, "number", image, deleted_at, created_at, updated_at)
VALUES(9916, 993, 992, 'https://img-host.filestatic3.xyz/mangas_files/dice-the-cube-that-changes-everything/365/img_or1911221815_0003.jpg', NULL, '2022-12-20 10:16:58.867', '2022-12-20 10:16:58.867');
INSERT INTO public.chapters_pages
(id, chapter_id, "number", image, deleted_at, created_at, updated_at)
VALUES(9917, 993, 3, 'https://img-host.filestatic3.xyz/mangas_files/dice-the-cube-that-changes-everything/365/img_or1911221815_0004.jpg', NULL, '2022-12-20 10:16:58.867', '2022-12-20 10:16:58.867');
INSERT INTO public.chapters_pages
(id, chapter_id, "number", image, deleted_at, created_at, updated_at)
VALUES(9918, 993, 994, 'https://img-host.filestatic3.xyz/mangas_files/dice-the-cube-that-changes-everything/365/img_or1911221815_0005.jpg', NULL, '2022-12-20 10:16:58.867', '2022-12-20 10:16:58.867');
INSERT INTO public.chapters_pages
(id, chapter_id, "number", image, deleted_at, created_at, updated_at)
VALUES(9919, 993, 995, 'https://img-host.filestatic3.xyz/mangas_files/dice-the-cube-that-changes-everything/365/img_or1911221815_0006.jpg', NULL, '2022-12-20 10:16:58.867', '2022-12-20 10:16:58.867');
INSERT INTO public.chapters_pages
(id, chapter_id, "number", image, deleted_at, created_at, updated_at)
VALUES(9920, 993, 996, 'https://img-host.filestatic3.xyz/mangas_files/dice-the-cube-that-changes-everything/365/img_or1911221815_0007.jpg', NULL, '2022-12-20 10:16:58.867', '2022-12-20 10:16:58.867');
INSERT INTO public.chapters_pages
(id, chapter_id, "number", image, deleted_at, created_at, updated_at)
VALUES(9921, 994, 991, 'https://img-host.filestatic3.xyz/mangas_files/dice-the-cube-that-changes-everything/367/img_or2012220950_0002.jpg', NULL, '2022-12-20 10:16:58.867', '2022-12-20 10:16:58.867');
INSERT INTO public.chapters_pages
(id, chapter_id, "number", image, deleted_at, created_at, updated_at)
VALUES(9922, 994, 992, 'https://img-host.filestatic3.xyz/mangas_files/dice-the-cube-that-changes-everything/367/img_or2012220950_0003.jpg', NULL, '2022-12-20 10:16:58.867', '2022-12-20 10:16:58.867');
INSERT INTO public.chapters_pages
(id, chapter_id, "number", image, deleted_at, created_at, updated_at)
VALUES(9923, 994, 993, 'https://img-host.filestatic3.xyz/mangas_files/dice-the-cube-that-changes-everything/367/img_or2012220950_0004.jpg', NULL, '2022-12-20 10:16:58.867', '2022-12-20 10:16:58.867');
INSERT INTO public.chapters_pages
(id, chapter_id, "number", image, deleted_at, created_at, updated_at)
VALUES(9924, 994, 4, 'https://img-host.filestatic3.xyz/mangas_files/dice-the-cube-that-changes-everything/367/img_or2012220950_0005.jpg', NULL, '2022-12-20 10:16:58.867', '2022-12-20 10:16:58.867');
INSERT INTO public.chapters_pages
(id, chapter_id, "number", image, deleted_at, created_at, updated_at)
VALUES(9925, 994, 995, 'https://img-host.filestatic3.xyz/mangas_files/dice-the-cube-that-changes-everything/367/img_or2012220950_0006.jpg', NULL, '2022-12-20 10:16:58.867', '2022-12-20 10:16:58.867');
INSERT INTO public.chapters_pages
(id, chapter_id, "number", image, deleted_at, created_at, updated_at)
VALUES(9926, 994, 996, 'https://img-host.filestatic3.xyz/mangas_files/dice-the-cube-that-changes-everything/367/img_or2012220950_0007.jpg', NULL, '2022-12-20 10:16:58.867', '2022-12-20 10:16:58.867');
INSERT INTO public.chapters_pages
(id, chapter_id, "number", image, deleted_at, created_at, updated_at)
VALUES(9927, 995, 991, 'https://img-host.filestatic3.xyz/mangas_files/dice-the-cube-that-changes-everything/366/img_or2911221216_0002.jpg', NULL, '2022-12-20 10:16:58.867', '2022-12-20 10:16:58.867');
INSERT INTO public.chapters_pages
(id, chapter_id, "number", image, deleted_at, created_at, updated_at)
VALUES(9928, 995, 992, 'https://img-host.filestatic3.xyz/mangas_files/dice-the-cube-that-changes-everything/366/img_or2911221216_0003.jpg', NULL, '2022-12-20 10:16:58.867', '2022-12-20 10:16:58.867');
INSERT INTO public.chapters_pages
(id, chapter_id, "number", image, deleted_at, created_at, updated_at)
VALUES(9929, 995, 993, 'https://img-host.filestatic3.xyz/mangas_files/dice-the-cube-that-changes-everything/366/img_or2911221216_0004.jpg', NULL, '2022-12-20 10:16:58.867', '2022-12-20 10:16:58.867');
INSERT INTO public.chapters_pages
(id, chapter_id, "number", image, deleted_at, created_at, updated_at)
VALUES(9930, 995, 994, 'https://img-host.filestatic3.xyz/mangas_files/dice-the-cube-that-changes-everything/366/img_or2911221216_0005.jpg', NULL, '2022-12-20 10:16:58.867', '2022-12-20 10:16:58.867');
INSERT INTO public.chapters_pages
(id, chapter_id, "number", image, deleted_at, created_at, updated_at)
VALUES(9931, 995, 5, 'https://img-host.filestatic3.xyz/mangas_files/dice-the-cube-that-changes-everything/366/img_or2911221216_0006.jpg', NULL, '2022-12-20 10:16:58.867', '2022-12-20 10:16:58.867');
INSERT INTO public.chapters_pages
(id, chapter_id, "number", image, deleted_at, created_at, updated_at)
VALUES(9932, 995, 996, 'https://img-host.filestatic3.xyz/mangas_files/dice-the-cube-that-changes-everything/366/img_or2911221216_0007.jpg', NULL, '2022-12-20 10:16:58.867', '2022-12-20 10:16:58.867');
INSERT INTO public.chapters_pages
(id, chapter_id, "number", image, deleted_at, created_at, updated_at)
VALUES(9933, 996, 991, 'https://img-host.filestatic3.xyz/mangas_files/dice-the-cube-that-changes-everything/365/img_or1911221815_0002.jpg', NULL, '2022-12-20 10:16:58.867', '2022-12-20 10:16:58.867');
INSERT INTO public.chapters_pages
(id, chapter_id, "number", image, deleted_at, created_at, updated_at)
VALUES(9934, 996, 992, 'https://img-host.filestatic3.xyz/mangas_files/dice-the-cube-that-changes-everything/365/img_or1911221815_0003.jpg', NULL, '2022-12-20 10:16:58.867', '2022-12-20 10:16:58.867');
INSERT INTO public.chapters_pages
(id, chapter_id, "number", image, deleted_at, created_at, updated_at)
VALUES(9935, 996, 993, 'https://img-host.filestatic3.xyz/mangas_files/dice-the-cube-that-changes-everything/365/img_or1911221815_0004.jpg', NULL, '2022-12-20 10:16:58.867', '2022-12-20 10:16:58.867');
INSERT INTO public.chapters_pages
(id, chapter_id, "number", image, deleted_at, created_at, updated_at)
VALUES(9936, 996, 994, 'https://img-host.filestatic3.xyz/mangas_files/dice-the-cube-that-changes-everything/365/img_or1911221815_0005.jpg', NULL, '2022-12-20 10:16:58.867', '2022-12-20 10:16:58.867');
INSERT INTO public.chapters_pages
(id, chapter_id, "number", image, deleted_at, created_at, updated_at)
VALUES(9937, 996, 995, 'https://img-host.filestatic3.xyz/mangas_files/dice-the-cube-that-changes-everything/365/img_or1911221815_0006.jpg', NULL, '2022-12-20 10:16:58.867', '2022-12-20 10:16:58.867');
INSERT INTO public.chapters_pages
(id, chapter_id, "number", image, deleted_at, created_at, updated_at)
VALUES(9938, 996, 6, 'https://img-host.filestatic3.xyz/mangas_files/dice-the-cube-that-changes-everything/365/img_or1911221815_0007.jpg', NULL, '2022-12-20 10:16:58.867', '2022-12-20 10:16:58.867');
INSERT INTO public.chapters_pages
(id, chapter_id, "number", image, deleted_at, created_at, updated_at)
VALUES(9939, 997, 991, 'https://img-host.filestatic3.xyz/mangas_files/dice-the-cube-that-changes-everything/367/img_or2012220950_0002.jpg', NULL, '2022-12-20 10:16:58.867', '2022-12-20 10:16:58.867');
INSERT INTO public.chapters_pages
(id, chapter_id, "number", image, deleted_at, created_at, updated_at)
VALUES(9940, 997, 992, 'https://img-host.filestatic3.xyz/mangas_files/dice-the-cube-that-changes-everything/367/img_or2012220950_0003.jpg', NULL, '2022-12-20 10:16:58.867', '2022-12-20 10:16:58.867');
INSERT INTO public.chapters_pages
(id, chapter_id, "number", image, deleted_at, created_at, updated_at)
VALUES(9941, 997, 993, 'https://img-host.filestatic3.xyz/mangas_files/dice-the-cube-that-changes-everything/367/img_or2012220950_0004.jpg', NULL, '2022-12-20 10:16:58.867', '2022-12-20 10:16:58.867');
INSERT INTO public.chapters_pages
(id, chapter_id, "number", image, deleted_at, created_at, updated_at)
VALUES(9942, 997, 994, 'https://img-host.filestatic3.xyz/mangas_files/dice-the-cube-that-changes-everything/367/img_or2012220950_0005.jpg', NULL, '2022-12-20 10:16:58.867', '2022-12-20 10:16:58.867');
INSERT INTO public.chapters_pages
(id, chapter_id, "number", image, deleted_at, created_at, updated_at)
VALUES(9943, 997, 995, 'https://img-host.filestatic3.xyz/mangas_files/dice-the-cube-that-changes-everything/367/img_or2012220950_0006.jpg', NULL, '2022-12-20 10:16:58.867', '2022-12-20 10:16:58.867');
INSERT INTO public.chapters_pages
(id, chapter_id, "number", image, deleted_at, created_at, updated_at)
VALUES(9944, 997, 996, 'https://img-host.filestatic3.xyz/mangas_files/dice-the-cube-that-changes-everything/367/img_or2012220950_0007.jpg', NULL, '2022-12-20 10:16:58.867', '2022-12-20 10:16:58.867');
INSERT INTO public.chapters_pages
(id, chapter_id, "number", image, deleted_at, created_at, updated_at)
VALUES(9945, 998, 991, 'https://img-host.filestatic3.xyz/mangas_files/dice-the-cube-that-changes-everything/366/img_or2911221216_0002.jpg', NULL, '2022-12-20 10:16:58.867', '2022-12-20 10:16:58.867');
INSERT INTO public.chapters_pages
(id, chapter_id, "number", image, deleted_at, created_at, updated_at)
VALUES(9946, 998, 992, 'https://img-host.filestatic3.xyz/mangas_files/dice-the-cube-that-changes-everything/366/img_or2911221216_0003.jpg', NULL, '2022-12-20 10:16:58.867', '2022-12-20 10:16:58.867');
INSERT INTO public.chapters_pages
(id, chapter_id, "number", image, deleted_at, created_at, updated_at)
VALUES(9947, 998, 993, 'https://img-host.filestatic3.xyz/mangas_files/dice-the-cube-that-changes-everything/366/img_or2911221216_0004.jpg', NULL, '2022-12-20 10:16:58.867', '2022-12-20 10:16:58.867');
INSERT INTO public.chapters_pages
(id, chapter_id, "number", image, deleted_at, created_at, updated_at)
VALUES(9948, 998, 994, 'https://img-host.filestatic3.xyz/mangas_files/dice-the-cube-that-changes-everything/366/img_or2911221216_0005.jpg', NULL, '2022-12-20 10:16:58.867', '2022-12-20 10:16:58.867');
INSERT INTO public.chapters_pages
(id, chapter_id, "number", image, deleted_at, created_at, updated_at)
VALUES(9949, 998, 995, 'https://img-host.filestatic3.xyz/mangas_files/dice-the-cube-that-changes-everything/366/img_or2911221216_0006.jpg', NULL, '2022-12-20 10:16:58.867', '2022-12-20 10:16:58.867');
INSERT INTO public.chapters_pages
(id, chapter_id, "number", image, deleted_at, created_at, updated_at)
VALUES(9950, 998, 996, 'https://img-host.filestatic3.xyz/mangas_files/dice-the-cube-that-changes-everything/366/img_or2911221216_0007.jpg', NULL, '2022-12-20 10:16:58.867', '2022-12-20 10:16:58.867');
INSERT INTO public.chapters_pages
(id, chapter_id, "number", image, deleted_at, created_at, updated_at)
VALUES(9951, 999, 991, 'https://img-host.filestatic3.xyz/mangas_files/dice-the-cube-that-changes-everything/365/img_or1911221815_0002.jpg', NULL, '2022-12-20 10:16:58.867', '2022-12-20 10:16:58.867');
INSERT INTO public.chapters_pages
(id, chapter_id, "number", image, deleted_at, created_at, updated_at)
VALUES(9952, 999, 992, 'https://img-host.filestatic3.xyz/mangas_files/dice-the-cube-that-changes-everything/365/img_or1911221815_0003.jpg', NULL, '2022-12-20 10:16:58.867', '2022-12-20 10:16:58.867');
INSERT INTO public.chapters_pages
(id, chapter_id, "number", image, deleted_at, created_at, updated_at)
VALUES(9953, 999, 993, 'https://img-host.filestatic3.xyz/mangas_files/dice-the-cube-that-changes-everything/365/img_or1911221815_0004.jpg', NULL, '2022-12-20 10:16:58.867', '2022-12-20 10:16:58.867');
INSERT INTO public.chapters_pages
(id, chapter_id, "number", image, deleted_at, created_at, updated_at)
VALUES(9954, 999, 994, 'https://img-host.filestatic3.xyz/mangas_files/dice-the-cube-that-changes-everything/365/img_or1911221815_0005.jpg', NULL, '2022-12-20 10:16:58.867', '2022-12-20 10:16:58.867');
INSERT INTO public.chapters_pages
(id, chapter_id, "number", image, deleted_at, created_at, updated_at)
VALUES(9955, 999, 995, 'https://img-host.filestatic3.xyz/mangas_files/dice-the-cube-that-changes-everything/365/img_or1911221815_0006.jpg', NULL, '2022-12-20 10:16:58.867', '2022-12-20 10:16:58.867');
INSERT INTO public.chapters_pages
(id, chapter_id, "number", image, deleted_at, created_at, updated_at)
VALUES(9956, 999, 996, 'https://img-host.filestatic3.xyz/mangas_files/dice-the-cube-that-changes-everything/365/img_or1911221815_0007.jpg', NULL, '2022-12-20 10:16:58.867', '2022-12-20 10:16:58.867');
