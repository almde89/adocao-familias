FROM payara/micro:5.201-jdk11

COPY build/libs/app-1.0.0.war $DEPLOY_DIR
COPY postboot/payara-post-boot-config.cli postboot/postgresql-42.2.18.jar $PAYARA_HOME/

CMD ["--deploymentDir", "/opt/payara/deployments", "--postbootcommandfile", "/opt/payara/payara-post-boot-config.cli", "--addlibs", "/opt/payara/postgresql-42.2.18.jar", "--contextroot", "api"]
