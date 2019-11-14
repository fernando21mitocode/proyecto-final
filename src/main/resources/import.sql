
insert into specialty(id, name) values (1,'NEUROCIRUGÍA');
insert into specialty(id, name) values (2,'CIRUGÍA GENERAL');
insert into specialty(id, name) values (3,'PSIQUIATRÍA/SIQUIATRÍA');
insert into specialty(id, name) values (4,'NEUROLOGÍA');
insert into specialty(id, name) values (5,'MEDICINA FAMILIAR');
insert into specialty(id, name) values (6,'PEDIATRÍA');
insert into specialty(id, name) values (7,'CARDIOLOGÍA');
insert into specialty(id, name) values (8,'PEDIATRÍA');
insert into specialty(id, name) values (9,'PATOLOGÍA');
insert into specialty(id, name) values (10,'UROLOGÍA');

insert into patient (id, first_name, last_name, dni,number_clinical_history) values (1,'Marite','Lazo','89098790','A1');
insert into patient (id, first_name, last_name, dni,number_clinical_history) values (2,'Noemi','Jijo','98798778','A2');
insert into patient (id, first_name, last_name, dni,number_clinical_history) values (3,'Thalia','Jiro','78667889','A3');
insert into patient (id, first_name, last_name, dni,number_clinical_history) values (4,'Laura','De La Cruz','54654356','B1');
insert into patient (id, first_name, last_name, dni,number_clinical_history) values (5,'Daniela','Hidalgo','56734543','B2');
insert into patient (id, first_name, last_name, dni,number_clinical_history) values (6,'Lidia','Soto','12332145','B3');
insert into patient (id, first_name, last_name, dni,number_clinical_history) values (7,'Sara','Mazano','87698778','C1');
insert into patient (id, first_name, last_name, dni,number_clinical_history) values (8,'Maria','Peter','87645643','C2');
insert into patient (id, first_name, last_name, dni,number_clinical_history) values (9,'Melissa','Quieroz','56745698','C3');
insert into patient (id, first_name, last_name, dni,number_clinical_history) values (10,'Luissa','Jairo','23454367','D1');

insert into doctor (id, first_name, last_name, dni, cmp,fk_specialty) values (1,'Juan','Lopez','77777777','ABC',1);
insert into doctor (id, first_name, last_name, dni, cmp,fk_specialty) values (2,'Luis','Rojas','87777777','ABC',2);
insert into doctor (id, first_name, last_name, dni, cmp,fk_specialty) values (3,'Pepe','Quintero','32777777','ABC',3);
insert into doctor (id, first_name, last_name, dni, cmp,fk_specialty) values (4,'Lucho','Juares','21777777','ABC',4);
insert into doctor (id, first_name, last_name, dni, cmp,fk_specialty) values (5,'Angel','Vazques','23777777','ABC',5);
insert into doctor (id, first_name, last_name, dni, cmp,fk_specialty) values (6,'Juan','Lopez','77734577','ABC',6);
insert into doctor (id, first_name, last_name, dni, cmp,fk_specialty) values (7,'Raquel','Rios','77777779','ABC',7);
insert into doctor (id, first_name, last_name, dni, cmp,fk_specialty) values (8,'Carla','Kiko','98989898','ABC',8);
insert into doctor (id, first_name, last_name, dni, cmp,fk_specialty) values (9,'Bertha','Hidalgo','88888888','ABC',7);
insert into doctor (id, first_name, last_name, dni, cmp,fk_specialty) values (10,'Pedro','Lazo','99999999','ABC',8);


