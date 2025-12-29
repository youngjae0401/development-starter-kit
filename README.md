# Development Starter Kit

A modern, production-ready full-stack development starter kit with best practices, clean architecture, and comprehensive monitoring.

## Tech Stack

### Backend
- **Spring Boot 3.4.1** - Latest Spring Boot framework with Virtual Threads
- **Java 21** - Latest LTS Java version
- **Gradle 8.11.1** - Build automation tool
- **PostgreSQL 16** - Production-grade relational database
- **Redis 7** - High-performance in-memory cache
- **JPA + QueryDSL 5.1.0** - Type-safe database queries with custom repositories
- **MapStruct 1.6.0** - Type-safe entity-DTO mapping
- **Springdoc OpenAPI 2.7.0** - Interactive API documentation (Swagger)

### Frontend
- **React 18.3** - Modern UI library with hooks
- **TypeScript 5.7** - Type-safe JavaScript
- **Vite 6.0** - Lightning-fast build tool
- **React Router 7** - Declarative routing
- **TanStack Query (React Query) 5.90** - Powerful data fetching and caching
- **Tailwind CSS 3.4** - Utility-first CSS framework
- **Axios 1.7** - Promise-based HTTP client
- **ESLint 9 + Prettier 3** - Code quality and formatting

### Infrastructure & Monitoring
- **Docker & Docker Compose** - Containerization and orchestration
- **Nginx 1.27** - Reverse proxy and static file serving
- **Prometheus 3.1** - Metrics collection and monitoring
- **Grafana 11.4** - Metrics and logs visualization
- **Loki 3.3** - Log aggregation system
- **Promtail 3.3** - Log shipping agent

## Project Structure

```
development-starter-kit/
├── backend/                      # Spring Boot application
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/com/starter/app/
│   │   │   │   ├── common/      # Common utilities
│   │   │   │   │   ├── exception/  # Exception handling (BusinessException, EntityNotFoundException)
│   │   │   │   │   ├── response/   # API response structures (ApiResponse, PageResponse, ErrorCode)
│   │   │   │   │   └── util/       # Utility classes (PageUtil)
│   │   │   │   ├── config/      # Spring configurations (JPA, Swagger)
│   │   │   │   ├── controller/  # REST controllers and API interfaces
│   │   │   │   ├── domain/      # JPA entities (BaseEntity with audit fields)
│   │   │   │   ├── dto/         # Data transfer objects (Request/Response DTOs)
│   │   │   │   ├── mapper/      # MapStruct entity-DTO mappers
│   │   │   │   ├── repository/  # JPA repositories with QueryDSL custom implementations
│   │   │   │   └── service/     # Business logic layer
│   │   │   └── resources/
│   │   │       ├── application.yml           # Base configuration
│   │   │       ├── application-local.yml     # Local environment config
│   │   │       ├── application-prod.yml      # Production environment config
│   │   │       ├── logback-spring.xml        # Logging configuration with Loki
│   │   │       └── static/                   # Static resources
│   │   └── test/
│   ├── build.gradle
│   └── Dockerfile
│
├── frontend/                     # React application
│   ├── src/
│   │   ├── api/                 # API client functions
│   │   ├── components/          # Reusable components
│   │   ├── hooks/               # Custom React hooks
│   │   ├── pages/               # Page components
│   │   ├── types/               # TypeScript types
│   │   └── utils/               # Utility functions
│   ├── package.json
│   ├── tsconfig.json
│   ├── vite.config.ts
│   ├── nginx.conf
│   └── Dockerfile
│
├── infrastructure/              # Infrastructure configurations
│   ├── nginx/                   # Nginx reverse proxy configuration
│   ├── prometheus/              # Prometheus metrics configuration
│   ├── grafana/                 # Grafana dashboards and datasources
│   │   └── provisioning/        # Pre-configured dashboards (Spring Boot, Logs)
│   ├── loki/                    # Loki log aggregation configuration
│   └── promtail/                # Promtail log shipping configuration
│
├── docker-compose.yml           # Production compose file
├── docker-compose.local.yml     # Local development compose file
├── Makefile                     # Common commands
└── README.md
```

## Architecture & Design Patterns

### Backend Architecture
- **Clean Layered Architecture** - Clear separation of concerns (Controller → Service → Repository → Domain)
- **Swagger API Interface Pattern** - Swagger annotations separated into interfaces for cleaner controllers
- **DTO Pattern** - Nested DTO structure (`UserDto.Request.Create`, `UserDto.Response.Info`)
- **Custom Repository Pattern** - JPA repositories with QueryDSL custom implementations
- **MapStruct Integration** - Type-safe, compile-time entity-DTO mapping
- **Base Entity Pattern** - Common audit fields (createdAt, updatedAt) in BaseEntity

