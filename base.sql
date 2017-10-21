CREATE TABLE status (
  id int(11) NOT NULL AUTO_INCREMENT,
  nome varchar(500) DEFAULT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

CREATE TABLE feedback (
  id int(11) NOT NULL AUTO_INCREMENT,
  nome varchar(500) DEFAULT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;


CREATE TABLE tipo_servico (
  id int(11) NOT NULL AUTO_INCREMENT,
  nome varchar(500) DEFAULT NULL,
  dh_inclusao datetime default NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;


CREATE TABLE cliente (
  id int(11) NOT NULL AUTO_INCREMENT,
  nome varchar(500) DEFAULT NULL,
  email varchar(500) DEFAULT NULL,
  telefone varchar(100) DEFAULT NULL,
  matricula int(11) default NULL,
  dh_inclusao datetime default NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

CREATE TABLE funcionario (
  id int(11) NOT NULL AUTO_INCREMENT,
  nome varchar(500) DEFAULT NULL,
  email varchar(500) DEFAULT NULL,
  telefone varchar(100) DEFAULT NULL,
  dh_inclusao datetime default NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;


CREATE TABLE agendamento (
  id int(11) NOT NULL AUTO_INCREMENT,
  cliente_id int(11) DEFAULT NULL,
  status_id int(11) DEFAULT NULL,
  tipo_servico_id int(11) DEFAULT NULL,
  funcionario_id int(11) DEFAULT NULL,
  contato_id int(11) default null,
  dh_inclusao datetime default NULL,
  dh_agendamento datetime default NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

ALTER TABLE agendamento
ADD foreign key (cliente_id) references cliente(id);

ALTER TABLE agendamento
ADD foreign key (status_id) references status(id);

ALTER TABLE agendamento
ADD foreign key (funcionario_id) references funcionario(id);

ALTER TABLE agendamento
ADD foreign key (contato_id) references contato(id);
  
  


CREATE TABLE contato (
  id int(11) NOT NULL AUTO_INCREMENT,
  cliente_id int(11) DEFAULT NULL,
  funcionario_id int(11) DEFAULT NULL,
  feedback_id int(11) DEFAULT NULL,
  observacao varchar(500) DEFAULT NULL,
  dh_inclusao datetime default NULL,
  dh_contato datetime default NULL,
  PRIMARY KEY (id),
  foreign key (cliente_id) references cliente(id),
  foreign key (funcionario_id) references funcionario(id),
  foreign key (feedback_id) references feedback(id)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;



CREATE TABLE agendamento (
  id int(11) NOT NULL AUTO_INCREMENT,
  cliente_id int(11) DEFAULT NULL,
  status_id int(11) DEFAULT NULL,
  tipo_servico_id int(11) DEFAULT NULL,
  funcionario_id int(11) DEFAULT NULL,
  contato_id int(11) default null,
  dh_inclusao datetime default NULL,
  dh_agendamento datetime default NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

ALTER TABLE agendamento
ADD foreign key (cliente_id) references cliente(id);

ALTER TABLE agendamento
ADD foreign key (status_id) references status(id);

ALTER TABLE agendamento
ADD foreign key (funcionario_id) references funcionario(id);

ALTER TABLE agendamento
ADD foreign key (contato_id) references contato(id);
