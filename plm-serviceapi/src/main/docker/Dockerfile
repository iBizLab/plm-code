FROM image.ibizlab.cn/library/openjdk:8-jre-alpine

ENV TZ="Asia/Shanghai" \
    SPRING_OUTPUT_ANSI_ENABLED=ALWAYS \
    IBIZ_SLEEP=0 \
    JAVA_OPTS=""

CMD echo "The application will start in ${IBIZ_SLEEP}s..." && \
    sleep ${IBIZ_SLEEP} && \
    java ${JAVA_OPTS} -Duser.timezone=$TZ -Djava.security.egd=file:/dev/./urandom -jar /plm-serviceapi.jar

EXPOSE 18080

ADD plm-serviceapi.jar /plm-serviceapi.jar