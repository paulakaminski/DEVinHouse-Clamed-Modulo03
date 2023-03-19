INSERT INTO public.role(nome) VALUES ('ROLE_TUTOR');
INSERT INTO public.role(nome) VALUES ('ROLE_ADOTANTE');

INSERT INTO public.usuario(nome, login, senha) VALUES ('Paula Kaminski', 'paulakaminski', '$2a$10$/9eA0sY3lDKPxT7N9tD14eWedAxSCtcgR2CQPkjBG2HcNE4soF2W6');
INSERT INTO public.usuario(nome, login, senha) VALUES ('Marcel Santin', 'marcelsantin', '$2a$10$/9eA0sY3lDKPxT7N9tD14eWedAxSCtcgR2CQPkjBG2HcNE4soF2W6');

INSERT INTO public.usuario_roles(usuario_model_id, roles_id) VALUES (1, 1);
INSERT INTO public.usuario_roles(usuario_model_id, roles_id) VALUES (2, 2);