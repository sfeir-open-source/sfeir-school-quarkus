
INSERT INTO public.character (id, name, type, speed, acceleration)
VALUES (nextVal('character_seq'), 'Baby Luigi', 'FEATHERWEIGHT', 2, 5);

INSERT INTO public.character (id, name, type, speed, acceleration)
VALUES (nextVal('character_seq'), 'Koopa Troopa', 'LIGHT', 3, 4);

INSERT INTO public.character (id, name, type, speed, acceleration)
VALUES (nextVal('character_seq'), 'Mario', 'MEDIUM', 7, 2);

INSERT INTO public.character (id, name, type, speed, acceleration)
VALUES (nextVal('character_seq'), 'Donkey Kong', 'CRUISER', 9, 1);

INSERT INTO public.character (id, name, type, speed, acceleration)
VALUES (nextVal('character_seq'), 'Bowser', 'HEAVY', 0, 10);
