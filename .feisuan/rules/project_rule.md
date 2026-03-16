
# 开发规范指南
为保证代码质量、可维护性、安全性与可扩展性，请在开发过程中严格遵循以下规范。

## 一、项目基本信息

- **项目作者**：Cc
- **用户工作目录**：`D:\work\java\JavaProject\springboot3`
- **开发环境**：Windows 10
- **JDK 版本**：JDK 17.0.12
- **构建工具**：Maven
- **注释语言**：中文（请使用中文编写代码注释和文档）

## 二、技术栈要求

- **主框架**：Spring Boot 4.0.3
- **语言版本**：Java 17
- **持久层框架**：MyBatis-Plus 3.5.9
- **API 文档**：SpringDoc OpenAPI (Swagger UI) 3.0.2
- **核心依赖**：
  - `spring-boot-starter-webmvc`
  - `mybatis-plus-spring-boot3-starter`
  - `spring-boot-starter-validation`
  - `lombok`
  - `mysql-connector-j`

## 三、项目目录结构

本项目采用标准的 Maven 目录结构，具体的包结构如下：

```text
springboot3
└── src
    ├── main
    │   ├── java
    │   │   └── com
    │   │       └── example
    │   │           └── springboot3
    │   │               ├── config         # 配置类（如 MyBatis-Plus 分页插件等）
    │   │               ├── controller     # 控制层
    │   │               ├── dto            # 数据传输对象（按模块分包，如 dto/user）
    │   │               ├── entity         # 数据库实体类
    │   │               ├── mapper         # MyBatis-Plus Mapper 接口
    │   │               ├── service        # 业务逻辑层
    │   │               │   └── interfaces # Service 接口定义
    │   │               └── utils          # 通用工具类
    │   └── resources
    │       ├── mapper         # MyBatis XML 映射文件存放目录
    │       ├── static
    │       └── templates
    └── test
        └── java
            └── com
                └── example
                    └── springboot3
```

## 四、分层架构规范

| 层级        | 职责说明                         | 开发约束与注意事项                                                                 |
|-------------|----------------------------------|----------------------------------------------------------------------------------|
| **Controller** | 处理 HTTP 请求与响应，定义 API 接口 | 不得直接访问数据库，必须通过 Service 层调用；使用 Swagger 注解生成接口文档       |
| **Service**    | 实现业务逻辑、事务管理与数据校验   | 必须通过 Mapper 层访问数据库；返回 DTO 而非 Entity（除非必要）                     |
| **Mapper**     | 数据库访问与持久化操作             | 继承 `BaseMapper<T>`；优先使用 MyBatis-Plus 内置方法，复杂 SQL 在 XML 中编写      |
| **Entity**     | 映射数据库表结构                   | 不得直接返回给前端（需转换为 DTO）；支持逻辑删除、自动填充等 MyBatis-Plus 特性    |

### 接口与实现分离

- Service 接口需放在 `service.interfaces` 包中。
- Service 实现类建议放在 `service` 包下的 `impl` 子包中（若当前结构未体现，请遵循此约定）。

## 五、安全与性能规范

### 输入校验

- 使用 `@Valid` 与 JSR-303 校验注解（如 `@NotBlank`, `@Size` 等）。
  - 注意：Spring Boot 3.x/4.x 中校验注解位于 `jakarta.validation.constraints.*`。
- 禁止手动拼接 SQL 字符串，防止 SQL 注入攻击，优先使用 MyBatis-Plus 的构造器。

### 事务管理

- `@Transactional` 注解仅用于 **Service 层**方法。
- 避免在循环中频繁提交事务，影响性能。

## 六、代码风格规范

### 命名规范

| 类型       | 命名方式             | 示例                  |
|------------|----------------------|-----------------------|
| 类名       | UpperCamelCase       | `UserServiceImpl`     |
| 方法/变量  | lowerCamelCase       | `saveUser()`          |
| 常量       | UPPER_SNAKE_CASE     | `MAX_LOGIN_ATTEMPTS`  |

### 注释规范

- **所有类、方法、字段需添加 Javadoc 注释，注释内容请使用中文。**

### 类型命名规范（阿里巴巴风格）

| 后缀 | 用途说明                     | 示例         |
|------|------------------------------|--------------|
| DTO  | 数据传输对象                 | `UserDTO`    |
| Entity| 数据库实体对象（MyBatis-Plus）| `User`       |
| VO   | 视图展示对象                 | `UserVO`     |
| Query| 查询参数封装对象             | `UserQuery`  |

### 实体类简化工具

- 使用 Lombok 注解替代手动编写 getter/setter/构造方法：
  - `@Data`
  - `@NoArgsConstructor`
  - `@AllArgsConstructor`

## 七、MyBatis-Plus 使用规范

1. **主键策略**：默认使用 `ASSIGN_ID`（雪花算法），实体类主键字段需标注 `@TableId`。
2. **逻辑删除**：默认配置字段为 `deleted`，逻辑删除值为 1，未删除值为 0，实体类需配置 `@TableLogic`。
3. **分页插件**：需在 `config` 包下配置分页拦截器 `PaginationInnerInterceptor`。
4. **代码生成器**：项目已引入 `mybatis-plus-generator` 和 `velocity` 模板引擎，可用于生成代码。

## 八、扩展性与日志规范

### 接口优先原则

- 所有业务逻辑通过接口定义（如 `UserService`），具体实现放在 `impl` 包中（如 `UserServiceImpl`）。

### 日志记录

- 使用 `@Slf4j` 注解代替 `System.out.println`。
- 开发环境 MyBatis 日志已配置为 `StdOutImpl`，生产环境请调整为合适的日志级别。

## 九、编码原则总结

| 原则       | 说明                                       |
|------------|--------------------------------------------|
| **SOLID**  | 高内聚、低耦合，增强可维护性与可扩展性     |
| **DRY**    | 避免重复代码，提高复用性                   |
| **KISS**   | 保持代码简洁易懂                           |
| **YAGNI**  | 不实现当前不需要的功能                     |
| **OWASP**  | 防范常见安全漏洞，如 SQL 注入、XSS 等      |
