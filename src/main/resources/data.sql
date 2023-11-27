INSERT INTO artist (id, name, year_born, year_dead) VALUES (100, 'Leonardo da Vinci', 1452, 1519);
INSERT INTO artist (id, name, year_born, year_dead) VALUES (101, 'Michelangelo', 1457, 1564);

INSERT INTO curator (id, name, year_born) VALUES (10, 'John', 2000);
INSERT INTO location (id, city, country) VALUES (300, 'Paris', 'France');

INSERT INTO museum (id, name, curator_id, location_id) VALUES (200, 'Louvre Museum', 10, 300);

INSERT INTO art (art_type, id, name, artist_id, medium, museum_id, year_completed, back_story, style) VALUES ('Painting', 500, 'Mona Lisa', 100, 'OIL', 200, 1503, 'Mona Lisa story.....', 'RENAISSANCE');
INSERT INTO art (art_type, id, name, artist_id, medium, museum_id, year_completed, back_story, style) VALUES ('Sculpture', 501, 'Dying Slave', 100, 'MARBLE', 200, 1516, 'Dying Slave story....', 'RENAISSANCE');