### Frontend Architecture
- **Component-Based** - Reusable React components with hooks
- **Custom Hooks Pattern** - Data fetching logic separated into custom hooks
- **API Layer Separation** - API calls centralized in dedicated files
- **Type-Safe API Clients** - Full TypeScript coverage with matching backend DTOs

## Features

### Backend Features
- **Clean API Controllers** - Business logic-focused controllers with Swagger documentation in interfaces
- **Standardized Responses** - Unified `ApiResponse<T>` structure for all endpoints
- **Global Exception Handling** - Centralized error handling with custom exceptions and error codes
- **Type-Safe Queries** - QueryDSL for compile-time SQL validation and complex queries
- **Smart Pagination** - Custom PageResponse with comprehensive metadata
- **Request Validation** - Jakarta Validation with custom error messages
- **Interactive API Docs** - Swagger UI with organized, well-documented endpoints
- **Entity Mapping** - MapStruct for efficient, type-safe entity-DTO conversions
- **Virtual Threads** - Java 21 virtual threads for improved throughput
- **Comprehensive Monitoring** - Actuator endpoints with Prometheus metrics and Loki logging

### Frontend Features
- **Modern React Patterns** - Hooks, custom hooks, and functional components
- **React Query Integration** - Powerful server state management with caching and auto-refetching
- **Tailwind CSS** - Utility-first styling with responsive design
- **Type-Safe API Layer** - TypeScript interfaces matching backend DTOs exactly
- **Centralized HTTP Client** - Axios instance with interceptors for auth and error handling
- **Organized Structure** - Clear separation of concerns (api, hooks, pages, components, types)
- **Code Quality Tools** - ESLint for linting, Prettier for formatting
- **Environment Support** - Separate configurations for development and production

## Getting Started

### Prerequisites
- Java 21+
- Node.js 20+
- Docker & Docker Compose
- Make (optional)

### Quick Start

#### Option 1: Docker Compose (Recommended)

Start all services (backend, frontend, database, cache, monitoring):
```bash
docker-compose up -d
```

Access the applications:
- Frontend: http://localhost
- Backend API: http://localhost/api
- Swagger UI: http://localhost/swagger-ui.html
- Prometheus: http://localhost:9090
- Grafana: http://localhost:3001 (admin/admin)

#### Option 2: Local Development

Start infrastructure services only:
```bash
# Using Make
make dev

# Or using Docker Compose
docker-compose -f docker-compose.local.yml up -d
```

Start backend:
```bash
cd backend
./gradlew bootRun
```

Start frontend:
```bash
cd frontend
npm install
npm run dev
```

Access the applications:
- Frontend: http://localhost:3000
- Backend API: http://localhost:8080/api
- Swagger UI: http://localhost:8080/swagger-ui.html

### Environment Configuration

Copy the example environment file:
```bash
cp .env.example .env
```

Edit `.env` with your configuration:
```env
DB_HOST=localhost
DB_PORT=5432
DB_NAME=starterdb
DB_USERNAME=starter
DB_PASSWORD=starter123

REDIS_HOST=localhost
REDIS_PORT=6379

SPRING_PROFILES_ACTIVE=local
VITE_API_BASE_URL=/api
```

### Available Make Commands

```bash
make help        # Show available commands
make dev         # Start local development environment
make up          # Start all services with Docker
make down        # Stop all services
make logs        # View logs from all services
make clean       # Remove all containers and volumes
make build       # Build all Docker images
make install     # Install backend and frontend dependencies
```

## API Documentation

### Swagger UI
Access interactive API documentation at:
- Local: http://localhost:8080/swagger-ui.html
- Docker: http://localhost/swagger-ui.html

### Sample API Endpoints

#### Get User
```http
GET /api/v1/users/{id}
```

#### Search Users
```http
GET /api/v1/users?keyword=john&page=0&size=20&sortBy=createdAt&direction=DESC
```

Note: Search parameters are now handled via `UserDto.Request.Search` object for cleaner controller methods.

#### Create User
```http
POST /api/v1/users
Content-Type: application/json

{
  "email": "user@example.com",
  "name": "John Doe",
  "password": "password123"
}
```

### Response Format

Success response:
```json
{
  "success": true,
  "message": "Success",
  "data": {
    "id": 1,
    "email": "user@example.com",
    "name": "John Doe",
    "status": "ACTIVE",
    "createdAt": "2025-12-29T12:00:00",
    "updatedAt": "2025-12-29T12:00:00"
  }
}
```

