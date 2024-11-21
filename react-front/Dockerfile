# Use Node.js base image
FROM node:16-alpine as build

# Set the working directory
WORKDIR /app

# Copy package files first to leverage Docker caching
COPY package.json package-lock.json ./

# Install dependencies
RUN npm install --production

# Copy the rest of the application files
COPY . .

# Build the React app
RUN npm run build

# Serve the React app using NGINX
FROM nginx:1.23-alpine
COPY --from=build /app/build /usr/share/nginx/html

# Expose the NGINX default port
EXPOSE 80

# Start NGINX
CMD ["nginx", "-g", "daemon off;"]
