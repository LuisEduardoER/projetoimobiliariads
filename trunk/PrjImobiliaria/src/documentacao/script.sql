/*
Created		12/10/2009
Modified		10/5/2010
Project		
Model			
Company		
Author		
Version		
Database		PostgreSQL 8.1 
*/


/* Create Tables */


Create table "TbImovel"
(
	"idImovel" Serial NOT NULL,
	"dsEndereco" Varchar(100) NOT NULL,
	"noEndereco" Smallint NOT NULL,
	"dsComplemento" Varchar(100),
	"nmBairro" Varchar(60) NOT NULL,
	"cdCEP" Char(8),
	"nmCidade" Varchar(60) NOT NULL,
	"sgEstado" Char(2) NOT NULL,
	"flQuitado" Boolean,
	"flLdSombra" Boolean,
	"tpDisponibilidade" Char(1) NOT NULL Constraint "ckTpDisponibilidade" Check ('0' <= 'tpDisponibilidade' and 'tpDisponibilidade'  <= '4'),
	"tpImovel" Char(1) NOT NULL Constraint "ckTpImovel" Check ('0' <= 'tpImovel' and 'tpImovel' <= '3'),
	"dsObservacao" Varchar(300),
	"idProprietario" Integer NOT NULL,
constraint "pk_TbImovel" primary key ("idImovel")
) Without Oids;


Create table "TbCasa"
(
	"idImovel" Integer NOT NULL,
	"qtQuarto" Smallint NOT NULL Default 0,
	"qtSuite" Smallint NOT NULL Default 0,
	"qtWCSocial" Smallint NOT NULL Default 0,
	"qtVgGaragem" Smallint NOT NULL Default 0,
	"noArea" Double precision,
	"flAreaServico" Boolean NOT NULL,
	"flMobiliada" Boolean NOT NULL,
	"flTelefone" Boolean NOT NULL,
	"flCozinha" Boolean NOT NULL,
	"flQuintal" Boolean NOT NULL,
constraint "pk_TbCasa" primary key ("idImovel")
) Without Oids;


Create table "TbApartamento"
(
	"idImovel" Integer NOT NULL,
	"nmApartamento" Varchar(30) NOT NULL,
	"noApartamento" Smallint NOT NULL,
	"noColuna" Smallint,
	"noAndar" Smallint NOT NULL,
	"qtQuarto" Smallint NOT NULL Default 0,
	"qtSuite" Smallint NOT NULL Default 0,
	"qtWCSocial" Smallint NOT NULL Default 0,
	"qtVgGaragem" Smallint NOT NULL Default 0,
	"noArea" Double precision,
	"vlCondominio" Double precision NOT NULL,
	"flAreaServico" Boolean NOT NULL,
	"flMobiliado" Boolean NOT NULL,
	"flTelefone" Boolean NOT NULL,
	"flCozinha" Boolean NOT NULL,
	"flVaranda" Boolean NOT NULL,
	"flAguaIndividual" Boolean NOT NULL,
	"flGasIndividual" Boolean NOT NULL,
	"flDEC" Boolean NOT NULL,
constraint "pk_TbApartamento" primary key ("idImovel")
) Without Oids;


Create table "TbTerreno"
(
	"idImovel" Integer NOT NULL,
	"noLargura" Double precision NOT NULL,
	"noComprimento" Double precision NOT NULL,
constraint "pk_TbTerreno" primary key ("idImovel")
) Without Oids;


Create table "TbSala"
(
	"idImovel" Integer NOT NULL,
	"noAltura" Double precision,
	"noLargura" Double precision NOT NULL,
	"noComprimento" Double precision NOT NULL,
	"qtWCSocial" Smallint NOT NULL Default 0,
	"flTelefone" Boolean NOT NULL,
	"flCozinha" Boolean NOT NULL,
constraint "pk_TbSala" primary key ("idImovel")
) Without Oids;


