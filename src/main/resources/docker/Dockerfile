FROM oraclelinux:8-slim

ARG BUILD_MODE

LABEL org.opencontainers.image.source https://github.com/gvenzl/oci-oracle-xe

ENV ORACLE_BASE=/opt/oracle \
    ORACLE_BASE_CONFIG=/opt/oracle \
    ORACLE_BASE_HOME=/opt/oracle/homes/OraDBHome21cXE \
    ORACLE_HOME=/opt/oracle/product/21c/dbhomeXE \
    ORACLE_SID=XE \
    PATH=${PATH}:/opt/oracle/product/21c/dbhomeXE/bin:/opt/oracle \
    NLS_LANG=.AL32UTF8

COPY oracle-database-xe-21c-1.0-1.ol8.x86_64.rpm install.2130.sh container-entrypoint.sh resetPassword createAppUser healthcheck.sh /install/

RUN /install/install.2130.sh "${BUILD_MODE}"

USER oracle
WORKDIR ${ORACLE_BASE}

HEALTHCHECK CMD "${ORACLE_BASE}"/healthcheck.sh >/dev/null || exit 1

ENTRYPOINT ["container-entrypoint.sh"]