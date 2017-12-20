-- liquibase formatted sql logicalFilePath:000010_t_commodity.sql

-- changeset ksarin:000010.1
CREATE TABLE if not exists t_commodity
(
      id                        integer         not null        AUTO_INCREMENT      COMMENT 'Primary Key'
    , code                      varchar(128)    not null                            COMMENT 'The commodity code'
	, description 				varchar(128)	not null							COMMENT 'the comodity description'
	, created                   timestamp       not null default CURRENT_TIMESTAMP  COMMENT 'Creation Date'
    , updated                   timestamp       not null default CURRENT_TIMESTAMP  COMMENT 'Last Updated Date'
    , updated_by                varchar(128)    not null default 'unknown'          COMMENT 'Last Updated By'
    
    , constraint t_commodity_pk                 primary key (id)
    , constraint t_commodity_code_uk          	unique (code)
	 
)
COMMENT = 'It store the commodity'
;
-- rollback drop table t_commodity;