Create table "TbPessoa"
(
	"idPessoa" Serial NOT NULL,
	"cdCPF" Char(11) NOT NULL UNIQUE,
	"cdRG" Varchar(11) NOT NULL UNIQUE,
	"nmPessoa" Varchar(50) NOT NULL,
	"dtNascimento" Date NOT NULL,
	"dsNaturalidade" Varchar(50) NOT NULL,
	"dsNacionalidade" Varchar(50) NOT NULL,
	"tpEstadoCivil" Char(1) NOT NULL Constraint "ckTpEstCivil" Check ('0' <= 'tpEstadoCivil' and 'tpEstadoCivil' <= '3'),
	"dsEmail" Varchar(50),
	"nmProfissao" Varchar(40) NOT NULL,
	"dsEndereco" Varchar(100) NOT NULL,
	"noEndereco" Smallint NOT NULL,
	"dsComplemento" Varchar(100),
	"nmBairro" Varchar(60) NOT NULL,
	"nmCidade" Varchar(60) NOT NULL,
	"sgEstado" Char(2) NOT NULL,
	"cdCEP" Char(8),
	"tpPessoa" Char(1) NOT NULL Constraint "ckTpPessoa" Check ('tpPessoa' in ('1','2','3','4','5','6','7')),
	"dsObservacao" Varchar(300),
constraint "pk_TbPessoa" primary key ("idPessoa")
) Without Oids;


Create table "TbLocatario"
(
	"idLocatario" Serial NOT NULL,
	"vlRenda" Double precision NOT NULL,
	"idPessoa" Integer NOT NULL,
constraint "pk_TbLocatario" primary key ("idLocatario")
) Without Oids;


Create table "TbUsuario"
(
	"idPessoa" Integer NOT NULL,
	"dsLogin" Varchar(50) NOT NULL UNIQUE,
	"dsSenha" Varchar(15) NOT NULL,
	"tpPerfil" Smallint NOT NULL Constraint "ckTpPerfil" Check ('0' <= 'tpPerfil' and 'tpPerfil' <= '3'),
constraint "pk_TbUsuario" primary key ("idPessoa")
) Without Oids;


Create table "TbFiador"
(
	"idFiador" Serial NOT NULL,
	"vlRenda" Double precision NOT NULL,
	"idPessoa" Integer NOT NULL,
constraint "pk_TbFiador" primary key ("idFiador")
) Without Oids;


Create table "TbCorretor"
(
	"idPessoa" Integer NOT NULL,
	"cdCRECI" Varchar(10) NOT NULL Constraint "uqCdCRECI" UNIQUE,
constraint "pk_TbCorretor" primary key ("idPessoa")
) Without Oids;


Create table "TbTelefone"
(
	"idTelefone" Serial NOT NULL,
	"cdDDD" Char(2) NOT NULL,
	"noTelefone" Char(8) NOT NULL,
	"noRamal" Varchar(5),
	"tpTelefone" Char(1) NOT NULL Constraint "ckTpTelefone" Check ('0' <= 'tpTelefone' and 'tpTelefone'  <= '3'),
	"dsObservacao" Varchar(300),
	"idPessoa" Integer NOT NULL,
constraint "pk_TbTelefone" primary key ("idTelefone")
) Without Oids;


Create table "TbLocacao"
(
	"idServico" Integer NOT NULL,
	"dtInicio" Date NOT NULL,
	"dtTermino" Date NOT NULL,
	"vlMensalidade" Double precision NOT NULL,
	"qtMesReajuste" Smallint NOT NULL,
	"tpFinalidade" Char(1) NOT NULL Constraint "ckTpFinalidade" Check ('0' <= 'tpFinalidade' and 'tpFinalidade' <= '1'),
	"dsObservacao" Varchar(300),
	"idTipoRegulamentacao" Integer NOT NULL,
	"idCorretor" Integer NOT NULL,
	"idLocatario" Integer NOT NULL,
	"idFiador" Integer NOT NULL,
constraint "pk_TbLocacao" primary key ("idServico")
) Without Oids;


