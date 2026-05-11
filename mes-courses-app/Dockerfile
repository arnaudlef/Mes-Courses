FROM node:alpine AS build

WORKDIR /app

COPY mes-courses-app/package*.json ./

RUN npm install --production

COPY mes-courses-app/. .

RUN npm run build


FROM nginx:alpine

COPY mes-courses-app/nginx.conf /etc/nginx/conf.d/default.conf

COPY --from=build /app/dist/mes-courses/browser /usr/share/nginx/html

EXPOSE 80