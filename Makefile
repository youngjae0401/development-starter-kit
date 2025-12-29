.PHONY: help dev up down logs clean build install

help:
	@echo "Available commands:"
	@echo "  make dev        - Start local development environment (infrastructure only)"
	@echo "  make up         - Start all services with Docker Compose"
	@echo "  make down       - Stop all services"
	@echo "  make logs       - View logs from all services"
	@echo "  make clean      - Remove all containers, volumes, and images"
	@echo "  make build      - Build all Docker images"
	@echo "  make install    - Install dependencies for backend and frontend"

dev:
	docker-compose -f docker-compose.local.yml up -d

up:
	docker-compose up -d

down:
	docker-compose down

logs:
	docker-compose logs -f

clean:
	docker-compose down -v --rmi all

build:
	docker-compose build

install:
	@echo "Installing backend dependencies..."
	cd backend && ./gradlew build -x test
	@echo "Installing frontend dependencies..."
	cd frontend && npm install
	@echo "Done!"