Create table "TbMensalidade"
(
	"idLocacao" Integer NOT NULL,
	"idMensalidade" Serial NOT NULL,
	"dtVencimento" Date NOT NULL,
	"vlMulta" Double precision NOT NULL,
	"txAdicional" Double precision,
	"dtPagamentoServico" Timestamp,
	"vlServico" Double precision,
	"dsObservacao" Varchar(300),
	"idRepassePagamento" Integer,
constraint "pk_TbMensalidade" primary key ("idLocacao","idMensalidade")
) Without Oids;


Create table "TbContratoAvulso"
(
	"idServico" Integer NOT NULL,
	"dtInicioLocacao" Date,
	"dtTerminoLocacao" Date NOT NULL,
	"vlMensalidade" Double precision NOT NULL,
	"qtMesReajuste" Smallint NOT NULL,
	"tpFinalidade" Char(1) NOT NULL Constraint "ckTpFinalidade" Check ('0' <= 'tpFinalidade' and 'tpFinalidade'  <= '1'),
	"dtPagamentoServico" Timestamp,
	"vlServico" Double precision,
	"dsObservacao" Varchar(300),
	"idTipoRegulamentacao" Integer NOT NULL,
	"idLocador" Integer NOT NULL,
	"idLocatario" Integer NOT NULL,
	"idFiador" Integer NOT NULL,
constraint "pk_TbContratoAvulso" primary key ("idServico")
) Without Oids;


Create table "TbVenda"
(
	"idServico" Integer NOT NULL,
	"vlSolicitado" Double precision NOT NULL,
	"dtVenda" Date,
	"vlVenda" Double precision,
	"dtPagamentoServico" Timestamp,
	"vlServico" Double precision,
	"dsObservacao" Varchar(300),
	"idCorretor" Integer NOT NULL,
	"idRepassePagamento" Integer,
constraint "pk_TbVenda" primary key ("idServico")
) Without Oids;


Create table "TbAvaliacao"
(
	"idServico" Integer NOT NULL,
	"dsJustificativa" Text NOT NULL,
	"vlImovel" Double precision,
	"dtPagamentoServico" Timestamp,
	"vlServico" Double precision,
	"dsObservacao" Varchar(300),
	"idCorretor" Integer NOT NULL,
constraint "pk_TbAvaliacao" primary key ("idServico")
) Without Oids;


Create table "TbTabelaPreco"
(
	"idTabelaPreco" Serial NOT NULL,
	"tpUnidade" Char(1) NOT NULL Constraint "ckUnidade" Check ('0' <= 'tpUnidade' and 'tpUnidade' <= '1'),
	"vlPreco" Double precision NOT NULL,
	"tpServico" Char(1) Constraint "ckTpServico" Check ('0' <= 'tpServico' and 'tpServico' <= '3'),
constraint "pk_TbTabelaPreco" primary key ("idTabelaPreco")
) Without Oids;


Create table "TbServico"
(
	"idServico" Serial NOT NULL,
	"dtSolicitacao" Date NOT NULL,
	"tpServico" Char(1) NOT NULL Constraint "ckTpServico" Check ('0' <= 'tpServico' and 'tpServico' <= '3'),
	"idCliente" Integer NOT NULL,
	"idImovel" Integer NOT NULL,
	"idTabelaPreco" Integer NOT NULL,
	"idUsuario" Integer NOT NULL,
constraint "pk_TbServico" primary key ("idServico")
) Without Oids;


Create table "TbRepassePagamento"
(
	"idRepassePagamento" Serial NOT NULL,
	"dtRepasse" Timestamp NOT NULL,
	"vlRepassado" Double precision NOT NULL,
	"idProprietario" Integer NOT NULL,
constraint "pk_TbRepassePagamento" primary key ("idRepassePagamento")
) Without Oids;


Create table "TbTipoRegulamentacao"
(
	"idTipoRegulamentacao" Serial NOT NULL,
	"dsTipoRegulamentacao" Varchar(50) NOT NULL UNIQUE,
constraint "pk_TbTipoRegulamentacao" primary key ("idTipoRegulamentacao")
) Without Oids;


