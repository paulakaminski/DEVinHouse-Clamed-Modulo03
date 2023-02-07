INSERT INTO public.role(nome) VALUES ('ROLE_ADMINISTRADOR');
INSERT INTO public.role(nome) VALUES ('ROLE_CADASTRADOR');

INSERT INTO public.usuario(login, nome, senha, email) VALUES ('paulakaminski', 'Paula Kaminski', '$2a$10$cGUiBsBFiW8RIaMGkgP6jeZQSqWG84UqwDmxLaDjeAAE4cdvyggNK', 'paula.kaminski@hotmail.com');
INSERT INTO public.usuario(login, nome, senha, email) VALUES ('marcelsantin', 'Marcel Santin', '$2a$10$JEtTQ98C.MgKFelxKrsP8.E3u2cEJM3gH5s3jgdRWA0gGasSSy5Xm', 'marcelsantink@gmail.com');

INSERT INTO public.usuarios_role(usuario_id, role_id) VALUES (1, 1);
INSERT INTO public.usuarios_role(usuario_id, role_id) VALUES (2, 2);