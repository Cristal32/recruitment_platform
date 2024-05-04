# Use official Node.js image as base
FROM node:latest

# Set working directory inside the container
WORKDIR /app

# Copy the rest of the application code
COPY . .

# Install dependencies
RUN npm install

# Expose port 4200 for Angular development server
EXPOSE 4200

# Start the Angular development server
CMD ["npm", "start"]