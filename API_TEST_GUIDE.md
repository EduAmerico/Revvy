# 🚀 AI Tuning API - Guia de Testes

## 📋 Endpoints Disponíveis

### 1. **Criar Usuário**
```bash
POST http://localhost:8080/api/users
Content-Type: application/json

{
  "username": "eduardo_tuning",
  "email": "eduardo@aituning.com",
  "password": "senha123",
  "firstName": "Eduardo",
  "lastName": "Silva",
  "bio": "Entusiasta automotivo e desenvolvedor",
  "companyName": "AI Tuning Dev",
  "phoneNumber": "+55 11 99999-9999",
  "isGarageOwner": false
}
```

### 2. **Buscar Usuário por ID**
```bash
GET http://localhost:8080/api/users/1
```

### 3. **Buscar Usuário por Username**
```bash
GET http://localhost:8080/api/users/username/eduardo_tuning
```

### 4. **Listar Todos os Usuários**
```bash
GET http://localhost:8080/api/users
```

## 🧪 Testando com cURL

### Criar Usuário
```bash
curl -X POST http://localhost:8080/api/users \
  -H "Content-Type: application/json" \
  -d '{
    "username": "teste_user",
    "email": "teste@example.com",
    "password": "senha123",
    "firstName": "Usuário",
    "lastName": "Teste",
    "bio": "Usuário de teste da API",
    "isGarageOwner": false
  }'
```

### Buscar Usuário
```bash
curl -X GET http://localhost:8080/api/users/1
```

### Listar Usuários
```bash
curl -X GET http://localhost:8080/api/users
```

## 📊 Resposta Esperada

### Usuário Criado (201 Created)
```json
{
  "id": 1,
  "username": "eduardo_tuning",
  "email": "eduardo@aituning.com",
  "firstName": "Eduardo",
  "lastName": "Silva",
  "bio": "Entusiasta automotivo e desenvolvedor",
  "profilePictureUrl": null,
  "isActive": true,
  "isVerified": false,
  "subscriptionPlan": "FREE",
  "subscriptionExpiresAt": null,
  "aiCreditsRemaining": 10,
  "companyName": "AI Tuning Dev",
  "phoneNumber": "+55 11 99999-9999",
  "isGarageOwner": false,
  "createdAt": "2025-09-23T20:33:45",
  "updatedAt": "2025-09-23T20:33:45"
}
```

### Erro de Validação (400 Bad Request)
```json
{
  "status": 400,
  "message": "Erro de validação",
  "details": {
    "username": "Username é obrigatório",
    "email": "Email deve ter formato válido"
  },
  "timestamp": "2025-09-23T20:33:45"
}
```

### Usuário Não Encontrado (404 Not Found)
```json
{
  "status": 404,
  "message": "Usuário não encontrado com ID: 999",
  "details": null,
  "timestamp": "2025-09-23T20:33:45"
}
```

## 🔧 Testando com Postman

1. **Importe a Collection**: Crie uma nova collection no Postman
2. **Configure Environment**: 
   - `base_url`: `http://localhost:8080`
3. **Teste os Endpoints**:
   - POST `/api/users` - Criar usuário
   - GET `/api/users/{id}` - Buscar usuário
   - GET `/api/users` - Listar usuários

## 🚨 Validações Implementadas

- **Username**: Obrigatório, 3-50 caracteres, único
- **Email**: Obrigatório, formato válido, único
- **Password**: Obrigatório, 6-100 caracteres
- **FirstName**: Máximo 100 caracteres
- **LastName**: Máximo 100 caracteres
- **Bio**: Máximo 500 caracteres
- **CompanyName**: Máximo 200 caracteres
- **PhoneNumber**: Máximo 20 caracteres

## 🎯 Próximos Passos

1. ✅ **API de Usuários** - Funcionando
2. 🔄 **API de Veículos** - Em desenvolvimento
3. 🔄 **API de Projetos** - Em desenvolvimento
4. 🔄 **Integração com IA** - Planejado

## 📝 Logs da Aplicação

A aplicação está rodando em `http://localhost:8080` e você pode ver os logs no terminal onde executou `./mvnw spring-boot:run`.

---

**🎉 Sua API está funcionando! Teste os endpoints acima para verificar se tudo está correto.**
