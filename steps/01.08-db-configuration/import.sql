
INSERT INTO public.character (id, name, type, speed, acceleration)
VALUES (nextVal('hibernate_sequence'), 'Baby Luigi', 'FEATHERWEIGHT', 2, 5);

INSERT INTO public.character (id, name, type, speed, acceleration)
VALUES (nextVal('hibernate_sequence'), 'Koopa Troopa', 'LIGHT', 3, 4);

INSERT INTO public.character (id, name, type, speed, acceleration)
VALUES (nextVal('hibernate_sequence'), 'Mario', 'MEDIUM', 7, 2);

INSERT INTO public.character (id, name, type, speed, acceleration)
VALUES (nextVal('hibernate_sequence'), 'Donkey Kong', 'CRUISER', 9, 1);

INSERT INTO public.character (id, name, type, speed, acceleration)
VALUES (nextVal('hibernate_sequence'), 'Bowser', 'HEAVY', 0, 10);
