CREATE SCHEMA `agendamento';

# Cliente
insert into cliente(id, nome, cpf) values(1, 'Marcio Simon', '62975211660');
insert into cliente(id, nome, cpf) values(2, 'Adna Suede', '30671779753');
insert into cliente(id, nome, cpf) values(3, 'Enrique Pereira', '86831980570');

# Conta
insert into conta(id, numero, cliente) values(1,'257283',1);
insert into conta(id, numero, cliente) values(2,'113108',2);
insert into conta(id, numero, cliente) values(3,'982562',3);