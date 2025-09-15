FROM eclipse-temurin:21-jdk-alpine

RUN apk add --no-cache \
    bash \
    curl \
    wget \
    unzip \
    chromium \
    chromium-chromedriver \
    nss \
    freetype \
    freetype-dev \
    harfbuzz \
    ca-certificates \
    ttf-freefont

ENV CHROME_BIN=/usr/bin/chromium-browser \
    CHROMEDRIVER=/usr/bin/chromedriver

WORKDIR /app
COPY target/*.jar scraper.jar

EXPOSE 8082

ENTRYPOINT ["java", "-jar", "scraper.jar"]
