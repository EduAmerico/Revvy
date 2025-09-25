# 🚗 AI Tuning - Plataforma SaaS de Customizações Automotivas Inteligentes

[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.5.5-brightgreen.svg)](https://spring.io/projects/spring-boot)
[![Java](https://img.shields.io/badge/Java-21-orange.svg)](https://openjdk.java.net/)
[![PostgreSQL](https://img.shields.io/badge/PostgreSQL-15-blue.svg)](https://www.postgresql.org/)
[![License](https://img.shields.io/badge/License-MIT-yellow.svg)](LICENSE)

## 📖 Sobre o Projeto

**AI Tuning** é uma plataforma SaaS inovadora que utiliza inteligência artificial para gerar projetos de customização automotiva personalizados. A plataforma conecta entusiastas automotivos, oficinas especializadas e profissionais do setor através de uma experiência inteligente e intuitiva.

### 🎯 Objetivos

- **Projeto Vitrine**: Demonstração técnica completa para portfólio profissional
- **Inovação**: Aplicação prática de IA em problemas reais do setor automotivo
- **Escalabilidade**: Arquitetura preparada para crescimento e evolução
- **Profissionalismo**: Código limpo, documentado e seguindo melhores práticas

## 🏗️ Arquitetura e Tecnologias

### Backend
- **Java 21** - Linguagem principal
- **Spring Boot 3.5.5** - Framework principal
- **Spring Security** - Autenticação e autorização
- **Spring Data JPA** - Persistência de dados
- **PostgreSQL** - Banco de dados principal
- **Flyway** - Migrações de banco de dados
- **Spring WebFlux** - Suporte reativo
- **Spring WebSocket** - Comunicação em tempo real

### Infraestrutura

### Funcionalidades Principais

#### 🔐 Sistema de Usuários
- Registro e autenticação segura
- Perfis diferenciados (usuário comum vs. oficina)
- Sistema de verificação de contas

#### 💳 Planos de Assinatura SaaS
- **FREE**: 10 créditos de IA gratuitos
- **BASIC**: R$ 29,90/mês - 100 créditos
- **PROFESSIONAL**: R$ 79,90/mês - 500 créditos
- **ENTERPRISE**: R$ 199,90/mês - 2000 créditos

#### 🚗 Gestão de Veículos
- Cadastro completo de veículos
- Histórico de modificações
- Galeria de imagens

#### 🤖 Projetos de Customização com IA
- Geração inteligente de projetos personalizados
- Categorização por tipo (Performance, Estética, Interior, etc.)
- Estimativas de custo e tempo
- Níveis de dificuldade (1-5)

#### 📋 Sistema de Etapas
- Planejamento detalhado passo a passo
- Acompanhamento de progresso
- Tempo estimado por etapa

## 🚀 Como Executar

### Pré-requisitos
- Java 21+
- Maven 3.8+
- PostgreSQL 15+
- Git

### Configuração Local

1. **Clone o repositório**
```bash
git clone https://github.com/seu-usuario/ai-tuning.git
cd ai-tuning
```

2. **Configure o banco de dados**
```bash
# Crie um banco PostgreSQL
createdb ai_tuning_dev

# Configure as credenciais em application.dev.yml
```

3. **Execute as migrações**
```bash
mvn flyway:migrate
```

4. **Execute a aplicação**
```bash
mvn spring-boot:run
```

A aplicação estará disponível em `http://localhost:8080`

### Configuração de Produção

1. **Configure as variáveis de ambiente**
```bash
export SPRING_PROFILES_ACTIVE=prod
export DATABASE_URL=jdbc:postgresql://seu-servidor:5432/ai_tuning
export DATABASE_USERNAME=seu_usuario
export DATABASE_PASSWORD=sua_senha
```

2. **Deploy com Docker**
```bash
docker build -t ai-tuning .
docker run -p 8080:8080 ai-tuning
```

## 📊 Estrutura do Banco de Dados

### Principais Entidades

- **users**: Usuários da plataforma com planos de assinatura
- **vehicles**: Veículos cadastrados pelos usuários
- **customization_projects**: Projetos de customização
- **project_steps**: Etapas detalhadas dos projetos
- **project_images**: Imagens dos projetos

### Relacionamentos

```
User (1) -----> (N) Vehicle
User (1) -----> (N) CustomizationProject
Vehicle (1) ----> (N) CustomizationProject
CustomizationProject (1) -----> (N) ProjectStep
CustomizationProject (1) -----> (N) ProjectImage
```

## 🔧 API Endpoints

### Usuários
- `POST /api/users` - Criar usuário
- `GET /api/users/{id}` - Buscar usuário por ID
- `GET /api/users/username/{username}` - Buscar por username
- `GET /api/users` - Listar usuários

### Veículos
- `POST /api/vehicles` - Cadastrar veículo
- `GET /api/vehicles/{id}` - Buscar veículo
- `GET /api/vehicles/user/{userId}` - Listar veículos do usuário

### Projetos
- `POST /api/projects` - Criar projeto
- `GET /api/projects/{id}` - Buscar projeto
- `GET /api/projects/user/{userId}` - Listar projetos do usuário
- `POST /api/projects/{id}/ai-generate` - Gerar projeto com IA

## 🧪 Testes

```bash
# Executar todos os testes
mvn test

# Executar testes com cobertura
mvn test jacoco:report
```

## 📈 Roadmap

### Fase 1 - MVP (Atual)
- [x] Estrutura base da aplicação
- [x] Sistema de usuários e autenticação
- [x] Gestão de veículos
- [x] Projetos de customização
- [ ] Integração com IA para geração de projetos

### Fase 2 - Funcionalidades Avançadas
- [ ] Sistema de pagamentos (Stripe/PagSeguro)
- [ ] Chat em tempo real
- [ ] Marketplace de peças e serviços
- [ ] App mobile (React Native)

### Fase 3 - Expansão
- [ ] Integração com oficinas parceiras
- [ ] Sistema de avaliações e reviews
- [ ] Analytics avançados
- [ ] API pública para terceiros

## 🤝 Contribuição

1. Fork o projeto
2. Crie uma branch para sua feature (`git checkout -b feature/AmazingFeature`)
3. Commit suas mudanças (`git commit -m 'Add some AmazingFeature'`)
4. Push para a branch (`git push origin feature/AmazingFeature`)
5. Abra um Pull Request

## 📝 Licença

Este projeto está sob a licença MIT. Veja o arquivo [LICENSE](LICENSE) para mais detalhes.

## 👨‍💻 Autor

**Eduardo** - Desenvolvedor Full Stack
- LinkedIn: [Seu LinkedIn](https://linkedin.com/in/seu-perfil)
- GitHub: [Seu GitHub](https://github.com/seu-usuario)
- Email: seu.email@exemplo.com

## 🙏 Agradecimentos

- Comunidade Spring Boot
- Comunidade Java
- Entusiastas automotivos que inspiraram este projeto

---

⭐ **Se este projeto te ajudou, considere dar uma estrela!**