insert into medical_consultation(id, date,fk_doctor, fk_patient) values (1,'2019-10-12',1,1);
insert into medical_consultation(id, date,fk_doctor, fk_patient) values (2,'2019-10-13',2,2);
insert into medical_consultation(id, date,fk_doctor, fk_patient) values (3,'2019-10-14',3,3);
insert into medical_consultation(id, date,fk_doctor, fk_patient) values (4,'2019-10-15',4,4);
insert into medical_consultation(id, date,fk_doctor, fk_patient) values (5,'2019-10-16',5,5);
insert into medical_consultation(id, date,fk_doctor, fk_patient) values (6,'2019-10-17',6,6);
insert into medical_consultation(id, date,fk_doctor, fk_patient) values (7,'2019-10-18',7,7);
insert into medical_consultation(id, date,fk_doctor, fk_patient) values (8,'2019-10-19',8,8);
insert into medical_consultation(id, date,fk_doctor, fk_patient) values (9,'2019-10-20',9,9);
insert into medical_consultation(id, date,fk_doctor, fk_patient) values (10,'2019-10-21',10,10);

insert into detail_consultation(id, diagnostic, treatment,fk_medical_consultation) values (1,'Epilepsia','Se inicia con medicamentos para detener las crisis epilépticas.',1);
insert into detail_consultation(id, diagnostic, treatment,fk_medical_consultation) values (2,'Cancer','Se inicia con medicamentos para detener las crisis epilépticas.',2);
insert into detail_consultation(id, diagnostic, treatment,fk_medical_consultation) values (3,'Epilepsia','Se inicia con medicamentos para detener las crisis epilépticas.',3);
insert into detail_consultation(id, diagnostic, treatment,fk_medical_consultation) values (4,'Epilepsia','Se inicia con medicamentos para detener las crisis epilépticas.',4);
insert into detail_consultation(id, diagnostic, treatment,fk_medical_consultation) values (5,'Epilepsia','Se inicia con medicamentos para detener las crisis epilépticas.',5);
insert into detail_consultation(id, diagnostic, treatment,fk_medical_consultation) values (6,'Epilepsia','Se inicia con medicamentos para detener las crisis epilépticas.',6);
insert into detail_consultation(id, diagnostic, treatment,fk_medical_consultation) values (7,'Epilepsia','Se inicia con medicamentos para detener las crisis epilépticas.',7);
insert into detail_consultation(id, diagnostic, treatment,fk_medical_consultation) values (8,'Epilepsia','Se inicia con medicamentos para detener las crisis epilépticas.',8);
insert into detail_consultation(id, diagnostic, treatment,fk_medical_consultation) values (9,'Epilepsia','Se inicia con medicamentos para detener las crisis epilépticas.',9);
insert into detail_consultation(id, diagnostic, treatment,fk_medical_consultation) values (10,'Epilepsia','Se inicia con medicamentos para detener las crisis epilépticas.',10);


INSERT INTO users (id, enabled, password, username) VALUES (1, true, '$2a$04$DSy0bBc32sAMcj/TZEKLPe638X/UgNEk.wgGNdhd7rENHJmRR9.cC', 'admin');
INSERT INTO users (id, enabled, password, username) VALUES (2, true, '$2a$04$DSy0bBc32sAMcj/TZEKLPe638X/UgNEk.wgGNdhd7rENHJmRR9.cC', 'user');
INSERT INTO users (id, enabled, password, username) VALUES (3, true, '$2a$04$DSy0bBc32sAMcj/TZEKLPe638X/UgNEk.wgGNdhd7rENHJmRR9.cC', 'doctor');


INSERT INTO authority (id, authority) VALUES (1, 'ROLE_ADMIN');
INSERT INTO authority (id, authority) VALUES (2, 'ROLE_USER');
INSERT INTO authority (id, authority) VALUES (3, 'ROLE_DOCTOR');

INSERT INTO authorities_users (usuario_id, authority_id) VALUES (1,1);
INSERT INTO authorities_users (usuario_id, authority_id) values (1,2);
INSERT INTO authorities_users (usuario_id, authority_id) VALUES (2,2);
INSERT INTO authorities_users (usuario_id, authority_id) VALUES (3,3);

