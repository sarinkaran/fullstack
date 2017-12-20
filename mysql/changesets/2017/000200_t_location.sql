-- liquibase formatted sql logicalFilePath:000200_t_location.sql

-- changeset ksarin:000200.1
CREATE TABLE if not exists t_location
(
      id                        integer         not null        AUTO_INCREMENT      COMMENT 'Primary Key'
    , code                      varchar(128)    not null                            COMMENT 'The Location code'
    , description               varchar(128)    not null                            COMMENT 'The locatin description'
    , created                   timestamp       not null default CURRENT_TIMESTAMP  COMMENT 'Creation Date'
    , updated                   timestamp       not null default CURRENT_TIMESTAMP  COMMENT 'Last Updated Date'
    , updated_by                varchar(128)    not null default 'unknown'          COMMENT 'Last Updated By.'
    
	, constraint t_location_pk              primary key (id)
    , constraint t_location_code_uk          unique (code)
)
COMMENT = 'location'
;

-- rollback drop table t_location;
