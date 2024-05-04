# Use official Node.js image as base
FROM node:latest

# Set working directory inside the container
WORKDIR /app

# Copy package.json and package-lock.json to container
COPY package*.json ./

# Install dependencies
RUN npm install

# Copy the rest of the application code
COPY . .

# Angular CLI
RUN npm install -g @angular/cli

# Expose port 4200 for Angular development server
EXPOSE 4200

# Start app
CMD ["ng","serve","--host", "0.0.0.0"]