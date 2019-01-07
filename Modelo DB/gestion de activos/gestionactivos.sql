/*==============================================================*/
/* DBMS name:      PostgreSQL 9.x                               */
/* Created on:     7/1/2019 4:18:47                             */
/*==============================================================*/


drop index ACTIVOS_PK;

drop table ACTIVOS;

drop index DEPARTAMENTOS_PK;

drop table DEPARTAMENTOS;

drop index RELATIONSHIP_4_FK;

drop index RELATIONSHIP_3_FK;

drop index HISTORIAL_ACTIVOS_PK;

drop table HISTORIAL_ACTIVOS;

drop index RELATIONSHIP_5_FK;

drop index RELATIONSHIP_1_FK;

drop index OFICINAS_PK;

drop table OFICINAS;

drop index PERSONAL_PK;

drop table PERSONAL;

drop index USUARIOS_PK;

drop table USUARIOS;

/*==============================================================*/
/* Table: ACTIVOS                                               */
/*==============================================================*/
create table ACTIVOS (
   ID                   SERIAL not null,
   NOMBRE               TEXT                 null,
   DETALLES             TEXT                 null,
   CANTIDAD             INT4                 null,
   CODIGO               TEXT                 null,
   constraint PK_ACTIVOS primary key (ID)
);

/*==============================================================*/
/* Index: ACTIVOS_PK                                            */
/*==============================================================*/
create unique index ACTIVOS_PK on ACTIVOS (
ID
);

/*==============================================================*/
/* Table: DEPARTAMENTOS                                         */
/*==============================================================*/
create table DEPARTAMENTOS (
   ID_DEPAR             SERIAL not null,
   NOMBRE               TEXT                 null,
   DESCRIPCION          TEXT                 null,
   constraint PK_DEPARTAMENTOS primary key (ID_DEPAR)
);

/*==============================================================*/
/* Index: DEPARTAMENTOS_PK                                      */
/*==============================================================*/
create unique index DEPARTAMENTOS_PK on DEPARTAMENTOS (
ID_DEPAR
);

/*==============================================================*/
/* Table: HISTORIAL_ACTIVOS                                     */
/*==============================================================*/
create table HISTORIAL_ACTIVOS (
   ID_ACTIVOS           SERIAL not null,
   ID                   INT4                 null,
   ID_PERSONAL          INT4                 null,
   CANTIDAD             INT4                 null,
   FECHA                DATE                 null,
   constraint PK_HISTORIAL_ACTIVOS primary key (ID_ACTIVOS)
);

/*==============================================================*/
/* Index: HISTORIAL_ACTIVOS_PK                                  */
/*==============================================================*/
create unique index HISTORIAL_ACTIVOS_PK on HISTORIAL_ACTIVOS (
ID_ACTIVOS
);

/*==============================================================*/
/* Index: RELATIONSHIP_3_FK                                     */
/*==============================================================*/
create  index RELATIONSHIP_3_FK on HISTORIAL_ACTIVOS (
ID
);

/*==============================================================*/
/* Index: RELATIONSHIP_4_FK                                     */
/*==============================================================*/
create  index RELATIONSHIP_4_FK on HISTORIAL_ACTIVOS (
ID_PERSONAL
);

/*==============================================================*/
/* Table: OFICINAS                                              */
/*==============================================================*/
create table OFICINAS (
   ID_OFICINA           SERIAL not null,
   ID_DEPAR             INT4                 null,
   ID_PERSONAL          INT4                 null,
   NOMBRE               TEXT                 null,
   DESCRIPCION          TEXT                 null,
   constraint PK_OFICINAS primary key (ID_OFICINA)
);

/*==============================================================*/
/* Index: OFICINAS_PK                                           */
/*==============================================================*/
create unique index OFICINAS_PK on OFICINAS (
ID_OFICINA
);

/*==============================================================*/
/* Index: RELATIONSHIP_1_FK                                     */
/*==============================================================*/
create  index RELATIONSHIP_1_FK on OFICINAS (
ID_DEPAR
);

/*==============================================================*/
/* Index: RELATIONSHIP_5_FK                                     */
/*==============================================================*/
create  index RELATIONSHIP_5_FK on OFICINAS (
ID_PERSONAL
);

/*==============================================================*/
/* Table: PERSONAL                                              */
/*==============================================================*/
create table PERSONAL (
   ID_PERSONAL          SERIAL not null,
   CEDULA               TEXT                 null,
   APELLIDOS            TEXT                 null,
   FECHA_NAC            DATE                 null,
   EDAD                 TEXT                 null,
   constraint PK_PERSONAL primary key (ID_PERSONAL)
);

/*==============================================================*/
/* Index: PERSONAL_PK                                           */
/*==============================================================*/
create unique index PERSONAL_PK on PERSONAL (
ID_PERSONAL
);

/*==============================================================*/
/* Table: USUARIOS                                              */
/*==============================================================*/
create table USUARIOS (
   ID_USER              SERIAL not null,
   USUARIO               TEXT                 null,
   PASS                 TEXT                 null,
   TIPO                 TEXT                 null,
   constraint PK_USUARIOS primary key (ID_USER)
);

/*==============================================================*/
/* Index: USUARIOS_PK                                           */
/*==============================================================*/
create unique index USUARIOS_PK on USUARIOS (
ID_USER
);

alter table HISTORIAL_ACTIVOS
   add constraint FK_HISTORIA_RELATIONS_ACTIVOS foreign key (ID)
      references ACTIVOS (ID)
      on delete restrict on update restrict;

alter table HISTORIAL_ACTIVOS
   add constraint FK_HISTORIA_RELATIONS_PERSONAL foreign key (ID_PERSONAL)
      references PERSONAL (ID_PERSONAL)
      on delete restrict on update restrict;

alter table OFICINAS
   add constraint FK_OFICINAS_RELATIONS_DEPARTAM foreign key (ID_DEPAR)
      references DEPARTAMENTOS (ID_DEPAR)
      on delete restrict on update restrict;

alter table OFICINAS
   add constraint FK_OFICINAS_RELATIONS_PERSONAL foreign key (ID_PERSONAL)
      references PERSONAL (ID_PERSONAL)
      on delete restrict on update restrict;