Error response:
```json
{
  "success": false,
  "message": "User not found",
  "error": {
    "code": "B001",
    "message": "User not found with id: 999"
  }
}
```

Paginated response:
```json
{
  "success": true,
  "message": "Success",
  "data": {
    "content": [...],
    "pageInfo": {
      "currentPage": 0,
      "pageSize": 20,
      "totalElements": 100,
      "totalPages": 5,
      "first": true,
      "last": false
    }
  }
}
```

## Database

### Initial Schema

The application uses JPA to manage database schema. On first run with `spring.jpa.hibernate.ddl-auto=update`, it will create the following tables:

- `users` - User information with audit fields (created_at, updated_at)

### Migrations

For production, set `spring.jpa.hibernate.ddl-auto=validate` and use a migration tool like Flyway or Liquibase.

## Monitoring & Observability

### Prometheus Metrics
- **Endpoint**: http://localhost:9090
- **Scrapes**: Backend metrics from `/actuator/prometheus`
- **Configuration**: `infrastructure/prometheus/prometheus.yml`
- **Metrics**: JVM, HTTP requests, custom business metrics

### Grafana Dashboards
- **Endpoint**: http://localhost:3001 (admin/admin)
- **Pre-configured Datasources**:
  - Prometheus for metrics
  - Loki for logs
- **Pre-built Dashboards**:
  - Spring Boot Application Dashboard (JVM, requests, errors)
  - Logs Dashboard (centralized log viewing)
- Located in: `infrastructure/grafana/provisioning/dashboards/`

### Loki Log Aggregation
- **Endpoint**: http://localhost:3100
- **Integration**: Backend logs shipped via Loki logback appender
- **Docker Logs**: Container logs collected by Promtail
- **Configuration**: `infrastructure/loki/loki-config.yml`
- **Query**: Use LogQL in Grafana to query and filter logs

### Promtail Log Shipping
- **Collects**: Docker container logs
- **Ships to**: Loki
- **Configuration**: `infrastructure/promtail/promtail-config.yml`

### Health Checks
```http
GET /actuator/health
GET /actuator/info
GET /actuator/prometheus
```

## Development Guidelines

### Backend

#### Adding a New Feature
1. **Entity**: Create in `domain/` extending `BaseEntity` for audit fields
2. **Repository**:
   - Create interface in `repository/` extending `JpaRepository`
   - Create `CustomRepository` interface for complex queries
   - Implement with QueryDSL in `RepositoryImpl` class
3. **DTO**: Create nested DTOs in `dto/` (e.g., `XxxDto.Request.Create`, `XxxDto.Response.Info`)
4. **Mapper**: Create MapStruct interface in `mapper/` for entity-DTO conversion
5. **Service**: Implement business logic in `service/`
6. **API Interface**: Create in `controller/` with Swagger annotations
7. **Controller**: Implement the API interface with actual logic

#### Error Handling
- Use `BusinessException` for business logic errors
- Use `EntityNotFoundException` for missing resources
- Add new error codes to `ErrorCode` enum
- Exceptions are automatically handled by `GlobalExceptionHandler`

#### Validation
- Use Jakarta Validation in DTOs (`@NotBlank`, `@Email`, `@Size`, `@Min`, `@Max`)
- Validation errors are automatically formatted in API responses

#### Swagger Documentation
- Put all Swagger annotations (`@Operation`, `@Parameter`, `@Tag`) in API interfaces
- Keep controllers clean with only business logic

### Frontend

#### Adding a New Feature
1. **Types**: Define TypeScript interfaces in `types/` matching backend DTOs
2. **API Client**: Create API functions in `api/` using axios instance
3. **Custom Hook**: Create React Query hook in `hooks/` for data fetching
4. **Components**: Create reusable components in `components/`
5. **Page**: Create page component in `pages/` using the custom hook
6. **Route**: Add route in `App.tsx`

#### Data Fetching
- Use React Query (`useQuery`, `useMutation`) for all server state
- Create custom hooks wrapping React Query for reusability
- Example: `useUsers()`, `useCreateUser()`

#### Styling
- Use Tailwind CSS utility classes
- Follow responsive design principles (mobile-first)
- Keep components self-contained and reusable

#### Type Safety
- Always define TypeScript types matching backend DTOs
- Use generics for API response types (`ApiResponse<T>`, `PageResponse<T>`)
- Leverage IDE autocomplete and type checking

## Code Examples

### Backend Example: Creating a New API

