DELETE FROM books;
DELETE FROM publishers;

INSERT INTO publishers (name, url) VALUES ('Addison-Wesley', 'http://www.addison-wesley.de/');
INSERT INTO publishers (name, url) VALUES ('dpunkt.verlag', 'http://dpunkt.de/');
INSERT INTO publishers (name, url) VALUES ('No Starch Press', 'https://www.nostarch.com/');

INSERT INTO books (
	title,
	subtitle,
	isbn,
	abstract_text,
	num_pages,
	author,
	publisher_id
)
VALUES (
	'Design Patterns',
	'Elements of Reusable Object-Oriented Software',
	'978-0-20163-361-0',
	'Capturing a wealth of experience about the design of object-oriented software, four top-notch designers present a catalog of simple and succinct solutions to commonly occurring design problems. Previously undocumented, these 23 patterns allow designers to create more flexible, elegant, and ultimately reusable designs without having to rediscover the design solutions themselves.',
	395,
	'Erich Gamma / Richard Helm / Ralph E. Johnson / John Vlissides',
	0
);
INSERT INTO books (
	title,
	subtitle,
	isbn,
	abstract_text,
	num_pages,
	author,
	publisher_id
)
VALUES (
	'REST und HTTP',
	'Entwicklung und Integration nach dem Architekturstil des Web',
	'978-3-86490-120-1',
	'Das Buch bietet eine theoretisch fundierte, vor allem aber praxistaugliche Anleitung zum professionellen Einsatz von RESTful HTTP. Es beschreibt den Architekturstil REST (Representational State Transfer) und seine Umsetzung im Rahmen der Protokolle des World Wide Web (HTTP, URIs und andere).',
	330,
	'Stefan Tilkov / Martin Eigenbrodt / Silvia Schreier / Oliver Wolf',
	1
);
INSERT INTO books (
	title,
	subtitle,
	isbn,
	abstract_text,
	num_pages,
	author,
	publisher_id
)
VALUES (
	'Eloquent JavaScript',
	'A Modern Introduction to Programming',
	'978-1-59327-584-6',
	'JavaScript lies at the heart of almost every modern web application, from social apps to the newest browser-based games. Though simple for beginners to pick up and play with, JavaScript is a flexible, complex language that you can use to build full-scale applications.',
	472,
	'Marijn Haverbeke',
	2
);
