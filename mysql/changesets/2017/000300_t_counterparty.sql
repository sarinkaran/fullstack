-- liquibase formatted sql logicalFilePath:000300_t_counterparty.sql

-- changeset ksarin:000200.1
CREATE TABLE if not exists t_counterparty
(
      id                        integer         not null                            COMMENT 'Primary Key'
    , code                      varchar(128)    not null                            COMMENT 'counterparty code'
    , description              	varchar(128)    not null                            COMMENT 'counterparty description'
    
    , constraint t_counterparty_id_pk               primary key (id)
    , constraint t_counterparty_code_uk             unique (code)
)
COMMENT = 'It stores couterparty details'
;

-- rollback drop table t_counterparty;