```java
// 1. Entity
@Entity
@Getter
@NoArgsConstructor
public class Product extends BaseEntity {
    private String name;
    private BigDecimal price;
}

// 2. Repository
public interface ProductRepository extends JpaRepository<Product, Long>, ProductRepositoryCustom {}

// 3. DTO
public class ProductDto {
    public static class Request {
        public record Create(String name, BigDecimal price) {}
    }
    public static class Response {
        public record Info(Long id, String name, BigDecimal price) {}
    }
}

// 4. API Interface
@Tag(name = "Product", description = "Product API")
public interface ProductControllerApi {
    @Operation(summary = "Create product")
    ApiResponse<ProductDto.Response.Info> createProduct(
        @Valid @RequestBody ProductDto.Request.Create request);
}

// 5. Controller
@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController implements ProductControllerApi {
    private final ProductService productService;

    @Override
    @PostMapping
    public ApiResponse<ProductDto.Response.Info> createProduct(
        @Valid @RequestBody ProductDto.Request.Create request) {
        return ApiResponse.success(productService.createProduct(request));
    }
}
```

### Frontend Example: Using React Query

```typescript
// 1. Types
export interface Product {
  id: number;
  name: string;
  price: number;
}

// 2. API Client
export const productApi = {
  getProducts: () =>
    axiosInstance.get<ApiResponse<PageResponse<Product>>>('/api/v1/products'),
  createProduct: (data: CreateProductRequest) =>
    axiosInstance.post<ApiResponse<Product>>('/api/v1/products', data),
};

// 3. Custom Hook
export const useProducts = () => {
  return useQuery({
    queryKey: ['products'],
    queryFn: async () => {
      const { data } = await productApi.getProducts();
      return data.data;
    },
  });
};

// 4. Component
export const ProductList = () => {
  const { data, isLoading } = useProducts();

  if (isLoading) return <div>Loading...</div>;

  return (
    <div className="grid gap-4">
      {data?.content.map(product => (
        <div key={product.id} className="p-4 border rounded">
          <h3 className="font-bold">{product.name}</h3>
          <p className="text-gray-600">${product.price}</p>
        </div>
      ))}
    </div>
  );
};
```

## Production Deployment

### Build for Production

Backend:
```bash
cd backend
./gradlew bootJar
```

Frontend:
```bash
cd frontend
npm run build
```

### Docker Deployment
```bash
docker-compose up -d
```

### Environment Variables
Set the following environment variables for production:
- `SPRING_PROFILES_ACTIVE=prod`
- `DB_HOST`, `DB_PORT`, `DB_NAME`, `DB_USERNAME`, `DB_PASSWORD`
- `REDIS_HOST`, `REDIS_PORT`
- `VITE_API_BASE_URL`

## Security Considerations

### Production Checklist
- [ ] Change default database passwords
- [ ] Change Grafana admin password
- [ ] Use environment variables for all sensitive data
- [ ] Enable HTTPS/TLS in production
- [ ] Implement authentication and authorization (JWT, OAuth2, etc.)
- [ ] Set up secrets management (e.g., HashiCorp Vault, AWS Secrets Manager)
- [ ] Configure CORS policies appropriately
- [ ] Enable security headers (CSP, HSTS, etc.)
- [ ] Regular dependency updates for security patches
- [ ] Set up rate limiting
- [ ] Enable SQL injection protection (QueryDSL/JPA helps with this)
- [ ] Sanitize user inputs
- [ ] Use prepared statements (JPA does this automatically)

## Key Technologies Summary

| Category | Technology | Purpose |
|----------|-----------|---------|
| **Backend Framework** | Spring Boot 3.4 | REST API, dependency injection |
| **Language** | Java 21 | Virtual threads, modern Java features |
| **Database** | PostgreSQL 16 | Relational data storage |
| **ORM** | JPA + QueryDSL | Type-safe database queries |
| **Cache** | Redis 7 | Session storage, caching |
| **Mapping** | MapStruct | Entity-DTO conversion |
| **API Docs** | Swagger/OpenAPI | Interactive API documentation |
| **Frontend** | React 18 + TypeScript | Type-safe UI development |
| **Styling** | Tailwind CSS | Utility-first styling |
| **State Management** | React Query | Server state management |
| **Metrics** | Prometheus | Application metrics |
| **Logs** | Loki + Promtail | Centralized logging |
| **Visualization** | Grafana | Dashboards for metrics and logs |

## License

This project is licensed under the MIT License.

## Contributing

Contributions are welcome! Please feel free to submit a Pull Request.