/* Create Foreign Keys */
Create index "IX_um_TbCasa" on "TbCasa" ("idImovel");
Alter table "TbCasa" add Constraint "um" foreign key ("idImovel") references "TbImovel" ("idImovel") on update restrict on delete cascade;
Create index "IX_um_TbApartamento" on "TbApartamento" ("idImovel");
Alter table "TbApartamento" add Constraint "um" foreign key ("idImovel") references "TbImovel" ("idImovel") on update restrict on delete cascade;
Create index "IX_um_TbTerreno" on "TbTerreno" ("idImovel");
Alter table "TbTerreno" add Constraint "um" foreign key ("idImovel") references "TbImovel" ("idImovel") on update restrict on delete cascade;
Create index "IX_um_TbSala" on "TbSala" ("idImovel");
Alter table "TbSala" add Constraint "um" foreign key ("idImovel") references "TbImovel" ("idImovel") on update restrict on delete cascade;
Create index "IX_Esta_em_TbServico" on "TbServico" ("idImovel");
Alter table "TbServico" add Constraint "Esta_em" foreign key ("idImovel") references "TbImovel" ("idImovel") on update restrict on delete restrict;
Create index "IX_um_TbLocatario" on "TbLocatario" ("idPessoa");
Alter table "TbLocatario" add Constraint "um" foreign key ("idPessoa") references "TbPessoa" ("idPessoa") on update restrict on delete restrict;
Create index "IX_um_TbFiador" on "TbFiador" ("idPessoa");
Alter table "TbFiador" add Constraint "um" foreign key ("idPessoa") references "TbPessoa" ("idPessoa") on update restrict on delete restrict;
Create index "IX_tem_TbTelefone" on "TbTelefone" ("idPessoa");
Alter table "TbTelefone" add Constraint "tem" foreign key ("idPessoa") references "TbPessoa" ("idPessoa") on update cascade on delete cascade;
Create index "IX_Possui_TbImovel" on "TbImovel" ("idProprietario");
Alter table "TbImovel" add Constraint "Possui" foreign key ("idProprietario") references "TbPessoa" ("idPessoa") on update restrict on delete restrict;
Create index "IX_um_TbUsuario" on "TbUsuario" ("idPessoa");
Alter table "TbUsuario" add Constraint "um" foreign key ("idPessoa") references "TbPessoa" ("idPessoa") on update restrict on delete cascade;
Create index "IX_Solicita_TbServico" on "TbServico" ("idCliente");
Alter table "TbServico" add Constraint "Solicita" foreign key ("idCliente") references "TbPessoa" ("idPessoa") on update restrict on delete restrict;
Create index "IX_Est__TbContratoAvulso" on "TbContratoAvulso" ("idLocador");
Alter table "TbContratoAvulso" add Constraint "Est_" foreign key ("idLocador") references "TbPessoa" ("idPessoa") on update restrict on delete restrict;
Create index "IX_Recebe_TbRepassePagamento" on "TbRepassePagamento" ("idProprietario");
Alter table "TbRepassePagamento" add Constraint "Recebe" foreign key ("idProprietario") references "TbPessoa" ("idPessoa") on update restrict on delete restrict;
Create index "IX_Est__TbLocacao" on "TbLocacao" ("idLocatario");
Alter table "TbLocacao" add Constraint "Est_" foreign key ("idLocatario") references "TbLocatario" ("idLocatario") on update restrict on delete restrict;
Create index "IX__TbContratoAvulso" on "TbContratoAvulso" ("idLocatario");
Alter table "TbContratoAvulso" add  foreign key ("idLocatario") references "TbLocatario" ("idLocatario") on update restrict on delete restrict;
Create index "IX_Registra_TbServico" on "TbServico" ("idUsuario");
Alter table "TbServico" add Constraint "Registra" foreign key ("idUsuario") references "TbUsuario" ("idPessoa") on update restrict on delete restrict;
Create index "IX_um_TbCorretor" on "TbCorretor" ("idPessoa");
Alter table "TbCorretor" add Constraint "um" foreign key ("idPessoa") references "TbUsuario" ("idPessoa") on update restrict on delete cascade;
Create index "IX_Pertence_TbLocacao" on "TbLocacao" ("idFiador");
Alter table "TbLocacao" add Constraint "Pertence" foreign key ("idFiador") references "TbFiador" ("idFiador") on update restrict on delete restrict;
Create index "IX_Pertence_TbContratoAvulso" on "TbContratoAvulso" ("idFiador");
Alter table "TbContratoAvulso" add Constraint "Pertence" foreign key ("idFiador") references "TbFiador" ("idFiador") on update restrict on delete restrict;
Create index "IX__TbLocacao" on "TbLocacao" ("idCorretor");
Alter table "TbLocacao" add  foreign key ("idCorretor") references "TbCorretor" ("idPessoa") on update restrict on delete restrict;
Create index "IX_Faz_TbAvaliacao" on "TbAvaliacao" ("idCorretor");
Alter table "TbAvaliacao" add Constraint "Faz" foreign key ("idCorretor") references "TbCorretor" ("idPessoa") on update restrict on delete restrict;
Create index "IX_Media_TbVenda" on "TbVenda" ("idCorretor");
Alter table "TbVenda" add Constraint "Media" foreign key ("idCorretor") references "TbCorretor" ("idPessoa") on update restrict on delete restrict;
Create index "IX_Possui_TbMensalidade" on "TbMensalidade" ("idLocacao");
Alter table "TbMensalidade" add Constraint "Possui" foreign key ("idLocacao") references "TbLocacao" ("idServico") on update restrict on delete cascade;
Create index "IX_Tem_TbServico" on "TbServico" ("idTabelaPreco");
Alter table "TbServico" add Constraint "Tem" foreign key ("idTabelaPreco") references "TbTabelaPreco" ("idTabelaPreco") on update restrict on delete restrict;
Create index "IX_um_TbVenda" on "TbVenda" ("idServico");
Alter table "TbVenda" add Constraint "um" foreign key ("idServico") references "TbServico" ("idServico") on update restrict on delete cascade;
Create index "IX_um_TbAvaliacao" on "TbAvaliacao" ("idServico");
Alter table "TbAvaliacao" add Constraint "um" foreign key ("idServico") references "TbServico" ("idServico") on update restrict on delete cascade;
Create index "IX_um_TbContratoAvulso" on "TbContratoAvulso" ("idServico");
Alter table "TbContratoAvulso" add Constraint "um" foreign key ("idServico") references "TbServico" ("idServico") on update restrict on delete cascade;
Create index "IX_um_TbLocacao" on "TbLocacao" ("idServico");
Alter table "TbLocacao" add Constraint "um" foreign key ("idServico") references "TbServico" ("idServico") on update restrict on delete cascade;
Create index "IX_Tem_TbVenda" on "TbVenda" ("idRepassePagamento");
Alter table "TbVenda" add Constraint "Tem" foreign key ("idRepassePagamento") references "TbRepassePagamento" ("idRepassePagamento") on update restrict on delete restrict;
Create index "IX_Tem_TbMensalidade" on "TbMensalidade" ("idRepassePagamento");
Alter table "TbMensalidade" add Constraint "Tem" foreign key ("idRepassePagamento") references "TbRepassePagamento" ("idRepassePagamento") on update restrict on delete restrict;
Create index "IX_Segue_TbLocacao" on "TbLocacao" ("idTipoRegulamentacao");
Alter table "TbLocacao" add Constraint "Segue" foreign key ("idTipoRegulamentacao") references "TbTipoRegulamentacao" ("idTipoRegulamentacao") on update restrict on delete restrict;
Create index "IX_Segue_TbContratoAvulso" on "TbContratoAvulso" ("idTipoRegulamentacao");
Alter table "TbContratoAvulso" add Constraint "Segue" foreign key ("idTipoRegulamentacao") references "TbTipoRegulamentacao" ("idTipoRegulamentacao") on update restrict on delete restrict;


